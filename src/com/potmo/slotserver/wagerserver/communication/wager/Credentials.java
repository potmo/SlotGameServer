package com.potmo.slotserver.wagerserver.communication.wager;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials
{

	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("account")
	public final String account;

	@JsonProperty("ticket")
	public final String ticket;

	@JsonProperty("currency")
	public final String currency;

	@JsonCreator
	public Credentials(
						@JsonProperty("partner") String partner,
						@JsonProperty("account") String account,
						@JsonProperty("ticket") String ticket,
						@JsonProperty("currency") String currency)
	{
		this.partner = partner;
		this.account = account;
		this.ticket = ticket;
		this.currency = currency;
	}
}
