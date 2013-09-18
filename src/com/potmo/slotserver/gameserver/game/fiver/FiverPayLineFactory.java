package com.potmo.slotserver.gameserver.game.fiver;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.payline.IPayLine;
import com.potmo.slotserver.gameserver.slot.payline.LeftToRightPayLine;

public class FiverPayLineFactory
{

	public ImmutableList<IPayLine<FiverReelSymbol>> getPaylineGroup()
	{



		List<IPayLine<FiverReelSymbol>> paylines = new LinkedList<IPayLine<FiverReelSymbol>>();

		paylines.add( new LeftToRightPayLine<FiverReelSymbol>( ImmutableList.of( 0, 0, 0, 0, 0 ) ) );
		paylines.add( new LeftToRightPayLine<FiverReelSymbol>( ImmutableList.of( 1, 1, 1, 1, 1 ) ) );
		paylines.add( new LeftToRightPayLine<FiverReelSymbol>( ImmutableList.of( 2, 2, 2, 2, 2 ) ) );
		paylines.add( new LeftToRightPayLine<FiverReelSymbol>( ImmutableList.of( 3, 3, 3, 3, 3 ) ) );
		paylines.add( new LeftToRightPayLine<FiverReelSymbol>( ImmutableList.of( 4, 4, 4, 4, 4 ) ) );

		return ImmutableList.copyOf( paylines );
	}

}
