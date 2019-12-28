package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




public class Login2 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Client c = Client.create();
		
		WebResource webResource = c.resource("http://localhost:8081/PrezentaOnline/userDTO");
		
		String input = "{\"username\":"+username+",\"password\":"+password +"}";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		String output = response.getEntity(String.class);
		System.out.println(output);
		res.sendRedirect("student.jsp");
		
	}
}
