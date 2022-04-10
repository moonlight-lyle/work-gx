package com.it.stratege;

import org.springframework.stereotype.Component;

/**
 * @author liuxing
 * @className EveryMonthObserveCalculateStrategy
 * @description 观察模式为每季度的计算实现策略
 * @create 2022/4/10
 **/
@Component
public class EveryQuarterObserveCalculateStrategy extends AbstractObserveDateCalculateStrategy implements ObserveDateCalculateStrategy{

    public static final int MONTH_COUNT = 3;
    @Override
    public int getMonthPlusStep() {
        return MONTH_COUNT;
    }
}
