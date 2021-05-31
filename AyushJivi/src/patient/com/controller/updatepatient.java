package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.com.util.Patient;


public class updatepatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder errorCode = new StringBuilder();
		String  patientId= request.getParameter("patient_id");

		long patientID  = Long.parseLong(patientId);
		Patient patient = null;
			Connection con = null;
			PreparedStatement pstmt  =null;
			ResultSet rs =null;
			
			String user="system";
			String password="root";
			String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con  = DriverManager.getConnection(url,user,password);
				String sql="select * from patient where patient_id=?" ; 
				pstmt  = con.prepareStatement(sql);
				pstmt.setLong(1, patientID);
				rs  =  pstmt.executeQuery();
				if( rs.next() ){
			          long patient_id  =rs.getLong("patient_id");
					  String patient_name  = rs.getString("patient_name");
					  int age  = rs.getInt("age");
					  long contact  =rs.getLong("contact_no");
					  String address  = rs.getString("Address");
					  String consulted_doctor  =rs.getString("consulted_doctor");
					  
					  patient = new Patient();
					  patient.setPatient_id(patient_id);
					  patient.setPatient_name(patient_name);
					  patient.setPatient_age(age);
					  patient.setContact(contact);
					  patient.setPatient_address(address);
					  patient.setConsulted_doctor(consulted_doctor);
					   
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
						     con.close();  //#5 close connection 
							}catch(SQLException e){
								 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
						  }
				  }
			 }
		request.setAttribute("errorCode", errorCode.toString());
		request.setAttribute("patient",patient);
		request.getRequestDispatcher("update_patient_form.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder errorCode = new StringBuilder();
		
		String  patientId= request.getParameter("patient_id");
		long PatientID = Long.parseLong(patientId);
		String  Name= request.getParameter("patient_name");
		String  Age= request.getParameter("age");
		String  Contact = request.getParameter("contact");
		String  Address= request.getParameter("address");
		String  Consulted_doctor = request.getParameter("Consulted_doctor");
		String str=Name;
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
	    	  errorCode.append("Invalid name entered<br>"); 
		long contact=0;
         int age=0;
         try {
        	 contact=Long.parseLong(Contact);
		} catch (NumberFormatException e) {
			errorCode.append(" Contact is not number "+ e.getMessage()+"<BR>");
		}
         try {
        	 age=Integer.parseInt(Age);
		} catch (NumberFormatException e) {
			errorCode.append(" Age is not number "+ e.getMessage()+"<BR>");
		}
       
		if(errorCode.length()>0){
			request.setAttribute("errorCode", errorCode.toString());
			request.getRequestDispatcher("update_patient_form.jsp").forward(request, response);
			return;
		}
		String updateMessage="";
		Connection con = null;
		PreparedStatement pstmt  =null;
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="update  patient"
					+ " set patient_name=?,age=?,contact_no=?,address=?,consulted_doctor=? where patient_id=?"; 
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,Name);
			pstmt.setInt(2,age);
			pstmt.setLong(3,contact);
			pstmt.setString(4,Address);
			pstmt.setString(5, Consulted_doctor);
			pstmt.setLong(6, PatientID);
			int result  = pstmt.executeUpdate();
		   if(result ==1){
			   updateMessage = " Patient record udpated successfully ";
			}else{
			   updateMessage = " Patient record not updated ";
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
							 errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
					  }
			  }
		}
		response.sendRedirect("showallpatient?update_msg="+updateMessage);
	}

}
