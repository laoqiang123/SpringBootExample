package com.example.test.service.impl;

import com.example.test.dao.UserDao;
import com.example.test.pojo.User;
import com.example.test.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {
	private ApplicationContext applicationContext;



	@Autowired
	private UserDao userDao;
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
	public int insertUser(User user) throws Exception {
		if("ppp".equals(user.getUserName())){
			throw  new RuntimeException("ggg");
		}
		return userDao.insertUser(user);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
	public int deleteUser(User user) {
		return userDao.deleteUser(user);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
	public int insertUsers(List<User> users) {
		UserService userService = applicationContext.getBean(UserService.class);
		for(int i=0;i<users.size();i++){
			try {
				userService.insertUser(users.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        return 0;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext =applicationContext;
	}
}
