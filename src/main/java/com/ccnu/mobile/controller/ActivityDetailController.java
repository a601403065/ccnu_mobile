package com.ccnu.mobile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccnu.mobile.entity.vo.ActivityDetailVo;
import com.ccnu.mobile.entity.vo.ActivityDto;
import com.ccnu.mobile.service.ActivityDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 活动详情表 前端控制器
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@RestController
@Api(description="活动详情")
@RequestMapping("/activityDetail")
public class ActivityDetailController {
	
	@Autowired
    private ActivityDetailService activityDetailService;

	@GetMapping("/findActivityDetail")
    @ApiOperation(value = "查询活动详情")
    public ActivityDetailVo findActivityDetail(@ApiParam(value = "活动ID", required = true) @RequestParam int activityId){
        ActivityDetailVo activityVo = activityDetailService.findActivityDetail(activityId);
        return activityVo;
    }

    @PostMapping("/updateActivity")
    @ApiOperation(value = "修改活动")
    public void updateActivity(@ApiParam(value = "活动ID", required = true) @RequestParam int activityId, ActivityDto activityDto){
    	activityDto.setActivityId(activityId);
    	activityDetailService.updateActivity(activityDto);
    }
}

