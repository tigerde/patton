package com.huntor.demo.dao;

import com.huntor.demo.entity.AttrDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by liuyang on 2017/8/1.
 */
public interface AttrDefinitionDao extends JpaRepository<AttrDefinition,Integer> ,JpaSpecificationExecutor<AttrDefinition> {
}
