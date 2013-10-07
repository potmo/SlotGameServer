package com.potmo.slotserver.transactionserver.communication.performtransaction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest
{
	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("game")
	public final String game;

	@JsonProperty("account")
	public final String account;

	@JsonProperty("ticket")
	public final String ticket;

	@JsonProperty("bet")
	public final BigInteger bet;

	@JsonProperty("win")
	public final BigInteger win;

	//TODO: Enumerate this?
	@JsonProperty("currency")
	public final String currency;

	@JsonProperty("campaigns")
	public final String[] campaigns;

	@JsonCreator
	public TransactionRequest(
								@JsonProperty("partner") String partner,
								@JsonProperty("game") String game,
								@JsonProperty("account") String account,
								@JsonProperty("ticket") String ticket,
								@JsonProperty("currency") String currency,
								@JsonProperty("bet") BigInteger bet,
								@JsonProperty("win") BigInteger win,
								@JsonProperty("campaigns") String[] campaigns)
	{
		this.partner = partner;
		this.game = game;
		this.currency = currency;
		this.bet = bet;
		this.win = win;
		this.account = account;
		this.ticket = ticket;
		this.campaigns = campaigns;
	}

}