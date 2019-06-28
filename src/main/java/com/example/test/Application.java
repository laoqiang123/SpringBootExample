package com.example.test;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.PostConstruct;

@SpringBootApplication
@PropertySource(value = "classpath:jdbc.properties", ignoreResourceNotFound = true)
@MapperScan(basePackages = "com.example.test.*", sqlSessionFactoryRef = "sqlSessionFactory", annotationClass = Repository.class)
public class Application implements InitializingBean {
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	@Autowired
	private RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		redisTemplate.setValueSerializer(redisSerializer);
	}
}
