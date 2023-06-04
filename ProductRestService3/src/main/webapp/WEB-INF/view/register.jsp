<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <style>

  #heading1 {
	text-align: center;
	padding: 30px;
}
  
  </style>
 
  
 <%
 if("${msg}".equals("true")) {
%>
<script> msg();</script>
<%
}
else {

}
%> 
 


  <body class="goto-here">
 
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Vegefoods</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	         <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="index" class="nav-link">Home</a></li>
	                  <li class="nav-item"><a href="login" class="nav-link">Login</a></li>
	             <li class="nav-item active"><a href="adminlogin" class="nav-link">Admin login</a></li>
	            <li class="nav-item active"><a href="adminregister" class="nav-link">Admin Register</a></li>
	         
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
	<div class="message">
		<div class="col-md-6 offset-md-3">
			<p class="text-center mb-1" style="color:red;">${msg}</p>
		</div>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h1 id="heading1">Register Here</h1>

				<form action="saveuser" method="post">
					<div class="form-group">
						<label for="name">User Name</label> <input type="text"
							class="form-control" id="name" aria-describedly="emailHelp"
							name="name" placeholder="Enter the user name"
							required>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							placeholder="Enter the email"
							name="email" class="form-control" id="price" required>

					</div>
					<div class="form-group">
						<label for="password">password</label> <input type="text"
							class="form-control" name="password" id="password"
							rows="5" placeholder="Enter the password" required>
						</textarea>
					</div>

					<div class="form-group">
						<label for="phoneNumber">Phonenumber</label> <input type="tel"
							placeholder="Enter the phonenumber" name="phoneNumber"
							class="form-control" id="quantity" maxlength="10" pattern="\d{10}"
					title="Please enter exactly 10 digits" required />

					</div>


					<div class="container-text-center">
						<%--  	<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger"> Back</a>  --%>
						<button type="submit"  class="btn btn-primary">Register</button>
					</div>

				</form>
			</div>
		</div>
	</div>
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>

	<script>
		function msg() {

			alert("already ");
		}
	</script>
	</body>
</html>