package com.potmo.slotserver.gameserver.random;

import java.util.Random;

public class UnsecureJavaRandomNumberGenerator implements IRandomNumberGenerator
{
	private Random random;

	public UnsecureJavaRandomNumberGenerator()
	{
		random = new Random();
	}

	@Override
	public Integer nextInt( Integer n )
	{
		return random.nextInt( n );
	}

}
