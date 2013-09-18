package com.potmo.slotserver.gameserver.slot.spin.freespin;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;

public class FreeSpin<T extends IReelSymbol>
{

	@JsonProperty("reelstopresults")
	private ReelStopResult<T> reelStopResults;

	@JsonProperty("payresult")
	private FreespinPayResult<T> payResult;

	@JsonCreator
	public FreeSpin(@JsonProperty("reelstopresults") ReelStopResult<T> reelStopResults, @JsonProperty("payresult") FreespinPayResult<T> payResult)
	{
		this.reelStopResults = reelStopResults;
		this.payResult = payResult;
	}

	@JsonIgnore
	public BigInteger getBetMultiplier()
	{
		return payResult.getBetMultiplier();
	}

}
