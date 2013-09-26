package com.potmo.slotserver.transportserver.persistence.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.potmo.slotserver.transportserver.persistence.Persistenter;

public class PersistenceConfigurationBinder extends AbstractBinder
{

	@Override
	protected void configure()
	{
		//TODO: load what config to use from disc
		bind( DevPersistenceConfiguration.class ).to( PersistenceConfiguration.class );
		bind( Persistenter.class ).to( Persistenter.class );
	}

}
