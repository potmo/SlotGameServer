package com.potmo.slotserver.gameserver.slot.reel;

import java.util.LinkedList;

public class Reel<T extends IReelSymbol>
{
	private final ReelStrip<T> reelStrip;
	private final Integer height;

	public Reel(ReelStrip<T> reelStrip, Integer height)
	{
		this.reelStrip = reelStrip;
		this.height = height;
	}

	public Integer getHeight()
	{
		return height;
	}

	public LinkedList<T> getVisibleSymbolsAtPositions( Integer position )
	{

		LinkedList<T> symbols = new LinkedList<T>();

		for ( int i = 0; i < height; i++ )
		{
			T symbol = reelStrip.getNthSymbol( position + i );
			symbols.add( symbol );
		}

		return symbols;
	}

	public Integer getReelStripLength()
	{
		return reelStrip.getLength();
	}
}
