<%@page import="patient.com.util.Patient" %>
<!doctype html>

<html lang="en">
  <head>
  	<title>Update Patient</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet"> 
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
  <link rel="stylesheet" href="css/style.css">  

	</head>
	<%
        Patient patient=(Patient)request.getAttribute("patient");
	 %>
	<body class="img js-fullheight" style="background-image: url(images/news-image2.jpg); height:2000;width:100%">
	<div class="container">
               <div class="row">
                <div class="col-md-6 col-sm-6">
                         <!-- CONTACT FORM HERE -->
                         <form id="update patient" role="form" method="post" action="updatepatient">

                           <!--    SECTION TITLE -->
                              <div class="section-title wow fadeInUp" data-wow-delay="0.4s">
                                  <h2 style="color:orange;font-family: Lucida Handwriting"><font size=10px><u>Update Patient</u></font></h2>
                              </div>

                             <div class="wow fadeInUp" data-wow-delay="0.8s">
                                   <div class="col-md-6 col-sm-6">
                                        <label for="ID"><font color="black" size=4> Patient ID</font></label>
                                       <input type="text" required class="form-control" id="ID" value="<%=patient.getPatient_id() %>" name="patient_id" readonly style="background-color:gray">
                                   </div> 

                                    <div class="col-md-6 col-sm-6">
                                        <label for="name"><font color="black" size=4> Patient Name </font> </label>
                                        <input type="text"  required id="name" class="form-control" value="<%=patient.getPatient_name() %>" name="patient_name">
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                       <label for="Age"><font color="black" size=4>Age</font> </label>
                                       <input type="text"  required class="form-control" name="age" value="<%=patient.getPatient_age() %>">
                                    </div>
                                   <div class="col-md-6 col-sm-6">
                                      <label for="Contact_No."><font color="black" size=4> Contact No.</font></label>
                                      <input type="text"  required class="form-control" name="contact" value="<%=patient.getContact() %>">
                                   </div>
                                   <div class="col-md-6 col-sm-6">
                                       <label for="Consulted_Doctor"><font color="black" size=4>Consulted Doctor</font></label>
                                   	   <input type="text"  required class="form-control" name="Consulted_doctor" value="<%=patient.getConsulted_doctor() %>">
                                   	</div>
                                   	<div class="col-md-12 col-sm-12">
                                   	   <label for="Patient's Address"><font color="black" size=5>Patient's Address</font></label>
                                   	   <textarea name="address" required  rows=4 cols=45><%=patient.getPatient_address() %></textarea>
                                   	   <button type="submit" class="form-control" id="cf-submit" name="submit"><font color="black" size=6>Update</font></button>
                                   	   <br>
                                   	    </div>
                              </div>
                        </form>
                    </div>
               </div>
          </div> 
          </body>
</html>