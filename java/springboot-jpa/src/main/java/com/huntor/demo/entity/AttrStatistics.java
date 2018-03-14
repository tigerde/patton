package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/7/28.
 */
@Entity
@Table( name = "attr_statistics" )
public class AttrStatistics {
    private Integer id;
    private Integer attributeId;
    private String attributeName;
    private Double rate;
    private String updateRate;
    private Double customerUpdateRate;
    private Date inputDate;
    private Date updateAt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "attribute_id")
    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }
    @Column(name = "attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    @Column(name = "rate")
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Column(name = "update_rate")
    public String getUpdateRate() {
        return updateRate;
    }

    public void setUpdateRate(String updateRate) {
        this.updateRate = updateRate;
    }



    @Column(name = "customer_update_rate")
    public Double getCustomerUpdateRate() {
        return customerUpdateRate;
    }

    public void setCustomerUpdateRate(Double customerUpdateRate) {
        this.customerUpdateRate = customerUpdateRate;
    }
    @Column(name = "input_date")
    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
    @Column(name = "update_at")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
