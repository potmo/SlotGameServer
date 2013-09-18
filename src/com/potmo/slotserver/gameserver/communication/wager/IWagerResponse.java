package com.potmo.slotserver.gameserver.communication.wager;

import java.math.BigInteger;

public interface IWagerResponse
{

	BigInteger getTotalWin();
	BigInteger getTotalCost();
}
