package com.huntor.demo.dao;

import com.huntor.demo.entity.TagLifeCycleRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagLifeCycleRuleDao extends JpaRepository<TagLifeCycleRule,Integer>,JpaSpecificationExecutor<TagLifeCycleRule> {
    List<TagLifeCycleRule> findByLifeCycleId(Integer lifeCycleId);
}
