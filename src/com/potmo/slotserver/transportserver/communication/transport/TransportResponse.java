package com.potmo.slotserver.transportserver.communication.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportResponse
{

	@JsonProperty("payload")
	public final String payload;

	@JsonCreator
	public TransportResponse(@JsonProperty("payload") String payload)
	{
		this.payload = payload;
	}

}
