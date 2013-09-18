package com.potmo.slotserver.gameserver.communication.wager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.potmo.slotserver.gameserver.game.fiver.Fiver;
import com.potmo.slotserver.gameserver.game.fiver.FiverFactory;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("wager")
public class Wager
{

	@Path("fiver")
	@POST
	public IWagerResponse doWager( @Context ContainerRequestContext context, WagerRequest request )
	{

		FiverFactory fiverFactory = new FiverFactory();
		Fiver game = fiverFactory.getGame();

		return game.wager( request );

	}
}
