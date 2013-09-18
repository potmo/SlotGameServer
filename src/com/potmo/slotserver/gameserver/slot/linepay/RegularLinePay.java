package com.potmo.slotserver.gameserver.slot.linepay;

import java.math.BigInteger;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;

public class RegularLinePay<T extends IReelSymbol>
{
	private T symbol;
	private BigInteger betMultiplier;
	private int inARow;

	public RegularLinePay(T symbol, int inARow, BigInteger betMultiplier)
	{
		this.symbol = symbol;
		this.inARow = inARow;
		this.betMultiplier = betMultiplier;
	}

	public BigInteger getBetMultiplierForSymbols( ImmutableList<T> lineSymbols )
	{
		for ( int i = 0; i < inARow; i++ )
		{
			if ( symbol != lineSymbols.get( i ) ) return BigInteger.ZERO;
		}

		System.out.println( this.symbol + " is " + lineSymbols.toString() + " in " + inARow );

		return betMultiplier;
	}
}
