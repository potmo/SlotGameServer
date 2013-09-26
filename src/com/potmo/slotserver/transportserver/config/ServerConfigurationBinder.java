package com.potmo.slotserver.transportserver.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ServerConfigurationBinder extends AbstractBinder
{

	@Override
	protected void configure()
	{
		//TODO: Load what config to use from disc
		bind( DevConfiguration.class ).to( ServerConfiguration.class );
	}

}
