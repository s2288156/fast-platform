CREATE TABLE `member` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `certificate_no` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `out_member_no` varchar(32) DEFAULT NULL COMMENT '外部会员号',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `pay_member_no` varchar(32) DEFAULT NULL COMMENT '支付会员号',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别，0 - 未知，1 - 男，2 - 女',
  `uid` varchar(32) DEFAULT NULL COMMENT '用户app_uid',
  `front_channel` tinyint(4) unsigned DEFAULT NULL COMMENT '前台渠道, 0 - 汴捷办APP, 1 - 微信公众号, 2 - 支付宝小程序, 3 - 线下渠道',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='会员注册信息表，为各渠道绑定统一支付会员号';
