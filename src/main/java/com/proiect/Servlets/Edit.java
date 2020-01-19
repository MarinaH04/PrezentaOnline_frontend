package com.proiect.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Edit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String username = req.getParameter("usernamedit");
		String firstname = req.getParameter("firstnamedit");
		String lastname = req.getParameter("lastnamedit");
		String email = req.getParameter("emailedit");
		String password = req.getParameter("passwordedit");
		
		Client c = Client.create();

		WebResource webResource = c.resource("http://localhost:8081/PrezentaOnline/userDTO/edit");
		String input = "{\"username\":" + username + ",\"firstname\":" + firstname + ",\"lastname\":" + lastname + ",\"email\":" + email + ",\"password\":" + password + "}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		if(!response.equals(null)) {
			RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
			PrintWriter out = res.getWriter();
			out.write("<p id='updateMsg' style='color: green; font-size: larger;'>Data succesfully updated !</p>");
			rs.include(req, res);
		}
	}
}
