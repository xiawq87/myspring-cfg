package com.xwq.dao.impl;

import com.xwq.dao.UserDao;
import com.xwq.entity.User;

public class UserDaoImpl implements UserDao {
    public User getUser(Long userId) {
        User user = new User();
        user.setUserId(2L);
        user.setUsername("zhangsan2");
        user.setPassword("1234");
        return user;
    }
}
