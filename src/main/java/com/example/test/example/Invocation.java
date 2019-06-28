package com.example.test.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
	private Object[] param;
	private Method method;
	private Object target;

	public Invocation(Object[] param, Method method, Object target) {
		super();
		this.param = param;
		this.method = method;
		this.target = target;
	}

	// 反射形式调用原来的方法
	public Object proceed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(target, param);
	}

	public Object[] getParam() {
		return param;
	}

	public void setParam(Object[] param) {
		this.param = param;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

}
