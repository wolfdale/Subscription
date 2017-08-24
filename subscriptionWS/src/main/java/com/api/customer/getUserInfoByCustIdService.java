package com.api.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.dao.DatabaseConnector;

@Path("/getUserInfo")
public class getUserInfoByCustIdService {
	@GET
	@Path("/custId/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerInfo(@PathParam("Id") String customerId){
		ArrayList<userInfoJSON> user = new ArrayList<userInfoJSON>();
		//userInfoJSON use = new userInfoJSON();
		try {
			DatabaseConnector dbconn = new DatabaseConnector();
			Connection conn = dbconn.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from customer where cust_id = "+customerId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				userInfoJSON info = new userInfoJSON();
				info.setCustomer_id(rs.getString("cust_id"));
				info.setCustomer_name(rs.getString("cust_name"));
				info.setCustomer_age(rs.getString("cust_age"));
				info.setCustomer_sub(rs.getString("sub_id"));
				user.add(info);
			}
		}
		catch(Exception e) {
		}
		return Response.ok(user).build();
	}
}
