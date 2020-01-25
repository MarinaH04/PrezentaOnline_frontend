<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css.map" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.css.map" rel="stylesheet" type="text/css">
<link href="css/bootstrap-reboot.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-reboot.css.map" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/style.css">
 <link rel="stylesheet" type="text/css" href="css/animate.css">
</head>
<body>
	<div class="container-fluid bg">
	<div class="row">
		<img src="images/student.png" alt="student"><h1 class="title">UNIVERSITATEA "LUCIAN BLAGA" SIBIU</h1>
	</div>
	<div class="row about">
		
		<div class="col-md-4">
		<img class="animated slideInLeft" src="images/litere.jpg">
		<img class="animated slideInLeft" src="images/studentsulbs.jpg" alt="students_ulbs">
		</div>
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<img class="animated slideInRight" src="images/inginerie.jpg">
		<img class="animated slideInRight" src="images/classroom.jpg">
		</div>
	</div>

			<div class="col-xl-3 col-lg-5 col-md-5 col-sm-12">

				<form class="text-center p-5 formular form1" action="Login"
					method="post">
					<input type="text" id="defaultLoginFormEmail"
						class="form-control mb-4" name="username" placeholder="Username">
					<input type="password" id="defaultLoginFormPassword"
						class="form-control mb-4" name="password" placeholder="Password"><br>
					<button type="submit"
						class="btn btn-info btn-block my-4 buttoncolor" name="submit">LOG IN</button>
				</form>


			</div>


	</div>
	
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js.map"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="formular.js"></script>
</body>
</html>