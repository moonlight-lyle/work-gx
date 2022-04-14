package com.it.pojo;

import lombok.Data;

/**
 * @author liuxing
 * @className AdmittedCustomerMqVO
 * @description 消息对象
 * @create 2022/4/14/014 21:16
 **/
@Data
public class AdmittedCustomerMqVO {

    private Long admittedCustomerId;

    private String customerName;

    private String customerCode;
}
