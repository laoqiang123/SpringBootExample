package com.example.test.example;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ShowCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		Environment environment =  context.getEnvironment();
		if(environment.getProperty("ljx1")!=null) {
			System.out.println("执行到了");
			return true;
		}
		
		return false;
	}

}
