package com.ccnu.mobile.controller;


import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.vo.ActivityDto;
import com.ccnu.mobile.service.ActivityService;
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
 * 活动表 前端控制器
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@RestController
@Api(description="活动")
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
    private ActivityService activityService;

    @PostMapping("/findActivityListAll")
    @ApiOperation(value = "查询所有活动列表")
    public List<Activity> findActivityListAll(Activity activity){
        List<Activity> activityList = activityService.findListByPage(activity);
        return activityList;
    }
    
    @PostMapping("/addActivity")
    @ApiOperation(value = "创建活动")
    public void addActivity(ActivityDto activityDto){
        activityService.addActivity(activityDto);
    }
    
    @PostMapping("/signActivity")
    @ApiOperation(value = "活动签到")
    public void signActivity(@ApiParam(value = "活动ID", required = true) @RequestParam int activityId){
        activityService.sign(activityId);
    }
    
    @PostMapping("/findRegisterActivityList")
    @ApiOperation(value = "查询发布活动列表")
    public List<Activity> findRegisterActivityList(@ApiParam(value = "发布者ID", required = true) @RequestParam int publisherId){
        List<Activity> activityList = activityService.findListByPublisherId(publisherId);
        return activityList;
    }
}

