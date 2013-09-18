package com.potmo.slotserver.gameserver.game.fiver;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.random.IRandomNumberGenerator;
import com.potmo.slotserver.gameserver.random.UnsecureJavaRandomNumberGenerator;
import com.potmo.slotserver.gameserver.slot.linepay.RegularLinePay;
import com.potmo.slotserver.gameserver.slot.payline.IPayLine;
import com.potmo.slotserver.gameserver.slot.reel.ReelGroup;
import com.potmo.slotserver.gameserver.slot.spin.freespin.FreeSpinner;
import com.potmo.slotserver.gameserver.slot.spin.freespin.IFreespinPayResolver;

public class FiverFactory
{

	public Fiver getGame()
	{
		IRandomNumberGenerator random = new UnsecureJavaRandomNumberGenerator();

		FiverLinePayFactory linePayFactory = new FiverLinePayFactory();
		ImmutableList<RegularLinePay<FiverReelSymbol>> regularLinePayGroup = linePayFactory.getRegularLinePayGroup();

		FiverPayLineFactory paylineGroupFactory = new FiverPayLineFactory();
		ImmutableList<IPayLine<FiverReelSymbol>> paylineGroup = paylineGroupFactory.getPaylineGroup();

		IFreespinPayResolver<FiverReelSymbol> payResolver = new FiverPayResolver<FiverReelSymbol>( paylineGroup,regularLinePayGroup );

		FiverReelStripFactory reelStripFactory = new FiverReelStripFactory();
		FiverReelFactory reelFactory = new FiverReelFactory( reelStripFactory );
		FiverReelGroupFactory reelGroupFactory = new FiverReelGroupFactory( reelFactory );

		ReelGroup<FiverReelSymbol> baseGameReelGroup = reelGroupFactory.getBaseGameReelGroup();
		ReelGroup<FiverReelSymbol> freeGameReelGroup = reelGroupFactory.getFreeGameReelGroup();

		FreeSpinner<FiverReelSymbol> spinner = new FreeSpinner<FiverReelSymbol>( random, payResolver, baseGameReelGroup, freeGameReelGroup );

		Fiver game = new Fiver( spinner );

		return game;

	}
}
