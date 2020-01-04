package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AdminManag extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String tip = req.getParameter("tip");
		
		Client u = Client.create();
		WebResource webResource = u.resource("http://localhost:8081/PrezentaOnline/userDTO/insert");
		String input = "{\"username\":" + username + ",\"firstname\":" + firstname + ",\"lastname\":" + lastname + ",\"email\":" + email + ",\"password\":" + password + ",\"tip\":" + tip + "}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		JSONObject output = response.getEntity(JSONObject.class);
//		String username1 ="";
//		try {
//			username1 = output.getString("username");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(username1);
	System.out.println(firstname + username + lastname + email + password + tip);
	}

}
