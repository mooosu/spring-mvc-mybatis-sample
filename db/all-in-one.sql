/*
 Navicat Premium Data Transfer

 Source Server         : zqs@localhost
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost
 Source Database       : zqs_development

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : utf-8

 Date: 01/05/2013 22:59:21 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `apps`
-- ----------------------------
DROP TABLE IF EXISTS `apps`;
CREATE TABLE `apps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_key` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `app_secret` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_apps_on_app_key_and_app_secret` (`app_key`,`app_secret`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `blogs`
-- ----------------------------
DROP TABLE IF EXISTS `blogs`;
CREATE TABLE `blogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `db_infos`
-- ----------------------------
DROP TABLE IF EXISTS `db_infos`;
CREATE TABLE `db_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `host` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `port` int(11) NOT NULL,
  `user` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `schema_migrations`
-- ----------------------------
DROP TABLE IF EXISTS `schema_migrations`;
CREATE TABLE `schema_migrations` (
  `version` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  UNIQUE KEY `unique_schema_migrations` (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `shiro_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `shiro_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`,`permission`),
  CONSTRAINT `fk_shiro_role_id` FOREIGN KEY (`role_id`) REFERENCES `shiro_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `shiro_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_sequence`;
CREATE TABLE `shiro_sequence` (
  `seq_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `seq_count` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `shiro_user`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `salt` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Table structure for `shiro_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_shiro_user_role_role_id` (`role_id`),
  CONSTRAINT `fk_shiro_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `shiro_role` (`id`),
  CONSTRAINT `fk_shiro_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `shiro_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO shiro_sequence (seq_name, seq_count) VALUES ('shiro_user_seq', 0);
INSERT INTO shiro_sequence (seq_name, seq_count) VALUES ('shiro_role_seq', 0);
INSERT INTO shiro_user (username, password, salt, email, created_at) VALUES ('TestUser', 'M1IFzumVt5cZznXtuE7uBS5xFE62vpcQY939F12ZTGQuJS9/vrnGKOiTu+cJGDEZO1XfJQYATVLO7qQTDuiCfA==', 'Cv2YXgmaudkMcw0/10T0jw==', 'TestUser@test.com', CURDATE()); 
INSERT INTO shiro_role (description, name) VALUES ('Test Role', 'Test');
INSERT INTO shiro_role_permission (role_id, permission) VALUES ( (SELECT id FROM shiro_role where name = 'Test' ), 'read');
INSERT INTO shiro_user_role (user_id, role_id) VALUES ((SELECT id FROM shiro_user where username = 'TestUser' ), (SELECT id FROM shiro_role where name = 'Test' ));

