package com.it.verify;

import com.it.mock.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class})
public class UserServiceImplTest {

    @Test
    public void saveOrUpdateWillUseSave() throws Exception {
        User user = PowerMockito.mock(User.class);
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(0);

        UserServiceImpl userService = new UserServiceImpl();
        userService.saveOrUpdate(user);

        // 验证调用insert（）而不调用update()
        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao, Mockito.never()).updateUser(user);
    }

    @Test
    public void saveOrUpdateWillUseUpdate() throws Exception {
        User user = PowerMockito.mock(User.class);
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(1);

        UserServiceImpl userService = new UserServiceImpl();
        userService.saveOrUpdate(user);

        // 验证不调用insert（）而调用update()
        Mockito.verify(userDao, Mockito.never()).insertUser(user);
        Mockito.verify(userDao).updateUser(user);
    }
}