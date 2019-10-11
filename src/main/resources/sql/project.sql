CREATE TABLE `project` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `name` VARCHAR(30) NOT NULL COMMENT '项目名称',
  `intro` VARCHAR(300) COMMENT '项目简介',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `manager_id` INT NOT NULL COMMENT '负责人id'
) COMMENT '项目表';

-- CREATE TABLE `project_module` (
--   `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
--   `name` VARCHAR(30) NOT NULL COMMENT '模块名称',
--   `intro` VARCHAR(300) DEFAULT NULL COMMENT '模块简介',
--   `create_time` DATETIME NOT NULL COMMENT '创建时间',
--   `manager_id` INT NOT NULL COMMENT '负责人id',
--   `project_id` INT NOT NULL COMMENT '所属项目id',
--   FOREIGN KEY (`manager_id`) REFERENCES `user_info`(`id`),
--   FOREIGN KEY (`project_id`) REFERENCES `project`(`id`)
-- ) COMMENT '项目模块表';

CREATE TABLE `project_personnel` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `user_id` INT NOT NULL COMMENT '用户id',
  `project_id` INT NOT NULL COMMENT '所属项目id',
  `role_type` VARCHAR(30) NOT NULL COMMENT '角色类型'
) COMMENT '项目人员表';
