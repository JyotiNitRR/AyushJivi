<!DOCTYPE html>
<%@page import="patient.com.util.Patient" %>
<%@page import="patient.com.util.User" %>
<%@page import="java.util.List"%>
<html lang="en">
<head>

     <title>AyushJivi</title>

     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="Tooplate">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     <link rel="stylesheet" href="css/animate.css">
     <link rel="stylesheet" href="css/owl.carousel.css">
     <link rel="stylesheet" href="css/owl.theme.default.min.css">

     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/tooplate-style.css">

</head>
<body id="top" data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
<%
	if(request.getParameter("addMsg")!=null){
		String addMsg=request.getParameter("addMsg");
%>
<h4 style="color:green"><%= addMsg %></h4>
<%} %>
     <!-- PRE LOADER -->
     <section class="preloader">
          <div class="spinner">

               <span class="spinner-rotate"></span>
               
          </div>
     </section>
<%
      User user=null;
      if(session.getAttribute("user")!=null){
      user =(User) session.getAttribute("user");
      } 
%> 

     <!-- HEADER -->
     <header>
          <div class="container">
               <div class="row">

                    <div class="col-md-4 col-sm-5">
                         <p>Welcome to a Professional Health Care</p>
                    </div>
                       
                       
                       
                    <div class="col-md-8 col-sm-7 text-align-right">
                         <span class="phone-icon"><i class="fa fa-phone"></i> (+91) 9691133221</span>
                         <span class="date-icon"><i class="fa fa-calendar-plus-o"></i> 6:00 AM - 10:00 PM (Mon-Sat)</span>
                         <span class="email-icon"><i class="fa fa-envelope-o"></i> <a href="https://www.gmail.com/">pandeyjyoti1819@gmail.com</a></span>
                         <% if(user!=null){%>
                         <span class="phone-icon"><i> <b><%=user.getName()%></b></i></span>
                         <%} %>
                    </div>

               </div>
          </div>
     </header>


     <!-- MENU -->
     <section class="navbar navbar-default navbar-static-top" role="navigation">
          <div class="container">

               <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                        
                         
                    </button>

                    <!-- lOGO TEXT HERE -->
                    
                    <a href="index.html" class="navbar-brand"><i class="fa fa-a-square">A</i>yushJivi</a>
              		<img src="images/hospitallogo.jpg" height=60px width=60px>
               </div>

               <!-- MENU LINKS -->
              
               <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                         
                         <li><a href="#news" class="smoothScroll">News</a></li>
                         <li><a href="#google-map" class="smoothScroll">Contact</a></li>
                         <li><a href="bedsavailable">Beds Available?</a></li>
               			 <li ><a href="showallpatient">Show All Patient</a></li>
               			 <li><a href="showallappointments">Show all Appointment</a></li>
               			 <li><a href="specialities.jsp">Specialities</a></li>
                         <li><a href="#admitpatient">Admit Patient</a></li> 
                         <%if(user!=null){ %>
                         <li class="appointment-btn"><a href="Logout">Logout</a></li> 
                         <%} %>
                    </ul>
               </div>

          </div>
     </section>


     <!-- HOME -->
     <section id="home" class="slider" data-stellar-background-ratio="0.5">
          <div class="container">
               <div class="row">

                         <div class="owl-carousel owl-theme">
                              <div class="item item-first">
                                   <div class="caption">
                                        <div class="col-md-offset-1 col-md-10">
                                             <h3>Let's make your life happier</h3>
                                             <h1>Healthy Living</h1>
                                             <a href="#team" class="section-btn btn btn-default smoothScroll">Meet Our Doctors</a>
                                        </div>
                                   </div>
                              </div>

                              <div class="item item-second">
                                   <div class="caption">
                                        <div class="col-md-offset-1 col-md-10">
                                             <h3>Hospitals are about healing</h3>
                                             <h1>New Lifestyle</h1>
                                             <a href="#about" class="section-btn btn btn-default btn-gray smoothScroll">More About Us</a>
                                        </div>
                                   </div>
                              </div>

                              <div class="item item-third">
                                   <div class="caption">
                                        <div class="col-md-offset-1 col-md-10">
                                             <h3>Health is a state of complete harmony of the body, mind and spirit</h3>
                                             <h1>Your Health Benefits</h1>
                                             <a href="#news" class="section-btn btn btn-default btn-blue smoothScroll">Read Stories</a>
                                        </div>
                                   </div>
                              </div>
                         </div>

               </div>
          </div>
     </section>


     <!-- ABOUT -->
     <section id="about">
          <div class="container">
               <div class="row">

                    <div class="col-md-6 col-sm-6">
                         <div class="about-info">
                              <h2 class="wow fadeInUp" data-wow-delay="0.6s">Welcome to Your <i class="fa fa-h-square"></i>ealth Center</h2>
                              <div class="wow fadeInUp" data-wow-delay="0.8s">
                                   <p>The hospital strives to provide quality healthcare services through patient safety, service excellence and training programs.</p>
                                   <p> Our hospital is committed in providing efficient, timely and patient-friendly healthcare to its patients, through best medical practices in a clean, healthy and rejuvenating environment.</p>
                                   <p>We provide healthcare services of international standard, at a reasonable cost, by having state-of-the-art infrastructure, varied spectrum of clinical services, highly qualified and experienced professionals, dedicated staff and patient-friendly culture</p>
                              </div>
                              <figure class="profile wow fadeInUp" data-wow-delay="1s">
                                   <img src="images/author-image.jpg" class="img-responsive" alt="">
                                   <figcaption>
                                        <h3>Dr. Ravi Mukherjee</h3>
                                        <p>Founder</p>
                                   </figcaption>
                              </figure>
                         </div>
                    </div>
                    
               </div>
          </div>
     </section>


     <!-- TEAM -->
     <section id="team" data-stellar-background-ratio="1">
          <div class="container">
               <div class="row">

                    <div class="col-md-6 col-sm-6">
                         <div class="about-info">
                              <h2 class="wow fadeInUp" data-wow-delay="0.1s">Our Doctors</h2>
                         </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="col-md-4 col-sm-6">
                         <div class="team-thumb wow fadeInUp" data-wow-delay="0.2s">
                              <img src="images/team-image1.jpg" class="img-responsive" alt="">

                                   <div class="team-info">
                                        <h3>Ajay Mehra</h3>
                                        <p>General Surgeon</p>
                                        <div class="team-contact-info">
                                             <p><i class="fa fa-phone"></i> (+91) 9534534377</p>
                                             <p><i class="fa fa-envelope-o"></i> <a href="#">ajaymehra121@gmail.com</a></p>
                                        </div>
                                        <ul class="social-icon">
                                             <li><a href="https://in.linkedin.com/" class="fa fa-linkedin-square"></a></li>
                                             <li><a href="https://www.google.com/" class="fa fa-envelope-o"></a></li>
                                        </ul>
                                   </div>

                         </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                         <div class="team-thumb wow fadeInUp" data-wow-delay="0.4s">
                              <img src="images/team-image2.jpg" class="img-responsive" alt="">

                                   <div class="team-info">
                                        <h3>Manish Mishra</h3>
                                        <p>Cardiologist</p>
                                        <div class="team-contact-info">
                                             <p><i class="fa fa-phone"> (+91)8853377798 </i> <a href="#">manishmishra321@gmail.com</a></p>
                                        </div>
                                        <ul class="social-icon">
                                             <li><a href="https://www.facebook.com/" class="fa fa-facebook-square"></a></li>
                                             <li><a href="https://www.google.com/" class="fa fa-envelope-o"></a></li>
                                             <li><a href="https://twitter.com/" class="fa fa-flickr"></a></li>
                                        </ul>
                                   </div>

                         </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                         <div class="team-thumb wow fadeInUp" data-wow-delay="0.6s">
                              <img src="images/team-image3.jpg" class="img-responsive" alt="">

                                   <div class="team-info">
                                        <h3>Pooja Pandey</h3>
                                        <p>Gynaecologist</p>
                                        <div class="team-contact-info">
                                             <p><i class="fa fa-phone"></i>(+91)9691133221 </p>
                                             <p><i class="fa fa-envelope-o"></i> <a href="#">poojapandey673@gmail.com</a></p>
                                        </div>
                                        <ul class="social-icon">
                                             <li><a href="https://twitter.com/" class="fa fa-twitter"></a></li>
                                             <li><a href="https://www.google.com/" class="fa fa-envelope-o"></a></li>
                                        </ul>
                                   </div>

                         </div>
                    </div>
                    
               </div>
          </div>
     </section>


     <!-- NEWS -->
     <section id="news" data-stellar-background-ratio="2.5">
          <div class="container">
               <div class="row">

                    <div class="col-md-12 col-sm-12">
                         <!-- SECTION TITLE -->
                         <div class="section-title wow fadeInUp" data-wow-delay="0.1s">
                              <h2>Latest News</h2>
                         </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                         <!-- NEWS THUMB -->
                         <div class="news-thumb wow fadeInUp" data-wow-delay="0.4s">
                              <a href="news-detail.jsp">
                                   <img src="images/news-image1.jpg" class="img-responsive" alt="">
                              </a>
                              <div class="news-info">
                                   <span>March 08, 2020</span>
                                   <h3><a href="news-detail.jsp">About Amazing Technology</a></h3>
                                   <p>Technology can improve the efficiency of a hospital and improve the quality of care delivered to patients.Modern societies reap great benefits from technological advancements. The healthcare sector is no different.</p>
                                   <div class="author">
                                        <img src="images/author-image.jpg" class="img-responsive" alt="">
                                        <div class="author-info">
                                             <h5>Jyoti Pandey</h5>
                                             <p>CEO / Founder</p>
                                        </div>
                                   </div>
                              </div>
                         </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                         <!-- NEWS THUMB -->
                         <div class="news-thumb wow fadeInUp" data-wow-delay="0.6s">
                              <a href="news-detail3.jsp">
                                   <img src="images/news-image2.jpg" class="img-responsive" alt="">
                              </a>
                              <div class="news-info">
                                   <span>February 20, 2020</span>
                                   <h3><a href="news-detail3.jsp">Introducing a new healing process</a></h3>
                                   <p>Tissue repair is a simple linear process in which the growth factors cause cell proliferation, thus leading to an integration of dynamic changes that involve soluble mediators, blood cells including other changes observed in body.</p>
                                   <div class="author">
                                        <img src="images/author-image.jpg" class="img-responsive" alt="">
                                        <div class="author-info">
                                             <h5>Sunita Garg</h5>
                                             <p>General Director</p>
                                        </div>
                                   </div>
                              </div>
                         </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                         <!-- NEWS THUMB -->
                         <div class="news-thumb wow fadeInUp" data-wow-delay="0.8s">
                              <a href="news-detail2.jsp">
                                   <img src="images/news-image3.jpg" class="img-responsive" alt="">
                              </a>
                              <div class="news-info">
                                   <span>January 27, 2020</span>
                                   <h3><a href="news-detail2.jsp">Review Annual Medical Research</a></h3>
                                   <p>The Annual Review of Medicine covers significant developments in various fields of medicine, including AIDS/HIV, cardiology, clinical pharmacology, dermatology, endocrinology/metabolism, gastroenterology.</p>
                                   <div class="author">
                                        <img src="images/author-image.jpg" class="img-responsive" alt="">
                                        <div class="author-info">
                                             <h5>Rajeev Awasthi</h5>
                                             <p>Online Advertising</p>
                                        </div>
                                   </div>
                              </div>
                         </div>
                    </div>

               </div>
          </div>
     </section>


     <!-- Admit Patient -->
