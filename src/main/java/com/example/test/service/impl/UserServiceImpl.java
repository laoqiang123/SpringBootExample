package com.example.test.service.impl;

import com.example.test.dao.UserDao;
import com.example.test.pojo.User;
import com.example.test.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    //将插入的user 缓存
    public int insertUser(User user) throws Exception {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public int insertUsers(List<User> users) {
        UserService userService = applicationContext.getBean(UserService.class);
        for (int i = 0; i < users.size(); i++) {
            try {
                userService.insertUser(users.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    //取参数id的user
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    @CacheEvict(value = "redisCache", key = "'redis_user_'+#id", beforeInvocation = false)
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName, note);
    }

    @Override
    @CachePut(value = "redisCache", condition = "#result!='null'", key = "'redis_user_'+#id")
    //如果该方法执行的为null，则不缓存
    public User updateUser(Integer id, String userName) {
        //此处getUserById方法,不会走缓存
        //执行sql，将查询数据库最新数据
        User user = this.getUserById(id);
        if (user == null) {
            return null;
        }
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}