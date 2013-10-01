package com.potmo.slotserver.transportserver.communication.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportRequest
{

	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("game")
	public final String game;

	@JsonProperty("ticket")
	public final String ticket;

	@JsonProperty("account")
	public final String account;

	@JsonProperty("payload")
	public final String payload;

	@JsonCreator
	public TransportRequest(
							@JsonProperty("partner") String partner,
							@JsonProperty("game") String game,
							@JsonProperty("account") String account,
							@JsonProperty("ticket") String ticket,
							@JsonProperty("payload") String payload)
	{
		this.partner = partner;
		this.game = game;
		this.account = account;
		this.ticket = ticket;
		this.payload = payload;
	}
}
