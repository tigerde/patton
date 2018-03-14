package com.huntor.demo.controller;

import com.huntor.demo.entity.vo.Entity;
import com.huntor.demo.service.LifeCycleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by patton on 2017/8/24.
 */
@Api(consumes = "123",value = "lifecyle",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,description = "生命周期")
@RestController
@RequestMapping(path = "/api/")
public class LifeCyleReportController {
	@Resource
	private LifeCycleService ls;
	
    @ApiOperation(value = "lifecyle/history",notes = "lifecyle history",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "lifecyle/history", method = RequestMethod.GET)
    public ResponseEntity<Entity> lifecylehistory(
            @ApiParam(value = "token", required = true) @RequestHeader String token) {
    	Entity entity=new Entity();
    	entity.setObject(ls.getLifeCycleLog());
        return ResponseEntity.ok(entity);
    }
    
    @ApiOperation(value = "lifecyle/status",notes = "lifecyle status",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "lifecyle/status", method = RequestMethod.GET)
    public ResponseEntity<Entity> lifecylestatus(
            @ApiParam(value = "token", required = true) @RequestHeader String token) {
    	Entity entity=new Entity();
    	entity.setObject(ls.getLifeCycleStatus());
        return ResponseEntity.ok(entity);
    }
    
    @ApiOperation(value = "lifecyle",notes = "lifecyle",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "lifecyle", method = RequestMethod.GET)
    public ResponseEntity<Entity> lifecyle(
            @ApiParam(value = "token", required = true) @RequestHeader String token,
            @ApiParam(value = "ids", required = true) @RequestParam String ids) {
    	Entity entity=new Entity();
    	if (ids!=null&&!("").equals(ids)) {
			String id[]=ids.split(",");
			entity.setObject(ls.getCustomerTag(id));
		}
    	
        return ResponseEntity.ok(entity);
    }
}
