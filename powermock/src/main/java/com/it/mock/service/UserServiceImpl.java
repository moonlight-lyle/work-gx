package com.it.mock.service;

import com.it.mock.dao.UserDao;
import com.it.mock.pojo.User;

public class UserServiceImpl {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void save(User user) {
        userDao.insertUser(user);
    }
}
