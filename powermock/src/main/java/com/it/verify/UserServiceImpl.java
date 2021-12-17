package com.it.verify;

import com.it.mock.pojo.User;

/**
 * verify相关
 */
public class UserServiceImpl {

    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }

    }
}
