package com.ccnu.mobile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.ActivityDetail;
import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.entity.vo.ActivityDto;
import com.ccnu.mobile.entity.vo.Constant;
import com.ccnu.mobile.entity.vo.ResultStatusEnum;
import com.ccnu.mobile.mapper.ActivityDetailMapper;
import com.ccnu.mobile.mapper.ActivityMapper;
import com.ccnu.mobile.mapper.UserMapper;
import com.ccnu.mobile.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhh
 * @since 2020-09-25
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

	@Autowired
	ActivityMapper activityMapper;
	
	@Autowired
	ActivityDetailMapper activityDetailMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<Activity> findListByPage(Activity activity) {
		activity.setValid(Constant.VALID);
		QueryWrapper<Activity> wrapper = new QueryWrapper<>(activity);
		wrapper.orderByDesc(Constant.TOPSTATUS);
		wrapper.orderByDesc(Constant.ADDEDTIME);
		List<Activity> activityList = activityMapper.selectList(wrapper);
		return activityList;
	}

	@Override
	public void addActivity(ActivityDto activityDto) {
		Activity activity = new Activity();
		ActivityDetail activityDetail = new ActivityDetail();
		activityDto.setValid(Constant.VALID);
		BeanUtils.copyProperties(activityDto, activity);
		BeanUtils.copyProperties(activityDto, activityDetail);

		User user = userMapper.selectById(activityDto.getPublisherId());
		if(user == null){
			throw new ResultStatusEnum(101,"用户不存在");
		}
		activity.setAddedTime(new Date());//获取当前服务器时间
		activity.setTopStatus(Constant.DEFAULT_TOPSTATUS);
		activity.setPublisherId(activityDto.getPublisherId());
		activity.setPublisher(user.getName());
		
		int resultA = activityMapper.insertActivity(activity);
		activityDetail.setActivityId(activity.getPkid());
		int resultAD = activityDetailMapper.insert(activityDetail);
		if(resultA == 1 && resultAD == 1){
			throw new ResultStatusEnum(200,"操作成功");
		}else{
			throw new ResultStatusEnum(100,"操作失败");
		}
	}

	@Override
	public void sign(int activityId) {
		ActivityDetail activityDetailModel = new ActivityDetail();
		activityDetailModel.setActivityId(activityId);
		activityDetailModel.setValid(Constant.VALID);
		QueryWrapper<ActivityDetail> wrapperAD = new QueryWrapper<>(activityDetailModel);
		ActivityDetail activityDetail = activityDetailMapper.selectOne(wrapperAD);

		Activity activityModel = new Activity();
		activityModel.setPkid(activityId);
		activityModel.setValid(Constant.VALID);
		QueryWrapper<Activity> wrapperA = new QueryWrapper<>(activityModel);
		Activity activity = activityMapper.selectOne(wrapperA);
		if (activityDetail == null || activity == null){
			throw new ResultStatusEnum(120,"该活动不存在");
		}
		if (activity.getActivityBeginTime().compareTo(new Date()) > 0){
			throw new ResultStatusEnum(130,"签到时间未到");
		}
		if (activity.getActivityEndTime().compareTo(new Date()) < 0){
			throw new ResultStatusEnum(131,"签到时间已过");
		}
		if(activityDetail.getSignAmount() < activityDetail.getRegisterAmount()){
			int signNumber = activityDetail.getSignAmount() + 1;
			activityDetail.setSignAmount(signNumber);
			activityDetailMapper.updateById(activityDetail);
			throw new ResultStatusEnum(201, "签到成功");
		}else{
			throw new ResultStatusEnum(123, "人数已满，签到失败");
		}
	}

	@Override
	public List<Activity> findListByPublisherId(int publisherId) {
		List<Activity> activityList = activityDetailMapper.selectListByPublisherId(publisherId);
		return activityList;
	}

}
