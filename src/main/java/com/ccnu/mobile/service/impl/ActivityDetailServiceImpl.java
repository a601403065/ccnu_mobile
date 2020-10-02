package com.ccnu.mobile.service.impl;

import com.ccnu.mobile.entity.vo.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.ActivityDetail;
import com.ccnu.mobile.entity.vo.ActivityDetailVo;
import com.ccnu.mobile.entity.vo.ActivityDto;
import com.ccnu.mobile.entity.vo.Constant;
import com.ccnu.mobile.mapper.ActivityDetailMapper;
import com.ccnu.mobile.mapper.ActivityMapper;
import com.ccnu.mobile.service.ActivityDetailService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhh
 * @since 2020-09-25
 */
@Service
public class ActivityDetailServiceImpl extends ServiceImpl<ActivityDetailMapper, ActivityDetail> implements ActivityDetailService {

	@Autowired
	private ActivityDetailMapper activityDetailMapper;
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Override
	public ActivityDetailVo findActivityDetail(int activityId) {
		ActivityDetailVo activityVo = activityDetailMapper.selectActivityDetail(activityId);
		if(activityVo == null){
			throw new ResultStatusEnum(110,"活动不存在");
		}
		return activityVo;
	}

	@Override
	public void updateActivity(ActivityDto activityDto) {
		Activity activity = activityMapper.selectById(activityDto.getActivityId());
		if(activity == null){
			throw new ResultStatusEnum(110,"活动不存在");
		}
		activity.setActivityName(activityDto.getActivityName());
		activity.setActivityBeginTime(activityDto.getActivityBeginTime());
		activity.setActivityEndTime(activityDto.getActivityEndTime());
		int resultA = activityMapper.updateById(activity);
		
		ActivityDetail activityDetail = new ActivityDetail();
		ActivityDetailVo adv = activityDetailMapper.selectActivityDetail(activityDto.getActivityId());
		activityDetail.setPkid(adv.getPkid());
		activityDetail.setActivityId(adv.getActivityId());
		activityDetail.setSignAmount(adv.getSignAmount());
		activityDetail.setRegisterBeginTime(activityDto.getRegisterBeginTime());
		activityDetail.setRegisterEndTime(activityDto.getRegisterEndTime());
		activityDetail.setActivityContent(activityDto.getActivityContent());
		activityDetail.setActivityUrl(activityDto.getActivityUrl());
		activityDetail.setRegisterMaxAmount(activityDto.getRegisterMaxAmount());
		activityDetail.setRegisterType(activityDto.getRegisterType());
		activityDetail.setQrCode(activityDto.getQrCode());
		activityDetail.setValid(Constant.VALID);
		int resultAD = activityDetailMapper.updateById(activityDetail);
		if(resultA == 1 && resultAD == 1){
			throw new ResultStatusEnum(200,"操作成功");
		}else{
			throw new ResultStatusEnum(100,"操作失败");
		}
	}
}
