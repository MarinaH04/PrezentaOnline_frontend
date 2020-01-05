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
 	String username = (String)session.getAttribute("username");
 	String firstname = (String)session.getAttribute("firstname");  
    String lastname = (String)session.getAttribute("lastname");
    String courses = (String)session.getAttribute("courses");

 %>
	<p>Welcome <%= firstname %> <%= lastname %>!</p>
	<p>Username: <%=username %></p>
	<p>Courses: <%=courses %></p>

	<table>
	<tr>
		<th>Cursuri</th>
		<th>Luni</th>
		<th>Marti</th>
		<th>Miercuri</th>
		<th>Joi</th>
		<th>Vineri</th>
	</tr>
	</table>
</body>
</html>