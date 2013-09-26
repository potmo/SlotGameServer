package com.potmo.slotserver.transportserver.config;

import org.jvnet.hk2.annotations.Service;

@Service
public class DevConfiguration implements ServerConfiguration
{

	@Override
	public String getTransportServerBaseUri()
	{
		return "http://localhost:8081/";
	}

	@Override
	public String getGameServerBaseUri()
	{
		return "http://localhost:8080/";
	}

}
