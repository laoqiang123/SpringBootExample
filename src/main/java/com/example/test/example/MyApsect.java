package com.example.test.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

//申明这是一个切面
@Aspect
@Order(1)
public class MyApsect {
	//@DeclareParents 这个注解是用来引入新的类来增强目标类的，这里增强的是HelloServiceImpl
	//value 设置增强的目标类
	//defaultImpl 是增强类的实现类
	@DeclareParents(value="com.example.test.service.impl.HelloServiceImpl",defaultImpl=UserVlidatorImpl.class)
	private UserValidator userValidator;
	//定义一个切点，里面的表达式会按照一定的规格去匹配连接点，在下面的方法上直接引用切点即可
	//在切点表达式中,* 代表任意的返回值  (..)代表任意的参数
	@Pointcut("execution(* com.example.test.service.impl.HelloServiceImpl.sayName(..))")
	public void pointCut() {
		
	}
	//前置增强
	@Before("pointCut() && args(name)")
    public void before(JoinPoint point,String name) {
		System.out.println(point.getArgs().toString());
    	System.out.println("this is before1");
    }
	//后置增强
	@After("pointCut()")
	public void after() {
		System.out.println("this is after1");
	}
	//返回增强
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("this is afterreturning1");
	}
	//异常增强
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("this is afterthrowing1");
	}
	@Around("pointCut()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("this is around before");
		proceedingJoinPoint.proceed();
		System.out.println("this is around after");
	}
	
	//这几个方法就是AOP  中定义约定流程的方法,无论是否发生异常，都会执行after，如果发生异常。afterretrning，就不会执行，这都是约定好的。
}
