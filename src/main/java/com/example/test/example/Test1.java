package com.example.test.example;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

import javax.annotation.PostConstruct;

@Component("test1")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Test1 {
	private String name;
	private int age;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
    @RequestMapping(method ={RequestMethod.GET,RequestMethod.DELETE})
	public void setAge(int age) {
		this.age = age;
	}
	@PostConstruct
	public void show(){
		System.out.println("test1 show");

	}

}
