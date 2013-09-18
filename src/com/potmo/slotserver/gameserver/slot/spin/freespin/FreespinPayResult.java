package com.potmo.slotserver.gameserver.slot.spin.freespin;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;

public class FreespinPayResult<T extends IReelSymbol>
{
	@JsonProperty("betmultiplier")
	private final BigInteger betMultiplier;

	@JsonProperty("additionalfreespins")
	private final int additionalFreespins;

	@JsonCreator
	public FreespinPayResult(@JsonProperty("betmultiplier") BigInteger betMultiplier, @JsonProperty("additionalfreespins") int additionalFreespins)
	{
		this.betMultiplier = betMultiplier;
		this.additionalFreespins = additionalFreespins;
	}

	@JsonIgnore
	public BigInteger getBetMultiplier()
	{
		return betMultiplier;
	}

	@JsonIgnore
	public int getAdditionalFreespins()
	{
		return additionalFreespins;
	}

}
