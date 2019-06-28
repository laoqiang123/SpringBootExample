package com.example.test.service.impl;

import com.example.test.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayName(String name) throws Exception {
		// TODO Auto-generated method stub
		if("jjj".equals(name)) {
			throw new Exception("parameter is error");
		}
		System.out.println(name);
		
	}

}
