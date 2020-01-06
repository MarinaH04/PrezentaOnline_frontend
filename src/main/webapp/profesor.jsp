<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.codehaus.jettison.json.JSONArray" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username = (String)session.getAttribute("username");
 	String firstname = (String)session.getAttribute("firstname");  
    String lastname = (String)session.getAttribute("lastname");
    JSONArray users = (JSONArray) session.getAttribute("users");
%>

<p>Welcome <%=username %></p>
<p>Profesor: <%=firstname %> <%= lastname %></p>
	<table>
		<tr>
			<th>Studenti</th>
			<th>Luni</th>
			<th>Marti</th>
			<th>Miercuri</th>
			<th>Joi</th>
			<th>Vineri</th>
		</tr>
		<%
			int i = 0;
			while (i < users.length()) {
				String obj = users.getString(i);
				i++;
		%>
		<tr><td><%= obj%></td></tr>


		<%
			}
		%>
	</table>
	<br>
	<p>Adaugare Student: </p>
	<form action="prof" method="post">
		Username: <input type="text" name="username"><br>
		Firstname: <input type="text" name="firstname"><br>
		Lastname: <input type="text" name="lastname"><br> Email:
		<input type="email" name="email"><br> Password: <input
			type="password" name="password"><br> 
		Type: <select name="tip">
			<option>Student</option>
		</select><br>
		<br> <input type="submit" name="add" value="add">
	</form>
</body>
</html>