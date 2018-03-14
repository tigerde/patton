package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/8/14.
 */
@Entity
@Table( name = "tag_life_cycle_trans" )
public class TagLifeCycleTrans {
    private Integer id;
    private String customerId;
    private Integer lastLifeCycleId;
    private String lastLifeCycleName;
    private Integer lifeCycleId;
    private String lifeCycleName;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private Date inputDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    @Column(name = "last_life_cycle_id")
    public Integer getLastLifeCycleId() {
        return lastLifeCycleId;
    }

    public void setLastLifeCycleId(Integer lastLifeCycleId) {
        this.lastLifeCycleId = lastLifeCycleId;
    }
    @Column(name = "last_life_cycle_name")
    public String getLastLifeCycleName() {
        return lastLifeCycleName;
    }

    public void setLastLifeCycleName(String lastLifeCycleName) {
        this.lastLifeCycleName = lastLifeCycleName;
    }
    @Column(name = "life_cycle_id")
    public Integer getLifeCycleId() {
        return lifeCycleId;
    }

    public void setLifeCycleId(Integer lifeCycleId) {
        this.lifeCycleId = lifeCycleId;
    }
    @Column(name = "life_cycle_name")
    public String getLifeCycleName() {
        return lifeCycleName;
    }

    public void setLifeCycleName(String lifeCycleName) {
        this.lifeCycleName = lifeCycleName;
    }
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Column(name = "updated_by")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    @Column(name = "input_date")
    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
