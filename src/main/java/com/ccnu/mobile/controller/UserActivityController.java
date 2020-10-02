package com.ccnu.mobile.controller;


import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.service.UserActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户活动关联表 前端控制器
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@RestController
@Api(description="用户活动")
@RequestMapping("/userActivity")
public class UserActivityController {

	@Autowired
	UserActivityService userActivityService;

    @PostMapping("/registerActivity")
    @ApiOperation(value = "报名活动")
    public void registerActivity(@ApiParam(value = "活动ID", required = true) @RequestParam int activityId, @ApiParam(value = "用户ID", required = true) @RequestParam int userId){
        userActivityService.register(activityId, userId);
    }
    
    @PostMapping("/findMyActivityPage")
    @ApiOperation(value = "C端用户查看已报名的活动列表")
    public List<Activity> findMyActivityPage(@ApiParam(value = "用户ID", required = true) @RequestParam int userId){
    	List<Activity> activityList = userActivityService.findMyActivity(userId);
        return activityList;
    }
    
    @PostMapping("/findRegisterUser")
    @ApiOperation(value = "查看活动报名者信息")
    public List<User> findRegisterUser(@ApiParam(value = "活动ID") @RequestParam int activityId){
    	List<User> userList = userActivityService.findRegisterUser(activityId);
        return userList;
    }
}

