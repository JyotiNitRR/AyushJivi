<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="patient.com.util.Patient" %>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<title>Show Patient</title>
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
	</head>
<body class="img js-fullheight" style="background-image: url(images/news-image.jpg); height:1000;width:100%">

 <% String errorMsg = (String)request.getAttribute("errorCode");
    List<Patient> patientList = (List<Patient>)request.getAttribute("allpatient");	
%>
<a href="Admin.jsp">Back to Home</a>
<h1 style="color:gray"><center><b><u>Patient List</u></b></center></h1><br><br>
 <table class="center" width="80%" border="2" style="color:whitesmoke;font-family:Georgia, Garamond, Serif;font-style:italic">
	<tr>
	<th>Patient_ID</th>
	<th>Patient_Name</th>
	<th>Age</th>
	<th>Contact_No</th>
	<th>Address</th>
	<th>Consulted_Doctor</th>
	<th>Action</th>
	</tr>
					   
					   <%
					   
					   for(Patient patient : patientList ){ %>
					   <tr>
					    <td><%=patient.getPatient_id() %></td>
					    <td><%=patient.getPatient_name() %></td>
					    <td><%=patient.getPatient_age() %></td>
					    <td><%=patient.getContact()%></td>
					    <td><%=patient.getPatient_address() %></td>
					    <td><%=patient.getConsulted_doctor()%></td>
					     
					     
					    <td align="center">
					    
					      
					      <a href="updatepatient?patient_id=<%=patient.getPatient_id()%>">update</a>&nbsp;&nbsp;
					      <a href="DischargePatient?patient_id=<%=patient.getPatient_id()%>">delete</a>&nbsp;&nbsp;
					     
					    </td>
					   </tr>
					  <%} %>
					   
					   
					   <% if(patientList.isEmpty()){ %>
					   <tr>
					    <td colspan="6" align="center"><h1 style="color:red">No Patient</h1></td>
					   </tr> 
					   <%} %> 
					  </table>
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>	   
       
</body>
</html>