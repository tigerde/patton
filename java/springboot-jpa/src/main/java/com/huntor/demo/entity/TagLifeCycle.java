package com.huntor.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuyang on 2017/8/10.
 */
@Entity
@Table( name = "tag_life_cycle" )
public class TagLifeCycle implements Serializable {
    private Integer id;
    private String lifeCycleName;
    private Integer showPriority;
    private Integer calculationPriority;
    private Integer runCycle;
    private String description;
    private String enable;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private String isDelete;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "life_cycle_name")
    public String getLifeCycleName() {
        return lifeCycleName;
    }

    public void setLifeCycleName(String lifeCycleName) {
        this.lifeCycleName = lifeCycleName;
    }
    @Column(name = "show_priority")
    public Integer getShowPriority() {
        return showPriority;
    }

    public void setShowPriority(Integer showPriority) {
        this.showPriority = showPriority;
    }
    @Column(name = "calculation_priority")
    public Integer getCalculationPriority() {
        return calculationPriority;
    }

    public void setCalculationPriority(Integer calculationPriority) {
        this.calculationPriority = calculationPriority;
    }
    @Column(name = "run_cycle")
    public Integer getRunCycle() {
        return runCycle;
    }

    public void setRunCycle(Integer runCycle) {
        this.runCycle = runCycle;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "enable")
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
    @Column(name = "is_delete")
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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


}
