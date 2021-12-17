package com.it.construction;

public class UserServiceImpl {

    public void save(String username, String password) {
        UserDao userDao = new UserDao(username, password);
        userDao.insertUser();

    }
}
