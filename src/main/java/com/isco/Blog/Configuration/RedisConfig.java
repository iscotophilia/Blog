package com.isco.Blog.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	@Bean
	public JedisPoolConfig initJedisPool() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(300);
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMaxWaitMillis(20000);
		return jedisPoolConfig;
	}

	@Bean(name = "redisStandaloneConfiguration")
	@ConfigurationProperties(prefix = "redis")
	public RedisStandaloneConfiguration initRedisConfiguration() {
		return new RedisStandaloneConfiguration();
	}

	@Bean(name = "connectionFactory")
	@Autowired
	public JedisConnectionFactory initJedisConnection(RedisStandaloneConfiguration redisStandaloneConfiguration) {
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean(name = "redisTemplate")
	@Autowired
	public RedisTemplate<String, Object> initRedisTemplate(JedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		return redisTemplate;
	}

}
