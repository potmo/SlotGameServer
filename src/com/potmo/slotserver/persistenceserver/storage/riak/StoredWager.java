package com.potmo.slotserver.persistenceserver.storage.riak;

import com.basho.riak.client.convert.RiakIndex;
import com.basho.riak.client.convert.RiakKey;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoredWager
{

	@RiakKey
	@JsonProperty("wagerid")
	private String wagerId;

	@RiakIndex(name = "partner")
	@JsonProperty("partner")
	private String partner;

	@RiakIndex(name = "game")
	@JsonProperty("game")
	private String game;

	@JsonProperty("gamesession")
	@RiakIndex(name = "gamesession")
	private String gameSession;

	@JsonProperty("payload")
	private String payload;

	public StoredWager(
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
