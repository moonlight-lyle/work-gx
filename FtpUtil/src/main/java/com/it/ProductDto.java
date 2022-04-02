package com.it;

import java.util.Date;

public class ProductDto {

    private Date natureDate;

    private String keyP;

    private boolean isTradeDay;

    private String opration;

    public Date getNatureDate() {
        return natureDate;
    }

    public void setNatureDate(Date natureDate) {
        this.natureDate = natureDate;
    }

    public boolean isTradeDay() {
        return isTradeDay;
    }

    public void setTradeDay(boolean tradeDay) {
        isTradeDay = tradeDay;
    }

    public String getKeyP() {
        return keyP;
    }

    public void setKeyP(String keyP) {
        this.keyP = keyP;
    }

    public String getOpration() {
        return opration;
    }

    public void setOpration(String opration) {
        this.opration = opration;
    }

    public ProductDto() {
    }

    public ProductDto(Date natureDate, String keyP, boolean isTradeDay, String opration) {
        this.natureDate = natureDate;
        this.keyP = keyP;
        this.isTradeDay = isTradeDay;
        this.opration = opration;
    }
}
