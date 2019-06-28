package com.example.test.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestSpringEl {
	@Value("#{T(System).currentTimeMillis()}")
    //#{} 是代表开启Spring 表达式，T 后面跟的是类名，java 默认加载的包，是不要写全限类名，其他的需要，后面的是静态方法
	//等同于		System.currentTimeMillis()
    private Long initTime;
	@Value("#{'jx'}")
	//这种可以给String(字符串需要加单引号)、float、double 直接赋值
	private String name;
	/*@Value("#{beanName.age}")
	//这种是根据bean的name ，将其某一个属性值赋值给当前Bean 的这个属性
	private int age;
	@Value("#{beanName.sex?.toUpperCase()}")
	//？ 是判断这个是否为空不为空，才执行下面的
	private String sex;
	@Value("#{beanName.num==7}")
	//数值比较用===
	private boolean num;
	@Value("#{beanName.s eq 'hello'}")
	//字符串的比较 用eq 表达式里面的字符串用单引号。
	private boolean flag;*/
	public Long getInitTime() {
		return initTime;
	}
	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}
	
	
	
}
