<!DOCTYPE html>
<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<html lang="en">
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

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
<body class="goto-here">

	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.html">Vegefoods</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="loginlandinghome"
						class="nav-link">Home</a></li>
					<li class="nav-item active"><a href="afterloginlanding"
						class="nav-link">Products</a></li>
					<li class="nav-item active"><a href="shoppingpage"
						class="nav-link">Shop</a></li>
					<!-- 					<li class="nav-item"><a href="about.html" class="nav-link">Login</a></li>
					<li class="nav-item"><a href="blog.html" class="nav-link">Register</a></li> -->
					<li class="nav-item cta cta-colored"><a href="cartpage"
						class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>
					<li class="nav-item active"><a href="logout" class="nav-link">Logout</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
	<div>
		<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String uid = (String) session.getAttribute("user");
		System.out.println(uid);
		if (uid == null) {
			response.sendRedirect("index");
		}
		%>
	</div>


	<div class="container mt-3" name="form1">
		<div class="row">
			<div class="col-md-12">

				<h1 class="text-center mb-3">Welcome to products</h1>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">S.No</th>
							<th scope="col">Product Name</th>
							<th scope="col">Image</th>
							<!-- 	<th scope="col">Quantity</th> -->
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>

					<tbody>
						<%-- 	<h6>"${msg}" </h6> --%>
						<c:forEach items="${products}" var="c">
							<tr>
								<td><c:out value="${c.getProductId() }" /></td>
								<td><c:out value="${c.getProductName() }" /></td>
								<td><img src="/resources/${c.getProductImage()}" width="50"></td>
								<td><c:out value="${c.getProductPrice() }" /></td>
								<!-- 		 <td> <INPUT TYPE="BUTTON" VALUE="Button1" ONCLICK="sample()"></td> -->
								<td><a href="addtocart?productId=${c.getProductId()}"><INPUT
										TYPE="BUTTON" VALUE="AddToCart" ONCLICK="sample()"></a></td>
							</tr>
						</c:forEach>

					</tbody>


				</table>






			</div>



		</div>


	</div>

	<script>
		function sample() {

			alert("Item added into cart");
		}
	</script>
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
  </body>
  </html>