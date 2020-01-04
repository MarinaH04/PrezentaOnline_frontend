<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
	%>
	<p>
		Welcome
		<%=username%></p>
	<p>
		Admin:
		<%=firstname%>
		<%=lastname%></p>
	<br>
	<form action="" method="post">
		Username: <input type="text" name="username"><br>
		Firstname: <input type="text" name="firstname"><br>
		Lastname: <input type="text" name="lastname"><br> Email:
		<input type="email" name="email"><br> Password: <input
			type="password" name="password"><br> Type: <select>
			<option>Profesor</option>
			<option>Student</option>
		</select><br>
		<br> <input type="submit" name="add" value="add">
	</form>
</body>
</html>