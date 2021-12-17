package com.it.construction;

/**
 * 演示Mock构造方法
 */
public class UserDao {

    private String username;

    private String password;

    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void insertUser() {
        throw new UnsupportedOperationException();
    }
}
