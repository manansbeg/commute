package com.broids;

 
/**
 * @author manan beg
 * 
 */
 

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/")
public class CommuteRESTService {
	CommuteManager commuteManager=null;
	
	
	public CommuteRESTService() throws ClassNotFoundException, SQLException {
		super();
		this.commuteManager = new CommuteManager();
	}
	
	
	@POST
	@Path("/insertCommute")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCommute(InputStream incomingData) throws JSONException, SQLException {
		
		
		StringBuilder commuteBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				commuteBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println(commuteBuilder.toString());
		
		JSONObject jsonObject = new JSONObject(commuteBuilder.toString());
		
		commuteManager.insertCommute(jsonObject);
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(commuteBuilder.toString()).build();
	}
	
	@GET
	@Path("/getAllCommutes")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllCommutes(InputStream incomingData) throws JSONException, SQLException {
	
		
		
		// return HTTP response 200 in case of success
		return Response.status(200).entity(commuteManager.getAllCommutes().toString()).build();
	}
	
	
 
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Commute Service is up";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}