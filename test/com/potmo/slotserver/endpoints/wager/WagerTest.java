package com.potmo.slotserver.endpoints.wager;

import java.math.BigInteger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.potmo.slotserver.gameserver.GameServer;
import com.potmo.slotserver.gameserver.communication.wager.WagerRequest;
import com.potmo.slotserver.gameserver.slot.communication.FreespinWagerResponse;
import com.potmo.slotserver.transportserver.TransportServer;
import com.potmo.slotserver.transportserver.communication.transport.TransportRequest;

public class WagerTest
{

	private HttpServer gameServer;
	private HttpServer transportServer;
	private WebTarget gameTarget;
	private WebTarget transportTarget;

	@Before
	public void setUp() throws Exception
	{
		// start the server
		gameServer = GameServer.startServer();
		transportServer = TransportServer.startServer();

		// create the client
		Client gameClient = ClientBuilder.newBuilder().build();
		gameTarget = gameClient.target( GameServer.BASE_URI );

		Client transportClient = ClientBuilder.newBuilder().build();
		transportTarget = transportClient.target( TransportServer.BASE_URI );

	}

	@After
	public void tearDown() throws Exception
	{
		gameServer.stop();
		transportServer.stop();
	}

	@Test
	public void testGameServer()
	{

		WagerRequest request = new WagerRequest( new BigInteger( "30" ), new BigInteger( "10" ) );
		FreespinWagerResponse response = gameTarget.path( "wager" ).path( "fiver" ).request().accept( MediaType.APPLICATION_JSON_TYPE ).post( Entity.entity( request, MediaType.APPLICATION_JSON ), FreespinWagerResponse.class );

	}

	@Test
	public void testTransportServer()
	{
		TransportRequest request = new TransportRequest( "balananana" );
		String response = transportTarget.path( "message" ).request().accept( MediaType.APPLICATION_JSON ).post( Entity.entity( request, MediaType.APPLICATION_JSON ), String.class );

		System.out.println( "Woo transporting: " + response );
	}
}
