package com.potmo.slotserver.gameserver.slot.spin.freespin;

import java.math.BigInteger;

import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;

public interface IFreespinPayResolver<T extends IReelSymbol>
{

	FreespinPayResult<T> resolve( ReelStopResult<T> reelsStopResult, BigInteger betLines );

}
