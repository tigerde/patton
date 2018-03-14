package com.huntor.demo.dao;

import com.huntor.demo.entity.TagLifeCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liuyang on 2017/8/10.
 */
public interface TagLifeCycleDao extends JpaRepository<TagLifeCycle,Integer> ,JpaSpecificationExecutor<TagLifeCycle>  {
    @Modifying
    @Query(value = "update tag_life_cycle set is_delete = ?1 where id = ?2",nativeQuery = true)
    public void updateById(String isDelete,Integer id);
    @Query(value ="select lifeCycleName from TagLifeCycle")
    public List<String> findName();
    @Query(value = "SELECT\n" +
            "\t1\n" +
            "FROM\n" +
            "\ttag_life_cycle\n" +
            "WHERE\n" +
            "\t(life_cycle_name = ?1\n" +
            "OR show_priority = ?2\n" +
            "OR calculation_priority = ?3)\n" +
            "AND is_delete=\"1\"\n" +
            "LIMIT 1",nativeQuery = true)
    public Integer findLifeCyleExists(String lifeCycleName,Integer showPriority,Integer calculationPriority);

    @Query(value = "select * from tag_life_cycle where life_cycle_name = ?1 and is_delete = ?2",nativeQuery = true)
    public TagLifeCycle findbyLifeCycleNameAndisDelete(String lifeCycleName,String isDelete);
    @Query(value = "select * from tag_life_cycle where show_priority = ?1 and is_delete = ?2",nativeQuery = true)
    public TagLifeCycle findbyShowPriorityAndisDelete(Integer showPriority,String isDelete);
    @Query(value = "select * from tag_life_cycle where calculation_priority = ?1 and is_delete = ?2",nativeQuery = true)
    public TagLifeCycle findbyCalculationPriorityAndisDelete(Integer calculationPriority,String isDelete);


}
