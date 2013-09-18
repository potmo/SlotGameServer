package com.potmo.slotserver.gameserver.slot.reel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.random.IRandomNumberGenerator;

public class ReelGroup<T extends IReelSymbol>
{

	private ImmutableList<Reel<T>> reels;

	public ReelGroup(ImmutableList<Reel<T>> reels)
	{
		this.reels = reels;
	}

	public ReelStopResult<T> createReelStopResult( IRandomNumberGenerator random )
	{
		LinkedList<LinkedList<T>> visibleSymbols = new LinkedList<LinkedList<T>>();
		LinkedList<Integer> stopPositions = new LinkedList<Integer>();

		for ( Reel<T> reel : this.reels )
		{

			Integer position = random.nextInt( reel.getReelStripLength() );

			stopPositions.add( position );

			LinkedList<T> randomSymbols = reel.getVisibleSymbolsAtPositions( position );
			visibleSymbols.add( randomSymbols );

		}

		return new ReelStopResult<T>( visibleSymbols, stopPositions );
	}
}
