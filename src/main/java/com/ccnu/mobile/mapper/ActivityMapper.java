package com.ccnu.mobile.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccnu.mobile.entity.Activity;
import com.ccnu.mobile.entity.vo.UserActivityVo;

/**
 * <p>
 * 活动表 Mapper 接口
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@Repository
public interface ActivityMapper extends BaseMapper<Activity> {

	int insertActivity(Activity activity);

	List<Activity> selectMyActivity(int userId);

	IPage<Activity> selectByUserId(Page<Activity> page, QueryWrapper<UserActivityVo> wrapper);

}
