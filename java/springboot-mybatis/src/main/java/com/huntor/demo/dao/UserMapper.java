package com.huntor.demo.dao;

import com.huntor.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liuyang on 2017/9/20.
 */
public interface UserMapper {
    User findUserById(Integer id);
    User findUserByName(String name);
}
