package com.it.mockstatic.service;

import com.it.mock.pojo.User;
import com.it.mockstatic.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class, UserDao.class})
public class UserServiceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUserCount() {
        // 将静态类Mock进来
        PowerMockito.mockStatic(UserDao.class);
        // 执行静态方法
        PowerMockito.when(UserDao.getCount()).thenReturn(10);

        UserServiceImpl userService = new UserServiceImpl();
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void save() {
        // 将静态类Mock进来
        PowerMockito.mockStatic(UserDao.class);

        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);

        UserServiceImpl userService = new UserServiceImpl();
        userService.save(user);
        // 验证静态方法是否调用
        PowerMockito.verifyStatic();
    }
}