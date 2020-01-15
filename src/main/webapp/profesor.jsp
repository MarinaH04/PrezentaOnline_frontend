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
<form action="prezenta" method = "post">
	<table>
		<tr>
			<th>Studenti</th>
			<th><input type="text" name="date1" value="2020-01-20"></th>
			<th><input type="text" name="date2" value="2020-01-21"></th>
			<th><input type="text" name="date3" value="2020-01-22"></th>
			<th><input type="text" name="date4" value="2020-01-23"></th>
			<th><input type="text" name="date5" value="2020-01-24"></th>
			
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
			<td><select name = <%=obj + "presence1"%>><option>-</option><option>Yes</option><option>No</option></select></td>
			<td><select name = "presence2"><option>-</option><option>Yes</option><option>No</option></select></td>
			<td><select name = "presence3"><option>-</option><option>Yes</option><option>No</option></select></td>
			<td><select name = "presence4"><option>-</option><option>Yes</option><option>No</option></select></td>
			<td><select name = "presence5"><option>-</option><option>Yes</option><option>No</option></select></td>
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



	<form action="logout" class="formular_logout" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>