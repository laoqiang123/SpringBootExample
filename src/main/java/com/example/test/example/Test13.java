package com.example.test.example;

import org.springframework.stereotype.Component;

@Component
public class Test13 {
	private int age =13;
	public Test13() {
		System.out.println("test test13");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
