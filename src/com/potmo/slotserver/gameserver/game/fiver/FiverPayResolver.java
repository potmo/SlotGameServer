package com.potmo.slotserver.gameserver.game.fiver;

import java.math.BigInteger;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.linepay.RegularLinePay;
import com.potmo.slotserver.gameserver.slot.payline.IPayLine;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreespinPayResult;
import com.potmo.slotserver.gameserver.slot.spin.freespin.IFreespinPayResolver;

public class FiverPayResolver<T> implements IFreespinPayResolver<FiverReelSymbol>
{

	private ImmutableList<IPayLine<FiverReelSymbol>> paylines;
	private ImmutableList<RegularLinePay<FiverReelSymbol>> regularLinePays;

	public FiverPayResolver(ImmutableList<IPayLine<FiverReelSymbol>> paylineGroup, ImmutableList<RegularLinePay<FiverReelSymbol>> regularLinePayGroup)
	{
		this.paylines = paylineGroup;
		this.regularLinePays = regularLinePayGroup;
	}

	@Override
	public FreespinPayResult<FiverReelSymbol> resolve( ReelStopResult<FiverReelSymbol> reelsStopResult, BigInteger betLines )
	{

		System.out.println( "stopped at: " + reelsStopResult.toString() );

		BigInteger totalBetMultiplier = BigInteger.ZERO;

		for ( IPayLine<FiverReelSymbol> payline : paylines )
		{
			ImmutableList<FiverReelSymbol> symbols = payline.getSymbols( reelsStopResult );

			for ( RegularLinePay<FiverReelSymbol> linepay : regularLinePays )
			{
				BigInteger betMultiplier = linepay.getBetMultiplierForSymbols( symbols );

				totalBetMultiplier = totalBetMultiplier.add( betMultiplier );
			}

		}

		int additionalFreespins = 0;
		if ( totalBetMultiplier.compareTo( BigInteger.ZERO ) > 0 ) additionalFreespins = 1;

		return new FreespinPayResult<FiverReelSymbol>( totalBetMultiplier, additionalFreespins );

	}

}
