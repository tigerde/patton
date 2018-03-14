package com.huntor.demo.dao;

import com.huntor.demo.entity.AttrStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuyang on 2017/8/1.
 */
public interface AttrStatisticsDao extends JpaRepository<AttrStatistics,Integer> {
    AttrStatistics findByAttributeId(Integer attributeId);
}
