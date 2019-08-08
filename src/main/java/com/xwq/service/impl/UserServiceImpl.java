package com.xwq.service.impl;

import com.xwq.dao.UserDao;
import com.xwq.entity.User;
import com.xwq.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public User getUser(Long userId) {
        System.out.println("UserServiceImpl.getUser -- userId: " + userId);
        return userDao.getUser(userId);
    }
}
