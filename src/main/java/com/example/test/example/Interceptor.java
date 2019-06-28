package com.example.test.example;

import java.lang.reflect.InvocationTargetException;

import org.springframework.jmx.access.InvalidInvocationException;
//提供一些增强的方法
public interface Interceptor {
   public void before();
   public Object around(Invocation invocation) throws  IllegalAccessException, IllegalArgumentException, InvocationTargetException ;
   public void after();
   public void afterReturning();
   public void afterThrowing();
   public boolean userAround();
   
   
}
