package com.it.construction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * 演示Mock构造方法
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class})
public class UserServiceImplTest {

    @Test
    public void save() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        String username = "NB";
        String password = "123456";
        PowerMockito.whenNew(UserDao.class).withArguments(username, password).thenReturn(userDao);

        PowerMockito.doNothing().when(userDao).insertUser();

        UserServiceImpl userService = new UserServiceImpl();
        userService.save(username, password);

        Mockito.verify(userDao).insertUser();
    }
}