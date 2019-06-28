package com.example.test.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean {
	private Interceptor interceptor;
	//得到一个代理对象
	//InvocationHandler 这个类里面是执行目标类方法
	public static Object getProxy(Object target,Interceptor interceptor) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) {
				// TODO Auto-generated method stub
				//这里是真正反射执行目标类的方法
				Invocation invocation = new Invocation(args, method, target);
				Object o = null;
				boolean exceptionFlag = false;
				interceptor.before();

					try {
						if(interceptor.userAround()) {
							//对目标执行的方法进行环绕增强
							o = interceptor.around(invocation);
						}else {
							o = method.invoke(target, args);
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						exceptionFlag = true;
						e.printStackTrace();
					}
			    interceptor.after();
			    if(exceptionFlag) {
			    	interceptor.afterThrowing();
			    }else {
			    	//返回增强只有在程序正常执行的情况下
			    	interceptor.afterReturning();
			    }
			    
				return o;
			}
		});
	}

}
