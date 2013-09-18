package com.potmo.slotserver.gameserver.communication.wager;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WagerRequest
{

	@JsonProperty("betlines")
	public final BigInteger betLines;
	
	@JsonProperty("betlevel")
	public final BigInteger betLevel;
	
	@JsonCreator
	public WagerRequest(@JsonProperty("betlines") BigInteger betLines, @JsonProperty("betlevel") BigInteger betLevel)
	{
		this.betLines = betLines;
		this.betLevel = betLevel;
	}
	
}
