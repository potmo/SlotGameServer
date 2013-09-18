package com.potmo.slotserver.gameserver.game.fiver;

import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.BACON;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.FLITCH;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.GAMMON;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.HAM;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.KASSLER;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.PORK;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.RASHER;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.SOWBELLY;

import java.util.Arrays;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.reel.ReelStrip;

public class FiverReelStripFactory
{

	private static final ReelStrip<FiverReelSymbol> BASEGAME_STRIP_1 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { HAM, BACON, PORK, PORK, PORK, PORK, PORK, PORK, FLITCH, RASHER, GAMMON, SOWBELLY, GAMMON, RASHER, KASSLER, GAMMON, GAMMON, HAM, RASHER,
			HAM, GAMMON, BACON, HAM, GAMMON, FLITCH, HAM, HAM, BACON, GAMMON, GAMMON, BACON, HAM, RASHER, SOWBELLY, HAM, GAMMON, BACON, RASHER, BACON, HAM, BACON, GAMMON, HAM, HAM, GAMMON, RASHER, FLITCH, GAMMON, } ) ) );

	private static final ReelStrip<FiverReelSymbol> BASEGAME_STRIP_2 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { FLITCH, BACON, PORK, PORK, PORK, PORK, PORK, PORK, FLITCH, RASHER, GAMMON, HAM, BACON, RASHER, HAM, HAM, BACON, BACON, FLITCH, RASHER,
			BACON, FLITCH, HAM, HAM, GAMMON, BACON, RASHER, FLITCH, BACON, RASHER, GAMMON, GAMMON, HAM, HAM, KASSLER, BACON, FLITCH, GAMMON, BACON, GAMMON, HAM, HAM, FLITCH, BACON, SOWBELLY, GAMMON, GAMMON, SOWBELLY, GAMMON, HAM, GAMMON, GAMMON, BACON, HAM, RASHER, } ) ) );

	private static final ReelStrip<FiverReelSymbol> BASEGAME_STRIP_3 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { RASHER, HAM, PORK, PORK, PORK, PORK, PORK, BACON, GAMMON, HAM, HAM, BACON, GAMMON, RASHER, FLITCH, GAMMON, BACON, HAM, FLITCH, RASHER,
			BACON, HAM, FLITCH, BACON, GAMMON, GAMMON, BACON, FLITCH, GAMMON, BACON, HAM, GAMMON, BACON, RASHER, HAM, HAM, GAMMON, BACON, RASHER, GAMMON, HAM, BACON, BACON, HAM, FLITCH, HAM, HAM, FLITCH, HAM, RASHER, HAM, HAM, BACON, GAMMON, KASSLER, HAM, HAM, BACON, SOWBELLY, BACON, HAM, SOWBELLY,
			HAM, GAMMON, } ) ) );

	private static final ReelStrip<FiverReelSymbol> BASEGAME_STRIP_4 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { GAMMON, RASHER, PORK, PORK, PORK, PORK, PORK, BACON, RASHER, HAM, BACON, GAMMON, BACON, KASSLER, BACON, GAMMON, HAM, GAMMON, HAM,
			GAMMON, HAM, BACON, GAMMON, BACON, HAM, GAMMON, FLITCH, HAM, GAMMON, BACON, GAMMON, SOWBELLY, GAMMON, HAM, GAMMON, BACON, HAM, BACON, RASHER, GAMMON, BACON, RASHER, GAMMON, HAM, HAM, BACON, GAMMON, HAM, FLITCH, HAM, HAM, GAMMON, RASHER, BACON, SOWBELLY } ) ) );

	private static final ReelStrip<FiverReelSymbol> BASEGAME_STRIP_5 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { GAMMON, GAMMON, PORK, PORK, PORK, PORK, PORK, HAM, BACON, RASHER, HAM, HAM, GAMMON, FLITCH, GAMMON, KASSLER, BACON, HAM, HAM, BACON,
			BACON, HAM, BACON, GAMMON, SOWBELLY, GAMMON, FLITCH, BACON, RASHER, FLITCH, HAM, BACON, GAMMON, GAMMON, BACON, FLITCH, GAMMON, RASHER, KASSLER, BACON, GAMMON, HAM, KASSLER, RASHER, FLITCH, HAM, HAM, FLITCH, BACON, RASHER, } ) ) );

	private static final ReelStrip<FiverReelSymbol> FREESPIN_STRIP_1 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { RASHER, HAM, PORK, PORK, PORK, PORK, PORK, PORK, PORK, FLITCH, RASHER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, HAM,
			GAMMON, BACON, HAM, RASHER, GAMMON, BACON, HAM, RASHER, SOWBELLY, GAMMON, GAMMON, BACON, SOWBELLY, HAM, GAMMON, HAM, BACON, GAMMON, RASHER, HAM, GAMMON, HAM, GAMMON, FLITCH, RASHER, GAMMON, HAM, BACON, HAM, FLITCH, GAMMON, BACON, GAMMON, RASHER, HAM, HAM, GAMMON, } ) ) );

	private static final ReelStrip<FiverReelSymbol> FREESPIN_STRIP_2 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { BACON, FLITCH, PORK, PORK, PORK, PORK, PORK, PORK, PORK, BACON, GAMMON, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, RASHER,
			GAMMON, HAM, GAMMON, SOWBELLY, RASHER, HAM, BACON, HAM, RASHER, GAMMON, BACON, HAM, GAMMON, SOWBELLY, GAMMON, GAMMON, BACON, FLITCH, GAMMON, RASHER, BACON, HAM, BACON, GAMMON, HAM, FLITCH, BACON, BACON, FLITCH, HAM, RASHER, GAMMON, HAM, FLITCH, RASHER, HAM, BACON, } ) ) );

	private static final ReelStrip<FiverReelSymbol> FREESPIN_STRIP_3 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { BACON, RASHER, PORK, PORK, PORK, PORK, PORK, PORK, PORK, BACON, BACON, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, HAM,
			FLITCH, GAMMON, HAM, BACON, GAMMON, FLITCH, HAM, RASHER, FLITCH, GAMMON, HAM, SOWBELLY, GAMMON, BACON, BACON, GAMMON, HAM, HAM, SOWBELLY, HAM, BACON, FLITCH, HAM, BACON, GAMMON, RASHER, HAM, HAM, RASHER, FLITCH, HAM, BACON, BACON, HAM, BACON, BACON, GAMMON, HAM, BACON, FLITCH, HAM, RASHER,
			GAMMON, HAM, BACON, HAM, RASHER, GAMMON, GAMMON, } ) ) );

	private static final ReelStrip<FiverReelSymbol> FREESPIN_STRIP_4 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { HAM, GAMMON, PORK, PORK, PORK, PORK, PORK, PORK, PORK, HAM, BACON, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, HAM, FLITCH,
			GAMMON, HAM, HAM, RASHER, GAMMON, HAM, RASHER, BACON, BACON, GAMMON, HAM, RASHER, BACON, GAMMON, HAM, RASHER, BACON, HAM, GAMMON, HAM, BACON, GAMMON, SOWBELLY, FLITCH, GAMMON, BACON, RASHER, GAMMON, SOWBELLY, GAMMON, HAM, RASHER, GAMMON, BACON, GAMMON, BACON, HAM, BACON, HAM, GAMMON,
			GAMMON, HAM, HAM, GAMMON, BACON, RASHER, } ) ) );

	private static final ReelStrip<FiverReelSymbol> FREESPIN_STRIP_5 = new ReelStrip<FiverReelSymbol>( ImmutableList.copyOf( Arrays.asList( new FiverReelSymbol[] { HAM, BACON, PORK, PORK, PORK, PORK, PORK, PORK, PORK, FLITCH, HAM, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, KASSLER, HAM, RASHER,
			GAMMON, BACON, HAM, FLITCH, GAMMON, GAMMON, HAM, RASHER, HAM, HAM, GAMMON, GAMMON, HAM, GAMMON, FLITCH, GAMMON, RASHER, GAMMON, GAMMON, HAM, FLITCH, SOWBELLY, HAM, BACON, BACON, HAM, GAMMON, BACON, HAM, SOWBELLY, HAM, HAM, BACON, GAMMON, RASHER, BACON, FLITCH, BACON, HAM, GAMMON, HAM,
			GAMMON, BACON, RASHER, GAMMON, BACON, } ) ) );

	public ReelStrip<FiverReelSymbol> getBaseGameSymbols1()
	{
		return BASEGAME_STRIP_1;
	}

	public ReelStrip<FiverReelSymbol> getBaseGameSymbols2()
	{
		return BASEGAME_STRIP_2;
	}

	public ReelStrip<FiverReelSymbol> getBaseGameSymbols3()
	{
		return BASEGAME_STRIP_3;
	}

	public ReelStrip<FiverReelSymbol> getBaseGameSymbols4()
	{
		return BASEGAME_STRIP_4;
	}

	public ReelStrip<FiverReelSymbol> getBaseGameSymbols5()
	{
		return BASEGAME_STRIP_5;
	}

	public ReelStrip<FiverReelSymbol> getFreeGameSymbols1()
	{
		return FREESPIN_STRIP_1;
	}

	public ReelStrip<FiverReelSymbol> getFreeGameSymbols2()
	{
		return FREESPIN_STRIP_2;
	}

	public ReelStrip<FiverReelSymbol> getFreeGameSymbols3()
	{
		return FREESPIN_STRIP_3;
	}

	public ReelStrip<FiverReelSymbol> getFreeGameSymbols4()
	{
		return FREESPIN_STRIP_4;
	}

	public ReelStrip<FiverReelSymbol> getFreeGameSymbols5()
	{
		return FREESPIN_STRIP_5;
	}

}
