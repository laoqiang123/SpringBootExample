/*package com.example.test.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("user")
public class User implements BeanNameAware,BeanPostProcessor, BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean {
	@Value("laoqiang")
	private String name;
	@Value("111")
	private Integer age;
	private Animals animals;
	
	

	public Animals getAnimals() {
		return animals;
	}
    @Autowired
    @Qualifier("animals")
	public void setAnimals(Animals animals) {
		this.animals = animals;
	}

	public String getName() {
		return name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("User.destroy()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("User.afterPropertiesSet()");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("User.setApplicationContext()");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("User.setBeanFactory()");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("User.setBeanName()");
		
	}
	@PostConstruct
	public void init() {
		System.out.println("this is my custom User.init()");
	}
	@PreDestroy
	public void destory() {
		System.out.println(" this is my custom  User.destory()");
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("User.postProcessBeforeInitialization()");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("User.postProcessAfterInitialization()");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	

}
*/