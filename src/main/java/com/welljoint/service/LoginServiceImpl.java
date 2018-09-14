package com.welljoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welljoint.dao.UserDao;

@Service
public class LoginServiceImpl implements LoginService{
//    public int login(String userName,String password){
//        return 1;
//    }
    @Autowired
    private UserDao userDao;

    public int login(String userName,String password){
        return userDao.find(userName, password)==null ? 0:1;
    }
}
