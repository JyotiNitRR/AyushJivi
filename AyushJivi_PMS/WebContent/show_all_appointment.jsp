<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="patient.com.util.Appointmentperson" %>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<title>Show Appointment</title>
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
	</head>
<body class="img js-fullheight" style="background-image: url(images/news-image.jpg); height:1000;width:100%">

 <% String errorMsg = (String)request.getAttribute("errorCode");
    List<Appointmentperson> appointment = (List<Appointmentperson>)request.getAttribute("allappointments");	
 %>
<a href="Admin.jsp">Back to Home</a>
<h1 style="color:black"><center><u><b>All Appointment</b></u></center></h1><br><br>

 <table class="center" width="80%" border="2" style="color:whitesmoke;font-family:Georgia, Garamond, Serif;font-style:italic">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Phone_No.</th>
	<th>Message</th>
	<th>E-Mail</th>
	<th>Appointment Date</th>
	<th>Department</th>
	
	</tr>
					   
					   <%
					   for(Appointmentperson person : appointment ){ %>
					   <tr>
					    <td><%=person.getId() %></td>
					    <td><%=person.getName() %></td>
					    <td><%=person.getPhone() %></td>
					    <td><%=person.getMessage()%></td>
					    <td><%=person.getEmail() %></td>
					    <td><%=person.getApdate()%></td>
					    <td><%=person.getDepartment()%></td>
					   </tr>
					  <%} %>
					   
					   
					   <% if(appointment.isEmpty()){ %>
					   <tr>
					    <td colspan="6" align="center"><h1 style="color:red">No Appointment</h1></td>
					   </tr> 
					   <%} %> 
					  </table>
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>	   
       
</body>
</html>