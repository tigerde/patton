package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface UserMapper extends Mapper<User> {
}