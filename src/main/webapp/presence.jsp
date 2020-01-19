<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="org.codehaus.jettison.json.JSONArray" %> 
<%@ page import="org.codehaus.jettison.json.JSONObject"  %>
<%@	page import="java.util.List"%>

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
	List<String> dataPresence = (List<String>) session.getAttribute("dataPresence");
	List<String> data = (List<String>) session.getAttribute("data");
%>


<p><%=username %></p>

<p><%=dataPresence %></p>
	<table>
		<tr>
			<th>Cursuri</th>
			<%
			int j= 0;
			while(j < data.size()){
				String objData = data.get(j);
			%>
			<th><%=objData %></th>
			<% 	j++;
			}
			%>
		</tr>
		<%
			int i = 0;
			while (i < lista.length()) {
				String obj = lista.getString(i);
				i++;
		%>
		<tr><td><%= obj%></td></tr>
			<td><%
				
			%></td>

		<%
			}
		
		%>
	</table>
	


</body>
</html>