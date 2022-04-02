package com.it.service.impl;

import com.it.constants.FormNoConstants;
import com.it.enums.FormNoTypeEnum;
import com.it.service.FormNoGenerateService;
import com.it.utils.FormNoSerialUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 单号生成接口实现
 *
 * @author mengqiang
 * @version FormNoGenerateServiceImpl.java, v 1.0 2019-01-01 18:10
 */
@Service
public class FormNoGenerateServiceImpl implements FormNoGenerateService {
    /**
     * redis 服务
     * demo 项目没有加redis相关，若有需要请参考，redis的博客
     */
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 根据单据编号类型 生成单据编号
     *
     * @param formNoTypeEnum 单据编号类型
     * @author kongwc
     * @date 2019/1/1
     */
    @Override
    public String generateFormNo(FormNoTypeEnum formNoTypeEnum) {
        //获得单号前缀
        //格式 固定前缀 +时间前缀 示例 ：YF20190101
        String formNoPrefix = FormNoSerialUtil.getFormNoPrefix(formNoTypeEnum);
        //获得缓存key
        String cacheKey = FormNoSerialUtil.getCacheKey(formNoPrefix);
        //获得当日自增数
        Long incrementalSerial = redisTemplate.opsForValue().increment(cacheKey);
        //设置失效时间 7天
        redisTemplate.expire(cacheKey, FormNoConstants.DEFAULT_CACHE_DAYS, TimeUnit.DAYS);
        //组合单号并补全流水号
        String serialWithPrefix = FormNoSerialUtil
                .completionSerial(formNoPrefix, incrementalSerial, formNoTypeEnum);
        //补全随机数
        return FormNoSerialUtil.completionRandom(serialWithPrefix, formNoTypeEnum);
    }


}
