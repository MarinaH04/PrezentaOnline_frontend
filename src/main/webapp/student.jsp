<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.codehaus.jettison.json.JSONArray" %> 
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
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
	JSONArray lista = (JSONArray) session.getAttribute("lista");
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
		<%
			int i = 0;
			while (i < lista.length()) {
				String obj = lista.getString(i);
				i++;
		%>
		<tr><td><%= obj%></td></tr>


		<%
			}
		%>
	</table>

	<form action="logout" class="formular_logout" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>