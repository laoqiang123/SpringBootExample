package com.example.test.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Test6 {
	public static  void show(String name) throws Exception {
		if(name.equals("ppp")){
			throw new Exception("heloo");
		}
		System.out.println("GO");
	}

	@PostConstruct
	public void show(){
		System.out.println("test6 show");
	}
}
