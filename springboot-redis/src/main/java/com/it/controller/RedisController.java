package com.it.controller;

import com.it.enums.FormNoTypeEnum;
import com.it.service.FormNoGenerateService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private FormNoGenerateService formNoGenerateService;

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/redis/set/{key}/{value}")
    public Object set(@PathVariable("key") String key,
                        @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key,value);
        return "success";
    }

    @RequestMapping("/redis/getOrderNo")
    public String generateOrderNo(){
        String orderNO = formNoGenerateService.generateFormNo(FormNoTypeEnum.YF_ORDER);
        System.out.println();
        return orderNO;
    }
}
