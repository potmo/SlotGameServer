package com.potmo.slotserver.persistenceserver;

import static org.junit.Assert.fail;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.potmo.slotserver.persistenceserver.communication.persistwager.PersistWagerRequest;
import com.potmo.slotserver.persistenceserver.communication.persistwager.PersistWagerResponse;
import com.potmo.slotserver.transportserver.TransportHubServer;
import com.potmo.slotserver.transportserver.communication.transport.TransportResponse;

public class PersistWagerTest
{

	private HttpServer persistanceServer;
	private WebTarget target;

	@Before
	public void setUp() throws Exception
	{
		// start the server
		persistanceServer = PersistenceServer.startServer();

		Client client = ClientBuilder.newBuilder().build();
		target = client.target( PersistenceServer.BASE_URI );
	}

	@After
	public void tearDown()
	{
		persistanceServer.stop();
	}

	@Test
	public void test()
	{

		PersistWagerRequest request = new PersistWagerRequest( "partner", "game", "session", "wager", "payload" );
		PersistWagerResponse response = target.path( "persistwager" )
				.request()
				.accept( MediaType.APPLICATION_JSON )
				.post( Entity.json( request ), PersistWagerResponse.class );

		// ok

	}

}
