package com.potmo.slotserver.transportserver.communication.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportRequest
{

	@JsonProperty("payload")
	public final String payload;

	@JsonCreator
	public TransportRequest(@JsonProperty("payload") String payload)
	{
		this.payload = payload;
	}
}
