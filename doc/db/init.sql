/*
 Navicat Premium Data Transfer

 Source Server         : 本机-MySQL-5.7.28
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : vehicle-info-management

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 10/06/2020 17:30:55
*/
DROP database IF EXISTS `vehicle-info-management`;
create database `vehicle-info-management` default character set utf8mb4 collate utf8mb4_general_ci;

USE vehicle-info-management;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_notification
-- ----------------------------
DROP TABLE IF EXISTS `b_notification`;
CREATE TABLE `b_notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` text NOT NULL COMMENT '通知内容',
  `belong_to_user` varchar(32) NOT NULL COMMENT '接收人',
  `read_status` tinyint(1) NOT NULL COMMENT '状态 0未读,1已读',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='通知信息表';

-- ----------------------------
-- Records of b_notification
-- ----------------------------
BEGIN;
INSERT INTO `b_notification` VALUES (1, '待办通知：客户姓名：李四，车型：宝马X3，类型：车检到期、车险到期，距离车检到期天数：4，距离车险到期天数：5，联系电话：18765432341。', 'admin', 0, 'admin', '2020-06-10 18:00:00', NULL, '2020-06-10 18:00:00');
INSERT INTO `b_notification` VALUES (2, '待办通知：客户姓名：张三，车型：奥迪A4L，类型：车检到期，距离车检到期天数：5，联系电话：15598765876。', 'admin', 0, 'admin', '2020-06-10 18:00:00', NULL, '2020-06-10 18:00:00');
INSERT INTO `b_notification` VALUES (3, '待办通知：客户姓名：王五，车型：大众宝来，类型：车险到期，距离车险到期天数：3，联系电话：15559876342。', 'admin', 0, 'admin', '2020-06-10 18:00:00', NULL, '2020-06-10 18:00:00');
COMMIT;

