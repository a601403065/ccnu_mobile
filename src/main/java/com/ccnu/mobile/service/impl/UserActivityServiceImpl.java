package com.ccnu.mobile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.ActivityDetail;
import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.entity.UserActivity;
import com.ccnu.mobile.entity.vo.Constant;
import com.ccnu.mobile.entity.vo.ResultStatusEnum;
import com.ccnu.mobile.mapper.ActivityDetailMapper;
import com.ccnu.mobile.mapper.ActivityMapper;
import com.ccnu.mobile.mapper.UserActivityMapper;
import com.ccnu.mobile.mapper.UserMapper;
import com.ccnu.mobile.service.UserActivityService;
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
public class UserActivityServiceImpl extends ServiceImpl<UserActivityMapper, UserActivity> implements UserActivityService {

	@Autowired
	private UserActivityMapper userActivityMapper;
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ActivityDetailMapper activityDetailMapper;
	
	@Override
	public void register(int activityId, int userId) {
		User user = userMapper.selectById(userId);
		if(user == null){
			throw new ResultStatusEnum(101,"用户不存在");
		}
		UserActivity userActivityModel = new UserActivity();
		userActivityModel.setActivityId(activityId);
		userActivityModel.setUserId(userId);
		userActivityModel.setValid(Constant.VALID);
		QueryWrapper<UserActivity> wrapper = new QueryWrapper<>(userActivityModel);
		int count = userActivityMapper.selectCount(wrapper);
		if(count != 0){
			throw new ResultStatusEnum(121,"不可重复报名");
		}
		if(user.getIsAdmin() == 1){
			throw new ResultStatusEnum(102,"管理员不可报名");
		}

		ActivityDetail activityDetail = activityDetailMapper.selectById(activityId);
		if (activityDetail == null){
			throw new ResultStatusEnum(120,"该活动不存在");
		}
		if(activityDetail.getRegisterBeginTime().compareTo(new Date()) > 0 ){
			throw new ResultStatusEnum(122,"报名时间未到");
		}
		if(activityDetail.getRegisterEndTime().compareTo(new Date()) < 0 ){
			throw new ResultStatusEnum(123,"报名时间已过");
		}
		if(activityDetail.getRegisterAmount() >= activityDetail.getRegisterMaxAmount()){
			throw new ResultStatusEnum(124,"报名人数已满");
		}

		UserActivity userActivity = new UserActivity();
		userActivity.setActivityId(activityId);
		userActivity.setUserId(userId);
		userActivity.setValid(Constant.VALID);
		userActivityMapper.insert(userActivity);

		activityDetail.setRegisterAmount(activityDetail.getRegisterAmount() + 1);
		int result = activityDetailMapper.updateById(activityDetail);
		if(result == 1){
			throw new ResultStatusEnum(200,"操作成功");
		}else{
			throw new ResultStatusEnum(100,"操作失败");
		}
	}

	@Override
	public List<Activity> findMyActivity(int userId) {
		List<Activity> activityList = activityMapper.selectMyActivity(userId);
		return activityList;
	}

	@Override
	public List<User> findRegisterUser(int activityId) {
		List<User> user = userMapper.selectRegisterUser(activityId);
		return user;
	}

}
