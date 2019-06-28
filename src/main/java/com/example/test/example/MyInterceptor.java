package com.example.test.example;

import java.lang.reflect.InvocationTargetException;

import org.aopalliance.intercept.Invocation;
import org.springframework.jmx.access.InvalidInvocationException;

public class MyInterceptor implements Interceptor {

	@Override
	public void before() {
		// TODO Auto-generated method stub
		System.out.println("this is before");
	}

	

	@Override
	public void after() {
		// TODO Auto-generated method stub
		System.out.println("this is after");
	}

	@Override
	public void afterReturning() {
		// TODO Auto-generated method stub
		System.out.println("this is afterreturing");
	}

	@Override
	public void afterThrowing() {
		// TODO Auto-generated method stub
		System.out.println("this is afterthrowing");
	}

	@Override
	public boolean userAround() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object around(com.example.test.example.Invocation invocation) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		System.out.println("this is around");
		Object o  = invocation.proceed();
		return o;
	}

}
