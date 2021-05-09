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
import patient.com.util.Patient;

@WebServlet("/showallpatient")
public class showallpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Patient>mypatientList  = new ArrayList<Patient>();
		
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
				String sql="select * from patient order by patient_id asc" ; 
				rs  =  stmt.executeQuery(sql);
				while(rs.next()){
			          long id  =rs.getLong("patient_id");
					  String name  = rs.getString("patient_name");
					  int age  = rs.getInt("age");
					 long contact  =rs.getLong("contact_no");
					  String address  = rs.getString("address");
					  String consulted_doctor = rs.getString("consulted_doctor");
					  
					  Patient patient  = new Patient();
					  patient.setPatient_id(id);
					  patient.setPatient_name(name);
					  patient.setPatient_age(age);
					  patient.setContact(contact);
					  patient.setPatient_address(address);
					  patient.setConsulted_doctor(consulted_doctor);
					  mypatientList.add(patient);
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
						     con.close();  //#5 close connection 
							}catch(SQLException e){
								 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
						  }
				  }
			 }

	    request.setAttribute("errorCode",errorCode.toString());
		request.setAttribute("allpatient", mypatientList);
		request.getRequestDispatcher("show_all_patient.jsp").forward(request, response);
		
	}

	
}
