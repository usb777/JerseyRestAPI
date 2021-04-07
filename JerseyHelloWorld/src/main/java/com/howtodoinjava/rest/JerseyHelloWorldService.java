package com.howtodoinjava.rest;

/**
 
Endpoints with Value:    http://localhost:8080/JerseyHelloWorld/products/feed
 
 
 */


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

@Path("/")
public class JerseyHelloWorldService
{
	@GET
	@Path("/{message}")
//	@Produces(MediaType.)
	public Response getMsg(@PathParam("message") String msg)
	{
		String output = "Message requested : " + msg;
		//Simply return the parameter passed as message
		return Response.status(200).entity(output).build();
	}
	
	
	  @GET
	    @Produces("text/html")
	    public Response index() 
	   {
	        return Response.ok(new Viewable("/index.jsp")).build();
	    }
	  

	    @GET
	    @Path("home")
	    public Viewable home() {
	        return new Viewable("/home.jsp");
	    }

	    @GET
	    @Path("login")
	    public Viewable login() 
	    {
	        return new Viewable("/login.jsp");
	    }
	    
	
	    /**	    
	    Endpoints with Value:    http://localhost:8080/JerseyHelloWorld/products/feed     
	     
	     */
	    
	    @GET
	    @Path("/feed")
	    public Viewable feed_page( @Context HttpServletRequest request,   @Context HttpServletResponse response) throws Exception
	    {
	    	 Map<String, String> model = new HashMap<String,String>();
		        model.put("key1", "Dzmitry Samoila");
		        model.put("key2", "Andrew LAzaro");
		        
	      request.setAttribute("key", "value");
	      request.setAttribute("mod", model); // send model to JSP
	      
	      String message = "Hello world!";
	      request.setAttribute("message", message); // send message to JSP
	      return new Viewable("/feed", null);
	    }
	    
	    
	    /*Send Parameter to Page*/
	    /**
	    endPoint -  http://localhost:8080/JerseyHelloWorld/products/feed/4
	     * @param productId
	     * @param request
	     * @param response
	     * @return
	     * @throws Exception
	     */
	    @GET  
	    @Path("/feed/{param}")  
	    public Viewable paramExploration(@PathParam("param") String productId, @Context HttpServletRequest request,   @Context HttpServletResponse response) throws Exception
	    {  
	       
	        request.setAttribute("productId", productId);
	       
	        String output = "Jersey say : " + productId;  
	        return new Viewable("/param", output);
	    }  
	    
	    
	    
	
	
}
