package com.ccnu.mobile.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.ActivityDetail;
import com.ccnu.mobile.entity.vo.ActivityDetailVo;

/**
 * <p>
 * 活动详情表 Mapper 接口
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@Repository
public interface ActivityDetailMapper extends BaseMapper<ActivityDetail> {

	ActivityDetailVo selectActivityDetail(int activityId);

	List<Activity> selectListByPublisherId(int publisherId);
}
