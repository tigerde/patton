package com.huntor.demo.controller;

import com.huntor.tools.ServletUtil;
import com.huntor.demo.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyang on 2017/7/28.
 */
@Controller
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequestMapping("/menu")
    public String menu(ModelMap modelMap, HttpServletRequest request){
        return "menu";
    }

    @RequestMapping(value = "/menuJson", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void menuJson(HttpServletRequest request , HttpServletResponse response){
        List<Map<String,Object>> menu= menuService.findAll();
        ServletUtil.createSuccessResponse(200, menu, response);
    }
}
