package com.it.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.it.mp.mapper.UserMapper;
import com.it.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.baomidou.mybatisplus.core.enums.SqlLike.LEFT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisPlusSpringBootTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = this.userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
        // 条件构造器
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(User::getName,"张三");
        List<User> userList = userMapper.selectList(lambdaQuery);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaQueryWrapper(){
        // 条件构造器
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        // 1.where name='张三'
//        lambdaQuery.eq(User::getName,"张三");

        // 2.姓曹，年龄=30，where name like '曹%' and age=30
//        lambdaQuery.likeRight(User::getName,"曹").eq(User::getAge,30);

        // 3.isNull、isNotNull
        // where age is null
//        lambdaQuery.isNull(User::getAge);

        // 4.in、notIn
//        List ageList=new ArrayList();
//        ageList.add(18);
//        ageList.add(20);
//        ageList.add(21);
//        lambdaQuery.in(User::getAge,ageList);
        List<User> users = userMapper.selectList(lambdaQuery);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
