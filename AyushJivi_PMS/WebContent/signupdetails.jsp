<!doctype html>

<html lang="en">
  <head>
  	<title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">

	</head>
	<body class="img js-fullheight" style="background-image: url(images/signupback.jpg); height:1000;width:100%">
	  <% String userEmail= "";
	 	userEmail  = (String)session.getAttribute("userEmail");	
 	 %>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Sign Up</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      
		      	<form action="signupdb" class="signin-form" method="post">
		      		<div class="form-group">
		      			<input type="text" class="form-control" name="user_id" readonly placeholder="Enter your ID" style="background-color:gray" required>
		      		</div>
		      		<div class="form-group">
		      			<input type="text" class="form-control" name="user_name" required placeholder="Enter Your Name">
		      		</div>
		      		<div class="form-group">
		      			<input type="email" class="form-control" name="user_email" readonly value="<%=userEmail%>" style="background-color:gray" required>
		      		</div>
	            <div class="form-group">
	              <input id="password-field" type="password" class="form-control" name="user_password" placeholder="Your Password" required>
	              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            </div>
	            <div class="form-group">
	            	<button type="submit" class="form-control btn btn-primary submit px-3">Sign Up</button>
	            </div>
	          </form>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

