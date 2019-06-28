package com.example.test.service.impl;

import com.example.test.dao.UserDao;
import com.example.test.pojo.User;
import com.example.test.service.TestService;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private UserDao userDao;
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,timeout = 5)
	public User findUserById(Long id) {
		return userDao.getUserById(id);
	}
}
