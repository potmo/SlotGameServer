package com.potmo.slotserver.transportserver.communication.transport.wager;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WagerResponse
{

	@JsonProperty("totalwin")
	public final BigInteger totalWin;

	@JsonProperty("totalcost")
	public final BigInteger totalCost;

	@JsonCreator
	public WagerResponse(@JsonProperty("totalwin") BigInteger totalWin, @JsonProperty("totalcost") BigInteger totalCost)
	{
		this.totalWin = totalWin;
		this.totalCost = totalCost;
	}

}
