package com.infymeMobile.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);

		// Key and value both are serialized and deserialized in the form of String
		// while storing and fetching from redis
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());

		return redisTemplate;

	}

}
