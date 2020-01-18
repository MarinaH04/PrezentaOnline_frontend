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
	
	String date = (String) session.getAttribute("date");
	JSONArray users = (JSONArray) session.getAttribute("users"); 
	
%>
<form action="prezenta" method = "post">
	<table>
		<tr>
			<th>Studenti</th>
			<th><input type="text" name="date" value=<%=date %>></th>
			
		</tr>
		<%
			int i = 0;
			int nrstud = 0;
			while (i < users.length()) {
				String obj = users.getString(i);
				i++;
				nrstud++;
		%>
		<tr>
			<td><input type="text" name=<%=obj %> value=<%=obj%> readonly></td>
			<td><select name = <%=obj + "presence"%>><option>-</option><option>Yes</option><option>No</option></select></td>
		</tr>
		


		<%
			}
		%>	
		<tr>
			<td><input type="text" name="nrstudenti" value=<%=nrstud %>></td>
		</tr>
	</table>
	<input type="submit" value="Trimite">
</form>

<br><br>

	<form action="logout" class="formular_logout" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>