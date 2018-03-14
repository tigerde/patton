package com.huntor.demo.entity.vo;

import java.util.Date;

/**
 * Created by liuyang on 2017/8/3.
 */
public class CustomerViewVO {
    private String customerId;
    private String basicName;
    private String basicMobile;
    private String basicCustomerStatus;
    private String topBasic;
    private String topBehavior;
    private String topDemand;
    private Date updateTime;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBasicName() {
        return basicName;
    }

    public void setBasicName(String basicName) {
        this.basicName = basicName;
    }

    public String getBasicMobile() {
        return basicMobile;
    }

    public void setBasicMobile(String basicMobile) {
        this.basicMobile = basicMobile;
    }

    public String getBasicCustomerStatus() {
        return basicCustomerStatus;
    }

    public void setBasicCustomerStatus(String basicCustomerStatus) {
        this.basicCustomerStatus = basicCustomerStatus;
    }

    public String getTopBasic() {
        return topBasic;
    }

    public void setTopBasic(String topBasic) {
        this.topBasic = topBasic;
    }

    public String getTopBehavior() {
        return topBehavior;
    }

    public void setTopBehavior(String topBehavior) {
        this.topBehavior = topBehavior;
    }

    public String getTopDemand() {
        return topDemand;
    }

    public void setTopDemand(String topDemand) {
        this.topDemand = topDemand;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
