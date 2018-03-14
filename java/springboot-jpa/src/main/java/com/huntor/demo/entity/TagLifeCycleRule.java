package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/8/14.
 */
@Entity
@Table( name = "tag_life_cycle_rule" )
public class TagLifeCycleRule {
    private Integer id;
    private String lifeCycleName;
    private Integer lifeCycleId;
    private Integer ruleAttributeNumber;
    private Integer attributeId;
    private String attributeName;
    private String ruleOperator;
    private Integer attributeValueId;
    private String attributeValue;
    private String relationalSymbol;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
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
    @Column(name = "life_cycle_id")
    public Integer getLifeCycleId() {
        return lifeCycleId;
    }

    public void setLifeCycleId(Integer lifeCycleId) {
        this.lifeCycleId = lifeCycleId;
    }
    @Column(name = "rule_attribute_number")
    public Integer getRuleAttributeNumber() {
        return ruleAttributeNumber;
    }

    public void setRuleAttributeNumber(Integer ruleAttributeNumber) {
        this.ruleAttributeNumber = ruleAttributeNumber;
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
    @Column(name = "rule_operator")
    public String getRuleOperator() {
        return ruleOperator;
    }

    public void setRuleOperator(String ruleOperator) {
        this.ruleOperator = ruleOperator;
    }
    @Column(name = "attribute_value_id")
    public Integer getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Integer attributeValueId) {
        this.attributeValueId = attributeValueId;
    }
    @Column(name = "attribute_value")
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
    @Column(name = "relational_symbol")
    public String getRelationalSymbol() {
        return relationalSymbol;
    }

    public void setRelationalSymbol(String relationalSymbol) {
        this.relationalSymbol = relationalSymbol;
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
