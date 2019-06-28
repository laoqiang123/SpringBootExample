package com.example.test.dao;

import com.example.test.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserDao {
	 User getUserById(Long id);
	 int insertUser(User user);
	 int deleteUser(User user);
}
