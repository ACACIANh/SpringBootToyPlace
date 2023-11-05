package com.example.redisinheritance;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.SslOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.function.Supplier;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisConfiguration {

	private final RedisProperties redisProperties;

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {

		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		config.setHostName( redisProperties.getHost() );
		config.setPort( redisProperties.getPort() );
		config.setDatabase( redisProperties.getDatabase() );
		config.setPassword( redisProperties.getPassword() );

		LettuceClientConfiguration clientConfig = this.lettuceClientConfiguration();
		return new LettuceConnectionFactory( config, clientConfig );
	}

	@Bean
	public LettuceClientConfiguration lettuceClientConfiguration() {
		// if you want ssl config, try this space.
		return LettuceClientConfiguration.builder()
				.commandTimeout( redisProperties.getTimeout() )
				.build();
	}

	@Bean
	public RedisTemplate< String, Object > redisTemplate() {

		RedisTemplate< String, Object > redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory( redisConnectionFactory() );
		redisTemplate.setKeySerializer( new StringRedisSerializer() );

		return redisTemplate;
	}
}
