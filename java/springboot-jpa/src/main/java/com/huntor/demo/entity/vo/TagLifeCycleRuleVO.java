package com.huntor.demo.entity.vo;

import com.huntor.demo.entity.TagLifeCycleRule;

/**
 * Created by liuyang on 2017/8/31.
 */
public class TagLifeCycleRuleVO extends TagLifeCycleRule {
    private String attributeValueText;
    private String attributeNameText;

    public String getAttributeNameText() {
        return attributeNameText;
    }

    public void setAttributeNameText(String attributeNameText) {
        this.attributeNameText = attributeNameText;
    }

    public String getAttributeValueText() {
        return attributeValueText;
    }

    public void setAttributeValueText(String attributeValueText) {
        this.attributeValueText = attributeValueText;
    }
}
