package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdmitPatientservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("admit_patient_form");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patient_name = request.getParameter("patient_name");
		String age = request.getParameter("patient_age");
		String contact_no = request.getParameter("patient_contact");
		String address = request.getParameter("patient_address");
		String consulted_doctor = request.getParameter("patient_consulted_doctor");
		String addMsg="";
		Connection con = null;
		PreparedStatement pstmt  =null;
		StringBuilder errorCode=new StringBuilder();
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";
		String str=patient_name;
		boolean hasAlphabet=true;
		str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch==' ')) {
	        	 hasAlphabet= false;
	        	 break;
	         }
	      }
	      if(!hasAlphabet)
	    	  errorCode.append("Invalid name <br>");
		int Age=0;
		long contact=0;
		try{
			Age=Integer.parseInt(age);
		}catch(NumberFormatException e){
			errorCode.append("Age should be number<br>");
		}
		try{
			contact=Long.parseLong(contact_no);
		}catch(NumberFormatException e){
			errorCode.append("Contact No. should be number<br>");
		}

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="insert into patient " + 
						"(patient_id,patient_name,Age,contact_no,address,consulted_doctor)"+ 
							"values(patient_seq.nextval,?,?,?,?,?)";
			pstmt  = con.prepareStatement(sql);
			
			pstmt.setString(1,patient_name);
			pstmt.setInt(2,Age);
			pstmt.setLong(3,contact);
			pstmt.setString(4,address);
			pstmt.setString(5,consulted_doctor);
			int result=0;
			if(hasAlphabet)
				result  = pstmt.executeUpdate();
			 if(result ==1){
				   addMsg = " Patient admitted ";
				}else{
				   addMsg = " Patient not admitted ";
				}


		}catch(ClassNotFoundException e){
		  errorCode.append("<h1 style='color:red'>Driver Not Loaded....." + e.getMessage()+"</h1>");
		}catch(SQLException e){
		  errorCode.append("<h1 style='color:red'>Database ERROR : " +e.getMessage()+"</h1>");
		  e.printStackTrace();
		}catch(Exception e){
		  errorCode.append("<h1 style='color:red'>Other ERROR " + e.getMessage()+"</h1>");
		}finally{
		    
		     if(con!=null){
			          try{
					     con.close(); 
						}catch(SQLException e){
							 errorCode.append("Database Con CLosing ERROR : "+ e.getMessage()+"<br>");
					  }
			  }
		}
			request.setAttribute("errorCode",errorCode.toString());
			request.setAttribute("addMsg", addMsg.toString());
			request.getRequestDispatcher("Result.jsp").forward(request, response);
		
	}

}
