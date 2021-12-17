package com.it.mockPrivate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;

/**
 * Mock私有方法
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class})
public class UserServiceImplTest {

    @Test
    public void foo() throws Exception {
        UserServiceImpl userService = PowerMockito.spy(new UserServiceImpl());
        userService.foo();
    }

    @Test
    public void testCheck() throws Exception {
        UserServiceImpl userService = PowerMockito.spy(new UserServiceImpl());

        PowerMockito.doReturn(true).when(userService, "checkExist", "alex");

        assertTrue(userService.exist("alex"));

        // 走真正的逻辑，抛异常throw new UnsupportedOperationException();
        userService.exist("other");
    }
}