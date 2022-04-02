package com.it.baseApi;

import java.time.LocalDate;

public class LocalDateDemo1 {
    public static void main(String[] args) {
        // 1.获取当前日期:yyyy-MM-dd
//        LocalDate now = LocalDate.now();
//        System.out.println(now);

        // 2.设置日期参数:参数1：年份，参数2：月份，参数3：日期，输出格式：yyyy-MM-dd
//        LocalDate date = LocalDate.of(2022, 2, 28);
//        System.out.println(date);

        // 3.获取指定日期是所在月的第几天
//        LocalDate localDate = LocalDate.of(2022, 2, 28);
//        System.out.println(localDate.getDayOfMonth());
        // 4.获取指定日期是星期几:eg:MONDAY
//        System.out.println(localDate.getDayOfWeek());
        // 5.获取指定日期是所在年的第几天
//        System.out.println(localDate.getDayOfYear());

        // 6.获取当前日期所在月份:eg:FEBRUARY
//        System.out.println(localDate.getMonth());

        // 7.获取当前日期所在月份的数子值:2
//        System.out.println(localDate.getMonthValue());
        // 8.获取当前日期所在月份共有多少天
//        System.out.println(localDate.lengthOfMonth());

        // 9.获取当前日期所在年共有多少天：365
//        System.out.println(localDate.lengthOfYear());

        // 10.获取当前日期所在年是否是闰年:false
//        System.out.println(localDate.isLeapYear());

        // with开头的方法
        // 替换上述日期中的日：2022-02-28--->2022-02-03
//        System.out.println(localDate.withDayOfMonth(3));

        // 替换上述日期中所在年份第多少天到指定值：例如：2022-02-28是2022年第59天，替换为第60天就是2022-03-01
//        System.out.println(localDate.withDayOfYear(60));

        // 替换上述日期中的月份值：2022-02-28---->2022-03-28
//        System.out.println(localDate.withMonth(3));

        // 替换上述日期中的年份
//        System.out.println(localDate.withYear(2021));


        // 日期的加减法
        LocalDate localDate = LocalDate.of(2022, 2, 28);

        // 上述日期减一天
//        System.out.println(localDate.minusDays(1));
        // 上述日期减1周
//        System.out.println(localDate.minusWeeks(1));
        // 上述日期减1月
//        System.out.println(localDate.minusMonths(1));
        // 上述日期减1年
//        System.out.println(localDate.minusYears(1));

        // 上述日期加1天
//        System.out.println(localDate.plusDays(1));
        // 加1周
//        System.out.println(localDate.plusWeeks(1));
        // 加1月
//        System.out.println(localDate.plusMonths(1));
        // 加1年
        System.out.println(localDate.plusYears(1));
    }
}
