package com.potmo.slotserver.transportserver.communication.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransportRequest
{

	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("game")
	public final String game;

	@JsonProperty("account")
	public final String account;

	@JsonProperty("ticket")
	public final String ticket;

	@JsonProperty("currency")
	public final String currency;

	@JsonProperty("campaigns")
	public final String[] campaigns;

	@JsonProperty("payload")
	public final String payload;

	@JsonCreator
	public TransportRequest(
							@JsonProperty("partner") String partner,
							@JsonProperty("game") String game,
							@JsonProperty("account") String account,
							@JsonProperty("ticket") String ticket,
							@JsonProperty("currency") String currency,
							@JsonProperty("payload") String payload,
							@JsonProperty("campaigns") String[] campaigns)
	{
		this.partner = partner;
		this.game = game;
		this.account = account;
		this.ticket = ticket;
		this.currency = currency;
		this.payload = payload;
		this.campaigns = campaigns;
	}
}
