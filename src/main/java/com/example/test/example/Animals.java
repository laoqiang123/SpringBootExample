package com.example.test.example;

import org.springframework.stereotype.Component;

@Component("animals")
public class Animals {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
