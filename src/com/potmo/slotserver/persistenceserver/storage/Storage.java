package com.potmo.slotserver.persistenceserver.storage;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface Storage
{

	void storeWager( String partner, String game, String gameSession, String wagerId, String payload );

}
