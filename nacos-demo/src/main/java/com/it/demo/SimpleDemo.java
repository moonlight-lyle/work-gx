package com.it.demo;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @author liuxing
 * @className SimpleDemo
 * @description nacos配置获取测试
 * @create 2022/4/10/010 19:49
 **/
public class SimpleDemo {

    public static void main(String[] args) throws NacosException {
        // nacos 地址         
        String serverAddr = "127.0.0.1:8848";
        // Data Id         
        String dataId = "nacos_simple_demo";
        // Group         
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        //  //获取配置,String dataId, String group, long timeoutMs        
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
    }
}
