/*
Navicat MySQL Data Transfer

Source Server         : ZZ-MyLocalhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : arch1

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-10-29 18:23:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_servers
-- ----------------------------
DROP TABLE IF EXISTS `tbl_servers`;
CREATE TABLE `tbl_servers` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(10) DEFAULT NULL COMMENT '服务ID',
  `ip` varchar(20) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `repName` varchar(100) DEFAULT NULL COMMENT '库名',
  `isMain` int(11) DEFAULT NULL,
  `canRead` int(11) DEFAULT NULL,
  `canWrite` int(11) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `equalsServers` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_servers
-- ----------------------------
INSERT INTO `tbl_servers` VALUES ('1', 's1', '192.168.1.101', '3306', 'arch1', '1', '1', '1', '1', '4,5');
INSERT INTO `tbl_servers` VALUES ('2', 's2', '192.168.1.101', '3307', 'arch1', '1', '1', '1', '1', null);
INSERT INTO `tbl_servers` VALUES ('3', 's3', '192.168.1.101', '3308', 'arch1', '1', '1', '1', '1', null);

-- ----------------------------
-- Table structure for tbl_sharddetails
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sharddetails`;
CREATE TABLE `tbl_sharddetails` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` varchar(100) DEFAULT NULL,
  `serverUuid` int(11) DEFAULT NULL,
  `idBegin` int(11) DEFAULT NULL,
  `idEnd` int(11) DEFAULT NULL,
  `modValue` varchar(100) DEFAULT NULL,
  `shardTblName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_sharddetails
-- ----------------------------
INSERT INTO `tbl_sharddetails` VALUES ('1', 'g1', '1', '1', '50', '0', 'tbl_user_0');
INSERT INTO `tbl_sharddetails` VALUES ('2', 'g1', '1', '1', '50', '1', 'tbl_user_1');
INSERT INTO `tbl_sharddetails` VALUES ('3', 'g1', '2', '51', '100', '0,1', 'tbl_user');
INSERT INTO `tbl_sharddetails` VALUES ('4', 'g2', '3', '101', '1000', '0', 'tbl_user3');
INSERT INTO `tbl_sharddetails` VALUES ('5', 'g2', '3', '101', '1000', '1,2', 'tbl_user4');

-- ----------------------------
-- Table structure for tbl_shards
-- ----------------------------
DROP TABLE IF EXISTS `tbl_shards`;
CREATE TABLE `tbl_shards` (
  `uuid` int(11) NOT NULL AUTO_INCREMENT,
  `tblName` varchar(100) DEFAULT NULL,
  `idBegin` int(11) DEFAULT NULL,
  `idEnd` int(11) DEFAULT NULL,
  `groupId` varchar(20) DEFAULT NULL,
  `modNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_shards
-- ----------------------------
INSERT INTO `tbl_shards` VALUES ('1', 'tbl_user', '1', '100', 'g1', '2');
INSERT INTO `tbl_shards` VALUES ('2', 'tbl_user', '101', '1000', 'g2', '3');

-- ----------------------------
-- Table structure for tbl_user_0
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_0`;
CREATE TABLE `tbl_user_0` (
  `uuid` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_user_0
-- ----------------------------
INSERT INTO `tbl_user_0` VALUES ('12', 'name12');

-- ----------------------------
-- Table structure for tbl_user_1
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_1`;
CREATE TABLE `tbl_user_1` (
  `uuid` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_user_1
-- ----------------------------
INSERT INTO `tbl_user_1` VALUES ('11', 'name11');
SET FOREIGN_KEY_CHECKS=1;
