package com.example.test.config;

import com.example.test.dao.UserDao;
import com.example.test.example.MyApsect;
import com.example.test.example.MyApsect2;
import com.example.test.example.ShowCondition;
import com.example.test.example.Test1;
import com.example.test.message.RedisMessageListener;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.example.test.service.impl.HelloServiceImpl;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = { "com.example.test.*" })
@ImportResource(value = "classpath:springbeans.xml")
public class MyApplicationConfig {
	@Autowired
	private Environment environment;
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private RedisMessageListener redisMessageListener;




	@Bean
	@Conditional(ShowCondition.class)
	public Test1 show() {
		return new Test1();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource getDataSources() {
		return  DataSourceBuilder.create().build();
	}

	@Bean
	public MyApsect getMyAspect() {
		return new MyApsect();
	}
	@Bean
	public MyApsect2 getMyAspect2() {
		return new MyApsect2();
	}

	@Bean
	public HelloServiceImpl getHelloServiceImpl() {
		return new HelloServiceImpl();
	}

	/**
	 * 在实际的规范中，我们开发完dao层，它的实现类，就是一般我们都是采用的是Mapper 配置，这种是没法通过new
	 * 去生成，所以要借助MapperFactoryBean
	 * @return
	 */
	/*@Bean
	public MapperFactoryBean<UserDao> MapperFactoryBean (){
		MapperFactoryBean<UserDao> mapperFactoryBean = new MapperFactoryBean<>();
		mapperFactoryBean.setMapperInterface(UserDao.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
		return mapperFactoryBean;
	}
	//这种的缺陷可以看到 对于一个Dao接口，就需要编写一个，接口多很麻烦。



	@Bean
    public MapperScannerConfigurer getMapperScannerConfigurerBean(){
	   MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
	   //这里Spring Boot 会自动加载sqlSessionFactory的实例，这里的，名称是固定的。
	   mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	   //这里只会扫描被@Repository 的接口
	   mapperScannerConfigurer.setAnnotationClass(Repository.class);
	   //扫描mapper 配置文件
	   mapperScannerConfigurer.setBasePackage("com.example.test.mapper.*");
	   return mapperScannerConfigurer;

	}*/
	//创建线程池，等待处理redis 消息
    @Bean
	public ThreadPoolTaskScheduler getThreadPoolTaskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		if(threadPoolTaskScheduler!=null){
			return threadPoolTaskScheduler;
		}
		threadPoolTaskScheduler.setPoolSize(20);
		return threadPoolTaskScheduler;
	}
	//定义redis 监听容器
    @Bean
	public RedisMessageListenerContainer getRedisMessageListenerContainer(){
      RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
      redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
      redisMessageListenerContainer.setTaskExecutor(getThreadPoolTaskScheduler());
		Topic topic = new ChannelTopic("topic1");
		//使用监听器监听redis 的topic 的信息
		redisMessageListenerContainer.addMessageListener(redisMessageListener,topic);
		return redisMessageListenerContainer;
	}
}