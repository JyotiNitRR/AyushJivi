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


public class bedsavailable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder errorCode = new StringBuilder();
			Connection con = null;
			PreparedStatement pstmt  =null;
			ResultSet rs =null;
			String user="system";
			String password="root";
			String url  = "jdbc:oracle:thin:@localhost:1521:XE";	
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con  = DriverManager.getConnection(url,user,password);
				String sql="select count(*) from patient" ; 
				pstmt  = con.prepareStatement(sql);
				int bedsUsed=0;
				rs  =  pstmt.executeQuery();
				String Countrow="";
				if(rs.next()){
				Countrow = rs.getString(1);
				}
				if(Countrow!=null){
					bedsUsed=Integer.parseInt(Countrow);
				}
				int totalBeds=500;
				int freeBeds=0;
				freeBeds = (totalBeds-bedsUsed);
				request.setAttribute("freeBeds",freeBeds);
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
								 errorCode.append("Database Con CLosing ERROR : "+ e.getMessage());
						  }
				  }
			 }
		request.getRequestDispatcher("beds_available.jsp").forward(request, response);
	}
}
