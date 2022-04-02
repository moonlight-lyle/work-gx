package com.it;

import java.util.Date;

public class ProductVo {

    private Date natureDate;

    private String businessType;

    private boolean isTradeDay;

    private String appointType;

    public Date getNatureDate() {
        return natureDate;
    }

    public void setNatureDate(Date natureDate) {
        this.natureDate = natureDate;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public boolean isTradeDay() {
        return isTradeDay;
    }

    public void setTradeDay(boolean tradeDay) {
        isTradeDay = tradeDay;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public ProductVo() {
    }

    public ProductVo(Date natureDate, String businessType, boolean isTradeDay, String appointType) {
        this.natureDate = natureDate;
        this.businessType = businessType;
        this.isTradeDay = isTradeDay;
        this.appointType = appointType;
    }
}
