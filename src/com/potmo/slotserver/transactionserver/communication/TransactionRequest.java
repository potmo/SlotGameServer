package com.potmo.slotserver.transactionserver.communication;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest
{
	@JsonProperty("partner")
	public final String partner;

	@JsonProperty("game")
	public final String game;

	@JsonProperty("bet")
	public final BigInteger bet;

	@JsonProperty("win")
	public final BigInteger win;
	
	@JsonProperty("ticket")
	public final String ticket;
	
	@JsonProperty("account")
	public final String account;

	@JsonCreator
	public TransactionRequest(
								@JsonProperty("partner") String partner,
								@JsonProperty("game") String game,
								@JsonProperty("bet") BigInteger bet,
								@JsonProperty("win") BigInteger win,
								@JsonProperty("account") String account,
								@JsonProperty("ticket") String ticket)
	{
		this.partner = partner;
		this.game = game;
		this.bet = bet;
		this.win = win;
		this.account = account;
		this.ticket = ticket;
	}
}