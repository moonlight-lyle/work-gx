package com.it.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * 枚举类
 */
public enum LegTypeEnum {

    VANILLA("Vanilla", "香草类"),

    AUTOCALL("AutoCall", "雪球类"),

    DIGITAL("Dagital", "二元类"),

    RANGEACCRUAL("RangeAccrual", "区间累计类"),

    BARRIER("Barrier", "单障碍类");

    private final String code;

    private final String message;


    LegTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static LegTypeEnum of(String code) {
        for (LegTypeEnum legTypeEnum : LegTypeEnum.values()) {
            if (StringUtils.equals(legTypeEnum.code, code)) {
                return legTypeEnum;
            }
        }
        return null;
    }
}
