package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Login2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		
		/* **** LOGIN **** */
		Client c = Client.create();

		WebResource webResource = c.resource("http://localhost:8081/PrezentaOnline/userDTO");

		String input = "{\"username\":" + username + ",\"password\":" + password + "}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		JSONObject output = response.getEntity(JSONObject.class);
		
		String firstname = "";
		String lastname = "";

		try {
			firstname = output.getString("firstname");
			lastname = output.getString("lastname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		/*   Found UserType */
		WebResource webUserType = c.resource("http://localhost:8081/PrezentaOnline/userDTO/usertype/" + username);
		ClientResponse responseUserType = webUserType.type("application/json").get(ClientResponse.class);
		JSONObject outputUserType = responseUserType.getEntity(JSONObject.class);
		String userType = "";
		try {
			userType = outputUserType.getString("tip");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		
		WebResource webResourceUsersType = c.resource("http://localhost:8081/PrezentaOnline/userDTO/byusertype/Admin");
		ClientResponse responseUsersType = webResourceUsersType.type("application/json").get(ClientResponse.class);
		JSONArray resultUserType = responseUsersType.getEntity(JSONArray.class);
		
		/* Courses of a student */
		WebResource webResourceCourses = c.resource("http://localhost:8081/PrezentaOnline/userDTO/course/"+ username);
		ClientResponse responseCourse = webResourceCourses.type("application/json").get(ClientResponse.class);
		JSONObject resultCourse = responseCourse.getEntity(JSONObject.class);
		String courses = "";
		try {
			courses = resultCourse.getString("courses");
		} catch (Exception e) {
		}
		JSONArray jArray = new JSONArray();
		try {
			jArray = resultCourse.getJSONArray("courses");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		System.out.println(jArray);
		String denumire = jArray.toString();
		
		/* Students of a teacher */
		
		JSONArray students = new JSONArray();
		if (userType.equals("Profesor")) {
		denumire = denumire.substring(2, denumire.length()-2);
		WebResource webResourceUsers = c.resource("http://localhost:8081/PrezentaOnline/courseDTO/users/"+ denumire);
		ClientResponse responseUser = webResourceUsers.type("application/json").get(ClientResponse.class);
		JSONObject resultUser = responseUser.getEntity(JSONObject.class);
		System.out.println(resultUser);
		JSONArray jUsers = new JSONArray();
		
		try {
			jUsers = resultUser.getJSONArray("users");
			int i = 0;
			while(i<jUsers.length()) {
				if(jUsers.getString(i).equals(username)) {}
				else {
				students.put(jUsers.getString(i));}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		session.setAttribute("username", username);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("courses", courses);
		session.setAttribute("lista", jArray);
		session.setAttribute("users", students);
		session.setAttribute("admin", resultUserType);
		

		
		if (userType.equals("Student")) {
			res.sendRedirect("student.jsp");
		} 
		
		else if (userType.equals("Profesor")) {
			res.sendRedirect("profesor.jsp");
		} 
		
		else if (userType.equals("Admin")) {
			res.sendRedirect("admin.jsp");
		} 
		
		else System.out.println("Error");
	}
}
