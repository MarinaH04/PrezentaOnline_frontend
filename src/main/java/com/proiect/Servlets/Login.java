package com.proiect.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.commons.UserShowDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Login extends HttpServlet {

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
		if(response.getStatus() == 200) {
		
		JSONObject output = response.getEntity(JSONObject.class);
		
		String firstname = "";
		String lastname = "";
		String email = "";
		

		try {
			firstname = output.getString("firstname");
			lastname = output.getString("lastname");
			email = output.getString("email");
		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		

		
		/*   Finding UserType */
		WebResource webUserType = c.resource("http://localhost:8081/PrezentaOnline/userDTO/usertype/" + username);
		ClientResponse responseUserType = webUserType.type("application/json").get(ClientResponse.class);
		JSONObject outputUserType = responseUserType.getEntity(JSONObject.class);
		String userType = "";
		try {
			userType = outputUserType.getString("tip");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		/* *** Admin page ** */
		
		if(userType.equals("Admin")) {
		
		WebResource webResourceUsersType = c.resource("http://localhost:8081/PrezentaOnline/userDTO/byusertype/Admin");
		ClientResponse responseUsersType = webResourceUsersType.type("application/json").get(ClientResponse.class);
		JSONArray resultUserType = responseUsersType.getEntity(JSONArray.class);
		int j = 0;
		JSONObject obj = new JSONObject();
		List<UserShowDTO> users = new ArrayList<UserShowDTO>();
		while (j < resultUserType.length()) {
			try {
				obj = resultUserType.getJSONObject(j);
				UserShowDTO userDTO = new UserShowDTO();
				userDTO.setUsername(obj.getString("username"));
				userDTO.setLastname(obj.getString("lastname"));
				userDTO.setFirstname(obj.getString("firstname"));
				userDTO.setEmail(obj.getString("email"));
				users.add(userDTO);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			j++;}
		
		WebResource webResourceUsersTypeS = c.resource("http://localhost:8081/PrezentaOnline/userDTO/byusertype/Student");
		ClientResponse responseUsersTypeS = webResourceUsersTypeS.type("application/json").get(ClientResponse.class);
		JSONArray resultUserTypeS = responseUsersTypeS.getEntity(JSONArray.class);
		int s = 0;
		JSONObject objS = new JSONObject();
		List<UserShowDTO> student = new ArrayList<UserShowDTO>();
		while (s < resultUserTypeS.length()) {
			try {
				objS = resultUserTypeS.getJSONObject(s);
				UserShowDTO userDTO = new UserShowDTO();
				userDTO.setUsername(objS.getString("username"));
				userDTO.setLastname(objS.getString("lastname"));
				userDTO.setFirstname(objS.getString("firstname"));
				userDTO.setEmail(objS.getString("email"));
				student.add(userDTO);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			s++;}
		
		WebResource webResourceUsersTypeP = c.resource("http://localhost:8081/PrezentaOnline/userDTO/byusertype/Profesor");
		ClientResponse responseUsersTypeP = webResourceUsersTypeP.type("application/json").get(ClientResponse.class);
		JSONArray resultUserTypeP = responseUsersTypeP.getEntity(JSONArray.class);
		int p = 0;
		JSONObject objP = new JSONObject();
		List<UserShowDTO> prof = new ArrayList<UserShowDTO>();
		while (p < resultUserTypeP.length()) {
			try {
				objP = resultUserTypeP.getJSONObject(p);
				UserShowDTO profDTO = new UserShowDTO();
				profDTO.setUsername(objP.getString("username"));
				profDTO.setLastname(objP.getString("lastname"));
				profDTO.setFirstname(objP.getString("firstname"));
				profDTO.setEmail(objP.getString("email"));
				prof.add(profDTO);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			p++;}
		
		List<UserShowDTO> studprof = new ArrayList<UserShowDTO>();
		studprof.addAll(prof);
		studprof.addAll(student);
		session.setAttribute("admin", users);
		session.setAttribute("student", student);
		session.setAttribute("prof", prof);
		session.setAttribute("studprof", studprof);
		}
		
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
		
		
		/*  SESSION SAVING... */
		session.setAttribute("username", username);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("courses", courses);
		session.setAttribute("lista", jArray);
		session.setAttribute("users", students);



		if (userType.equals("Student")) {
			RequestDispatcher rs = req.getRequestDispatcher("student.jsp");
			rs.forward(req, res);
		} 
		
		else if (userType.equals("Profesor")) {
			RequestDispatcher rs = req.getRequestDispatcher("profesor.jsp");
			rs.forward(req, res);
		} 
		
		else if (userType.equals("Admin")) {
			RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
			rs.forward(req, res);
		} 
		}
		else {
			RequestDispatcher rs = req.getRequestDispatcher("Login.jsp");
			PrintWriter out = res.getWriter();
	        out.write("<html><body><div id='serlvetResponse' >");
			out.write("<p id='errMsg' style='color: red; font-size: larger;'>Username or Password invalid!</p>");
			rs.include(req, res);
		}
		}
	}

