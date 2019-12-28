package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//		 System.out.println(username1 + firstname + lastname);
		System.out.println(output);

		session.setAttribute("username", username);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		res.sendRedirect("student.jsp");

	}
}
