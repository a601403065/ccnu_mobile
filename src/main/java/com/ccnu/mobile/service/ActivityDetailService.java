package com.ccnu.mobile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccnu.mobile.entity.ActivityDetail;
import com.ccnu.mobile.entity.vo.ActivityDetailVo;
import com.ccnu.mobile.entity.vo.ActivityDto;

/**
 * <p>
 * 活动详情表 服务类
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
public interface ActivityDetailService extends IService<ActivityDetail> {

	ActivityDetailVo findActivityDetail(int activityId);

	void updateActivity(ActivityDto activityDto);
}
