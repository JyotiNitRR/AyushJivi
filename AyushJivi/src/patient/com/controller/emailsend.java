package patient.com.controller;

import javax.mail.*;
import javax.mail.internet.*;
import patient.com.util.*;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class emailsend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientUserEmail  =request.getParameter("user_email");
		Random  rand  = new Random();
		int otpNum  = (rand.nextInt(1001)+1000); //1000-2000
		String otp = otpNum+"";
		HttpSession session=request.getSession();
		session.setAttribute("otp", otp);
		  final String senderEmailId = "jyotiupcnitmca@gmail.com";
		final String senderPassword = Emailpassword.getPassword();
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		System.out.println("login starting .....");
		Session email_session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmailId, senderPassword);
			}
		  });
		try {
			System.out.println("message sending");
			
			Message message = new MimeMessage(email_session);
			message.setFrom(new InternetAddress(senderEmailId));
			
			String receiverEmailList=clientUserEmail;
			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverEmailList));
			
			String subject= "OTP :signup";
			message.setSubject(subject);
				
			String dataText="Your OTP for Sign Up is "+otp;
			message.setText(dataText);
			
			Transport.send(message);
			System.out.println("message sent ");
		} catch (MessagingException e) {
			
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
		session.setAttribute("userEmail", clientUserEmail);
		request.getRequestDispatcher("otp.jsp").forward(request, response);
	}

}
