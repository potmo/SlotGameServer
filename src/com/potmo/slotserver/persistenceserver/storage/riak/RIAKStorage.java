package com.potmo.slotserver.persistenceserver.storage.riak;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jvnet.hk2.annotations.Service;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakException;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.RiakRetryFailedException;
import com.basho.riak.client.bucket.Bucket;
import com.basho.riak.client.bucket.DomainBucket;
import com.basho.riak.client.cap.DefaultResolver;
import com.basho.riak.client.cap.DefaultRetrier;
import com.potmo.slotserver.configuration.ServerConfiguration;
import com.potmo.slotserver.persistenceserver.storage.Storage;

@Service
public class RIAKStorage implements Storage
{

	private ServerConfiguration config;

	private IRiakClient riakClient;

	@Inject
	public RIAKStorage(@Singleton ServerConfiguration config)
	{

		this.config = config;

		String url = this.config.getRiakServerUri();

		try
		{
			riakClient = RiakFactory.httpClient( url );
		} catch ( RiakException e )
		{
			e.printStackTrace();
		}

	}

	@Override
	public void storeWager( String partner, String game, String gameSession, String wagerId, String payload )
	{

		//TODO: Handle this logging error in a better way? How?
		try
		{
			storeInRiak( partner, game, gameSession, wagerId, payload );
		} catch ( RiakRetryFailedException e )
		{
			e.printStackTrace();
		} catch ( RiakException e )
		{
			e.printStackTrace();
		}

	}

	private void storeInRiak( String partner, String game, String gameSession, String wagerId, String payload ) throws RiakException
	{
		Bucket bucket = riakClient.createBucket( "test-wager" ).execute();

		final DomainBucket<StoredWager> domainBucket = DomainBucket.builder( bucket, StoredWager.class )
				.withResolver( new DefaultResolver<StoredWager>() )
				.retrier( new DefaultRetrier( 5 ) )
				.w( 1 )
				.dw( 1 )
				.r( 1 )
				.rw( 1 )
				.build();

		//TODO: add timestamp
		domainBucket.store( new StoredWager( partner, game, gameSession, wagerId, payload ) );
	}
}
