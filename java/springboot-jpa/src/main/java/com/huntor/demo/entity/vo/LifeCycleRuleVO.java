package com.huntor.demo.entity.vo;

/**
 * Created by liuyang on 2017/8/22.
 */
public class LifeCycleRuleVO {
    private Integer id;
    private String ruleOperator;
    private String attributeValue;
    private String relationalSymbol;
    private String attributeName;
    private String attributeId;

    public String getRuleOperator() {
        return ruleOperator;
    }

    public void setRuleOperator(String ruleOperator) {
        this.ruleOperator = ruleOperator;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getRelationalSymbol() {
        return relationalSymbol;
    }

    public void setRelationalSymbol(String relationalSymbol) {
        this.relationalSymbol = relationalSymbol;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LifeCycleRuleVO{" +
                "ruleOperator='" + ruleOperator + '\'' +
                ", attributeValue='" + attributeValue + '\'' +
                ", relationalSymbol='" + relationalSymbol + '\'' +
                ", attributeName='" + attributeName + '\'' +
                ", attributeId='" + attributeId + '\'' +
                '}';
    }
}
