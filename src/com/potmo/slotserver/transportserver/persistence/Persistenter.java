package com.potmo.slotserver.transportserver.persistence;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.potmo.slotserver.transportserver.persistence.config.PersistenceConfiguration;

public class Persistenter
{

	private PersistenceConfiguration persistenceConfig;

	@Singleton
	@Inject
	public Persistenter(PersistenceConfiguration persistenceConfig)
	{
		this.persistenceConfig = persistenceConfig;
	}

	public void printConfig()
	{
		System.out.println( "I got config: " + persistenceConfig.getStuff() );
	}
}
