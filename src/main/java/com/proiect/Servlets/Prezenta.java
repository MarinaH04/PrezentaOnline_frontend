package com.proiect.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.proiect.business.DateParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Prezenta extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		JSONArray lista = (JSONArray) session.getAttribute("lista");
		String curs = lista.toString();
		String[] arrOfStr = curs.split(",", 5);
		String cursprof = arrOfStr[0];
		cursprof = cursprof.substring(2, cursprof.length()-2);

		JSONArray students = new JSONArray();
		
		
		Client c = Client.create();
		
		WebResource webResourceUsers = c.resource("http://localhost:8081/PrezentaOnline/courseDTO/users/"+cursprof);
		ClientResponse responseUser = webResourceUsers.type("application/json").get(ClientResponse.class);
		JSONObject resultUser = responseUser.getEntity(JSONObject.class);
		System.out.println(resultUser);
		JSONArray jUsers = new JSONArray();
		
		try {
			jUsers = resultUser.getJSONArray("users");
			int i = 0;
			while(i<jUsers.length()) {
				if(jUsers.getString(i).equals("MorariuP")) {}
				else {
				students.put(jUsers.getString(i));}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		WebResource webResource = c.resource("http://localhost:8081/PrezentaOnline/prezentaDTO");
		int j=0;
		while(j<students.length()) {
			try {
				String username = students.getString(j);
				String stud = req.getParameter(username);
				String prez = req.getParameter(username+"presence");
				String data = req.getParameter("date");
				Date date = DateParser.parse(data);
				Boolean presence = null;
				if(prez.contentEquals("Yes")) {presence = true;}
				else presence = false;
				String input = "{\"username\":" + stud + ",\"denumire\":"+ cursprof + ",\"date\":" + data +",\"present\":" + presence + "}";
				ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			catch (ParseException ex) {
				ex.printStackTrace();
			}
			j++;
		}
		
		
		
		}
	
	
	
}
