package com.huntor.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huntor.demo.entity.TagLifeCycleLog;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagLifeCycleLogDao extends JpaRepository<TagLifeCycleLog,Integer>,JpaSpecificationExecutor<TagLifeCycleLog> {
    @Query(value = "SELECT * FROM tag_life_cycle_log where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(created_at) AND life_cycle_id = ?1 ORDER BY created_at DESC",nativeQuery = true)
    List<TagLifeCycleLog> findByLifeCycleId(Integer lifeCycleId);

    @Query(value = "SELECT * FROM tag_life_cycle_log where  life_cycle_id = ?1 ORDER BY created_at ASC",nativeQuery = true)
    List<TagLifeCycleLog> findByLifeCycleIdTwo(Integer lifeCycleId);

    List<TagLifeCycleLog> findByInputDate(Date inputDate);

}
