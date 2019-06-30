package com.example.test.dao;

import com.example.test.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao {
	 User getUserById(Long id);
	 int insertUser(User user);
	 int deleteUser(User user);
	 User getUser(Long id);
	 int deleteUser(Long id);
	 //如果传的不是一个对象，是多个参数，可以采用@param 去指定参数对象值和数据库字段的对应
	 List<User> findUsers(@Param(("userName")) String userName, @Param(("note")) String note);
	 int updateUser(User user);


}
