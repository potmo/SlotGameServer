package com.potmo.slotserver.configuration;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface ServerConfiguration
{

	public String getTransportServerBaseUri();
	public String getGameServerBaseUri();
	public String getPersistanceServerBaseUri();
	public String getTransactionServerBaseUri();

}
