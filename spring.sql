/*
 Navicat MySQL Data Transfer

 Source Server         : 1234
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 01/06/2023 11:00:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '开发部', 101);
INSERT INTO `department` VALUES (2, '测试部', 102);
INSERT INTO `department` VALUES (3, '产品部', 103);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int NULL DEFAULT NULL,
  `dep_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 26, '男', '李强', 1001, 1);
INSERT INTO `employee` VALUES (2, 25, '女', '陈蕊', 1003, 2);
INSERT INTO `employee` VALUES (3, 25, '男', '赵阳', 1004, 3);
INSERT INTO `employee` VALUES (4, 24, '男', '周建', 1005, 2);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'employee', '员工管理');
INSERT INTO `permission` VALUES (2, 'department', '部门管理');
INSERT INTO `permission` VALUES (3, 'sysUser', '用户管理');
INSERT INTO `permission` VALUES (4, 'sysRole', '角色管理');
INSERT INTO `permission` VALUES (5, 'sysPermission', '权限管理');
INSERT INTO `permission` VALUES (6, 'common', '通用权限');

-- ----------------------------
-- Table structure for r_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `r_role_permission`;
CREATE TABLE `r_role_permission`  (
  `r_id` int NOT NULL,
  `p_id` int NOT NULL,
  UNIQUE INDEX `UKkv0n5oaq3qj97a8x19d4inuj4`(`r_id`, `p_id`) USING BTREE,
  INDEX `FKhaca8pvellcle7vskde3o1c1g`(`p_id`) USING BTREE,
  CONSTRAINT `FKhaca8pvellcle7vskde3o1c1g` FOREIGN KEY (`p_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKoq494xr5wlce206pei4u90qwb` FOREIGN KEY (`r_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of r_role_permission
-- ----------------------------
INSERT INTO `r_role_permission` VALUES (1, 1);
INSERT INTO `r_role_permission` VALUES (2, 1);
INSERT INTO `r_role_permission` VALUES (3, 1);
INSERT INTO `r_role_permission` VALUES (1, 2);
INSERT INTO `r_role_permission` VALUES (2, 2);
INSERT INTO `r_role_permission` VALUES (1, 3);
INSERT INTO `r_role_permission` VALUES (1, 4);
INSERT INTO `r_role_permission` VALUES (1, 5);
INSERT INTO `r_role_permission` VALUES (1, 6);
INSERT INTO `r_role_permission` VALUES (2, 6);
INSERT INTO `r_role_permission` VALUES (3, 6);

-- ----------------------------
-- Table structure for r_user_role
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role`  (
  `u_id` int NOT NULL,
  `r_id` int NOT NULL,
  UNIQUE INDEX `UKjf1ltyjy22qrcnoosqfefvati`(`u_id`, `r_id`) USING BTREE,
  INDEX `FKqx1ufwg7tc4cvm6m6yakywlv`(`r_id`) USING BTREE,
  CONSTRAINT `FK5nt76v8rt7hy8v77fk0oocg7o` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqx1ufwg7tc4cvm6m6yakywlv` FOREIGN KEY (`r_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES (5, 1);
INSERT INTO `r_user_role` VALUES (6, 2);
INSERT INTO `r_user_role` VALUES (7, 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_ADMIN', '管理员');
INSERT INTO `role` VALUES (2, 'ROLE_MANAGER', '经理');
INSERT INTO `role` VALUES (3, 'ROLE_EMPLOYEE', '员工');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'gu', '21', '2019-12-12');
INSERT INTO `student` VALUES (2, 'gu', '22', '2002-12-12');

-- ----------------------------
-- Table structure for table_department
-- ----------------------------
DROP TABLE IF EXISTS `table_department`;
CREATE TABLE `table_department`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_department
-- ----------------------------
INSERT INTO `table_department` VALUES (1, 101, '开发部');
INSERT INTO `table_department` VALUES (2, 102, '测试部');
INSERT INTO `table_department` VALUES (3, 103, '产品部');
INSERT INTO `table_department` VALUES (4, 99, '测试的');

-- ----------------------------
-- Table structure for table_employee
-- ----------------------------
DROP TABLE IF EXISTS `table_employee`;
CREATE TABLE `table_employee`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `dep_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of table_employee
-- ----------------------------
INSERT INTO `table_employee` VALUES (1, 1001, '李强', '男', 26, 1);
INSERT INTO `table_employee` VALUES (2, 1003, '陈蕊', '女', 25, 2);
INSERT INTO `table_employee` VALUES (3, 1004, '赵阳', '男', 25, 3);
INSERT INTO `table_employee` VALUES (4, 1005, '周建', '男', 24, 2);
INSERT INTO `table_employee` VALUES (15, 1022, '沙发萨福', '女', 1022, 1);
INSERT INTO `table_employee` VALUES (17, 1009, 'tom是', '男', 1009, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, '$2a$10$tOog08665kiLkPp4WOoFvOrGHepZ0t.1ZS4.Qrot.V57gzg7DfucG', 'admin');
INSERT INTO `user` VALUES (6, '$2a$10$nLNSZDvSM.3Li486eGk.Ue88ohTWdeHvoOlo/hVLSymd4tuErTVW6', 'tom');
INSERT INTO `user` VALUES (7, '$2a$10$UPJHuwTS48BCX59/iuxBOeiUPf969TeLXLnpyMM2EkHPxVXqr9A4i', 'jerry');

SET FOREIGN_KEY_CHECKS = 1;
