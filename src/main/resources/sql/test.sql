/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2019-06-30 21:52:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `note` varchar(24) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('67', 'jjjj2', '1', 'ewewewew');
INSERT INTO `user` VALUES ('69', 'ljx', null, null);
INSERT INTO `user` VALUES ('70', 'ppp', '1', 'kkk');
INSERT INTO `user` VALUES ('71', 'ppp1', '2', 'kkk1');
INSERT INTO `user` VALUES ('72', 'ppp1', '2', 'kkk1');

-- ----------------------------
-- Table structure for `user1`
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user1
-- ----------------------------
