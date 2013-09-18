package com.potmo.slotserver.gameserver.slot.reel;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReelStopResult<T extends IReelSymbol>
{

	@JsonIgnore
	private final LinkedList<LinkedList<T>> visibleSymbols;

	@JsonProperty("stoppositions")
	private final LinkedList<Integer> stopPositions;

	public ReelStopResult(LinkedList<LinkedList<T>> visibleSymbols, LinkedList<Integer> stopPositions)
	{
		this.visibleSymbols = visibleSymbols;
		this.stopPositions = stopPositions;
	}

	@JsonCreator
	public ReelStopResult(@JsonProperty("stoppositions") LinkedList<Integer> stopPositions)
	{
		this.visibleSymbols = null;
		this.stopPositions = stopPositions;
	}

	@JsonIgnore
	public LinkedList<Integer> getStopPositions()
	{
		return stopPositions;
	}

	@JsonIgnore
	public LinkedList<LinkedList<T>> getVisibleSymbols()
	{
		return visibleSymbols;
	}

	@JsonIgnore
	public T getSymbolAt( int x, int y )
	{
		return visibleSymbols.get( x ).get( y );
	}

	@Override
	public String toString()
	{
		return "ReelStopResult [visibleSymbols=" + visibleSymbols + ", stopPositions=" + stopPositions + "]";
	}
	
	

}
