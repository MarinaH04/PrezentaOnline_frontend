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
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
		List<UserShowDTO> users = (List<UserShowDTO>) session.getAttribute("admin");
		List<UserShowDTO> student = (List<UserShowDTO>) session.getAttribute("student");
		List<UserShowDTO> prof = (List<UserShowDTO>) session.getAttribute("prof");
	%>
	<p>
		Welcome
		<%=username%></p>
	<p>
		Admin:
		<%=firstname%>
		<%=lastname%></p>
	<br>
	<form action="admin" method="post">
		Username: <input type="text" name="username"><br>
		Firstname: <input type="text" name="firstname"><br>
		Lastname: <input type="text" name="lastname"><br> Email:
		<input type="email" name="email"><br> Password: <input
			type="password" name="password"><br> 
		Type: <select name="tip">
			<option>Profesor</option>
			<option>Student</option>
			<option>Admin</option>
		</select><br>
		<br> <input type="submit" name="add" value="add">
	</form>
	
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
			<th>Students</th>
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
		</select>
		<br>
		<select name="profesori">
		<% for(UserShowDTO pr:prof){ %>
			<option><%=pr.getUsername() %></option>
		<%} %>
		</select>
		<br>
		<input type="submit" value="Adauga">
	
	</form>
	
</body>
</html>