package com.cenyol.example.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cenyol.example.service.MyService;


/**
 * Created by sjj on 2015/10/24 0024.
 */
@Controller
public class MainController {
    @Resource
    MyService ms;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody()
    public void sayWord(){
        ms.sayHello("hello");
    }
}