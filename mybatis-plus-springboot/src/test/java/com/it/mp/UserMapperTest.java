package com.it.mp;

import com.it.mp.mapper.UserMapper;
import com.it.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setEmail("2@itcast.cn");
        user.setAge(301);
        user.setUserName("caocao1");
        user.setName("曹操1");
        user.setPassword("123456");

        int result = this.userMapper.insert(user); //result数据库受影响的行数
        System.out.println("result => " + result);

        //获取自增长后的id值, 自增长后的id值会回填到user对象中
        System.out.println("id => " + user.getId());
    }
}
