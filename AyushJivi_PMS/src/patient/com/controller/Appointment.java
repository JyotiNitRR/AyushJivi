package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Appointment")
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("appointment-form");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email= request.getParameter("email");
		String date = request.getParameter("appdate");
		String department = request.getParameter("department");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		String addMsg="";
		Connection con = null;
		PreparedStatement pstmt  =null;
		StringBuilder errorCode=new StringBuilder();
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";
		java.util.Date appDate = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
		try {
			appDate = sdf.parse(date);
		} catch (ParseException e) {
			
			errorCode.append("Date is invalid format"+e.getMessage()+"<br>");
		}  
		Long domMs  =appDate.getTime();
		java.sql.Date fixDate =new java.sql.Date(domMs);
		long phoneNo = 0;
		try{
			phoneNo=Long.parseLong(phone);
		}catch(NumberFormatException e){
			errorCode.append("Phone Number should be number<br>");
		}
	System.out.println(fixDate);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="insert into appointment " + 
						"(id,name,email,apdate,department,phone,message)"+ 
							"values(appointment_seq.nextval,?,?,?,?,?,?)";
			pstmt  = con.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3, date);
			pstmt.setString(4,department);
			pstmt.setLong(5,phoneNo);
			pstmt.setString(6,message);
			
			int result  = pstmt.executeUpdate();
			 if(result ==1){
				   addMsg = " Appointment fixed ";
				}else{
				   addMsg = " Appointment not fixed!!! ";
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
							 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage()+"<br>");
					  }
			  }
		}
		request.setAttribute("errorCode",errorCode.toString());
		response.sendRedirect("index.jsp?addMsg="+addMsg);
	}

}
