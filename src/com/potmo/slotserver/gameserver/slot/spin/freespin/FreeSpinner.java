package com.potmo.slotserver.gameserver.slot.spin.freespin;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import com.potmo.slotserver.gameserver.random.IRandomNumberGenerator;
import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;
import com.potmo.slotserver.gameserver.slot.reel.ReelGroup;
import com.potmo.slotserver.gameserver.slot.reel.ReelStopResult;

public class FreeSpinner<T extends IReelSymbol>
{
	private IRandomNumberGenerator random;
	private IFreespinPayResolver<T> payResolver;
	private ReelGroup<T> baseGameReels;
	private ReelGroup<T> freespinReels;

	public FreeSpinner(IRandomNumberGenerator random, IFreespinPayResolver<T> payResolver, ReelGroup<T> baseGameReels, ReelGroup<T> freespinReels)
	{
		this.random = random;
		this.payResolver = payResolver;
		this.baseGameReels = baseGameReels;
		this.freespinReels = freespinReels;
	}

	public LinkedList<FreeSpin<T>> spin( BigInteger betLines )
	{

		LinkedList<FreeSpin<T>> spins = new LinkedList<FreeSpin<T>>();

		//start with list of empty spins that has zero freespins 
		doSpin( spins, betLines, baseGameReels, 0 );

		return spins;
	}

	private void doSpin( List<FreeSpin<T>> spins, BigInteger betLines, ReelGroup<T> baseGameReels2, int freespins )
	{
		ReelStopResult<T> reelsStopResult = baseGameReels.createReelStopResult( random );
		FreespinPayResult<T> payResult = payResolver.resolve( reelsStopResult, betLines );

		FreeSpin<T> freeSpin = new FreeSpin<T>( reelsStopResult, payResult );
		spins.add( freeSpin );

		freespins += payResult.getAdditionalFreespins();

		// recurse if we have more freespins to finish
		if ( freespins > 0 )
		{
			freespins--;
			doSpin( spins, betLines, freespinReels, freespins );
		}

	}

}
