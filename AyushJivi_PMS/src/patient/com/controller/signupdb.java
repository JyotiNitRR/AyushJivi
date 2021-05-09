package patient.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupdb")
public class signupdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("signupdetails.jsp");
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder errorCode=new StringBuilder();
		String Name=request.getParameter("user_name");
		String Email=request.getParameter("user_email");
		String Password=request.getParameter("user_password");
		String addMsg="";
		Connection con = null;
		PreparedStatement pstmt  =null;
		String dbuser="system";
		String dbpassword="root";
		String url  = "jdbc:oracle:thin:@localhost:1521:XE";	

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url,dbuser,dbpassword);
			String sql="insert into myuser " + 
						"(id,name,email,password)"+ 
							"values(userseq.nextval,?,?,?)";
			pstmt  = con.prepareStatement(sql);
			
			
			pstmt.setString(1,Name);
			pstmt.setString(2,Email);
			pstmt.setString(3,Password);
			
			int result  = pstmt.executeUpdate();
			 if(result ==1){
				   addMsg = " You are signed up ";
				}else{
				   addMsg = " Signup failed!!! ";
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
		
		 response.sendRedirect("Login.jsp?addMsg="+ addMsg);
		
	}

}
