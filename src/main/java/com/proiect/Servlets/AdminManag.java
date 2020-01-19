package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AdminManag extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

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
		System.out.println(response);
		
		
		String studenti = req.getParameter("studenti");
		String profesori = req.getParameter("profesori");
		
		if(!studenti.equals(null)) {
		WebResource webResourceUpdate = u.resource("http://localhost:8081/PrezentaOnline/userDTO/update");
		String inputUpdate = "{\"username\":" + studenti + ",\"denumire\":" + profesori +"}";
		webResourceUpdate.type("application/json").post(ClientResponse.class, inputUpdate);
		
	}
	}

}
