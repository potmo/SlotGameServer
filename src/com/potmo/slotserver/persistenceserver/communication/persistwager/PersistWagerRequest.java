package com.potmo.slotserver.persistenceserver.communication.persistwager;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersistWagerRequest
{
	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("game")
	public final String game;

	@JsonProperty("gamesession")
	public final String gameSession;

	@JsonProperty("wagerid")
	public final String wagerId;

	@JsonProperty("payload")
	public final String payload;

	@JsonCreator
	public PersistWagerRequest(
								@JsonProperty("partner") String partner,
								@JsonProperty("game") String game,
								@JsonProperty("gamesession") String gameSession,
								@JsonProperty("wagerid") String wagerId,
								@JsonProperty("payload") String payload)
	{
		this.partner = partner;
		this.game = game;
		this.gameSession = gameSession;
		this.wagerId = wagerId;
		this.payload = payload;
	}
}
