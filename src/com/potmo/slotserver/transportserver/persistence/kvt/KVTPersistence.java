package com.potmo.slotserver.transportserver.persistence.kvt;

import se.gawell.kvtstore.core.Deserializer;
import se.gawell.kvtstore.core.KeyTimeValueStore;
import se.gawell.kvtstore.core.Serializer;
import se.gawell.kvtstore.core.SystemTimeProvider;
import se.gawell.kvtstore.core.TimeProvider;
import se.gawell.kvtstore.core.jackson.JacksonDeserializer;
import se.gawell.kvtstore.core.jackson.JacksonSerializer;
import se.gawell.kvtstore.core.riak.AlphabeticallySortableTimeFormatter;
import se.gawell.kvtstore.core.riak.RiakKeyTimeValueStore;
import se.gawell.kvtstore.core.riak.TimeFormatter;

import com.basho.riak.client.http.RiakClient;
import com.basho.riak.client.http.RiakConfig;

public class KVTPersistence
{

	private final KeyTimeValueStore<String> store;

	public KVTPersistence()
	{
		RiakConfig config = new RiakConfig();
		RiakClient riakClient = new RiakClient( config );
		Serializer serializer = new JacksonSerializer();

		Deserializer deserializer = new JacksonDeserializer();

		TimeFormatter timeFormatter = new AlphabeticallySortableTimeFormatter();
		TimeProvider timeProvider = new SystemTimeProvider();
		
		store = new RiakKeyTimeValueStore( riakClient, serializer, deserializer, timeProvider, timeFormatter );
	}
}
