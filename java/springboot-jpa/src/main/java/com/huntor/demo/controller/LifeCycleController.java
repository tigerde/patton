package com.huntor.demo.controller;

import com.huntor.tools.ServletUtil;
import com.huntor.demo.entity.vo.Item;
import com.huntor.demo.entity.vo.LifeCycleSaveVO;
import com.huntor.demo.entity.vo.TagLifeCycleVO;
import com.huntor.demo.service.LifeCycleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyang on 2017/8/10.
 */
@Controller
public class LifeCycleController {
    @Resource
    private LifeCycleService lifeCycleService;

    @RequestMapping("/lifeCycleList")
    public String lifeCycleList(ModelMap modelMap, HttpServletRequest request){
        return "lifeCycleList";
    }

    @RequestMapping(value = "/findLifeCycle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void findLifeCycleList(HttpServletRequest request , HttpServletResponse response,
                                  @RequestParam Integer page, @RequestParam Integer size){
        ServletUtil.createSuccessResponse(200, lifeCycleService.findLifeCycleList(page,size), response);
    }

    @RequestMapping(value = "/deleLifeCycle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleLifeCycle(HttpServletRequest request , HttpServletResponse response,
                              @RequestParam Integer id){
        //获取参数
        lifeCycleService.deleteBYLCADefinition(id);
        ServletUtil.createSuccessResponse(200, "", response);
    }

    @RequestMapping("/combinationChart")
    public String combinationChart(ModelMap modelMap, HttpServletRequest request){
        return "combinationChart";
    }

    @RequestMapping(value = "/findReportData", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> findReportData(HttpServletRequest request , HttpServletResponse response){
        return lifeCycleService.findReportData();
    }

    @RequestMapping("/LifeCycleSvae")
    public String LifeCycleSvae(ModelMap modelMap, HttpServletRequest request){
        return "LifeCycleSvae";
    }

    @RequestMapping(value = "/LifeCycleSvaeForm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void LifeCycleSvaeForm(HttpServletRequest request , HttpServletResponse response, @RequestBody LifeCycleSaveVO data){
        System.out.print(data.toString());
        String b=lifeCycleService.SaveLifeCycle(data);
            ServletUtil.createSuccessResponse(200, b, response);
    }

    @RequestMapping(value = "/LifeCycleEditForm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void LifeCycleEditForm(HttpServletRequest request , HttpServletResponse response, @RequestBody LifeCycleSaveVO data){
        System.out.print(data.toString());
        String b=lifeCycleService.editLifeCycle(data);
            ServletUtil.createSuccessResponse(200, b, response);
    }

    @RequestMapping("/LifeCycleEdit")
    public String LifeCycleEdit(ModelMap modelMap, HttpServletRequest request){
        return "LifeCycleEdit";
    }

    @RequestMapping(value = "/LifeCycleEditData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void LifeCycleEditData(HttpServletRequest request , HttpServletResponse response,
                                  @RequestParam Integer id){
        //获取参数
        ServletUtil.createSuccessResponse(200, lifeCycleService.findLifeCycleEdit(id), response);
    }

    @RequestMapping("/LifeCycleDetails")
    public String LifeCycleDetails(ModelMap modelMap, HttpServletRequest request,
                                   @RequestParam Integer id){
        TagLifeCycleVO tagLifeCycle=lifeCycleService.findTagLifeCycle(id);
        modelMap.addAttribute("tagLifeCycle",tagLifeCycle);
        return "lifeCycleDetails";
    }
    @RequestMapping(value = "/LifeCycleDetailsData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void LifeCycleDetailsData(HttpServletRequest request , HttpServletResponse response,
                                     @RequestParam Integer id){
        ServletUtil.createSuccessResponse(200, lifeCycleService.findDetails(id), response);
    }

    @RequestMapping(value ="/findItem", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void findItem(HttpServletRequest request , HttpServletResponse response,
                         @RequestParam String attributeColumnName){
        List<Item> items=lifeCycleService.findItem(attributeColumnName);
        ServletUtil.createSuccessResponse(200, items, response);
    }

}
