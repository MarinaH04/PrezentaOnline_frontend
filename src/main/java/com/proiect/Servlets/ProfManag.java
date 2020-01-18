package com.proiect.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProfManag extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String tip = req.getParameter("tip");
		
		String date = req.getParameter("date");
		
		Client p = Client.create();
		WebResource webResource = p.resource("http://localhost:8081/PrezentaOnline/userDTO/insert");
		String input = "{\"username\":" + username + ",\"firstname\":" + firstname + ",\"lastname\":" + lastname + ",\"email\":" + email + ",\"password\":" + password + ",\"tip\":" + tip + "}";
		webResource.type("application/json").post(ClientResponse.class, input);
		
		session.setAttribute("date", date);
		
		if(!date.equals("-")) {
			res.sendRedirect("presencep.jsp");
		}
		else res.sendRedirect("profesor.jsp");
	
	}
}
