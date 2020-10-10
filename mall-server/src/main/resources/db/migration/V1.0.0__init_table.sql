CREATE TABLE `t_product`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(255) NULL COMMENT '名称',
  `price` decimal(10, 2) NULL COMMENT '单价',
  `sales` int(10) UNSIGNED ZEROFILL NULL COMMENT '销量',
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_product_specs_attribute`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `product_id` varchar(32) NULL,
  `attribute` varchar(32) NULL COMMENT '属性',
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_product_specs_value`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `specs_key_id` varchar(32) NULL,
  `value` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_product_stock`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `product_id` varchar(32) NULL,
  `product_specs` varchar(1024) NOT NULL COMMENT '商品规格',
  `stock` int(10) ZEROFILL NULL COMMENT '库存量',
  `price` decimal(10, 2) NOT NULL COMMENT '单价',
  `sort` tinyint NULL COMMENT '排序',
  `pic_album` varchar(512) NULL COMMENT '图片册，逗号分隔，最多5张',
  `is_default` tinyint(1) UNSIGNED NULL COMMENT '是否为默认，0 - 否，1 - 是',
  PRIMARY KEY (`id`)
);