-- ----------------------------
-- Table structure for b_vehicle_register_info
-- ----------------------------
DROP TABLE IF EXISTS `b_vehicle_register_info`;
CREATE TABLE `b_vehicle_register_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `customer_real_name` varchar(32) NOT NULL COMMENT '客户姓名',
  `vehicle_info` varchar(64) NOT NULL COMMENT '车辆信息',
  `customer_phone_number` varchar(11) NOT NULL COMMENT '客户电话',
  `last_inspection_day` date DEFAULT NULL COMMENT '上次车检时间',
  `insurance_expiry_day` date DEFAULT NULL COMMENT '车险到期时间',
  `agent_user` varchar(32) NOT NULL COMMENT '代理人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_last_inspection_day` (`last_inspection_day`) USING BTREE,
  KEY `index_insurance_expiry_day` (`insurance_expiry_day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='车辆信息登记表';

-- ----------------------------
-- Records of b_vehicle_register_info
-- ----------------------------
BEGIN;
INSERT INTO `b_vehicle_register_info` VALUES (1, '张三', '奥迪A4L', '15598765876', '2019-06-17', '2020-06-30', 'admin', '', NULL, '2020-06-10 16:29:54', 'admin', '2020-06-10 17:21:14');
INSERT INTO `b_vehicle_register_info` VALUES (2, '李四', '宝马X3', '18765432341', '2019-06-16', '2020-06-16', 'admin', '', NULL, '2020-06-10 16:31:18', 'admin', '2020-06-10 17:22:21');
INSERT INTO `b_vehicle_register_info` VALUES (3, '王五', '大众宝来', '15559876342', '2020-04-23', '2020-06-14', 'admin', NULL, 'admin', '2020-06-10 16:32:29', NULL, '2020-06-10 16:32:29');
INSERT INTO `b_vehicle_register_info` VALUES (4, '345678', '2323232', '15974950068', '2017-01-01', '2019-01-01', 'admin', '12', NULL, '2020-06-11 01:56:41', 'admin', '2020-06-11 01:57:21');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(32) NOT NULL COMMENT '姓名',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `index_account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '15559876543', 'admin@xx.com', NULL, '2020-06-10 01:30:52', NULL, '2020-06-10 15:39:27');
INSERT INTO `sys_user` VALUES (2, 'ycx315', '161ebd7d45089b3446ee4e0d86dbcf92', '232', '15974950068', 'ycx.bn.cn@qq.com', 'admin', '2020-06-11 01:54:38', NULL, '2020-06-11 01:54:38');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_group
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_group`;
CREATE TABLE `xxl_job_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(64) NOT NULL COMMENT '执行器AppName',
  `title` varchar(12) NOT NULL COMMENT '执行器名称',
  `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
  `address_list` varchar(512) DEFAULT NULL COMMENT '执行器地址列表，多地址逗号分隔',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_group
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_group` VALUES (2, 'vehicle-management-service', '车辆信息管理服务', 0, 'http://172.18.120.171:9988/,http://172.18.120.171:9989/');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_info
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_info`;
CREATE TABLE `xxl_job_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_cron` varchar(128) NOT NULL COMMENT '任务执行CRON',
  `job_desc` varchar(255) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `author` varchar(64) DEFAULT NULL COMMENT '作者',
  `alarm_email` varchar(255) DEFAULT NULL COMMENT '报警邮件',
  `executor_route_strategy` varchar(50) DEFAULT NULL COMMENT '执行器路由策略',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_block_strategy` varchar(50) DEFAULT NULL COMMENT '阻塞处理策略',
  `executor_timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `glue_type` varchar(50) NOT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) DEFAULT NULL COMMENT 'GLUE备注',
  `glue_updatetime` datetime DEFAULT NULL COMMENT 'GLUE更新时间',
  `child_jobid` varchar(255) DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
  `trigger_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度状态：0-停止，1-运行',
  `trigger_last_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
  `trigger_next_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_info
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_info` VALUES (3, 2, '0 0 2 * * ?', '车辆信息任务', '2020-06-09 17:32:29', '2020-06-10 16:36:22', 'admin', '', 'ROUND', 'vehicleInfoJobHandler', '', 'SERIAL_EXECUTION', 300, 3, 'BEAN', '', 'GLUE代码初始化', '2020-06-09 17:32:29', '', 1, 1591812000000, 1591898400000);
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_lock
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_lock`;
CREATE TABLE `xxl_job_lock` (
  `lock_name` varchar(50) NOT NULL COMMENT '锁名称',
  PRIMARY KEY (`lock_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_lock
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_lock` VALUES ('schedule_lock');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_log
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_log`;
CREATE TABLE `xxl_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `executor_address` varchar(255) DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_sharding_param` varchar(20) DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `trigger_time` datetime DEFAULT NULL COMMENT '调度-时间',
  `trigger_code` int(11) NOT NULL COMMENT '调度-结果',
  `trigger_msg` text COMMENT '调度-日志',
  `handle_time` datetime DEFAULT NULL COMMENT '执行-时间',
  `handle_code` int(11) NOT NULL COMMENT '执行-状态',
  `handle_msg` text COMMENT '执行-日志',
  `alarm_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `I_trigger_time` (`trigger_time`) USING BTREE,
  KEY `I_handle_code` (`handle_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_log
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_log` VALUES (9, 2, 3, 'http://172.18.120.171:9988/', 'vehicleInfoJobHandler', '', NULL, 3, '2020-06-10 13:00:00', 200, '任务触发类型：手动触发<br>调度机器：172.17.0.2<br>执行器-注册方式：自动注册<br>执行器-地址列表：[http://172.18.120.171:9988/]<br>路由策略：轮询<br>阻塞处理策略：单机串行<br>任务超时时间：300<br>失败重试次数：3<br><br><span style=\"color:#00c0ef;\" > >>>>>>>>>>>触发调度<<<<<<<<<<< </span><br>触发调度：<br>address：http://172.18.120.171:9988/<br>code：200<br>msg：null', '2020-06-10 13:00:00', 200, '', 0);
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_log_report
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_log_report`;
CREATE TABLE `xxl_job_log_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trigger_day` datetime DEFAULT NULL COMMENT '调度-时间',
  `running_count` int(11) NOT NULL DEFAULT '0' COMMENT '运行中-日志数量',
  `suc_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行成功-日志数量',
  `fail_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行失败-日志数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `i_trigger_day` (`trigger_day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_log_report
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_log_report` VALUES (1, '2020-06-09 00:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (2, '2020-06-08 00:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (3, '2020-06-07 00:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (4, '2020-06-10 00:00:00', 0, 1, 0);
INSERT INTO `xxl_job_log_report` VALUES (5, '2020-06-09 16:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (6, '2020-06-08 16:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (7, '2020-06-07 16:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (8, '2020-06-10 16:00:00', 0, 3, 0);
INSERT INTO `xxl_job_log_report` VALUES (9, '2020-06-10 11:00:00', 0, 1, 0);
INSERT INTO `xxl_job_log_report` VALUES (10, '2020-06-09 11:00:00', 0, 0, 0);
INSERT INTO `xxl_job_log_report` VALUES (11, '2020-06-08 11:00:00', 0, 0, 0);
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_logglue
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_logglue`;
CREATE TABLE `xxl_job_logglue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `glue_type` varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) NOT NULL COMMENT 'GLUE备注',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for xxl_job_registry
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_registry`;
CREATE TABLE `xxl_job_registry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registry_group` varchar(50) NOT NULL,
  `registry_key` varchar(255) NOT NULL,
  `registry_value` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `i_g_k_v` (`registry_group`,`registry_key`,`registry_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_registry
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_registry` VALUES (4, 'EXECUTOR', 'vehicle-management-service', 'http://172.18.120.171:9988/', '2020-06-10 21:04:06');
INSERT INTO `xxl_job_registry` VALUES (5, 'EXECUTOR', 'vehicle-management-service', 'http://172.18.120.171:9989/', '2020-06-10 21:04:28');
COMMIT;

-- ----------------------------
-- Table structure for xxl_job_user
-- ----------------------------
DROP TABLE IF EXISTS `xxl_job_user`;
CREATE TABLE `xxl_job_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `role` tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xxl_job_user
-- ----------------------------
BEGIN;
INSERT INTO `xxl_job_user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
