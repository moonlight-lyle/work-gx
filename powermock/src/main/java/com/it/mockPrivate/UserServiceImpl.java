package com.it.mockPrivate;

/**
 * Mock私有方法
 */
public class UserServiceImpl {

    public void foo() {
        log();
    }

    private void log() {
        System.out.println("I am console log.");
    }

    public boolean exist(String username) {
        return checkExist(username);
    }

    private boolean checkExist(String username) {
        throw new UnsupportedOperationException();
    }
}
