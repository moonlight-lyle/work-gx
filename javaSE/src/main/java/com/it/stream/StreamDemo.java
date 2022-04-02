package com.it.stream;


import com.it.pojo.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // filter使用
        List<String> list=new ArrayList<String>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("王杰");
        list.add("林俊杰");
        // 筛选出包含"王"的数据
//        Stream<String> stream = list.stream().filter(item -> item.contains("王"));
//        stream.forEach(System.out::println);
//
//        // 统计包含"王"的数据的个数
//        long count = list.stream().filter(item -> item.contains("王")).count();
//        System.out.println(count);

        // 去重
//        list.add("周杰伦");
//        list.add("王力宏");
//        Stream<String> stream = list.stream().distinct();
//        stream.forEach(System.out::println);

        // 集合收集器
        List<User> userList=new ArrayList<>();
        User user1=new User(18,"张三","湖北");
        User user2=new User(20,"张铁",null);
        User user3=new User(21,"李四","湖南");
        User user4=new User(25,"李静","广西");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        // 收集年龄大于20的用户
//        List<User> users = userList.stream().filter(item -> item.getAge() > 20).collect(Collectors.toList());
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<String> stringList = userList.stream().map(item -> item.getAge() + item.getName()).collect(Collectors.toList());
//        for (String s : stringList) {
//            System.out.println(s);
//        }

        List<User> collect = userList.stream().filter(item -> StringUtils.isNotEmpty(item.getAddress())).collect(Collectors.toList());
        for (User user : collect) {
            System.out.println(user);
        }

    }
}
