package com.it.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.it.util.ObserveDateCalculateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author liuxing
 * @className TestController
 * @description 请求测试
 * @create 2022/4/10/010 10:53
 **/
@RestController
@RequestMapping("/api/design")
public class TestController {

    @Resource
    private ObserveDateCalculateUtils observeDateCalculateUtils;

    @GetMapping("/strategy")
    public String getDates() {
        LocalDate startDate = LocalDate.of(2022, 4, 11);
        LocalDate maturityDate = LocalDate.of(2023, 12, 31);
        String observePeriod = "Every_Tow_Months";
        List<Date> dates = observeDateCalculateUtils.getDates(localDateToDate(startDate), localDateToDate(maturityDate), observePeriod);
        if (CollectionUtil.isNotEmpty(dates)) {
            for (Date date : dates) {
                System.out.println(DateUtil.format(date, "yyyy-MM-dd"));
            }
        }
        return "SUCCESS";
    }

    /**
     * LocalDate转换成Date
     * @param localDate
     * @return
     */
    private Date localDateToDate(LocalDate localDate) {
        if(null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }
}
