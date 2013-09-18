package com.potmo.slotserver.gameserver.slot.payline;

import com.google.common.collect.ImmutableList;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;

public interface IPayLine<T extends IReelSymbol>
{

	public abstract ImmutableList<T> getSymbols( ReelStopResult<T> reelStopResults );

}