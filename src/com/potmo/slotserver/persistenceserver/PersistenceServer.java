package com.potmo.slotserver.persistenceserver;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.potmo.slotserver.configuration.ServerConfigurationBinder;

/**
 * Main class.
 * 
 */
public class PersistenceServer
{
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8082/";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer()
	{
		// create a resource config that scans for JAX-RS resources and providers
		// in com.potmo.slotserver package
		final ResourceConfig rc = new ResourceConfig().packages( "com.potmo.slotserver.persistenceserver" );

		// register server configuration
		rc.register( new ServerConfigurationBinder() );

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer( URI.create( BASE_URI ), rc );
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main( String[] args ) throws IOException
	{

		final HttpServer server = startServer();
		System.out.println( String.format( "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI ) );
		System.in.read();
		server.stop();
	}
}
