package com.it.mockfinal.service;

import com.it.mockfinal.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * final类的Mock
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class, UserDao.class})
public class UserServiceImplTest {

//    @Mock
//    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Ignore
//    @Test
//    public void queryUserCountWithMockito() {
//        MockitoAnnotations.initMocks(this);
//        UserServiceImpl userService=new UserServiceImpl(userDao);
//        Mockito.when(userDao.getCount()).thenReturn(10);
//        int result = userService.queryUserCount();
//        assertEquals(10,result);
//    }

    @Test
    public void queryUserCountWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserServiceImpl userService = new UserServiceImpl(uDao);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void save() {
    }
}