CREATE TABLE `user_auth` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `user_info_id` INT NOT NULL COMMENT '用户信息id',
  `auth_type` VARCHAR(30) NOT NULL COMMENT '用户认证类型',
  `username` VARCHAR(30) NOT NULL COMMENT '用户名',
  `password` VARCHAR(30) NOT NULL COMMENT '密码'
) COMMENT '用户认证表';

CREATE TABLE `user_info` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `nickname` VARCHAR(30) NOT NULL COMMENT '昵称',
  `sex` CHAR(1) NOT NULL DEFAULT 'm' COMMENT '性别',
  `birthday` DATE COMMENT '生日',
  `address` VARCHAR(100) COMMENT '住址',
  `avatar_url` VARCHAR(100) COMMENT '头像url',
  `intro` VARCHAR(200) COMMENT '简介'
) COMMENT '用户信息表';
