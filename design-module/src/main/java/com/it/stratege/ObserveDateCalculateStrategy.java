package com.it.stratege;

import java.util.Date;
import java.util.List;

/**
 * @author liuxing
 * @className ObserveDateCalculateStrategy
 * @description 观察日计算策略接口
 * @create 2022/4/10
 **/
public interface ObserveDateCalculateStrategy {

    List<Date> getDates(ObserveDateContext observeDateContext);
}
