package com.potmo.slotserver.gameserver.game.fiver;

import java.math.BigInteger;
import java.util.LinkedList;

import com.potmo.slotserver.gameserver.communication.wager.IWagerResponse;
import com.potmo.slotserver.gameserver.communication.wager.WagerRequest;
import com.potmo.slotserver.gameserver.slot.communication.FreespinWagerResponse;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreeSpin;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreeSpinner;

public class Fiver
{
	private final FreeSpinner<FiverReelSymbol> spinner;

	public Fiver(FreeSpinner<FiverReelSymbol> spinner)
	{
		this.spinner = spinner;
	}

	public IWagerResponse wager( WagerRequest request )
	{

		LinkedList<FreeSpin<FiverReelSymbol>> spins = spinner.spin( request.betLines );

		BigInteger totalLineBetMultiplier = BigInteger.ZERO;

		for ( FreeSpin<FiverReelSymbol> spin : spins )
		{
			totalLineBetMultiplier = totalLineBetMultiplier.add( spin.getBetMultiplier() );
		}

		BigInteger totalWin = totalLineBetMultiplier.multiply( request.betLevel );
		BigInteger totalCost = request.betLevel.multiply( request.betLines );

		return new FreespinWagerResponse( totalWin, totalCost, spins );

	}

	public BigInteger getTotalCost( BigInteger lineBet, Integer betLines )
	{
		return lineBet.multiply( new BigInteger( betLines.toString() ) );
	}

}
