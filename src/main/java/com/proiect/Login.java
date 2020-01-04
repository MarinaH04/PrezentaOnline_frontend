package com.proiect;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Login {
	public static void main(String[] args) {
		
		try {
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8082/PrezentaOnline/user");
	
	ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
	
	if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
	String output = response.getEntity(String.class);
	
	System.out.println(output);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
}
}