package com.example.test.service;

import com.example.test.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
	int insertUser(User user) throws Exception;
	int deleteUser(User user);
	int insertUsers(List<User> users) throws Exception;
	User getUserById(Integer id);
	int deleteUser(Integer id);
	List<User> findUsers(String userName,String note);
	User updateUser(Integer id,String userName);


}
