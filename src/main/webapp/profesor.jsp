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
    
%>

<p>Welcome <%=username %></p>
<p>Profesor: <%=firstname %> <%= lastname %></p>

	<br>
	<p>Adaugare Student: </p>
	
	<form action="prof" method="post">
		Username: <input type="text" name="username"><br>
		Firstname: <input type="text" name="firstname"><br>
		Lastname: <input type="text" name="lastname"><br> 
		Email:<input type="email" name="email"><br> 
		Password: <input type="password" name="password"><br> 
		Type: <select name="tip">
				<option>Student</option>
			  </select>
		<br> <br> 
		<input type="submit" name="add" value="add">
	</form>
	
	<form action="addDate" method="post">
		<select name="date">
			<option>-</option>
			<option>2020-01-27</option>
			<option>2020-01-28</option>
			<option>2020-01-29</option>
			<option>2020-01-30</option>
			<option>2020-01-31</option>
		</select>
		<input type="submit" value="Choose">
	</form>


	<form action="logout" class="formular_logout" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>