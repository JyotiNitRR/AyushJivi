package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.com.util.Appointmentperson;

@WebServlet("/showallappointments")
public class showallappointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Appointmentperson>myAppointmentList  = new ArrayList<Appointmentperson>();
		
	    StringBuilder errorCode = new StringBuilder();
		  
			Connection con = null;
			Statement stmt  =null;
			ResultSet rs =null;
			String user="system";
			String password="root";
			String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con  = DriverManager.getConnection(url,user,password);
				stmt  = con.createStatement();
				String sql="select * from appointment order by id asc" ; 
				rs  =  stmt.executeQuery(sql);
				while(rs.next()){
			          long id  =rs.getLong("id");
					  String name  = rs.getString("name");
					  long phone  = rs.getLong("phone");
					  String message  = rs.getString("message");
					 String email  =rs.getString("email");
					 java.sql.Date apDate  = rs.getDate("apdate");
					  String department = rs.getString("department");
					  
					  Appointmentperson appPerson  = new Appointmentperson();
					  appPerson.setId(id);
					  appPerson.setName(name);
					  appPerson.setPhone(phone);
					  appPerson.setMessage(message);
					  appPerson.setEmail(email);
					  appPerson.setApdate(apDate);
					  appPerson.setDepartment(department);
					  myAppointmentList.add(appPerson);
				}
				
			 }catch(ClassNotFoundException e){
			   errorCode.append("<h1 style='color:red'>Driver Not Loaded....." + e.getMessage()+"</h1>");
			 }catch(SQLException e){
			   errorCode.append("<h1 style='color:red'>DB ERROR : " +e.getMessage()+"</h1>");
			   e.printStackTrace();
			 }catch(Exception e){
			   errorCode.append("<h1 style='color:red'>Other ERROR " + e.getMessage()+"</h1>");
			 }finally{
			      if(con!=null){
				          try{
						     con.close(); 
							}catch(SQLException e){
								 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
						  }
				  }
			 }
	    request.setAttribute("errorCode",errorCode.toString());
		request.setAttribute("allappointments", myAppointmentList);
		request.getRequestDispatcher("show_all_appointment.jsp").forward(request, response);
		
	}

}
