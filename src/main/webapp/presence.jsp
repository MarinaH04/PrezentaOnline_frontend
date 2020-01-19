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
	String username = (String) session.getAttribute("username");
	JSONArray lista = (JSONArray) session.getAttribute("lista");
	String present = (String) session.getAttribute("present");
%>


<p><%=username %></p>



</body>
</html>