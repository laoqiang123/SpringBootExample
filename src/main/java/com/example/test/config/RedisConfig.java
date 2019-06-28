package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	private RedisConnectionFactory redisConnectionFactory = null;

	/*@Bean("RedisConnectionFactory")
	public RedisConnectionFactory initRedisConnectionFactory() {
		if (this.redisConnectionFactory != null) {
			return this.redisConnectionFactory;
		}
        //配置redis 连接池的配置
		JedisPoolConfig jedisPoolConfig  = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(30);
		jedisPoolConfig.setMaxTotal(50);
		jedisPoolConfig.setMaxWaitMillis(2000);
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		return jedisConnectionFactory;
	}
    @Bean("RedisTemplate")
	public RedisTemplate<Object,Object> getRedisTemplate(){
		RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(initRedisConnectionFactory());
		RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		redisTemplate.setValueSerializer(redisSerializer);
		redisTemplate.setHashKeySerializer(redisSerializer);
		redisTemplate.setHashValueSerializer(redisSerializer);
		return redisTemplate;
	}*/

}
