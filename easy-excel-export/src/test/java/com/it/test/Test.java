package com.it.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("20211115");
        list.add("20220115");
        list.add("20211215");
        list.add("20230311");
        list.add("20240215");
        list.add("20120323");
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }
        String str = null;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);
    }
}
