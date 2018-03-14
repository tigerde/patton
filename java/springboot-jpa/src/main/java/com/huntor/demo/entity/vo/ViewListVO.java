package com.huntor.demo.entity.vo;

import java.util.Date;

/**
 * Created by liuyang on 2017/8/1.
 */
public class ViewListVO {
    private String attributeName;
    private String attributeNameDesc;
    private String dataType;
    private String valueRange;
    private String rate;
    private String updateRate;
    private Date updateAt;
    private String customerUpdateRate;
    private Integer attributeId;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeNameDesc() {
        return attributeNameDesc;
    }

    public void setAttributeNameDesc(String attributeNameDesc) {
        this.attributeNameDesc = attributeNameDesc;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUpdateRate() {
        return updateRate;
    }

    public void setUpdateRate(String updateRate) {
        this.updateRate = updateRate;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getCustomerUpdateRate() {
        return customerUpdateRate;
    }

    public void setCustomerUpdateRate(String customerUpdateRate) {
        this.customerUpdateRate = customerUpdateRate;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }
}
