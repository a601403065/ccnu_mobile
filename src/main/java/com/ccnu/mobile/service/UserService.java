package com.ccnu.mobile.service;

import com.ccnu.mobile.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
public interface UserService extends IService<User> {

    void register(User user);
}
