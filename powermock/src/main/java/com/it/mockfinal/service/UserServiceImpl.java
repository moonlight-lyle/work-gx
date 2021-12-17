package com.it.mockfinal.service;

import com.it.mock.pojo.User;
import com.it.mockfinal.dao.UserDao;

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
