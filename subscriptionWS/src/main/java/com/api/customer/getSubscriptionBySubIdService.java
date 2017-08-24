package com.api.customer;

import java.sql.Timestamp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/getInfo")
public class getSubscriptionBySubIdService {
	@GET
	@Path("/subsId/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getsubscription(@PathParam("Id") String custId) {
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		subscriptionJSON subs = new subscriptionJSON(custId,"Netflix",stamp.toString());
		return Response.ok(subs).build();
		
	}
}

