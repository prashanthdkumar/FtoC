package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("*/ftoc")
public class FtoC {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertFtoC() throws JSONException {
		
		JSONObject json = new JSONObject();
		double f = 98.4, c = (f - 32) * (5/9);
		json.put("F", f);
		json.put("c", c);
		
		String result = "@Produces(MediaType.APPLICATION_JSON) "
						+ "Output: \n\n Farenheit to Celsius conversion: \n\n"
						+ json;
		
		return Response.status(200).entity(result).build(); 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{f}")
	public Response convertFtoCInput(@PathParam("f") float f) throws JSONException {
		JSONObject json = new JSONObject();
		double c = (f - 32) * (5/9);
		json.put("F", f);
		json.put("c", c);
		
		String result = "@Produces(MediaType.APPLICATION_JSON) "
						+ "Output: \n\n Farenheit to Celsius conversion: \n\n"
						+ json;
		
		return Response.status(200).entity(result).build(); 
	}
	
}