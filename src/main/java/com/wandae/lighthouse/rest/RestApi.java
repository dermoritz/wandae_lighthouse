package com.wandae.lighthouse.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import com.wandae.lighthouse.relay.Relay;

@Path("/")
public class RestApi {
	
	@Inject
	private Relay relay; 
	
	@Context 
	private HttpServletRequest request;

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response setRelayEndpoint(String endpoint) {
		String remoteEndpoint = endpoint.startsWith("/") ? endpoint : "/" + endpoint;
		relay.setRelayUrl(request.getScheme()+ "://" + request.getRemoteAddr() + ":" + request.getRemotePort() + remoteEndpoint);
		return Response.created(UriBuilder.fromResource(RestApi.class).build()).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getRelay() {
		if (relay.getRelayUrl() == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else{
			return Response.ok(relay.getRelayUrl()).build();
		}
	}
}
