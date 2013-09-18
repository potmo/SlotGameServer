package com.potmo.slotserver.gameserver.game.fiver;

import com.potmo.slotserver.gameserver.slot.reel.Reel;

public class FiverReelFactory
{

	private static final int HEIGHT = 5;
	private FiverReelStripFactory reelStripFactory;

	public FiverReelFactory(FiverReelStripFactory reelStripFactory)
	{
		this.reelStripFactory = reelStripFactory;
	}

	public Reel<FiverReelSymbol> getBasegameReel1()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getBaseGameSymbols1(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getBasegameReel2()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getBaseGameSymbols2(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getBasegameReel3()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getBaseGameSymbols3(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getBasegameReel4()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getBaseGameSymbols4(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getBasegameReel5()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getBaseGameSymbols5(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getFreespinReel1()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getFreeGameSymbols1(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getFreespinReel2()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getFreeGameSymbols2(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getFreespinReel3()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getFreeGameSymbols3(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getFreespinReel4()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getFreeGameSymbols4(), HEIGHT );
	}
	
	public Reel<FiverReelSymbol> getFreespinReel5()
	{
		return new Reel<FiverReelSymbol>( this.reelStripFactory.getFreeGameSymbols5(), HEIGHT );
	}
}
