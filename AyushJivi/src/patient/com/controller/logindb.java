package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import patient.com.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logindb extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("user_email");
		String userPassword=request.getParameter("user_password");
		User loginUser=null;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String dbuser ="system";
		String dbpassword ="root";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		StringBuilder errorCode=new StringBuilder("");
		 try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con  = DriverManager.getConnection(url,dbuser,dbpassword);
				stmt  = con.createStatement();
				 
				String sql="select  * from  myuser "
						+ "where email='"+userEmail+"' "
								+ " AND password='"+userPassword+"'" ; 
		     	 rs  =  stmt.executeQuery(sql);
				if( rs.next() ){
			          long id  =rs.getLong("id");
					  String name  = rs.getString("name");
					  String email  = rs.getString("email");
					  String password  = rs.getString("password");
					  loginUser= new User();
					  loginUser.setId(id);
					  loginUser.setName(name);
					  loginUser.setEmail(email);
					  loginUser.setPassword(password);
				}
				
			 }catch(ClassNotFoundException e){
			   errorCode.append("Driver Not Loaded....." + e.getMessage());
			 }catch(SQLException e){
			   errorCode.append("Database ERROR : " +e.getMessage());
			   e.printStackTrace();
			 }catch(Exception e){
			   errorCode.append("Other ERROR " + e.getMessage());
			 }finally{
			      if(con!=null){
				          try{
						     con.close();  
							}catch(SQLException e){
								errorCode.append("DB Con CLosing ERROR : "+ e.getMessage());
						  }
				  }
			 }
		 
			 if(loginUser!=null){
				 HttpSession session = request.getSession();
			
				 session.setAttribute("user", loginUser);
				 request.getRequestDispatcher("Admin.jsp").forward(request,response);

			 }else{
				 errorCode.append("Invalid email or password");
				 
				 request.setAttribute("loginError", errorCode.toString());
				 request.getRequestDispatcher("Login.jsp").forward(request, response);
					
			 }
	}

}
