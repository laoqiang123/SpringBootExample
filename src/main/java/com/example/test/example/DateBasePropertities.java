package com.example.test.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class DateBasePropertities {
	private String dirverName;
	private String userName;

	public String getDirverName() {
		return dirverName;
	}
	
	public void setDirverName(String dirverName) {
		this.dirverName = dirverName;
		System.out.println(dirverName + "****");
	}

	public String getUserName() {
		return userName;
	} 
	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println(userName + "***");
	}

}
