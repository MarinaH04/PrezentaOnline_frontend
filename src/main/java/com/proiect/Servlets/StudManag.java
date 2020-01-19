package com.proiect.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class StudManag extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		HttpSession session = req.getSession();
		JSONArray lista = (JSONArray) session.getAttribute("lista");
		
		int j = 0;
		
		Client c = Client.create();
		WebResource webPresence = c.resource("http://localhost:8081/PrezentaOnline/prezentaDTO/presence");
		List<String> data = new ArrayList<String>(Arrays.asList("2020-01-27","2020-01-28", "2020-01-29", "2020-01-30", "2020-01-31"));
		List<String> dataPresence = new ArrayList<String>();
		String pres = "";
		while(j < data.size()) {
			int i = 0;
		while (i < lista.length()) {	
		
		try {
			String obj = lista.getString(i);
			String presence = "{\"username\":" + username + ",\"denumire\":" + obj + ",\"date\":" + data.get(j) + "}";
			ClientResponse response = webPresence.type("application/json").post(ClientResponse.class, presence);
			
			JSONObject output = response.getEntity(JSONObject.class);
			System.out.println(output.toString());
			String present = "";
			present = output.getString("present");
			System.out.println(present);
			if(present.equals("true")) {
				pres="P";
			}
			else if(present.equals("false")) {
				pres = "A";
			}
			
			else pres="-";
	//		System.out.println("Studentul "+ username +" la materia: " + obj +" in data de: "+data.get(j)+" este " + pres);
			String dataP = obj + data.get(j) + pres;
			dataPresence.add(dataP);
		} 
		catch (JSONException ex) {
			ex.printStackTrace();
		}
		i++;
		}

		j++;
		
		}
		System.out.println(dataPresence);
		session.setAttribute("data", data);
		session.setAttribute("dataPresence", dataPresence);
		
		res.sendRedirect("presence.jsp");
	}
		
}
