package com.potmo.slotserver.wagerserver.communication.wager.wager;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.potmo.slotserver.configuration.ServerConfiguration;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("")
public class Wager
{

	@Singleton
	@Inject
	ServerConfiguration serverConfig;

	@Path("wager")
	@POST
	public WagerResponse transportMessage( WagerRequest request ) throws JsonParseException, JsonMappingException, IOException
	{

		// send to game
		GameWagerResponse gameWagerResponse = sendWagerToGame( request );

		System.out.println( "I will take: " + gameWagerResponse.totalCost + " and return " + gameWagerResponse.totalWin );

		return new WagerResponse();
	}

	private GameWagerResponse sendWagerToGame( WagerRequest request ) throws IOException, JsonParseException, JsonMappingException
	{

		//TODO: we probably don't need to reconstruct this on every time
		// set up a client to be able to relay the message
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target( serverConfig.getGameServerBaseUri() );

		// pass the wager request to the actual game
		GameWagerResponse response = target.path( "wager" ).path( request.game ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.json( request.gamepayload ), GameWagerResponse.class );
		System.out.println( "wagered" );
		return response;
	}
}
