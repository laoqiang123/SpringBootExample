package com.example.test.service;

import com.example.test.dao.UserDao;
import com.example.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.TestDao;
public interface TestService {
   User findUserById(Long id);



}
