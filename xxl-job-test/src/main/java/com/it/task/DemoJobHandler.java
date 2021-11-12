package com.it.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * 任务Handler示例（Bean模式）
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 * 5、任务执行结果枚举：SUCCESS、FAIL、FAIL_TIMEOUT
 */
@Component
public class DemoJobHandler extends IJobHandler {

    @XxlJob(value = "demoJobHandler")
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("=====hello world=====");
        return ReturnT.SUCCESS;
    }

}
