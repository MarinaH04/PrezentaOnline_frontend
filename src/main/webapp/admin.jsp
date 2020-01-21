<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="org.codehaus.jettison.json.JSONArray" %> 
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@ page import="java.util.List" %>
<%@ page import="com.commons.UserShowDTO" %>
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
<link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
		String email = (String)session.getAttribute("email");
		String password = (String)session.getAttribute("password");
		List<UserShowDTO> users = (List<UserShowDTO>) session.getAttribute("admin");
		List<UserShowDTO> student = (List<UserShowDTO>) session.getAttribute("student");
		List<UserShowDTO> prof = (List<UserShowDTO>) session.getAttribute("prof");
		List<UserShowDTO> studprof = (List<UserShowDTO>) session.getAttribute("studprof");
	%>
	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(123, 89, 124)">
  <a class="navbar-brand" href="#">Admin ULBS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Acasa <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Despre</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact</a>
      </li>
    </ul>
    <span class="navbar-text">
    Welcome <%= username %>
    </span>
  </div>
</nav>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 editing"><p id="editare">Edit account</p></div>
		<div class="col-md-4 editing"><p id="delete">Insert user</p></div>
		<div class="col-md-4 editing"><p id="logout">Log out</p></div>

	
	</div>

		Admin:
		<%=firstname%>
		<%=lastname%>
	<br>
<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 mt-5" id="afisare">
				<form action="edit" class="formular_edit" method="post">
				<p>Edit your account</p>
					<hr>
					<span><img src="images/user.png"></span> <input type="text" class="formtext" name="usernamedit" value=<%=username%> readonly> 
					<span><img src="images/user.png"></span>  <input type="text" class="formtext" name="firstnamedit" value=<%=firstname%>><br>
					<span><img src="images/user.png"></span>  <input type="text" class="formtext" name="lastnamedit" value=<%=lastname%>><br> 
					<span><img src="images/envelope.png"></span> <input type="email" class="formtext" name="emailedit" value=<%=email%>><br> 
					<span><img src="images/key.png"></span> <input type="password" class="formtext" name="passwordedit" value=<%=password%>>
					<input type="submit" value="Edit">
				</form>
				
				
				<br> <br> Adaugare user:
				<form action="admin" class="formular_insert" method="post">
					Username: <input type="text" name="username"><br>
					Firstname: <input type="text" name="firstname"><br>
					Lastname: <input type="text" name="lastname"><br>
					Email: <input type="email" name="email"><br> Password:
					<input type="password" name="password"><br> Type: <select
						name="tip">
						<option>Profesor</option>
						<option>Student</option>
						<option>Admin</option>
					</select><br> <br> <input type="submit" name="add" value="add">
				</form>

				<form action="logout" class="formular_logout" method="post">
					<input type="submit" value="Log out">
				</form>
		</div>
</div>
				
				
	Admini:
	<table>
	<tr>
		<th>Admin</th>
		<th>Username</th>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Email</th>
	</tr>
			<%
			int var = 0;
			for(UserShowDTO userDTO: users){
		%>
		<tr>
			<td><%=++var %></td>
			<td><%=userDTO.getUsername() %></td>
			<td><%=userDTO.getFirstname() %></td>
			<td><%=userDTO.getLastname() %></td>
			<td><%=userDTO.getEmail() %>
		</tr>
	

		<%
			}
		%>
	</table>
	<br>
	<p>Studenti: </p>
	<table>
		<tr>
			<th>Students</th>
			<th>Username</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
		</tr>
		<%
			int var1 = 0;
			for (UserShowDTO studentDTO : student) {
		%>
		<tr>
			<td><%=++var1%></td>
			<td><%=studentDTO.getUsername()%></td>
			<td><%=studentDTO.getFirstname()%></td>
			<td><%=studentDTO.getLastname()%></td>
			<td><%=studentDTO.getEmail()%>
		</tr>


		<%
			}
		%>
	</table>
	
	<br>
	<p>Profesori: </p>
		<table>
		<tr>
			<th>Teacher</th>
			<th>Username</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
		</tr>
		<%
			int var2 = 0;
			for (UserShowDTO profDTO : prof) {
		%>
		<tr>
			<td><%=++var2%></td>
			<td><%=profDTO.getUsername()%></td>
			<td><%=profDTO.getFirstname()%></td>
			<td><%=profDTO.getLastname()%></td>
			<td><%=profDTO.getEmail()%></td>
		</tr>


		<%
			}
		%>
	</table>
	<form action="update" method="post">
		<select name="studenti">
			<% for(UserShowDTO stud: student){ %>
			<option><%=stud.getUsername() %></option>
			<%} %>
		</select> <br> <select name="profesori">
			<% for(UserShowDTO pr:prof){ %>
			<option><%=pr.getUsername() %></option>
			<%} %>
		</select> <br> <input type="submit" value="Adauga">

	</form>
	
	<p>STERGERE USER!</p>
	<form action="delete" method="post">
		<select name="userdelete">
			<% for(UserShowDTO stud: studprof){ %>
			<option><%=stud.getUsername() %></option>
			<%} %>

		</select>
		<input type="submit" value="delete">
	</form>



</div>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js.map"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="formular.js"></script>
</body>
</html>