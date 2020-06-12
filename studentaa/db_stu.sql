/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : db_stu

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-12-26 20:04:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `number` varchar(20) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('12345', '12345', '12345', '12345');
INSERT INTO `student` VALUES ('123456', '男', '李四', '2020-12-12');
INSERT INTO `student` VALUES ('324423', '男', '士大夫', '2020-12-12');
INSERT INTO `student` VALUES ('45372', '男', '离得近', '2020-12-12');
