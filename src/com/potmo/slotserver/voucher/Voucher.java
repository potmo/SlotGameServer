package com.potmo.slotserver.voucher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Voucher
{

	@JsonProperty("type")
	public final VoucherType type;

	//TODO: Use UUID or something here instead for a generic string
	@JsonProperty("id")
	public final String id;

	@JsonCreator
	public Voucher(
					@JsonProperty("type") VoucherType type,
					@JsonProperty("id") String id
	)
	{
		this.type = type;
		this.id = id;
		
	}
}
