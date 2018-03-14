package com.huntor.demo.controller;

import com.huntor.demo.dao.UserMapper;
import com.huntor.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuyang on 2017/9/20.
 */
@RestController
public class UserController {
    @Resource
    private UserMapper userDao;

    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam(value="id") Integer id) {
        User user = null;
        try {
            user = userDao.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
