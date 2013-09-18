package com.potmo.slotserver.gameserver.slot.reel;

import com.google.common.collect.ImmutableList;

public class ReelStrip<T extends IReelSymbol>
{

	private final ImmutableList<T> symbols;
	private final int length;

	public ReelStrip(ImmutableList<T> symbols)
	{
		this.symbols = symbols;
		this.length = symbols.size();
	}

	public T getNthSymbol( int i )
	{
		i = i % this.length;
		return symbols.get( i );
	}

	public Integer getLength()
	{
		return this.length;
	}
}
