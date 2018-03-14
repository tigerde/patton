package com.huntor.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huntor.demo.entity.TagLifeCycleStatistics;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagLifeCycleStatisticsDao extends JpaRepository<TagLifeCycleStatistics,Integer>,JpaSpecificationExecutor<TagLifeCycleStatistics> {
	List<TagLifeCycleStatistics> findByInputDate(Date date);
}
