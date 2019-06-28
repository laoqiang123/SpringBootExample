package com.example.test.service;

import com.example.test.pojo.User;

import java.util.List;

public interface UserBatchService {
	int insertUsers(List<User> users) throws Exception;

}
