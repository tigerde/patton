package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/8/10.
 */
@Entity
@Table( name = "tag_life_cycle_log" )
public class TagLifeCycleLog {
    private Integer id;
    private Integer lifeCycleId;
    private String lifeCycleName;
    private Integer calculationNumber;
    private Integer calculationTime;
    private String calculationType;
    private Integer inNumber;
    private Integer outNumber;
    private String isSuccees;
    private Date createTime;
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

    @Column(name = "life_cycle_id")
    public Integer getLifeCycleId() {
        return lifeCycleId;
    }

    public void setLifeCycleId(Integer lifeCycleId) {
        this.lifeCycleId = lifeCycleId;
    }
    @Column(name = "calculation_number")
    public Integer getCalculationNumber() {
        return calculationNumber;
    }

    public void setCalculationNumber(Integer calculationNumber) {
        this.calculationNumber = calculationNumber;
    }
    @Column(name = "calculation_time")
    public Integer getCalculationTime() {
        return calculationTime;
    }

    public void setCalculationTime(Integer calculationTime) {
        this.calculationTime = calculationTime;
    }
    @Column(name = "calculation_type")
    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }
    @Column(name = "in_number")
    public Integer getInNumber() {
        return inNumber;
    }

    public void setInNumber(Integer inNumber) {
        this.inNumber = inNumber;
    }
    @Column(name = "out_number")
    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }
    @Column(name = "is_succees")
    public String getIsSuccees() {
        return isSuccees;
    }

    public void setIsSuccees(String isSuccees) {
        this.isSuccees = isSuccees;
    }
    @Column(name = "created_at")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    @Column(name = "life_cycle_name")
	public String getLifeCycleName() {
		return lifeCycleName;
	}

	public void setLifeCycleName(String lifeCycleName) {
		this.lifeCycleName = lifeCycleName;
	}
    

}
