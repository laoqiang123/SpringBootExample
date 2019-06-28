package com.example.test.controller;

import com.example.test.example.*;
import com.example.test.pojo.SexEnum;
import com.example.test.pojo.User;
import com.example.test.service.TestService;
import com.example.test.service.UserBatchService;
import com.example.test.service.UserService;
import com.example.test.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

@RestController
public class TestController {
	@Autowired
	private DateBasePropertities database;
	@Autowired
	private MySqlConfiguration mySqlConfiguration;
	@Autowired
	private Person person;
	@Autowired
	private TestSpringEl testSpringEl;
	@Autowired
	private HelloServiceImpl helloServiceImpl;

	@Autowired
	private UserService userService;

	@Autowired
	private TestService testService;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private UserBatchService userBatchService;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping(value = "/hello")
	public String testMethod() throws Exception {
		// 它会根据后面load 这个类的全限类名去到各个依赖的META-INF 下找到这个文件名一致的，加载它下面的所有实现类
		/*
		 * ServiceLoader<TestService1> serviceLoader =
		 * ServiceLoader.load(TestService1.class); Iterator<TestService1> iterator =
		 * serviceLoader.iterator(); while(iterator.hasNext()) { TestService1
		 * testService1Impl= iterator.next(); testService1Impl.show(); }
		 */
		UserValidator userValidator = (UserValidator) helloServiceImpl;
		if (userValidator.validate("jjj")) {
			helloServiceImpl.sayName("kkkk");
		} else {
			System.out.println("exception");
		}

		return "helloworld";
	}

	@RequestMapping(value = "/show")
	public void show() {
      //User user = testService.findUserById(1L);
      //System.out.println(user.getSex().getName());
		User user = new User();
		user.setNote("kkk");
		user.setSex(SexEnum.MAN);
		user.setUserName("ppp");
		User user1 = new User();
		user1.setNote("kkk1");
		user1.setSex(SexEnum.WOMAN);
		user1.setUserName("ppp1");
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		try {
			userService.insertUsers(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/show1")
	public String show1(){
		//redisTemplate.opsForValue().set("ljx1","hhh");
		//return redisTemplate.opsForValue().get("ljx1").toString();
		/*BoundValueOperations<String,Object>  boundValueOperations = redisTemplate.boundValueOps("ljc");
		boundValueOperations.append("s");
		boundValueOperations.append("asds");
		return boundValueOperations.get().toString();*/

		//DefaultListableBeanFactory
		//ClassPathBeanDefinitionScanner
		//BeanDefinitionRegistry


		redisTemplate.opsForValue().set("key2","value2");
		stringRedisTemplate.opsForValue().increment("key",1);
		Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
		jedis.decr("key");//减1
		//hash 是集合操作
		stringRedisTemplate.opsForHash().put("hash","key3","value3");
		stringRedisTemplate.opsForList().leftPushAll("list","v1","v2","v3");
		stringRedisTemplate.opsForList().leftPop("list");
		stringRedisTemplate.opsForSet().add("set","v1","v2","v3","v4");

 		return redisTemplate.opsForValue().get("ljx1").toString();
	}
	@RequestMapping("/showzset")
	public Map<String,Double> testZset(){
		Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
		for(int i =1;i<10;i++){
			double score = i*9;
			ZSetOperations.TypedTuple typedTuple = new DefaultTypedTuple("value"+i,score);
			typedTupleSet.add(typedTuple);
		}
		stringRedisTemplate.opsForZSet().add("zset",typedTupleSet);
		BoundZSetOperations boundZSetOperations = stringRedisTemplate.boundZSetOps("zset");
		Double score1 = boundZSetOperations.score("value1");
		Set<ZSetOperations.TypedTuple<String>> typedTupleSet1 = boundZSetOperations.rangeWithScores(0,boundZSetOperations.size());
		Map<String,Double> map = new HashMap<>();
		for(ZSetOperations.TypedTuple<String> typedTuple:typedTupleSet1){
			map.put(String.valueOf(typedTuple.getValue()),typedTuple.getScore());
		}
		return map;
	}

	@RequestMapping("/showredistransation")
	public void showRediStransation(){

		redisTemplate.opsForValue().set("ljx","111");
		BoundValueOperations boundValueOperations = redisTemplate.boundValueOps("ljx");
		boundValueOperations.increment(1);
		System.out.println(redisTemplate.opsForValue().get("ljx"));
		stringRedisTemplate.opsForValue().set("ljx1","222");
		BoundValueOperations boundValueOperations1 = redisTemplate.boundValueOps("ljx1");
		boundValueOperations1.increment(1);
		System.out.println(redisTemplate.opsForValue().get("ljx1"));

	}
	@RequestMapping("/show11")
	public void showRediStransation1(){
		stringRedisTemplate.opsForValue().set("test","1111");
		stringRedisTemplate.execute(new SessionCallback() {

			@Override
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.watch("test");//监控这个key
				operations.multi();//开启事务,将下面redis 的命令存入队列，下面并不会执行
				operations.opsForValue().set("test2","test2");
				operations.opsForValue().increment("test",1);
				return operations.exec();//执行事务中操作，如果监控的test 发生变化，则不执行事务
			}
		});

	}

}
