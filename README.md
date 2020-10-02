# 掌上华师
后端  

建表sql：  
活动表：  
CREATE TABLE `activity` (  
  `pkid` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',  
  `activity_name` varchar(255) DEFAULT NULL COMMENT '活动名称',  
  `activity_address` varchar(255) DEFAULT NULL COMMENT '活动地址',  
  `activity_begin_time` datetime DEFAULT NULL COMMENT '活动开始时间',  
  `activity_end_time` datetime DEFAULT NULL COMMENT '活动结束时间',  
  `activity_type` int(20) DEFAULT NULL COMMENT '活动类型',  
  `top_status` int(2) DEFAULT '0' COMMENT '置顶状态1:是,0:否',  
  `added_time` datetime DEFAULT NULL COMMENT '添加时间',  
  `publisher` varchar(255) DEFAULT NULL COMMENT '发布者',  
  `publisher_id` int(20) DEFAULT NULL COMMENT '发布者ID',  
  `valid` int(20) DEFAULT NULL COMMENT '有效1:是,0:否',  
  PRIMARY KEY (`pkid`),  
  KEY `publisher_id` (`publisher_id`)  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='活动表';  

活动详情表:  
CREATE TABLE `activity_detail` (  
  `pkid` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',  
  `activity_id` int(20) DEFAULT NULL COMMENT '活动ID',  
  `register_begin_time` datetime DEFAULT NULL COMMENT '报名开始时间',  
  `register_end_time` datetime DEFAULT NULL COMMENT '报名结束时间',  
  `register_type` int(20) DEFAULT NULL COMMENT '签到方式1:二维码签到,',  
  `register_amount` int(20) DEFAULT '0' COMMENT '报名人数',  
  `register_max_amount` int(20) DEFAULT NULL COMMENT '最大报名人数',  
  `sign_amount` int(20) DEFAULT '0' COMMENT '签到人数',  
  `activity_content` varchar(255) DEFAULT NULL COMMENT '活动内容',  
  `activity_url` varchar(255) DEFAULT NULL COMMENT '活动url',  
  `qr_code` varchar(255) DEFAULT NULL COMMENT '二维码',  
  `valid` int(2) DEFAULT NULL COMMENT '有效1:是,0:否',  
  PRIMARY KEY (`pkid`),  
  KEY `activity_id` (`activity_id`)  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='活动详情表';  

用户表：  
CREATE TABLE `user` (  
  `pkid` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',  
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',  
  `password` varchar(255) DEFAULT NULL COMMENT '密码',  
  `is_admin` int(2) DEFAULT NULL COMMENT '是否管理员1:是,0:否',  
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',  
  `number` int(20) DEFAULT NULL COMMENT '一卡通号码',  
  `valid` int(2) DEFAULT NULL COMMENT '有效1:是,0:否',  
  PRIMARY KEY (`pkid`)  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';  

用户活动关联表：  
CREATE TABLE `user_activity` (  
  `pkid` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',  
  `user_id` int(20) DEFAULT NULL COMMENT '用户ID',  
  `activity_id` int(20) DEFAULT NULL COMMENT '活动ID',  
  `valid` int(2) DEFAULT NULL COMMENT '有效1:是,0:否',  
  PRIMARY KEY (`pkid`),  
  KEY `user_id` (`user_id`),  
  KEY `activity_id` (`activity_id`)  
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户活动关联表';  
