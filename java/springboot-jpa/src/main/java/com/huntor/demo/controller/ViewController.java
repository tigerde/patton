package com.huntor.demo.controller;

import com.huntor.tools.ServletUtil;
import com.huntor.demo.entity.vo.LifeCycleSaveVO;
import com.huntor.demo.entity.vo.ViewDataVO;
import com.huntor.demo.service.LifeCycleService;
import com.huntor.demo.service.MenuService;
import com.huntor.demo.service.ViewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyang on 2017/8/1.
 */
@Controller
public class ViewController {
    @Resource
    private ViewService viewService;
    @Resource
    private MenuService menuService;
    @Resource
    private LifeCycleService lifeCycleService;

    @RequestMapping(value = "/viewList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void viewList(HttpServletRequest request , HttpServletResponse response){
        Map<String,Object> resMap=new HashMap<>();
        Integer id=9;
        if (!"".equals(request.getParameter("id"))){
            //获取参数
            id= Integer.valueOf(request.getParameter("id"));
        }
        //获取参数
        Integer page= Integer.valueOf(request.getParameter("page"));
        //获取参数
        Integer size= Integer.valueOf(request.getParameter("size"));
        List<Map<String,Object>> menu= menuService.findAll();
        ViewDataVO viewDataVO=viewService.viewList(id,page,size);
        resMap.put("menu",menu);
        resMap.put("viewDataVO",viewDataVO);
        ServletUtil.createSuccessResponse(200, resMap, response);
    }

    @RequestMapping(value = "/viewListEdit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void viewListEdit(HttpServletRequest request , HttpServletResponse response){
        Map<String,Object> resMap=new HashMap<>();
        Integer id=9;
        if (!"".equals(request.getParameter("id"))){
            //获取参数
            id= Integer.valueOf(request.getParameter("id"));
        }
        //获取参数
        Integer page= Integer.valueOf(request.getParameter("page"));
        //获取参数
        Integer size= Integer.valueOf(request.getParameter("size"));

        Integer lifeCycleId= Integer.valueOf(request.getParameter("lifeCycleId"));
        LifeCycleSaveVO lifeCycleSaveVO=lifeCycleService.findLifeCycleEdit(lifeCycleId);
        List<Map<String,Object>> menu= menuService.findAll();
        ViewDataVO viewDataVO=viewService.viewList(id,page,size);
        resMap.put("menu",menu);
        resMap.put("viewDataVO",viewDataVO);
        resMap.put("lifeCycleSaveVO",lifeCycleSaveVO);
        ServletUtil.createSuccessResponse(200, resMap, response);
    }


}
