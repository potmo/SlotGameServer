package com.potmo.slotserver.transportserver.config;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface ServerConfiguration
{

	public String getTransportServerBaseUri();
	public String getGameServerBaseUri();

}
