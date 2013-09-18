package com.potmo.slotserver.gameserver.slot.communication;

import java.math.BigInteger;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.gameserver.communication.wager.IWagerResponse;
import com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreeSpin;

public class FreespinWagerResponse implements IWagerResponse
{

	@JsonProperty("totalwin")
	public final BigInteger totalWin;

	@JsonProperty("spins")
	public final LinkedList<FreeSpin<FiverReelSymbol>> spins;

	@JsonProperty("totalcost")
	private BigInteger totalCost;

	@JsonCreator
	public FreespinWagerResponse(@JsonProperty("totalwin") BigInteger totalWin, @JsonProperty("totalcost") BigInteger totalCost, @JsonProperty("spins") LinkedList<FreeSpin<FiverReelSymbol>> spins)
	{
		this.totalWin = totalWin;
		this.totalCost = totalCost;
		this.spins = spins;
	}

	@Override
	@JsonIgnore
	public BigInteger getTotalWin()
	{
		return this.totalWin;
	}

	@JsonIgnore
	@Override
	public BigInteger getTotalCost()
	{
		return this.totalCost;
	}

}
