package com.potmo.slotserver.wagerserver.communication.wager.wager;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.analytics.AnalyticType;

public class GameWagerResponse
{

	@JsonProperty("totalwin")
	public final BigInteger totalWin;

	@JsonProperty("totalcost")
	public final BigInteger totalCost;

	@JsonProperty("analytics")
	public final Map<AnalyticType, BigInteger> analytics;

	@JsonProperty("outcome")
	public final Object outcome;

	@JsonCreator
	public GameWagerResponse(
								@JsonProperty("totalwin") BigInteger totalWin,
								@JsonProperty("totalcost") BigInteger totalCost,
								@JsonProperty("analytics") HashMap<AnalyticType, BigInteger> analytics,
								@JsonProperty("outcome") Object outcome)
	{
		this.totalWin = totalWin;
		this.totalCost = totalCost;
		this.analytics = analytics;
		this.outcome = outcome;
	}

}
