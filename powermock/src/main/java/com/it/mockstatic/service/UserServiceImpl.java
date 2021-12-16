package com.it.mockstatic.service;

import com.it.mock.pojo.User;
import com.it.mockstatic.dao.UserDao;

public class UserServiceImpl {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void save(User user) {
        UserDao.insertUser(user);
    }
}
