package com.example.test.example;

public class UserVlidatorImpl implements UserValidator {

	@Override
	public boolean validate(String name) {
		// TODO Auto-generated method stub
		return "jjj".equals(name);
	}

}
