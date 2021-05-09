
<!doctype html>

<html lang="en">
  <head>
  	<title>Beds Available</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet"> 
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
  <link rel="stylesheet" href="css/style.css">  

	</head>
	<%
        int freeBeds=(int)request.getAttribute("freeBeds");
	 %>
	<body class="img js-fullheight" style="background-image: url(images/news-image2.jpg); height:655px;width:100%">
		<%if(freeBeds>0){ %>
		<font size="7px" color="green" align="center" >Beds Available</font>
		<%}else{ %>
			<font size="7px" color="crimson" align="center" >Sorry,Beds are NOT Available!</font>
		<%} %>
    </body>
</html>