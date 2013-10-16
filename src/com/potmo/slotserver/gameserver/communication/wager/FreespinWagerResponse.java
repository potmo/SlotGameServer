package com.potmo.slotserver.gameserver.communication.wager;

import java.math.BigInteger;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreeSpin;

public class FreespinWagerResponse
{

	@JsonProperty("totalwin")
	public final BigInteger totalWin;

	@JsonProperty("totalcost")
	private BigInteger totalCost;

	//TODO: Put the spins in an outcome typed as Object?
	@JsonProperty("spins")
	public final LinkedList<FreeSpin<FiverReelSymbol>> spins;

	@JsonCreator
	public FreespinWagerResponse(
									@JsonProperty("totalwin") BigInteger totalWin,
									@JsonProperty("totalcost") BigInteger totalCost,
									@JsonProperty("spins") LinkedList<FreeSpin<FiverReelSymbol>> spins)
	{
		this.totalWin = totalWin;
		this.totalCost = totalCost;
		this.spins = spins;
	}

}
