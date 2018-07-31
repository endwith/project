/*
Navicat MySQL Data Transfer

Source Server         : ptteng
Source Server Version : 50720
Source Host           : 118.126.113.248:3306
Source Database       : polyFinance-google

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-30 11:30:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for backstage_account
-- ----------------------------
DROP TABLE IF EXISTS `backstage_account`;
CREATE TABLE `backstage_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `admin_role` varchar(50) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(50) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  `status` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for history_product
-- ----------------------------
DROP TABLE IF EXISTS `history_product`;
CREATE TABLE `history_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product` varchar(255) DEFAULT NULL,
  `bank_card` varchar(255) DEFAULT NULL,
  `buyer` varchar(255) DEFAULT NULL,
  `buy_time` bigint(20) DEFAULT NULL,
  `arrive_time` bigint(20) DEFAULT NULL,
  `transaction_action` int(11) DEFAULT NULL,
  `transaction_amouont` decimal(20,2) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `expected_rate` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for information_manage
-- ----------------------------
DROP TABLE IF EXISTS `information_manage`;
CREATE TABLE `information_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `infor_id` varchar(20) DEFAULT NULL,
  `infor_title` varchar(50) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  `infor_status` int(20) DEFAULT NULL,
  `send_time` bigint(50) DEFAULT NULL,
  `infor_content` varchar(20000) DEFAULT NULL,
  `infor_picture` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for investment_contract
-- ----------------------------
DROP TABLE IF EXISTS `investment_contract`;
CREATE TABLE `investment_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `true_name` varchar(20) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `invest_amount` decimal(50,2) DEFAULT NULL,
  `income` decimal(20,2) DEFAULT NULL,
  `effective_time` bigint(50) DEFAULT NULL,
  `invalid_time` bigint(50) DEFAULT NULL,
  `status` int(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for matchs
-- ----------------------------
DROP TABLE IF EXISTS `matchs`;
CREATE TABLE `matchs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trade_id` bigint(20) DEFAULT NULL,
  `obl_id` bigint(20) DEFAULT NULL,
  `amount` decimal(50,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for message_relationship
-- ----------------------------
DROP TABLE IF EXISTS `message_relationship`;
CREATE TABLE `message_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `infor_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for module_manage
-- ----------------------------
DROP TABLE IF EXISTS `module_manage`;
CREATE TABLE `module_manage` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(255) NOT NULL,
  `parent_id` bigint(50) NOT NULL,
  `module_url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  `create_at` bigint(20) DEFAULT NULL,
  `modifier` varchar(255) DEFAULT NULL,
  `founder` varchar(255) DEFAULT NULL,
  `delete_status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for module_role_manage
-- ----------------------------
DROP TABLE IF EXISTS `module_role_manage`;
CREATE TABLE `module_role_manage` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `module_id` bigint(20) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for obligatory_right
-- ----------------------------
DROP TABLE IF EXISTS `obligatory_right`;
CREATE TABLE `obligatory_right` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(100) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `loan_sum` decimal(50,0) DEFAULT NULL,
  `loan_term` bigint(50) DEFAULT NULL,
  `loan_time` bigint(50) DEFAULT NULL,
  `repay_time` bigint(50) DEFAULT NULL,
  `matching_amount` decimal(50,0) DEFAULT NULL,
  `status` int(20) DEFAULT NULL,
  `corporate` varchar(20) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `expected_rate` decimal(50,2) DEFAULT NULL,
  `investment_cycle` int(20) DEFAULT NULL,
  `origin_money` decimal(50,2) DEFAULT NULL,
  `add_money` decimal(50,2) DEFAULT NULL,
  `introduce` varchar(1000) DEFAULT NULL,
  `return_interest` int(10) DEFAULT NULL,
  `repayment_date` bigint(50) DEFAULT NULL,
  `return_date` bigint(50) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `more_information` varchar(1000) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for product_recommend
-- ----------------------------
DROP TABLE IF EXISTS `product_recommend`;
CREATE TABLE `product_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product` varchar(50) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `intervals` int(10) DEFAULT NULL,
  `recommend_status` int(10) DEFAULT NULL,
  `banner_status` int(10) DEFAULT NULL,
  `push_time` bigint(10) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for role_manage
-- ----------------------------
DROP TABLE IF EXISTS `role_manage`;
CREATE TABLE `role_manage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) DEFAULT NULL,
  `founder` varchar(20) DEFAULT NULL,
  `create_at` bigint(50) DEFAULT NULL,
  `update_at` bigint(50) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  `authority` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sugge_content` varchar(500) DEFAULT NULL,
  `adviser` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `submit_time` bigint(50) DEFAULT NULL,
  `replier` varchar(20) DEFAULT NULL,
  `reply_content` varchar(500) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `reply_time` bigint(50) DEFAULT NULL,
  `user_id` bigint(50) DEFAULT NULL,
  `ready_status` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `investment_contract_id` bigint(20) DEFAULT NULL,
  `product` varchar(50) DEFAULT NULL,
  `purchaser` varchar(20) DEFAULT NULL,
  `buy_time` bigint(50) DEFAULT NULL,
  `delay_time` bigint(50) DEFAULT NULL,
  `expire_time` bigint(50) DEFAULT NULL,
  `to_be_matched` decimal(50,0) DEFAULT NULL,
  `purchase_amount` decimal(50,0) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `expected_rate` decimal(50,0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_card` varchar(50) DEFAULT NULL,
  `total_assets` decimal(50,2) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `salt` varchar(80) DEFAULT NULL,
  `true_name` varchar(50) DEFAULT NULL,
  `bank_card1` varchar(200) DEFAULT NULL,
  `bank_card2` varchar(200) DEFAULT NULL,
  `is_novice_gift` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `accumul_income` decimal(50,2) DEFAULT NULL,
  `create_at` bigint(20) DEFAULT NULL,
  `update_at` bigint(20) DEFAULT NULL,
  `modifier` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
