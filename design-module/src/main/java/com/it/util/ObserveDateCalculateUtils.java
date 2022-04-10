package com.it.util;

import com.it.enumeration.ObservePeriodEnum;
import com.it.stratege.ObserveDateCalculateStrategy;
import com.it.stratege.ObserveDateContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author liuxing
 * @className ObserveDateCalculateUtils
 * @description 获取观察日计算工具封装
 * @create 2022/4/10/010 10:31
 **/
@Component
public class ObserveDateCalculateUtils {

    @Resource
    private ApplicationContext applicationContext;

    public List<Date> getDates(Date startObserveDate, Date maturityDate, String observePeriod) {
        ObserveDateContext observeDateContext = new ObserveDateContext();
        observeDateContext.setStartObserveDate(startObserveDate);
        observeDateContext.setMaturityDate(maturityDate);
        observeDateContext.setObservePeriod(observePeriod);
        // 获取计算的策略Bean
        ObserveDateCalculateStrategy calculateStrategyBean = applicationContext.getBean(
                ObservePeriodEnum.getCalculateStrategyBean(observePeriod), ObserveDateCalculateStrategy.class);
        return calculateStrategyBean.getDates(observeDateContext);
    }
}
