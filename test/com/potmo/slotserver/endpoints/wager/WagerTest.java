package com.potmo.slotserver.endpoints.wager;

import java.io.IOException;
import java.math.BigInteger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.potmo.slotserver.gameserver.GameServer;
import com.potmo.slotserver.gameserver.communication.wager.FreespinWagerResponse;
import com.potmo.slotserver.gameserver.communication.wager.WagerRequest;
import com.potmo.slotserver.persistenceserver.PersistenceServer;
import com.potmo.slotserver.transactionserver.TransactionServer;
import com.potmo.slotserver.transportserver.TransportHubServer;
import com.potmo.slotserver.transportserver.communication.transport.TransportRequest;
import com.potmo.slotserver.transportserver.communication.transport.TransportResponse;

public class WagerTest
{

	private HttpServer gameServer;
	private HttpServer transportServer;
	//private WebTarget gameTarget;
	private WebTarget transportTarget;
	private ObjectMapper jsonObjectMapper;
	private HttpServer transactionServer;
	private HttpServer persistanceServer;

	@Before
	public void setUp() throws Exception
	{
		// start the server
		gameServer = GameServer.startServer();
		transportServer = TransportHubServer.startServer();
		transactionServer = TransactionServer.startServer();
		persistanceServer = PersistenceServer.startServer();

		Client transportClient = ClientBuilder.newBuilder().build();
		transportTarget = transportClient.target( TransportHubServer.BASE_URI );

		jsonObjectMapper = new ObjectMapper();

	}

	@After
	public void tearDown() throws Exception
	{
		gameServer.stop();
		transportServer.stop();
		transactionServer.stop();
		persistanceServer.stop();
	}

	@Test
	public void testTransportServer() throws IOException
	{
		WagerRequest wagerRequest = new WagerRequest( new BigInteger( "30" ), new BigInteger( "10" ) );
		String wagerRequestJson = jsonObjectMapper.writeValueAsString( wagerRequest );
		TransportRequest transportRequest = new TransportRequest( "testpartner", "fiver", "testaccount", "testticket", wagerRequestJson );

		TransportResponse transportResponse = null;
		for ( int i = 0; i < 1; i++ )
		{
			transportResponse = transportTarget.path( "wager" ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.json( transportRequest ), TransportResponse.class );
		}

		FreespinWagerResponse wagerResponse = jsonObjectMapper.readValue( transportResponse.payload, FreespinWagerResponse.class );

		System.out.println( "Woo transporting: " + wagerResponse.totalWin );
	}
}
