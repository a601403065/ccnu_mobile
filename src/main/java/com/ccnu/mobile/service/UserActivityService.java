package com.ccnu.mobile.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.entity.UserActivity;

/**
 * <p>
 * 用户活动关联表 服务类
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
public interface UserActivityService extends IService<UserActivity> {

	void register(int activityId, int userId);

	List<Activity> findMyActivity(int userId);

	List<User> findRegisterUser(int activityId);

}
