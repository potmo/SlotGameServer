package com.potmo.slotserver.transportserver.communication.transporthub.wager;

import java.io.IOException;
import java.math.BigInteger;

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
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.potmo.slotserver.configuration.ServerConfiguration;
import com.potmo.slotserver.persistenceserver.communication.savewager.PersistWagerRequest;
import com.potmo.slotserver.persistenceserver.communication.savewager.PersistWagerResponse;
import com.potmo.slotserver.transactionserver.communication.TransactionRequest;
import com.potmo.slotserver.transactionserver.communication.TransactionResponse;
import com.potmo.slotserver.transportserver.communication.transporthub.TransportRequest;
import com.potmo.slotserver.transportserver.communication.transporthub.TransportResponse;

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
	public TransportResponse transportMessage( @Context ContainerRequestContext context, TransportRequest request ) throws JsonParseException, JsonMappingException, IOException
	{

		// send to game
		String response = sendWagerToGame( request );

		// map it so we can read the result
		WagerResponse wagerResponse = mapResponseToWagerResponse( response );

		// perform transaction
		TransactionResponse transactionResponse = performTransaction( request.partner, request.game, request.account, request.ticket, wagerResponse.totalCost, wagerResponse.totalWin );

		persistWager( transactionResponse.gameSessionId, transactionResponse.wagerId, request.game, request.partner, response );

		System.out.println( "I will take: " + wagerResponse.totalCost + " and return " + wagerResponse.totalWin + " in gamesession " + transactionResponse.gameSessionId + ":" + transactionResponse.wagerId );

		return new TransportResponse( response );
	}

	private PersistWagerResponse persistWager( String gameSessionId, String wagerId, String game, String partner, String payload )
	{
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target( serverConfig.getPersistanceServerBaseUri() );

		PersistWagerRequest request = new PersistWagerRequest( partner, game, gameSessionId, wagerId, payload );

		PersistWagerResponse response = target.path( "persistwager" ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.json( request ), PersistWagerResponse.class );
		System.out.println( "persisted" );
		return response;
	}

	private TransactionResponse performTransaction( String partner, String game, String account, String ticket, BigInteger totalCost, BigInteger totalWin )
	{
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target( serverConfig.getTransactionServerBaseUri() );

		TransactionRequest request = new TransactionRequest( partner, game, totalCost, totalWin, account, ticket );
		TransactionResponse response = target.path( "performtransaction" ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.json( request ), TransactionResponse.class );
		System.out.println( "transacted" );
		return response;
	}

	private WagerResponse mapResponseToWagerResponse( String response ) throws IOException, JsonParseException, JsonMappingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		WagerResponse wagerResponse = objectMapper.readValue( response, WagerResponse.class );
		return wagerResponse;
	}

	private String sendWagerToGame( TransportRequest request ) throws IOException, JsonParseException, JsonMappingException
	{
		// set up a client to be able to relay the message
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target( serverConfig.getGameServerBaseUri() );

		// pass the wager request to the actual game
		// get the response as a string for later parsing
		String response = target.path( "wager" ).path( request.game ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.json( request.payload ), String.class );
		System.out.println( "wagered" );
		return response;
	}
}
