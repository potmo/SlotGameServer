package com.potmo.slotserver.persistenceserver.storage;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.potmo.slotserver.persistenceserver.storage.riak.RIAKStorage;

public class StoragerBinder extends AbstractBinder
{

	@Override
	protected void configure()
	{
		//TODO: Load what config to use from disc
		bind( RIAKStorage.class ).to( Storage.class );
	}
}
