package com.ccnu.mobile.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccnu.mobile.entity.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

	List<User> selectRegisterUser(int activityId);

}
