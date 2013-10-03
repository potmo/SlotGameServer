package com.potmo.slotserver.persistenceserver;

import org.junit.Test;

import com.potmo.slotserver.configuration.LocalConfiguration;
import com.potmo.slotserver.persistenceserver.storage.riak.RIAKStorage;

public class RiakStorageTest
{

	@Test
	public void test()
	{
		RIAKStorage riakStorage = new RIAKStorage( new LocalConfiguration() );

		riakStorage.storeWager( "partner", "game", "gameSession", "wagerId", "payload" );
	}
}
