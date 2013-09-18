package com.potmo.slotserver.transportserver.communication.transport;

import java.math.BigInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.potmo.slotserver.gameserver.GameServer;
import com.potmo.slotserver.gameserver.communication.wager.WagerRequest;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("message")
public class Transport
{

	@POST
	public String transportMessage( @Context ContainerRequestContext context, TransportRequest request )
	{

		// do some stuff and delagate some other stuff
		Client gameClient = ClientBuilder.newBuilder().build();
		WebTarget gameTarget = gameClient.target( GameServer.BASE_URI );

		WagerRequest wagerRequest = new WagerRequest( new BigInteger( "30" ), new BigInteger( "10" ) );
		String response = gameTarget.path( "wager" ).path( "fiver" ).request().accept( MediaType.APPLICATION_JSON_TYPE ).post( Entity.entity( wagerRequest, MediaType.APPLICATION_JSON ), String.class );

		return response;
	}
}
