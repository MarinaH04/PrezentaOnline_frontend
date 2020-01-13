package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String userdelete = req.getParameter("userdelete");
		
		Client c = Client.create();

		WebResource webResource = c.resource("http://localhost:8081/PrezentaOnline/userDTO/delete");
		String input = "{\"username\":" + userdelete + "}";
		webResource.type("application/json").post(ClientResponse.class, input);
	}

}
