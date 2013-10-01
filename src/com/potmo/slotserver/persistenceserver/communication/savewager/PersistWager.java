package com.potmo.slotserver.persistenceserver.communication.savewager;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.potmo.slotserver.configuration.ServerConfiguration;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("")
public class PersistWager
{

	@Singleton
	@Inject
	ServerConfiguration serverConfig;

	@Path("persistwager")
	@POST
	public PersistWagerResponse transportMessage( PersistWagerRequest request )
	{
		System.out.println( "persisting wager" );
		return new PersistWagerResponse( true );
	}
}