<section id="admitpatient" data-stellar-background-ratio="3">
        <div class="container">
               <div class="row">

                   <div class="col-md-6 col-sm-6">
                         <img src="images/Patient.jpg" class="img-responsive" alt="Admit_patient">
                    </div>

                  <div class="col-md-6 col-sm-6">
                         <!-- CONTACT FORM HERE -->
                         <form id="admit_patient_form" role="form" method="post" action="AdmitPatientservlet">

                           <!--    SECTION TITLE -->
                              <div class="section-title wow fadeInUp" data-wow-delay="0.4s">
                                   <h2>Admit Patient</h2>
                              </div>

                             <div class="wow fadeInUp" data-wow-delay="0.8s">
                                   <div class="col-md-6 col-sm-6">
                                        <label for="ID">Patient ID</label>
                                        <input type="text" class="form-control" id="ID" name="patient_id" placeholder="Automatically takes value" readonly style="background-color:gray">
                                   </div> 

                                    <div class="col-md-6 col-sm-6">
                                        <label for="name">Patient Name</label>
                                        <input type="text" class="form-control" id="name" name="patient_name" placeholder="Patient Name">
                                   </div>

                                     <div class="col-md-6 col-sm-6">
                                        <label for="Age">Age</label>
                                        <input type="text"  name="patient_age" id="Age" placeholder="Patient Age" class="form-control">
                                   </div>

                                    <div class="col-md-6 col-sm-6">
                                        <label for="Contact_No.">Contact No.</label>
                                        <input type="text"  name="patient_contact" id="Contact_No." placeholder="Patient Contact No." class="form-control">
                                   </div>
                                    
                                  <div class="col-md-6 col-sm-6">
                                        <label for="Consulted_Doctor">Consulted Doctor</label>
                                        <input type="text"  id="Consulted_Doctor" name="patient_consulted_doctor" placeholder="Patient's Consulted Doctor" class="form-control">
                                   </div>

                                      <div class="col-md-12 col-sm-12">
                                       	<label for="Patient's Address">Patient's Address</label>
                                        <textarea class="form-control" rows="5" id="address" name="patient_address" placeholder="Enter Patient Address"></textarea>
                                        <button type="submit" class="form-control" id="cf-submit" name="submit">Admit</button>
                                   <br>
                                  </div>
                              </div>
                        </form>
                    </div>
               </div>
          </div> 
     </section> 
	
     <!-- GOOGLE MAP -->
     <section id="google-map">
     <!-- How to change your own map point
            1. Go to Google Maps
            2. Click on your location point
            3. Click "Share" and choose "Embed map" tab
            4. Copy only URL and paste it within the src="" field below
	-->
          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3606.557359179604!2d82.99438281448691!3d25.31907173295947!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x398e2e0882c5f72b%3A0x9f505dd9e5366734!2sAlliance%20Hospital!5e0!3m2!1sen!2sin!4v1618261111948!5m2!1sen!2sin" width="100%" height="350" frameborder="0" style="border:0" allowfullscreen></iframe>
     </section>           
	
	

     <!-- FOOTER -->
     <footer data-stellar-background-ratio="5">
          <div class="container">
               <div class="row">

                    <div class="col-md-4 col-sm-4">
                         <div class="footer-thumb"> 
                              <h4 class="wow fadeInUp" data-wow-delay="0.4s">Contact Info</h4>
                              <p>Emergency Service available 24/7</p>

                              <div class="contact-info">
                                   <p><i class="fa fa-phone"></i> (+91)-9691133221</p>
                                   <p><i class="fa fa-envelope-o"></i> <a href="https://www.gmail.com/">pandeyjyoti1819@gmail.com</a></p>
                              </div>
                         </div>
                    </div>

                    <div class="col-md-4 col-sm-4"> 
                         <div class="footer-thumb"> 
                              <h4 class="wow fadeInUp" data-wow-delay="0.4s">Latest News</h4>
                              <div class="latest-stories">
                                   <div class="stories-image">
                                        <a href="news-detail.jsp"><img src="images/news-image.jpg" class="img-responsive" alt=""></a>
                                   </div>
                                   <div class="stories-info">
                                        <a href="news-detail.jsp"><h5>Amazing Technology</h5></a>
                                        <span>March 08, 2020</span>
                                   </div>
                              </div>

                              <div class="latest-stories">
                                   <div class="stories-image">
                                        <a href="news-detail3.jsp"><img src="images/news-image.jpg" class="img-responsive" alt=""></a>
                                   </div>
                                   <div class="stories-info">
                                        <a href="news-detail3.jsp"><h5>New Healing Process</h5></a>
                                        <span>February 20, 2020</span>
                                   </div>
                              </div>
                         </div>
                    </div>

                    <div class="col-md-4 col-sm-4"> 
                         <div class="footer-thumb">
                              <div class="opening-hours">
                                   <h4 class="wow fadeInUp" data-wow-delay="0.4s">Opening Hours</h4>
                                   <p>Monday -Friday <span>06:00 AM - 10:00 PM</span></p>
                                   <p>Saturday <span>09:00 AM - 08:00 PM</span></p>
                                   <p>Sunday <span>Closed</span></p>
                              </div> 

                              <ul class="social-icon">
                                   <li><a href="https://www.facebook.com/" class="fa fa-facebook-square" attr="facebook icon"></a></li>
                                   <li><a href="https://twitter.com/" class="fa fa-twitter"></a></li>
                                   <li><a href="https://www.instagram.com/" class="fa fa-instagram"></a></li>
                              </ul>
                         </div>
                    </div>

                    <div class="col-md-12 col-sm-12 border-top">
                         <div class="col-md-4 col-sm-6">
                              <div class="copyright-text"> 
                                   <p>Copyright &copy; 2018 AyushJivi
                                   
                                   | </p>
                              </div>
                         </div>
                         <div class="col-md-6 col-sm-6">
                              <div class="footer-link"> 
                                   <a href="specialities.jsp">Laboratory Tests</a>
                                   <a href="specialities.jsp">Departments</a>
                                   <a href="specialities.jsp">Insurance Policy</a>
                                   <a href="specialities.jsp">Careers</a>
                              </div>
                         </div>
                         <div class="col-md-2 col-sm-2 text-align-center">
                              <div class="angle-up-btn"> 
                                  <a href="#top" class="smoothScroll wow fadeInUp" data-wow-delay="1.2s"><i class="fa fa-angle-up"></i></a>
                              </div>
                         </div>   
                    </div>
                    
               </div>
          </div>
     </footer>

     <!-- SCRIPTS -->
     <script src="js/jquery.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script src="js/jquery.sticky.js"></script>
     <script src="js/jquery.stellar.min.js"></script>
     <script src="js/wow.min.js"></script>
     <script src="js/smoothscroll.js"></script>
     <script src="js/owl.carousel.min.js"></script>
     <script src="js/custom.js"></script>

</body>
</html>



