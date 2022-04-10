package com.it.stratege;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxing
 * @className ObserveDateContext
 * @description 观察日上下文，策略模式计算入参封装类
 * @create 2022/4/10
 **/
@Data
public class ObserveDateContext {

    /**
     * 开始观察日
     */
    private Date startObserveDate;

    /**
     * 到期观察日
     */
    private Date maturityDate;

    /**
     * 观察日周期
     */
    private String observePeriod;
}
