package com.example.test.example;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.test.service.HelloService;
import com.example.test.service.impl.HelloServiceImpl;

public class TestApplication {
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(MyApplicationConfig.class);
		// Test1 t1 = (Test1) context.getBean("test1");
		// Test1 t2 = (Test1) context.getBean("test1");
		// System.out.println(t1==t2);
		// DataSource dataSource = (DataSource) context.getBean("datasources");
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("springbeans.xml");
		HelloService helloService = new HelloServiceImpl();
		//拦截器实现上用来进行方法的增强的
		Interceptor interceptor = new MyInterceptor();
		HelloService helloServiceProxy = (HelloService) ProxyBean.getProxy(helloService, interceptor);
		try {
			helloServiceProxy.sayName("jjj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
