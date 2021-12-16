package com.it.local.service;

import com.it.local.dao.UserDao;
import com.it.mock.pojo.User;

public class UserServiceImpl {


    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void save(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
