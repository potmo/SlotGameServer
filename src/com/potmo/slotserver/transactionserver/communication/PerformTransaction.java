package com.potmo.slotserver.transactionserver.communication;

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
public class PerformTransaction
{

	@Singleton
	@Inject
	ServerConfiguration serverConfig;

	@Path("performtransaction")
	@POST
	public TransactionResponse transportMessage( TransactionRequest request )
	{
		System.out.println( "Performing transaction" );
		return new TransactionResponse( "NOSESSION", "NOWAGERID" );
	}
}
