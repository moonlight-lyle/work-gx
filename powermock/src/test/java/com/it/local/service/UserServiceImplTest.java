package com.it.local.service;

import com.it.local.dao.UserDao;
import com.it.mock.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * 局部变量测试：
 * 此处UserServiceImpl中UserDao属于局部变量
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class})
public class UserServiceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUserCount() {
        try {
            UserServiceImpl userService = new UserServiceImpl();
            // 将UserDao Mock进来
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int result = userService.queryUserCount();
            assertEquals(10, result);
        } catch (Throwable e) {
            fail();
        }

    }

    @Test
    public void save() {

        try {
            User user = new User();
            UserServiceImpl userService = new UserServiceImpl();
            // 将UserDao Mock进来
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);

            userService.save(user);
            // 验证调用userDao中插入方法一次
            Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
        } catch (Throwable e) {
            fail();
        }
    }
}