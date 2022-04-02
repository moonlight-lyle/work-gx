package com.it.enums;

import com.it.constants.FormNoConstants;

/**
 * 单号生成类型枚举
 *
 * @author mq
 * 注：随机号位于流水号之后,流水号使用redis计数据，每天都是一个新的key,长度不足时则自动补0
 * <p>
 * 生成规则 =固定前缀+当天日期串+流水号(redis自增，不足长度则补0)+随机数
 */
public enum FormNoTypeEnum {

    /**
     * 应付单单号：
     * 固定前缀：YF
     * 时间格式：yyyyMMdd
     * 流水号长度：7(当单日单据较多时可根据业务适当增加流水号长度)
     * 随机数长度：3
     * 总长度：20
     */
    YF_ORDER("YF", FormNoConstants.SERIAL_YYMMDD_PREFIX, 7, 3, 20),

    /**
     * 付款单单号：
     * 固定前缀：FK
     * 时间格式：yyyyMMdd
     * 流水号长度：7
     * 随机数长度：3
     * 总长度：20
     */
    FK_ORDER("FK", FormNoConstants.SERIAL_YYYYMMDD_PREFIX, 7, 3, 20),

    /**
     * 测试单单号：
     * 固定前缀：""
     * 时间格式：yyyyMMdd
     * 流水号长度：10
     * 随机数长度：0
     * 总长度：20
     */
    TEST_ORDER("te", FormNoConstants.SERIAL_YYYYMMDD_PREFIX, 10, 0, 20),
    ;

    /**
     * 单号前缀
     * 为空时填""
     */
    private String prefix;

    /**
     * 时间格式表达式
     * 例如：yyyyMMdd
     */
    private String datePattern;

    /**
     * 流水号长度
     */
    private Integer serialLength;
    /**
     * 随机数长度
     */
    private Integer randomLength;

    /**
     * 总长度
     */
    private Integer totalLength;


    FormNoTypeEnum(String prefix, String datePattern, Integer serialLength, Integer randomLength, Integer totalLength) {
        this.prefix = prefix;
        this.datePattern = datePattern;
        this.serialLength = serialLength;
        this.randomLength = randomLength;
        this.totalLength = totalLength;
    }
    //省略 get 方法

    public String getPrefix() {
        return prefix;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public Integer getSerialLength() {
        return serialLength;
    }

    public Integer getRandomLength() {
        return randomLength;
    }

    public Integer getTotalLength() {
        return totalLength;
    }
}