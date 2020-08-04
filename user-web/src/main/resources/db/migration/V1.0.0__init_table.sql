CREATE TABLE `user`  (
  `id` varchar(32) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(32) NULL,
  `email` varchar(255) NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(15) NULL,
  `name` varchar(45) NULL,
  `age` tinyint(1) UNSIGNED NULL,
  `sex` tinyint(1) UNSIGNED NULL,
  PRIMARY KEY (`id`)
);

