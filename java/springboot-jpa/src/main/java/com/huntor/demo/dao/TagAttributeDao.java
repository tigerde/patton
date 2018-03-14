package com.huntor.demo.dao;

import com.huntor.demo.entity.TagAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagAttributeDao extends JpaRepository<TagAttribute,Integer>,JpaSpecificationExecutor<TagAttribute> {
    TagAttribute findByAttributeColumnName(String attributeColumnName);
}
