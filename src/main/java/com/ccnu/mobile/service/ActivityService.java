package com.ccnu.mobile.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.vo.ActivityDto;

/**
 * <p>
 * 活动表 服务类
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
public interface ActivityService extends IService<Activity> {

	List<Activity> findListByPage(Activity activity);

	void addActivity(ActivityDto activityDto);

	void sign(int activityId);

	List<Activity> findListByPublisherId(int publisherId);
}
