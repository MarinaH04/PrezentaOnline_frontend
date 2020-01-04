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
%>

<p>Welcome <%=username %></p>
<p>Teacher: <%=firstname %> <%= lastname %></p>
</body>
</html>