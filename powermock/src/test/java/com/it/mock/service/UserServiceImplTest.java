package com.it.mock.service;

import com.it.mock.dao.UserDao;
import com.it.mock.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl(new UserDao());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Ignore
    @Test
    public void queryUserCountWIthJuint() {
        try {
            int count = userService.queryUserCount();
            fail("should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Ignore
    @Test
    public void saveWIthJuint() {
        try {
            userService.save(new User());
            fail("should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    /**
     * **************** Mock方式 *****************************************************
     */

    @Mock
    private UserDao userDao;

    @Ignore
    @Test
    public void queryUserCountWIthMock() {
        MockitoAnnotations.initMocks(this);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);

        int count = userService.queryUserCount();
        assertEquals(10, count);
    }

    /**
     * **************** PowerMock方式 *****************************************************
     */

    @Test
    public void queryUserCountWIthPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        UserServiceImpl userService = new UserServiceImpl(uDao);
        // 有返回值方法mock
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void testSaveUserWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        User user = new User();
        // 无返回值方法执行mock
        PowerMockito.doNothing().when(uDao).insertUser(user);
        UserServiceImpl userService = new UserServiceImpl(uDao);
        userService.save(user);
        // 断言是否有调用UserDao中的insertUser()方法
        Mockito.verify(uDao).insertUser(user);
    }
}