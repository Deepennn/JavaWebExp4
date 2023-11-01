/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : loginuser

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 29/10/2023 08:34:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for detailedinfo
-- ----------------------------
DROP TABLE IF EXISTS `detailedinfo`;
CREATE TABLE `detailedinfo`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sexy` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `picturelocation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detailedinfo
-- ----------------------------
INSERT INTO `detailedinfo` VALUES ('u1', 19, 'male', 'E:/');
INSERT INTO `detailedinfo` VALUES ('u2', 1, 'male', 'E:/');
INSERT INTO `detailedinfo` VALUES ('u3', 1, 'male', 'E:/');
INSERT INTO `detailedinfo` VALUES ('u4', 1, 'male', 'E:/');
INSERT INTO `detailedinfo` VALUES ('u5', 1, 'male', 'E:/');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('abc', 'abc');
INSERT INTO `user` VALUES ('u1', 'p1');
INSERT INTO `user` VALUES ('u2', 'p2');
INSERT INTO `user` VALUES ('u3', 'p3');
INSERT INTO `user` VALUES ('u4', 'p4');
INSERT INTO `user` VALUES ('u5', 'p5');

SET FOREIGN_KEY_CHECKS = 1;
