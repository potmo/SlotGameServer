package com.potmo.slotserver.gameserver.game.fiver;

import com.potmo.slotserver.gameserver.slot.reel.IReelSymbol;

public enum FiverReelSymbol implements IReelSymbol
{
	HAM('H'), BACON('B'), PORK('P'), FLITCH('F'), RASHER('R'), GAMMON('G'), SOWBELLY('S'), KASSLER('K'), CAPICOLA('C'), PIGLET('P');

	private final Character symbol;

	FiverReelSymbol(Character symbol)
	{
		this.symbol = symbol;
	}

	public String toString()
	{
		return this.symbol.toString();
	}
}
