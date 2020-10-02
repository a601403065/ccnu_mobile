package com.ccnu.mobile.service.impl;

import com.ccnu.mobile.entity.vo.Constant;
import com.ccnu.mobile.entity.vo.ResultStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.mapper.UserMapper;
import com.ccnu.mobile.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhh
 * @since 2020-09-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        user.setValid(Constant.VALID);
        int result = userMapper.insert(user);
        if(result != 0){
            throw new ResultStatusEnum(200,"操作成功");
        }else{
            throw new ResultStatusEnum(100,"操作失败");
        }
    }
}
