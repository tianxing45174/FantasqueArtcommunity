/*
 Navicat Premium Data Transfer

 Source Server         : guli@175.178.14.144
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : 175.178.14.144:3306
 Source Schema         : work

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 26/06/2023 23:03:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_perm
-- ----------------------------
DROP TABLE IF EXISTS `role_perm`;
CREATE TABLE `role_perm`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleid` int NOT NULL COMMENT '角色id',
  `permid` int NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_perm
-- ----------------------------
INSERT INTO `role_perm` VALUES (1, 1, 1);
INSERT INTO `role_perm` VALUES (2, 1, 8);
INSERT INTO `role_perm` VALUES (3, 1, 15);
INSERT INTO `role_perm` VALUES (4, 2, 2);
INSERT INTO `role_perm` VALUES (5, 2, 5);
INSERT INTO `role_perm` VALUES (6, 2, 6);
INSERT INTO `role_perm` VALUES (7, 2, 7);
INSERT INTO `role_perm` VALUES (8, 2, 16);
INSERT INTO `role_perm` VALUES (9, 2, 20);
INSERT INTO `role_perm` VALUES (10, 2, 21);
INSERT INTO `role_perm` VALUES (11, 3, 5);
INSERT INTO `role_perm` VALUES (12, 3, 6);
INSERT INTO `role_perm` VALUES (13, 3, 7);
INSERT INTO `role_perm` VALUES (14, 3, 12);
INSERT INTO `role_perm` VALUES (15, 3, 16);
INSERT INTO `role_perm` VALUES (16, 3, 19);
INSERT INTO `role_perm` VALUES (17, 3, 20);
INSERT INTO `role_perm` VALUES (18, 3, 21);
INSERT INTO `role_perm` VALUES (19, 2, 22);

SET FOREIGN_KEY_CHECKS = 1;
