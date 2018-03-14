package com.huntor.demo.dao;

import com.huntor.demo.entity.TagAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagAttributeValueDao extends JpaRepository<TagAttributeValue,Integer>,JpaSpecificationExecutor<TagAttributeValue> {
    List<TagAttributeValue> findByAttributeId(Integer attributeId);
}
