package com.potmo.slotserver.persistenceserver.communication.persistwager;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersistWagerResponse
{
	@JsonProperty("status")
	public final Boolean status;

	@JsonCreator
	public PersistWagerResponse(@JsonProperty("status") Boolean status)
	{
		this.status = status;
	}

}
