package com.potmo.slotserver.wagerserver.communication.wager.wager;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.potmo.slotserver.voucher.Voucher;
import com.potmo.slotserver.wagerserver.communication.wager.Credentials;

public class WagerRequest
{
	@JsonProperty("game")
	public final String game;

	@JsonProperty("credentials")
	public final Credentials credentials;

	@JsonProperty("gamepayload")
	public final String gamepayload;

	@JsonProperty("vouchers")
	public final List<Voucher> vouchers;

	@JsonCreator
	public WagerRequest(
						@JsonProperty("credentials") Credentials credentials,
						@JsonProperty("gamepayload") String gamepayload,
						@JsonProperty("game") String game,
						@JsonProperty("vouchers") ArrayList<Voucher> vouchers)
	{
		this.credentials = credentials;
		this.gamepayload = gamepayload;
		this.game = game;
		this.vouchers = vouchers;
	}
}
