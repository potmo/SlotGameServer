package com.potmo.slotserver.gameserver.game.fiver;

import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.BACON;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.CAPICOLA;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.FLITCH;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.GAMMON;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.HAM;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.KASSLER;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.PIGLET;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.PORK;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.RASHER;
import static com.potmo.slotserver.gameserver.game.fiver.FiverReelSymbol.SOWBELLY;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.linepay.RegularLinePay;

public class FiverLinePayFactory
{

	public ImmutableList<RegularLinePay<FiverReelSymbol>> getRegularLinePayGroup()
	{

		ImmutableList<FiverReelSymbol> regularSymbols = ImmutableList.of( HAM, BACON, PORK, FLITCH, RASHER, GAMMON, SOWBELLY, PIGLET );
		ImmutableList<FiverReelSymbol> wildSymbols = ImmutableList.of( KASSLER );
		ImmutableList<FiverReelSymbol> scatterSymbols = ImmutableList.of( CAPICOLA );

		List<RegularLinePay<FiverReelSymbol>> linePays = new LinkedList<RegularLinePay<FiverReelSymbol>>();

		linePays.add( new RegularLinePay<FiverReelSymbol>( BACON, 5, new BigInteger( "500" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( BACON, 4, new BigInteger( "200" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( BACON, 3, new BigInteger( "50" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( BACON, 3, new BigInteger( "4" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( RASHER, 5, new BigInteger( "400" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( RASHER, 4, new BigInteger( "150" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( RASHER, 3, new BigInteger( "40" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( SOWBELLY, 5, new BigInteger( "350" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( SOWBELLY, 4, new BigInteger( "100" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( SOWBELLY, 3, new BigInteger( "30" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( PIGLET, 5, new BigInteger( "350" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( PIGLET, 4, new BigInteger( "100" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( PIGLET, 3, new BigInteger( "30" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( GAMMON, 5, new BigInteger( "250" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( GAMMON, 4, new BigInteger( "100" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( GAMMON, 3, new BigInteger( "20" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( HAM, 5, new BigInteger( "250" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( HAM, 4, new BigInteger( "100" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( HAM, 3, new BigInteger( "20" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( PORK, 5, new BigInteger( "200" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( PORK, 4, new BigInteger( "75" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( PORK, 3, new BigInteger( "15" ) ) );

		linePays.add( new RegularLinePay<FiverReelSymbol>( FLITCH, 5, new BigInteger( "200" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( FLITCH, 4, new BigInteger( "75" ) ) );
		linePays.add( new RegularLinePay<FiverReelSymbol>( FLITCH, 3, new BigInteger( "15" ) ) );

		return ImmutableList.copyOf( linePays );

	}
}
