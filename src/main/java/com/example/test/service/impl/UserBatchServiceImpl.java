package com.example.test.service.impl;

import com.example.test.dao.UserDao;
import com.example.test.pojo.User;
import com.example.test.service.UserBatchService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBatchServiceImpl implements UserBatchService {
	@Autowired
	private UserService userService;


	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.NESTED)
	public int insertUsers(List<User> users)  {
		int result = 0;
		for(int i =0;i<users.size();i++){
			if(i==0){
				User user = new User();
				user.setId(68);
				userService.deleteUser(user);
			}
			try {
				result+=userService.insertUser(users.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}    
}
