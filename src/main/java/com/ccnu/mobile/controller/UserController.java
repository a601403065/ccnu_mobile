package com.ccnu.mobile.controller;


import com.ccnu.mobile.entity.User;
import com.ccnu.mobile.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yhh
 * @since 2020-09-26
 */
@RestController
@Api(description="用户")
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public void registerActivity(User user){
        userService.register(user);
    }
}

