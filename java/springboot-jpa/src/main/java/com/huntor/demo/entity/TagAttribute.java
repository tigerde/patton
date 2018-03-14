package com.huntor.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuyang on 2017/8/16.
 */
@Entity
@Table( name = "tag_attribute" )
public class TagAttribute {
    private Integer id;
    private String attributeName;
    private String attributeColumnName;
    private String inputType;
    private String description;
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
    @Column(name = "attribute_name")
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    @Column(name = "attribute_column_name")
    public String getAttributeColumnName() {
        return attributeColumnName;
    }

    public void setAttributeColumnName(String attributeColumnName) {
        this.attributeColumnName = attributeColumnName;
    }
    @Column(name = "input_type")
    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
