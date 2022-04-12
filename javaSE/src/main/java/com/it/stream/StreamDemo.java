package com.it.stream;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.it.enumeration.LegTypeEnum;
import com.it.pojo.ProductDto;
import com.it.pojo.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // filter使用
//        List<String> list=new ArrayList<String>();
//        list.add("周杰伦");
//        list.add("王力宏");
//        list.add("王杰");
//        list.add("林俊杰");
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
//        List<User> userList=new ArrayList<>();
//        User user1=new User(18,"张三","湖北");
//        User user2=new User(20,"张铁",null);
//        User user3=new User(21,"李四","湖南");
//        User user4=new User(25,"李静","广西");
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//        userList.add(user4);
        // 收集年龄大于20的用户
//        List<User> users = userList.stream().filter(item -> item.getAge() > 20).collect(Collectors.toList());
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<String> stringList = userList.stream().map(item -> item.getAge() + item.getName()).collect(Collectors.toList());
//        for (String s : stringList) {
//            System.out.println(s);
//        }

//        List<User> collect = userList.stream().filter(item -> StringUtils.isNotEmpty(item.getAddress())).collect(Collectors.toList());
//        for (User user : collect) {
//            System.out.println(user);
//        }

//        ArrayList<User> users = new ArrayList<>();
//        User user1=new User(18,"张三","湖北");
//        User user2=new User(20,"张铁",null);
//        User user3=new User(21,"李四","湖南");
//        User user4=new User(25,"李静","广西");
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        users.removeIf(user -> (user.getAge() > 18));
//        System.out.println(JSONArray.toJSONString(users));

//        System.out.println(LegTypeEnum.AUTOCALL.getCode());

        // 根据对象的某个属性排序
        List<ProductDto> list = new ArrayList<>();
        ProductDto productDto1 = new ProductDto();
        productDto1.setKeyP("11");
        productDto1.setNatureDate(DateUtil.parseDate("2022-05-23"));
        list.add(productDto1);

        ProductDto productDto2 = new ProductDto();
        productDto2.setKeyP("22");
        productDto2.setNatureDate(DateUtil.parseDate("2022-04-23"));
        list.add(productDto2);

        ProductDto productDto3 = new ProductDto();
        productDto3.setKeyP("33");
        productDto3.setNatureDate(DateUtil.parseDate("2022-12-23"));
        list.add(productDto3);

        ProductDto productDto4 = new ProductDto();
        productDto4.setKeyP("44");
        productDto4.setNatureDate(DateUtil.parseDate("2022-08-23"));
        list.add(productDto4);

        // 排序
        List<ProductDto> collect = list.stream().sorted(Comparator.comparing(ProductDto::getNatureDate)).collect(Collectors.toList());
        for (ProductDto productDto : collect) {
            System.out.println(productDto.getKeyP()+":"+productDto.getNatureDate());
        }


    }
}
