<!doctype html>

<html lang="en">
  <head>
  	<title>Output</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">

	</head>
	<body class="img js-fullheight" style="background-image: url(images/signupback.jpg); height:1000;width:100%">
	  <a href="index.jsp">back to home</a>
	  <% if(request.getParameter("addMsg")!=null){ %>
		  <h1 style="color:green"><%=request.getParameter("addMsg") %> </h1><br>
	  <%}%>
 	
	
	<% if(request.getAttribute("errorCode")!=null){  %>
      <h1 style="color:red"><%=request.getAttribute("errorCode")%></h1>
      <h1 style="color:whitesmoke"><%=request.getAttribute("addMsg")%></h1>
   <%}%>
	
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

