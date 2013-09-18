package com.potmo.slotserver.gameserver.game.fiver;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.reel.Reel;
import com.potmo.slotserver.gameserver.slot.reel.ReelGroup;

public class FiverReelGroupFactory
{
	private FiverReelFactory reelFactory;

	public FiverReelGroupFactory(FiverReelFactory reelFactory)
	{
		this.reelFactory = reelFactory;
	}

	public ReelGroup<FiverReelSymbol> getBaseGameReelGroup()
	{
		ArrayList<Reel<FiverReelSymbol>> reels = new ArrayList<Reel<FiverReelSymbol>>();
		reels.add( reelFactory.getBasegameReel1() );
		reels.add( reelFactory.getBasegameReel2() );
		reels.add( reelFactory.getBasegameReel3() );
		reels.add( reelFactory.getBasegameReel4() );
		reels.add( reelFactory.getBasegameReel5() );

		return new ReelGroup<FiverReelSymbol>( ImmutableList.copyOf( reels ) );
	}

	public ReelGroup<FiverReelSymbol> getFreeGameReelGroup()
	{
		ArrayList<Reel<FiverReelSymbol>> reels = new ArrayList<Reel<FiverReelSymbol>>();
		reels.add( reelFactory.getFreespinReel1() );
		reels.add( reelFactory.getFreespinReel2() );
		reels.add( reelFactory.getFreespinReel3() );
		reels.add( reelFactory.getFreespinReel4() );
		reels.add( reelFactory.getFreespinReel5() );

		return new ReelGroup<FiverReelSymbol>( ImmutableList.copyOf( reels ) );
	}
}
