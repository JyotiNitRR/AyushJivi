package patient.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Emailotpvalidation")
public class Emailotpvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("otp.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userInputOtp=request.getParameter("received_otp");
		HttpSession session=request.getSession();
		String createdOtp=(String)session.getAttribute("otp");
		if(userInputOtp.equals(createdOtp)){
			request.getRequestDispatcher("signupdetails.jsp").forward(request, response);
		}
		else{
			request.setAttribute("otpError", "Enter correct OTP");
			request.getRequestDispatcher("otp.jsp").forward(request, response);
		}
	}

}
