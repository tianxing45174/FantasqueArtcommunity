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

 Date: 26/06/2023 23:03:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `perm`;
CREATE TABLE `perm`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名',
  `perm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限标识符',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perm
-- ----------------------------
INSERT INTO `perm` VALUES (1, 'ManageUser', 'user:manage', '拥有管理所有用户权限');
INSERT INTO `perm` VALUES (2, 'CreateUser', 'user:create', '允许创建用户');
INSERT INTO `perm` VALUES (3, 'DeleteUser', 'user:delete:*', '允许注销所有用户');
INSERT INTO `perm` VALUES (4, 'UpdateUser', 'user:update:*', '允许修改用户所有信息');
INSERT INTO `perm` VALUES (5, 'SelectUser', 'user:select:*', '允许查看用户所有信息');
INSERT INTO `perm` VALUES (6, 'UpdateOwnUser', 'user:update:own', '允许修改个人信息');
INSERT INTO `perm` VALUES (7, 'DeleteOwnUser', 'user:delete:own', '允许删除个人信息');
INSERT INTO `perm` VALUES (8, 'ManageArtwork', 'artwork:manage', '拥有管理作品所有权限');
INSERT INTO `perm` VALUES (9, 'CreateArtwork', 'artwork:create', '允许上传作品');
INSERT INTO `perm` VALUES (10, 'DeleteArtwork', 'artwork:delete:*', '允许删除所有作品');
INSERT INTO `perm` VALUES (11, 'UpdateArtwork', 'artwork:update:*', '允许修改所有作品');
INSERT INTO `perm` VALUES (12, 'SelectArtwork', 'artwork:select:*', '允许查看所有作品');
INSERT INTO `perm` VALUES (13, 'UpdateOwnArtwork', 'artwork:update:own', '允许修改个人作品');
INSERT INTO `perm` VALUES (14, 'DeleteOwnArtwork', 'artwork:delete:own', '允许删除个人作品');
INSERT INTO `perm` VALUES (15, 'ManageComment', 'comment:manage', '拥有管理所有评论权限');
INSERT INTO `perm` VALUES (16, 'CreateComment', 'comment:create', '允许发表评论');
INSERT INTO `perm` VALUES (17, 'DeleteComment', 'comment:delete:*', '允许删除所有评论');
INSERT INTO `perm` VALUES (18, 'UpdateComment', 'comment:update:*', '允许修改所有评论');
INSERT INTO `perm` VALUES (19, 'SelectComment', 'comment:select:*', '允许查看所有评论');
INSERT INTO `perm` VALUES (20, 'DeleteOwnComment', 'comment:delete:own', '允许删除个人评论');
INSERT INTO `perm` VALUES (21, 'UpdateOwnComment', 'comment:update:own', '允许修改个人评论');
INSERT INTO `perm` VALUES (22, 'DeleteMyArtworkComment', 'comment:delete:myartwork', '允许删除个人作品评论');

SET FOREIGN_KEY_CHECKS = 1;
