package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;


public class DischargePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder errorCode = new StringBuilder();
		String dischargeMsg="";
		String  patientId= request.getParameter("patient_id");
		long patientID  = Long.parseLong(patientId);
		Connection con = null;
		PreparedStatement pstmt  =null;
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="delete from patient where Patient_id=?" ; 
			pstmt  = con.prepareStatement(sql);
			pstmt.setLong(1, patientID);
			int result  = pstmt.executeUpdate();
		   if(result ==1){
			   dischargeMsg = " Patient Discharged ";
			}else{
				dischargeMsg = " Patient is not discharged ";
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
		request.setAttribute("loginError", errorCode.toString());
		response.sendRedirect("showallpatient?dischargeMsg="+dischargeMsg);
	}

}
