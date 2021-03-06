/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : mygame

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-02-20 22:03:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `kind`
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `khp` int(11) NOT NULL,
  `kwg` int(11) NOT NULL,
  `kwf` int(11) NOT NULL,
  `ktg` int(11) NOT NULL,
  `ktf` int(11) NOT NULL,
  `ksd` int(11) NOT NULL,
  `imgL` varchar(30) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `shuxing` varchar(30) CHARACTER SET utf8 NOT NULL,
  `skill1` int(11) DEFAULT NULL,
  `skillpp1` int(11) DEFAULT NULL,
  `skill2` int(11) DEFAULT NULL,
  `skillpp2` int(11) DEFAULT NULL,
  `skill3` int(11) DEFAULT NULL,
  `skillpp3` int(11) DEFAULT NULL,
  `skill4` int(11) DEFAULT NULL,
  `skillpp4` int(11) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '41', '84', '45', '50', '50', '50', 'img/147.gif', '迷你龙', '龙', '35', '20', '43', '30', '86', '20', null, null);
INSERT INTO `kind` VALUES ('2', '45', '49', '49', '65', '65', '45', 'img/1.gif', '妙蛙种子', '草', '33', '35', '45', '30', null, null, null, null);
INSERT INTO `kind` VALUES ('3', '39', '52', '43', '60', '50', '65', 'img/4.gif', '小火龙', '火', '10', '40', '45', '30', null, null, null, null);
INSERT INTO `kind` VALUES ('4', '44', '48', '65', '50', '64', '43', 'img/7.gif', '杰尼龟', '水', '33', '35', '39', '30', null, null, null, null);

