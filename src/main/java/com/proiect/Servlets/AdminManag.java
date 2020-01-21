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
		if(!response.equals(null)) {
			RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
			PrintWriter out = res.getWriter();
			out.write("<p id='updateMsg' style='color: green; '>User succesfully inserted !</p>");
			rs.include(req, res);
		}
		
		
		String studenti = req.getParameter("studenti");
		String profesori = req.getParameter("profesori");
		
		/* !!!!DE MODIFICAT */
		
		if (!studenti.equals(null)) {
			WebResource webResourceUpdate = u.resource("http://localhost:8081/PrezentaOnline/userDTO/update");
			String inputUpdate = "{\"username\":" + studenti + ",\"denumire\":" + profesori + "}";
			ClientResponse responseUpdate = webResourceUpdate.type("application/json").post(ClientResponse.class,
					inputUpdate);
			if (!responseUpdate.equals(null)) {
				RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
				PrintWriter out = res.getWriter();
				out.write("<p id='updateMsg' style='color: green; '>Student succesfully assigned to a teacher !</p>");

				rs.include(req, res);
			}

		}
	}

}
