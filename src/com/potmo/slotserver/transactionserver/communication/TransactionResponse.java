package com.potmo.slotserver.transactionserver.communication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse
{
	@JsonProperty("gamesessionid")
	public final String gameSessionId;

	@JsonProperty("wagerid")
	public final String wagerId;

	@JsonCreator
	public TransactionResponse(
								@JsonProperty("gamesessionid") String gameSessionId,
								@JsonProperty("wagerid") String wagerId)
	{
		this.gameSessionId = gameSessionId;
		this.wagerId = wagerId;
	}
}