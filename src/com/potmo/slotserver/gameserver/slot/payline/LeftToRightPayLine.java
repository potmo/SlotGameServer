package com.potmo.slotserver.gameserver.slot.payline;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;

public class LeftToRightPayLine<T extends IReelSymbol> implements IPayLine<T>
{

	private ImmutableList<Integer> positions;

	public LeftToRightPayLine(ImmutableList<Integer> positions)
	{
		this.positions = positions;
	}

	/* (non-Javadoc)
	 * @see com.potmo.slotserver.gameimpl.reels.payline.IPayLine#getSymbols(com.potmo.slotserver.gameimpl.reels.reel.ReelStopResult)
	 */
	@Override
	public ImmutableList<T> getSymbols( ReelStopResult<T> spinResult )
	{

		List<T> symbols = new LinkedList<T>();

		for ( int i = 0; i < positions.size(); i++ )
		{
			int x = i;
			int y = positions.get( x );

			T symbol = spinResult.getSymbolAt( x, y );
			symbols.add( symbol );
		}

		return ImmutableList.copyOf( symbols );
	}

}
