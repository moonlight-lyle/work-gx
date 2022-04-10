package com.it.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liuxing
 * @className ObservePeriodEnum
 * @description 观察方式枚举类
 * @create 2022/4/10/010 10:31
 **/
public enum ObservePeriodEnum {

    MONTHLY("Monthly", "everyMonthObserveCalculateStrategy", "每月"),

    EVERY_TWO_MONTHS("Every_Tow_Months", "everyTwoMonthsObserveCalculateStrategy", "每2月"),

    QUARTERLY("Quarterly", "everyQuarterObserveCalculateStrategy", "每季度");

    private final String observePeriod;

    private final String calculateStrategyBean;

    private final String description;

    ObservePeriodEnum(String observePeriod, String calculateStrategyBean, String description) {
        this.calculateStrategyBean = calculateStrategyBean;
        this.observePeriod = observePeriod;
        this.description = description;
    }

    public String getCalculateStrategyBean() {
        return calculateStrategyBean;
    }

    public String getObservePeriod() {
        return observePeriod;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据观察方式获取计算观察日的策略Bean
     * @param observePeriod 观察方式
     * @return
     */
    public static String getCalculateStrategyBean(String observePeriod) {
        for (ObservePeriodEnum observePeriodEnum : ObservePeriodEnum.values()) {
            if (StringUtils.equals(observePeriodEnum.getObservePeriod(), observePeriod)) {
                return observePeriodEnum.getCalculateStrategyBean();
            }
        }
        return MONTHLY.getCalculateStrategyBean();
    }

    /**
     * 根据观察方式转换成对应的枚举类
     * @param observePeriod 观察方式
     * @return
     */
    public static ObservePeriodEnum of(String observePeriod) {
        for (ObservePeriodEnum observePeriodEnum : ObservePeriodEnum.values()) {
            return observePeriodEnum;
        }
        return MONTHLY;
    }
}
