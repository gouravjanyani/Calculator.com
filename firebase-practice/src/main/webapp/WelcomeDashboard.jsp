<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
@import url('https://fonts.googleapis.com/css2?family=Lobster&display=swap');
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
</head>
<body>
<!-- Section: Design Block -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand fw-bold text-primary mx-5" href="#">Calculator.com</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse float-right" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="Home.html">Home</a></li>
					<li class="nav-item dropdown dropdown show"><a
						class=" nav-link dropdown-toggle dropdown-toggle" href="#"
						role="button" id="dropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Products </a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="index.html">Income Tax
								Calculator</a><!--  <a class="dropdown-item" href="#">Another action</a>
							<a class="dropdown-item" href="#">Something else here</a> -->
						</div></li>
					
					<li class="nav-item"><a class="nav-link" href="AdminSignIn.html">Admin
							Portal</a></li>

					<!-- <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li> -->
				</ul>
			</div>
		</div>
	</nav>
	<section class="background-radial-gradient overflow-hidden"
		style="height: 100vh">
		<style>
.background-radial-gradient {
	background-color: hsl(218, 41%, 15%);
	background-image: radial-gradient(650px circle at 0% 0%, hsl(218, 41%, 35%)
		15%, hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%,
		hsl(218, 41%, 19%) 80%, transparent 100%),
		radial-gradient(1250px circle at 100% 100%, hsl(218, 41%, 45%) 15%,
		hsl(218, 41%, 30%) 35%, hsl(218, 41%, 20%) 75%, hsl(218, 41%, 19%) 80%,
		transparent 100%);
}

#radius-shape-1 {
	height: 220px;
	width: 220px;
	top: -60px;
	left: -130px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

#radius-shape-2 {
	border-radius: 38% 62% 63% 37%/70% 33% 67% 30%;
	bottom: -60px;
	right: -110px;
	width: 300px;
	height: 300px;
	background: radial-gradient(#44006b, #ad1fff);
	overflow: hidden;
}

.bg-glass {
	background-color: hsla(0, 0%, 100%, 0.9) !important;
	backdrop-filter: saturate(200%) blur(25px);
}
</style>

<div class="text-center pt-5 text-white h1">
	<%
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		long salary = Long.parseLong(request.getParameter("salary"));
		out.println(" Welcome <span style=\"font-family: 'Lobster\', cursive;\">" + firstname + " " + lastname + "</span> to our Dashboard");
	%>
</div>

<div class="text-center pt-5 text-white h3">
	<%
		out.println(request.getAttribute("output"));
	%>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>