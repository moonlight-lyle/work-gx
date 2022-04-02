package com.it;

public class OpenDate {
    private int id;
    private String openDate;
    private String businessType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public OpenDate(int id, String openDate, String businessType) {
        this.id = id;
        this.openDate = openDate;
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "OpenDate{" +
                "id=" + id +
                ", openDate='" + openDate + '\'' +
                ", businessType='" + businessType + '\'' +
                '}';
    }
}
