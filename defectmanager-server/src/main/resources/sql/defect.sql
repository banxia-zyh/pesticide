CREATE TABLE `defect` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `submit_user_id` INT NOT NULL COMMENT '提交用户id',
  `submit_time` DATETIME NOT NULL COMMENT '提交时间',
  `title` VARCHAR(60) NOT NULL COMMENT '缺陷标题',
  `description` VARCHAR(500) NOT NULL COMMENT '缺陷描述',
  `defect_state` VARCHAR(30) NOT NULL COMMENT '缺陷状态',
  `project_id` INT NOT NULL COMMENT '所属项目id',
  `resolve_user_id` INT NOT NULL COMMENT '处理用户id'
) COMMENT '缺陷表';

CREATE TABLE `defect_modification` (
  `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
  `defect_id` INT NOT NULL COMMENT '缺陷id',
  `modify_user_id` INT NOT NULL COMMENT '修改用户id',
  `modify_description` VARCHAR(300) NOT NULL COMMENT '修改描述',
  `result_state` INT NOT NULL COMMENT '结果缺陷状态'
) COMMENT '缺陷修改表';
