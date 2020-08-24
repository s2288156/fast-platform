CREATE TABLE `t_permission`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(64) NULL,
  `description` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_role`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(64) NOT NULL COMMENT '角色名',
  `description` varchar(255) NULL COMMENT '详细说明',
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_role_permission`  (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `permission_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_role_id`(`role_id`) USING BTREE
);

CREATE TABLE `t_user`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(32) NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(255) NULL,
  `phone` varchar(15) NULL,
  `name` varchar(45) NULL,
  `age` tinyint(1) UNSIGNED NULL,
  `sex` tinyint(1) UNSIGNED NULL COMMENT '0-男，1-女',
  PRIMARY KEY (`id`),
  INDEX `idx_username`(`username`) USING BTREE,
  INDEX `idx_email`(`email`) USING BTREE,
  INDEX `idx_phone`(`phone`) USING BTREE
);

CREATE TABLE `t_user_role`  (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_user_id`(`user_id`) USING BTREE
);

