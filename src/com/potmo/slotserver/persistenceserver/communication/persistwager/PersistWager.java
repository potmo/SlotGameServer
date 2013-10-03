package com.potmo.slotserver.persistenceserver.communication.persistwager;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.potmo.slotserver.persistenceserver.storage.Storage;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("")
public class PersistWager
{


	@Singleton
	@Inject
	private Storage storage;

	@Path("persistwager")
	@POST
	public PersistWagerResponse transportMessage( PersistWagerRequest request )
	{
		// When the data is here I take responsibility of storing it
		// we can return back with an OK directly.

		this.storage.storeWager( request.partner, request.game, request.gameSession, request.wagerId, request.payload );

		System.out.println( "persisting wager" );
		return new PersistWagerResponse( true );
	}
}