-- ----------------------------
-- Table structure for `pets`
-- ----------------------------
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `khp` int(11) NOT NULL,
  `kwg` int(11) NOT NULL,
  `kwf` int(11) NOT NULL,
  `ktg` int(11) NOT NULL,
  `ktf` int(11) NOT NULL,
  `ksd` int(11) NOT NULL,
  `ohp` int(11) NOT NULL,
  `owg` int(11) NOT NULL,
  `owf` int(11) NOT NULL,
  `otg` int(11) NOT NULL,
  `otf` int(11) NOT NULL,
  `osd` int(11) NOT NULL,
  `rhp` int(11) NOT NULL,
  `rwg` int(11) NOT NULL,
  `rwf` int(11) NOT NULL,
  `rtg` int(11) NOT NULL,
  `rtf` int(11) NOT NULL,
  `rsd` int(11) NOT NULL,
  `lv` int(11) NOT NULL,
  `pinzhi` varchar(30) NOT NULL,
  `imgL` varchar(30) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `shuxing` varchar(30) CHARACTER SET utf8 NOT NULL,
  `skill1` int(11) DEFAULT NULL,
  `skillpp1` int(11) DEFAULT NULL,
  `skill2` int(11) DEFAULT NULL,
  `skillpp2` int(11) DEFAULT NULL,
  `skill3` int(11) DEFAULT NULL,
  `skillpp3` int(11) DEFAULT NULL,
  `skill4` int(11) DEFAULT NULL,
  `skillpp4` int(11) DEFAULT NULL,
  `bhp` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `expMax` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `ownerName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pets
-- ----------------------------
INSERT INTO `pets` VALUES ('275', '45', '49', '49', '65', '65', '45', '17', '28', '28', '24', '7', '31', '16', '17', '17', '17', '15', '18', '5', 'A', 'img/1.gif', '妙蛙种子', '草', '33', '35', '45', '30', null, null, null, null, '0', '0', '100', '1', '唱别久悲不成悲');
INSERT INTO `pets` VALUES ('279', '39', '52', '43', '60', '50', '65', '11', '9', '7', '7', '18', '19', '16', '15', '15', '15', '16', '16', '5', 'D', 'img/4.gif', '小火龙', '火', '10', '40', '45', '30', null, null, null, null, '16', '0', '100', '1', '唱别久悲不成悲');
INSERT INTO `pets` VALUES ('280', '44', '48', '65', '50', '64', '43', '5', '5', '18', '14', '19', '27', '15', '15', '16', '16', '16', '17', '5', 'D', 'img/7.gif', '杰尼龟', '水', '33', '35', '39', '30', null, null, null, null, '15', '0', '100', '3', '留灵修兮憺忘归');
INSERT INTO `pets` VALUES ('281', '39', '52', '43', '60', '50', '65', '28', '8', '9', '20', '28', '8', '17', '15', '15', '17', '17', '15', '5', 'C', 'img/4.gif', '小火龙', '火', '10', '40', '45', '30', null, null, null, null, '17', '0', '100', '3', '留灵修兮憺忘归');
INSERT INTO `pets` VALUES ('282', '44', '48', '65', '50', '64', '43', '17', '4', '9', '25', '4', '6', '16', '15', '15', '17', '15', '15', '5', 'D', 'img/7.gif', '杰尼龟', '水', '33', '35', '39', '30', null, null, null, null, '16', '0', '100', '1', '野生');
INSERT INTO `pets` VALUES ('283', '41', '84', '45', '50', '50', '50', '3', '25', '9', '21', '31', '26', '15', '17', '15', '17', '18', '17', '5', 'B', 'img/147.gif', '迷你龙', '龙', '35', '20', '43', '30', '86', '20', null, null, '15', '0', '100', '1', '唱别久悲不成悲');
INSERT INTO `pets` VALUES ('284', '39', '52', '43', '60', '50', '65', '23', '19', '7', '13', '13', '24', '17', '16', '15', '16', '16', '17', '5', 'C', 'img/4.gif', '小火龙', '火', '10', '40', '45', '30', null, null, null, null, '17', '0', '100', '2', '野生');
INSERT INTO `pets` VALUES ('285', '41', '84', '45', '50', '50', '50', '23', '5', '8', '13', '7', '11', '17', '15', '15', '16', '15', '16', '5', 'D', 'img/147.gif', '迷你龙', '龙', '35', '20', '43', '30', '86', '20', null, null, '17', '0', '100', '1', '唱别久悲不成悲');
INSERT INTO `pets` VALUES ('286', '45', '49', '49', '65', '65', '45', '21', '9', '13', '26', '9', '0', '17', '15', '16', '17', '15', '15', '5', 'D', 'img/1.gif', '妙蛙种子', '草', '33', '35', '45', '30', null, null, null, null, '12', '0', '100', '1', '唱别久悲不成悲');
INSERT INTO `pets` VALUES ('287', '39', '52', '43', '60', '50', '65', '3', '7', '5', '16', '31', '29', '15', '15', '15', '16', '18', '17', '5', 'C', 'img/4.gif', '小火龙', '火', '10', '40', '45', '30', null, null, null, null, '5', '0', '100', '2', '野生');

-- ----------------------------
-- Table structure for `skill`
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `skillName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `desciption` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `kind` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pp` int(11) DEFAULT NULL,
  `shuxing` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `mingzhong` int(11) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES ('1', '拍打', '40', null, 'w', '35', '普', '100');
INSERT INTO `skill` VALUES ('2', '空手刃', '50', null, 'w', '25', '斗', '100');
INSERT INTO `skill` VALUES ('3', '往复拍打', null, null, null, null, null, null);
INSERT INTO `skill` VALUES ('4', '连续拳击', null, null, null, null, null, null);
INSERT INTO `skill` VALUES ('5', '百万拳击', '80', null, 'w', '20', '普', '85');
INSERT INTO `skill` VALUES ('6', '聚宝功', '40', null, 'w', '20', '普', '100');
INSERT INTO `skill` VALUES ('10', '抓', '40', null, 'w', '35', '普', '100');
INSERT INTO `skill` VALUES ('33', '撞击', '50', null, 'w', '35', '普', '100');
INSERT INTO `skill` VALUES ('35', '卷紧', '15', null, 'w', '20', '普', '90');
INSERT INTO `skill` VALUES ('39', '甩尾', '50', null, 'w', '30', '普', '100');
INSERT INTO `skill` VALUES ('43', '瞪眼', '50', null, 'w', '30', '普', '100');
INSERT INTO `skill` VALUES ('45', '叫声', '50', null, 'w', '40', '普', '100');
INSERT INTO `skill` VALUES ('86', '电磁波', '60', null, 't', '20', '电', '100');

-- ----------------------------
-- Table structure for `skill_copy`
-- ----------------------------
DROP TABLE IF EXISTS `skill_copy`;
CREATE TABLE `skill_copy` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `skillName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `desciption` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `kind` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pp` int(11) DEFAULT NULL,
  `shuxing` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `mingzhong` int(11) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of skill_copy
-- ----------------------------
INSERT INTO `skill_copy` VALUES ('1', '拍打', '40', null, 'w', '35', '普', '100');
INSERT INTO `skill_copy` VALUES ('2', '空手刃', '50', null, 'w', '25', '斗', '100');
INSERT INTO `skill_copy` VALUES ('3', '往复拍打', null, null, null, null, null, null);
INSERT INTO `skill_copy` VALUES ('4', '连续拳击', null, null, null, null, null, null);
INSERT INTO `skill_copy` VALUES ('5', '百万拳击', '80', null, 'w', '20', '普', '85');
INSERT INTO `skill_copy` VALUES ('6', '聚宝功', '40', null, 'w', '20', '普', '100');
INSERT INTO `skill_copy` VALUES ('10', '抓', '40', null, 'w', '35', '普', '100');
INSERT INTO `skill_copy` VALUES ('33', '撞击', '50', null, 'w', '35', '普', '100');
INSERT INTO `skill_copy` VALUES ('35', '卷紧', '15', null, 'w', '20', '普', '90');
INSERT INTO `skill_copy` VALUES ('39', '甩尾', null, null, 'b', '30', '普', '100');
INSERT INTO `skill_copy` VALUES ('43', '瞪眼', null, null, 'b', '30', '普', '100');
INSERT INTO `skill_copy` VALUES ('45', '叫声', null, null, 'b', '40', '普', '100');
INSERT INTO `skill_copy` VALUES ('86', '电磁波', null, null, 'b', '20', '电', '100');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL DEFAULT '',
  `nickName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18861821884', 'ma1897', '唱别久悲不成悲');
INSERT INTO `user` VALUES ('2', 'random', '123', '野生');
INSERT INTO `user` VALUES ('3', '18861821883', 'ma1897', '留灵修兮憺忘归');
