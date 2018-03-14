package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/7/28.
 */
@Entity
@Table( name = "attr_definition" )
public class AttrDefinition {
    private Integer id;
    private Integer attributeId;
    private String attributeName;
    private String attributeNameChs;
    private String attributeNameDesc;
    private String dataType;
    private String valueRange;
    private Date createTime;
    private Date updateTime;
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
    @Column(name = "attribute_name_chs")
    public String getAttributeNameChs() {
        return attributeNameChs;
    }

    public void setAttributeNameChs(String attributeNameChs) {
        this.attributeNameChs = attributeNameChs;
    }
    @Column(name = "attribute_name_desc")
    public String getAttributeNameDesc() {
        return attributeNameDesc;
    }

    public void setAttributeNameDesc(String attributeNameDesc) {
        this.attributeNameDesc = attributeNameDesc;
    }
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    @Column(name = "value_range")
    public String getValueRange() {
        return valueRange;
    }

    public void setValueRange(String valueRange) {
        this.valueRange = valueRange;
    }
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
