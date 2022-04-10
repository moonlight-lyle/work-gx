package com.it.stratege;

import cn.hutool.core.collection.CollectionUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author liuxing
 * @className AbstractObserveDateCalculateStrategy
 * @description 策略模式抽象类，实现策略接口，可用于存放每个策略实现的公共方法
 * @create 2022/4/10
 **/
public abstract class AbstractObserveDateCalculateStrategy implements ObserveDateCalculateStrategy{

    /**
     * 获取观察日每次增加的月数：
     *    每月观察策略：每次增加1月；
     *    每2月观察策略：每次增加2月；
     *    每季度观察策略：每次增加3月
     * @return
     */
    public abstract int getMonthPlusStep();

    /*
     * @Author Lyle
     * @Description 观察日计算方法
     * @Date 10:08 2022/4/10
     * @Param [observeDateContext]
     * @return java.util.List<java.util.Date>
     **/
    @Override
    public List<Date> getDates(ObserveDateContext observeDateContext) {
        List<Date> dates = new ArrayList<>();

        LocalDate startDate = dateToLocalDate(observeDateContext.getStartObserveDate());
        LocalDate maturityDate = dateToLocalDate(observeDateContext.getMaturityDate());

        LocalDate nextDay = startDate;
        while (nextDay.isBefore(maturityDate)) {
            dates.add(localDateToDate(nextDay));
            nextDay = nextDay.plusMonths(getMonthPlusStep());
        }
        Date maturityDay = observeDateContext.getMaturityDate();
        if (!CollectionUtil.contains(dates,  maturityDay)) {
            dates.add(maturityDay);
        }
        return dates;
    }

    /**
     * 将 Date 转为 LocalDate
     *
     * @param date
     * @return java.time.LocalDate;
     */
    private LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
