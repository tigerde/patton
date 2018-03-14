package com.huntor.demo.dao;

import com.huntor.demo.entity.TagLifeCycleTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by liuyang on 2017/8/16.
 */
public interface TagLifeCycleTransDao extends JpaRepository<TagLifeCycleTrans,Integer>,JpaSpecificationExecutor<TagLifeCycleTrans> {

//    @Query(value = "select count(1) from tag_life_cycle_trans where created_at > :startTime and created_at < :endTime and customer_id = :customerId GROUP BY created_at ORDER BY created_at DESC",nativeQuery = true)
    @Query(value = "select count(1) from TagLifeCycleTrans where createdAt > :startTime and createdAt < :endTime and lifeCycleId = :lifeCycleId GROUP BY createdAt ORDER BY createdAt ASC")
    public List<Long> findCount(@Param("startTime") Date startTime, @Param("endTime")  Date endTime, @Param("lifeCycleId") Integer lifeCycleId);

    @Query(value = "select count(1) from tag_life_cycle_trans where created_at > :startTime and created_at < :endTime and life_cycle_id = :lifeCycleId",nativeQuery = true)
    public Integer findTotalCount(@Param("startTime") Date startTime, @Param("endTime")  Date endTime, @Param("lifeCycleId") Integer lifeCycleId);

    @Query(value = "select createdAt from TagLifeCycleTrans where createdAt > :startTime and createdAt < :endTime and lifeCycleId = :lifeCycleId GROUP BY createdAt ORDER BY createdAt ASC")
    public List<Date> findCountAndTime(@Param("startTime") Date startTime, @Param("endTime")  Date endTime, @Param("lifeCycleId") Integer lifeCycleId);
}
