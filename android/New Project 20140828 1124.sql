-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema myproject
--

CREATE DATABASE IF NOT EXISTS myproject;
USE myproject;

--
-- Temporary table structure for view `actihuo`
--
DROP TABLE IF EXISTS `actihuo`;
DROP VIEW IF EXISTS `actihuo`;
CREATE TABLE `actihuo` (
  `actiid` int(11),
  `actiname` varchar(30),
  `userid` int(11),
  `nickname` varchar(30),
  `userpho` varchar(20),
  `rank` int(11),
  `sportid` int(11),
  `sportname` varchar(30),
  `actiusercount` int(11),
  `actibegtime` datetime,
  `actiendtime` datetime,
  `acticont` text,
  `actiplace` varchar(30),
  `actizancount` int(11),
  `actisettime` datetime
);

--
-- Temporary table structure for view `activity`
--
DROP TABLE IF EXISTS `activity`;
DROP VIEW IF EXISTS `activity`;
CREATE TABLE `activity` (
  `actiid` int(11),
  `actiname` varchar(30),
  `userid` int(11),
  `nickname` varchar(30),
  `userpho` varchar(20),
  `rank` int(11),
  `sportid` int(11),
  `sportname` varchar(30),
  `actiusercount` int(11),
  `actibegtime` datetime,
  `actiendtime` datetime,
  `acticont` text,
  `actiplace` varchar(30),
  `actizancount` int(11),
  `actisettime` datetime
);

--
-- Temporary table structure for view `peruser`
--
DROP TABLE IF EXISTS `peruser`;
DROP VIEW IF EXISTS `peruser`;
CREATE TABLE `peruser` (
  `userid` int(11),
  `account` varchar(30),
  `nickname` varchar(30),
  `gender` varchar(10),
  `colletreasid` varchar(400),
  `zanactiid` varchar(45),
  `actiid` varchar(45),
  `userpho` varchar(20),
  `sportlabel` varchar(100)
);

--
-- Temporary table structure for view `vdiary`
--
DROP TABLE IF EXISTS `vdiary`;
DROP VIEW IF EXISTS `vdiary`;
CREATE TABLE `vdiary` (
  `mdiaryid` int(11),
  `userid` int(11),
  `userpho` varchar(20),
  `sportlabel` varchar(100),
  `mdiarytime` datetime,
  `mdiaryname` varchar(30),
  `mdiarycont` text
);

--
-- Temporary table structure for view `vshuoshuo`
--
DROP TABLE IF EXISTS `vshuoshuo`;
DROP VIEW IF EXISTS `vshuoshuo`;
CREATE TABLE `vshuoshuo` (
  `staid` int(11),
  `userid` int(11),
  `nickname` varchar(30),
  `sportlabel` varchar(100),
  `userpho` varchar(20),
  `stacontext` text,
  `stapubtime` datetime
);

--
-- Definition of table `activityinvitation`
--

DROP TABLE IF EXISTS `activityinvitation`;
CREATE TABLE `activityinvitation` (
  `actiid` int(11) NOT NULL AUTO_INCREMENT,
  `sportid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `actiname` varchar(30) NOT NULL,
  `actibegtime` datetime NOT NULL,
  `actiissucc` tinyint(1) DEFAULT NULL,
  `actisettime` datetime NOT NULL,
  `actiusercount` int(11) DEFAULT NULL,
  `acticont` text NOT NULL,
  `actiplace` varchar(30) NOT NULL,
  `actiendtime` datetime NOT NULL,
  `actizancount` int(11) DEFAULT '0',
  PRIMARY KEY (`actiid`),
  KEY `FK_actisportid` (`sportid`),
  KEY `FK_actiuserid` (`userid`),
  CONSTRAINT `FK_actisportid` FOREIGN KEY (`sportid`) REFERENCES `sport` (`sportid`),
  CONSTRAINT `FK_actiuserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `activityinvitation`
--

/*!40000 ALTER TABLE `activityinvitation` DISABLE KEYS */;
INSERT INTO `activityinvitation` (`actiid`,`sportid`,`userid`,`actiname`,`actibegtime`,`actiissucc`,`actisettime`,`actiusercount`,`acticont`,`actiplace`,`actiendtime`,`actizancount`) VALUES 
 (1,1,1,'爱运动','2014-07-30 00:00:00',0,'2014-07-03 00:00:00',12,'啦啦啦','天津市南开区','2014-07-30 00:00:00',23),
 (2,2,1,'啦啦啦','2014-08-10 00:00:00',0,'2014-08-10 00:00:00',-1,'hello','天津','2014-08-10 00:00:00',5),
 (3,3,1,'老了老了','2014-09-08 00:00:00',0,'2014-08-10 00:00:00',2,'随时随地查v','老了老了','2014-09-08 00:00:00',1),
 (10,2,1,'么么哒','2014-09-08 00:00:00',0,'2014-08-11 00:00:00',2,'求组团','南开大学','2014-09-08 00:00:00',0),
 (11,10,2,'健美操','2014-09-08 00:00:00',0,'2014-08-12 00:00:00',2,'啦啦啦啦啦','南开','2014-09-08 00:00:00',1),
 (12,10,1,'朱晴宇','2014-09-08 00:00:00',0,'2014-08-14 14:26:36',1,'我好累    ','天兵','2014-09-08 00:00:00',0),
 (13,11,4,'朱晴宇','2014-09-08 00:00:00',0,'2014-08-14 15:10:00',2,'哦哦哦了了','沼菊','2014-09-08 00:00:00',0),
 (14,3,4,'额','2014-09-08 00:00:00',0,'2014-08-14 15:30:13',3,'跑步','天津','2014-09-08 00:00:00',0),
 (15,18,4,'唤醒','2014-09-08 00:00:00',0,'2014-08-14 16:23:55',6,'哦哈也','谈么','2014-09-08 00:00:00',0),
 (16,17,4,'挑战','2014-09-08 00:00:00',0,'2014-08-14 16:30:35',7,'哦也','天津','2014-09-08 00:00:00',0),
 (17,2,4,'uuu','2014-09-08 00:00:00',0,'2014-08-14 00:00:00',1,'QQ群轻轻巧巧','天津','2014-09-08 00:00:00',0),
 (18,17,4,'呜呜','2014-09-08 00:00:00',0,'2014-08-14 16:32:51',0,'QQ群QQ群QQ群','北京','2014-09-08 00:00:00',0),
 (19,2,1,'啦啦啦','2014-08-15 20:13:59',0,'2014-08-15 20:13:59',0,'hello','天津','2014-08-15 20:13:59',0),
 (20,2,4,'朱晴宇','2014-09-08 00:00:00',0,'2014-08-15 21:48:30',0,'mmmmmmmmmm ','北京','2014-09-08 00:00:00',0),
 (21,15,3,'和小伙伴一起玩耍','2014-08-09 00:00:00',0,'2014-08-16 11:44:52',0,' 旱冰很帅气，有木有，求组队，么么哒','天津大学','2014-11-10 00:00:00',0),
 (22,11,5,'郑多燕减肥操','2014-08-09 00:00:00',0,'2014-08-18 00:12:03',0,'减肥减肥','中软','2014-11-10 00:00:00',0),
 (23,9,1,'身上','2014-08-09 00:00:00',0,'2014-08-18 11:05:27',0,'广告歌','南开大学','2014-11-10 00:00:00',0),
 (24,2,1,'一起看世界杯','2014-08-09 00:00:00',0,'2014-08-18 12:51:19',0,'德国必胜','南开大学','2014-11-10 00:00:00',0),
 (25,1,3,'世界杯决赛','2014-08-09 00:00:00',0,'2014-08-19 00:00:00',1,'观看世界杯决赛','南开大学','2014-08-10 00:00:00',0),
 (26,7,3,'排球求组队','2014-08-09 00:00:00',0,'2014-08-19 13:29:29',0,'小伙伴爱生活爱运动','南开大学','2014-08-10 00:00:00',0),
 (27,18,3,'爱生活','2014-08-09 00:00:00',0,'2014-08-19 00:00:00',3,'爱运动','南开大学','2014-11-10 00:00:00',0),
 (28,5,1,'wuwuwu','2014-08-27 00:00:00',0,'2014-08-27 00:00:00',1,'zhuqingyushizhu','zhuzhuzhu','2014-08-27 00:00:00',0),
 (29,2,1,'wushi zhu ','2014-08-27 00:00:00',0,'2014-08-27 00:00:00',1,'ni cai shi zhu ','kkakak','2014-08-27 00:00:00',1),
 (30,2,1,'kkkaka','2014-08-27 00:00:00',0,'2014-08-27 00:00:00',1,'zhuqingyushizhu','momo','2014-08-27 00:00:00',0),
 (31,3,1,'kkkk','2014-08-27 10:24:52',0,'2014-08-27 10:24:52',0,'lrrrrrrrr','rrrrrrr','2014-08-27 10:24:52',0),
 (32,2,1,'11','2014-08-27 11:14:36',0,'2014-08-27 11:14:36',0,'111','11','2014-08-27 11:14:36',0);
/*!40000 ALTER TABLE `activityinvitation` ENABLE KEYS */;


--
-- Definition of table `coach`
--

DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `coachid` int(11) NOT NULL AUTO_INCREMENT,
  `coaname` varchar(20) NOT NULL,
  `coagender` varchar(10) NOT NULL,
  `coatypeid` int(11) DEFAULT NULL,
  `coaphon` varchar(20) NOT NULL,
  `coamark` float DEFAULT NULL,
  `coacontext` text NOT NULL,
  `coaimage` varchar(45) NOT NULL,
  PRIMARY KEY (`coachid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coach`
--

/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
INSERT INTO `coach` (`coachid`,`coaname`,`coagender`,`coatypeid`,`coaphon`,`coamark`,`coacontext`,`coaimage`) VALUES 
 (1,'奥尼尔','男',1,'1234567',9,'拥有教练四级资格证','01.jpg'),
 (2,'赵海','男',2,'2789065',10,'肌肉发达','02.jpg'),
 (3,'ann','女',7,'8775433',9.8,'拥有啦啦啦啦啦','03.jpg'),
 (4,'alvin','男',1,'9999999',8,'啦啦啦啦啦啦啦','04.jpg'),
 (5,'麦克','男',1,'9999999',8,'啦啦啦','05.jpg');
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;


--
-- Definition of table `coachcomment`
--

DROP TABLE IF EXISTS `coachcomment`;
CREATE TABLE `coachcomment` (
  `coacomid` int(11) NOT NULL AUTO_INCREMENT,
  `coachid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `coacomcont` text NOT NULL,
  `coacomresid` varchar(100) DEFAULT NULL,
  `coacomtime` datetime NOT NULL,
  `coacomstar` int(11) DEFAULT NULL,
  PRIMARY KEY (`coacomid`),
  KEY `FK_comcoaid` (`coachid`),
  KEY `FK_comuserid` (`userid`),
  CONSTRAINT `FK_comcoaid` FOREIGN KEY (`coachid`) REFERENCES `coach` (`coachid`),
  CONSTRAINT `FK_comuserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coachcomment`
--

/*!40000 ALTER TABLE `coachcomment` DISABLE KEYS */;
INSERT INTO `coachcomment` (`coacomid`,`coachid`,`userid`,`coacomcont`,`coacomresid`,`coacomtime`,`coacomstar`) VALUES 
 (1,1,1,'非常好',NULL,'2014-08-08 12:00:00',9),
 (2,1,4,'好帅啊',NULL,'2014-08-11 18:30:10',9),
 (3,5,4,'是',NULL,'2014-08-11 18:32:25',2),
 (4,1,4,'三生三世宿舍',NULL,'2014-08-11 18:42:43',3),
 (5,2,4,'哈哈哈',NULL,'2014-08-11 20:02:09',9),
 (6,1,4,'好帅啊',NULL,'2014-08-12 09:31:35',7),
 (7,1,3,'教练很负责',NULL,'2014-08-17 17:28:41',8),
 (8,1,1,'啦啦啦',NULL,'2014-08-18 11:10:43',1),
 (9,1,3,'教练很负责的',NULL,'2014-08-19 13:13:20',9),
 (10,1,3,'很好的教练',NULL,'2014-08-19 13:13:56',10),
 (11,3,3,'教练很负责',NULL,'2014-08-19 13:30:47',1);
/*!40000 ALTER TABLE `coachcomment` ENABLE KEYS */;


--
-- Definition of table `dailytips`
--

DROP TABLE IF EXISTS `dailytips`;
CREATE TABLE `dailytips` (
  `tipid` int(11) NOT NULL AUTO_INCREMENT,
  `tipcontext` text,
  `tipresid` varchar(100) DEFAULT NULL,
  `tipstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`tipid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dailytips`
--

/*!40000 ALTER TABLE `dailytips` DISABLE KEYS */;
INSERT INTO `dailytips` (`tipid`,`tipcontext`,`tipresid`,`tipstatus`) VALUES 
 (1,'每天跑一千米',NULL,NULL),
 (2,'每天多喝水',NULL,NULL),
 (3,'早点睡觉',NULL,NULL);
/*!40000 ALTER TABLE `dailytips` ENABLE KEYS */;


--
-- Definition of table `datedfriend`
--

DROP TABLE IF EXISTS `datedfriend`;
CREATE TABLE `datedfriend` (
  `datedfrirelaid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `friendid` int(11) DEFAULT NULL,
  `datedtime` datetime NOT NULL,
  `datedtype` int(11) NOT NULL,
  PRIMARY KEY (`datedfrirelaid`),
  KEY `FK_datedfriid` (`userid`),
  KEY `FK_dateduserid` (`friendid`) USING BTREE,
  CONSTRAINT `FK_datedfriid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_dateduserid` FOREIGN KEY (`friendid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `datedfriend`
--

/*!40000 ALTER TABLE `datedfriend` DISABLE KEYS */;
INSERT INTO `datedfriend` (`datedfrirelaid`,`userid`,`friendid`,`datedtime`,`datedtype`) VALUES 
 (1,1,2,'2014-07-30 02:00:00',1),
 (2,1,3,'2014-07-08 08:00:00',2),
 (3,1,4,'2014-07-30 09:00:00',7),
 (4,2,6,'2014-07-30 08:00:00',1);
/*!40000 ALTER TABLE `datedfriend` ENABLE KEYS */;


--
-- Definition of table `friendinvitation`
--

DROP TABLE IF EXISTS `friendinvitation`;
CREATE TABLE `friendinvitation` (
  `inviid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `sportid` int(11) DEFAULT NULL,
  `invibegtime` datetime NOT NULL,
  `inviendtime` datetime NOT NULL,
  `invicont` text NOT NULL,
  `invipubtime` datetime NOT NULL,
  `partuserid` varchar(200) DEFAULT NULL,
  `partusercount` int(11) DEFAULT NULL,
  `inviplace` varchar(100) NOT NULL,
  PRIMARY KEY (`inviid`),
  KEY `FK_Relationship_4` (`userid`),
  KEY `FK_invisportid` (`sportid`),
  CONSTRAINT `FK_invisportid` FOREIGN KEY (`sportid`) REFERENCES `sport` (`sportid`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `friendinvitation`
--

/*!40000 ALTER TABLE `friendinvitation` DISABLE KEYS */;
INSERT INTO `friendinvitation` (`inviid`,`userid`,`sportid`,`invibegtime`,`inviendtime`,`invicont`,`invipubtime`,`partuserid`,`partusercount`,`inviplace`) VALUES 
 (1,1,1,'2014-07-30 12:00:00','2014-07-30 02:00:00','一起来吧，么么么','2014-07-30 00:00:00','1/2/',2,'天津市南开区'),
 (2,2,2,'2014-07-30 02:00:00','2014-07-30 05:00:00','求组团','2014-07-29 12:00:00',NULL,0,'北京'),
 (3,3,1,'2014-07-02 16:00:00','2014-07-02 18:00:00','小伙伴们。。。。。。。','2014-07-01 12:00:00','1/3/4/2',4,'天津市');
/*!40000 ALTER TABLE `friendinvitation` ENABLE KEYS */;


--
-- Definition of table `friendrelation`
--

DROP TABLE IF EXISTS `friendrelation`;
CREATE TABLE `friendrelation` (
  `relatid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  PRIMARY KEY (`relatid`),
  KEY `FK_friendid` (`userid`),
  KEY `FK_userid` (`fid`) USING BTREE,
  CONSTRAINT `FK_friendid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_userid` FOREIGN KEY (`fid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `friendrelation`
--

/*!40000 ALTER TABLE `friendrelation` DISABLE KEYS */;
INSERT INTO `friendrelation` (`relatid`,`userid`,`fid`) VALUES 
 (3,2,3),
 (4,3,2),
 (65,1,2),
 (66,2,1),
 (73,3,1),
 (74,1,3),
 (75,3,4),
 (76,4,3);
/*!40000 ALTER TABLE `friendrelation` ENABLE KEYS */;


--
-- Definition of table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msgid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `touserid` int(11) DEFAULT NULL,
  `msgtime` datetime DEFAULT NULL,
  `msgcontext` text,
  `msgresid` varchar(100) DEFAULT NULL,
  `msgstatus` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`msgid`) USING BTREE,
  KEY `FK_megfriendid` (`userid`),
  KEY `FK_mesguserid` (`touserid`) USING BTREE,
  CONSTRAINT `FK_megfriendid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK_mesguserid` FOREIGN KEY (`touserid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`msgid`,`userid`,`touserid`,`msgtime`,`msgcontext`,`msgresid`,`msgstatus`) VALUES 
 (1,1,2,NULL,'哈哈哈哈',NULL,1),
 (2,2,1,NULL,'仍然',NULL,1),
 (3,3,4,NULL,'锵锵锵',NULL,1),
 (4,4,3,NULL,'淡定淡定',NULL,1),
 (5,1,2,NULL,'呜呜呜呜',NULL,1),
 (6,2,1,NULL,'斑斑驳驳',NULL,1),
 (7,1,2,NULL,'惺惺惜惺惺',NULL,1),
 (8,3,4,'2014-08-17 13:52:05','海',NULL,0),
 (9,3,4,'2014-08-17 13:53:51','你好',NULL,0),
 (10,3,4,'2014-08-17 13:54:06','你好',NULL,0),
 (11,3,4,'2014-08-17 13:55:25','你好阿',NULL,0),
 (12,3,4,'2014-08-17 14:00:38','你好阿',NULL,0),
 (13,3,4,'2014-08-17 14:02:46','坎坎坷坷',NULL,0),
 (14,3,4,'2014-08-17 14:04:31','好烦阿',NULL,0),
 (15,3,4,'2014-08-17 14:17:28','还没弄好',NULL,0),
 (16,3,4,'2014-08-17 14:23:40','淡定淡定',NULL,0),
 (17,3,4,'2014-08-17 14:25:22','锵锵锵',NULL,0),
 (18,3,4,'2014-08-17 14:26:26','淡定淡定',NULL,0),
 (19,3,1,'2014-08-17 18:33:06','hhh',NULL,0),
 (20,3,1,'2014-08-17 18:41:35','mandina\r\n',NULL,0),
 (21,3,1,'2014-08-17 18:41:45','慢点\r\n',NULL,0),
 (22,3,2,'2014-08-17 18:47:59','1111111111111',NULL,0),
 (23,3,2,'2014-08-17 18:48:08','2222222222222222',NULL,0),
 (24,3,2,'2014-08-17 18:48:40','4444444444444444',NULL,0),
 (25,3,2,'2014-08-17 18:48:41','4444444444444444',NULL,0),
 (26,3,2,'2014-08-17 18:48:42','4444444444444444',NULL,0),
 (27,3,2,'2014-08-17 18:48:42','4444444444444444',NULL,0),
 (28,3,2,'2014-08-17 18:49:07','4444444444444444',NULL,0),
 (29,3,1,'2014-08-17 18:49:40','6666',NULL,0),
 (30,4,3,'2014-08-17 21:50:09','你好',NULL,0),
 (31,4,3,'2014-08-17 21:51:19','我不好',NULL,0),
 (32,1,2,'2014-08-18 00:08:30','谁把',NULL,0),
 (33,1,2,'2014-08-18 00:09:31','睡吧',NULL,0),
 (34,1,2,'2014-08-18 11:15:40','12',NULL,0),
 (35,3,2,'2014-08-19 13:42:33','好',NULL,0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Definition of table `mydiary`
--

DROP TABLE IF EXISTS `mydiary`;
CREATE TABLE `mydiary` (
  `mdiaryid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `mdiarytime` datetime NOT NULL,
  `mdiaryname` varchar(30) NOT NULL,
  `mdiarycont` text NOT NULL,
  `mdiarystatus` int(11) NOT NULL,
  `mdiaryresid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`mdiaryid`),
  KEY `FK_mdiaryuserid` (`userid`),
  CONSTRAINT `FK_mdiaryuserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mydiary`
--

/*!40000 ALTER TABLE `mydiary` DISABLE KEYS */;
INSERT INTO `mydiary` (`mdiaryid`,`userid`,`mdiarytime`,`mdiaryname`,`mdiarycont`,`mdiarystatus`,`mdiaryresid`) VALUES 
 (1,2,'2014-08-09 16:16:50','zhu','朱晴宇是猪',1,'24386529280689.bmp'),
 (2,1,'2014-08-09 18:14:22','第一篇','哈哈哈哈哈哈哈啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',1,'31439136957672.bmp'),
 (3,1,'2014-08-09 18:25:26','第二篇','再来一次。。。。。。',1,'32102906752048.jpg'),
 (4,1,'2014-08-09 19:12:37','第三篇','啊啊啊啊啊啊啊啊啊',1,'34933475873753.bmp'),
 (5,3,'2014-08-09 21:38:56','猪猪猪','朱晴宇施主是猪',1,'43713056514954.bmp'),
 (6,1,'2014-08-12 12:46:37','ggggggggg','ggggggg',1,'14905506268044.jpg'),
 (7,1,'2014-08-14 14:03:13','HELLO','我好累',1,'19790103686969.bmp'),
 (8,3,'2014-08-19 13:17:38','运动','爱运动爱生活',1,'102299828878555.jpg'),
 (9,3,'2014-08-19 13:40:29','爱生活第一篇','爱生活爱运动',1,'103670354008444.jpg'),
 (10,1,'2014-08-26 10:32:16','123','123',1,NULL),
 (11,1,'2014-08-26 10:33:38','10','10',1,NULL),
 (12,1,'2014-08-26 10:38:06','2','2',1,NULL),
 (13,1,'2014-08-26 10:42:43','hange','hange',1,NULL),
 (14,1,'2014-08-26 10:42:51','hange','hangehaoshuaiya',1,NULL),
 (15,1,'2014-08-26 10:45:07','123','123',1,NULL),
 (16,1,'2014-08-26 10:50:36','hangehaoshuai','hangehaoshuai',1,NULL),
 (17,1,'2014-08-26 10:52:41','haoshuai','hange',1,NULL),
 (18,1,'2014-08-27 10:25:17','kkkkkk','ssssss',1,NULL);
/*!40000 ALTER TABLE `mydiary` ENABLE KEYS */;


--
-- Definition of table `offiacti`
--

DROP TABLE IF EXISTS `offiacti`;
CREATE TABLE `offiacti` (
  `offiactiid` int(11) NOT NULL AUTO_INCREMENT,
  `offiactiname` varchar(30) NOT NULL,
  `offiactitime` datetime NOT NULL,
  `offiactiplace` varchar(100) DEFAULT NULL,
  `offiactitype` varchar(100) DEFAULT NULL,
  `offiactisimpintr` text NOT NULL,
  `offiactistatus` int(11) DEFAULT NULL,
  `offiactires` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`offiactiid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `offiacti`
--

/*!40000 ALTER TABLE `offiacti` DISABLE KEYS */;
/*!40000 ALTER TABLE `offiacti` ENABLE KEYS */;


--
-- Definition of table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `regid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `regtime` datetime NOT NULL,
  `regaddr` varchar(200) NOT NULL,
  `reggender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`regid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`regid`,`account`,`password`,`nickname`,`regtime`,`regaddr`,`reggender`) VALUES 
 (1,'123qq.com','123','xiaopingguo','2012-08-08 00:00:00','tianjin','male'),
 (2,'456@qq.com','456','金龟子','2012-08-09 00:00:00','北京','男'),
 (3,'789@qq.com','789789','打豆豆','2012-08-01 00:00:00','南京','女'),
 (4,'123@163.com','123456','北极星','2012-08-03 00:00:00','','female'),
 (5,'456@163.com','456','蜘蛛侠','2012-08-06 00:00:00','广州','女'),
 (6,'789@163.com','789','么么哒','2012-08-07 00:00:00','天津','女'),
 (7,'alvin@163.com','123','小黄蜂','2012-08-08 00:00:00','北京','男'),
 (8,'ann@qq.com','123','大boss','2012-08-08 00:00:00','上海','女'),
 (9,'8080@qq.com','8080pgy','蒲公英','2014-08-11 22:01:39','天安门','女生'),
 (10,'1111@qq.com','111111','小云朵','2014-08-17 20:22:49','广东','女生'),
 (11,'424224257@qq.com','111111','小评估偶','2014-08-18 09:59:19','天津','男生'),
 (12,'789789@qq.com','789789','北极星','2014-08-19 13:09:23','天津','女生'),
 (13,'123123@qq.com','123123','太平洋','2014-08-19 13:26:54','天津','女生'),
 (14,'123456@qq.com','123456','爱生活爱运动','2014-08-19 13:33:58','天津','女生');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


--
-- Definition of table `publishstatus`
--

DROP TABLE IF EXISTS `publishstatus`;
CREATE TABLE `publishstatus` (
  `staid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `followid` int(11) NOT NULL,
  `stacontext` text NOT NULL,
  `staviewcount` int(11) DEFAULT NULL,
  `stapracount` int(11) DEFAULT NULL,
  `starepcount` int(11) DEFAULT NULL,
  `staresid` varchar(100) DEFAULT NULL,
  `stapubtime` datetime NOT NULL,
  `stastatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`staid`) USING BTREE,
  KEY `FK_Relationship_8` (`userid`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `publishstatus`
--

/*!40000 ALTER TABLE `publishstatus` DISABLE KEYS */;
INSERT INTO `publishstatus` (`staid`,`userid`,`followid`,`stacontext`,`staviewcount`,`stapracount`,`starepcount`,`staresid`,`stapubtime`,`stastatus`) VALUES 
 (1,1,0,'啦啦啦啦啦了，嘻嘻(*^__^*) 嘻嘻',1,1,3,NULL,'2014-07-30 16:00:00',NULL),
 (2,2,0,'一起跑步吧，求小伙伴。。。。。',2,2,9,NULL,'2014-07-30 12:00:00',NULL),
 (3,1,1,'萌萌哒',1,1,1,NULL,'2014-07-30 17:00:00',NULL),
 (4,3,2,'好啊',0,0,0,NULL,'2014-07-30 02:00:00',NULL),
 (5,4,3,'求组队',7,7,0,NULL,'2014-07-30 19:00:00',NULL),
 (6,1,0,'好累啊',0,0,0,'19814464748761.jpg','2014-08-14 14:03:37',1),
 (7,3,0,'运动，爱运动，爱生活',0,0,0,'102328396768919.jpg','2014-08-19 13:18:07',1),
 (8,3,0,'爱生活爱运动',0,0,0,'103694133303768.jpg','2014-08-19 13:40:53',1),
 (9,1,0,'shuoshuo',0,0,0,NULL,'2014-08-26 11:30:47',1),
 (10,1,0,'zhuminjiebuyaochongqi,buyaohunle haomemememememe',0,0,0,NULL,'2014-08-26 11:32:11',1),
 (11,1,0,'111111111111111111111111111',0,0,0,NULL,'2014-08-27 09:52:12',1);
/*!40000 ALTER TABLE `publishstatus` ENABLE KEYS */;


--
-- Definition of table `resource`
--

DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `resid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `restype` varchar(20) DEFAULT NULL,
  `restime` datetime DEFAULT NULL,
  `resdesc` text,
  `reslocation` varchar(200) NOT NULL,
  PRIMARY KEY (`resid`),
  KEY `FK_Relationship_26` (`userid`),
  CONSTRAINT `FK_Relationship_26` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resource`
--

/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` (`resid`,`userid`,`restype`,`restime`,`resdesc`,`reslocation`) VALUES 
 (1,3,NULL,'2014-08-17 19:01:29','1111111111111','38359619096208.jpg');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;


--
-- Definition of table `sport`
--

DROP TABLE IF EXISTS `sport`;
CREATE TABLE `sport` (
  `sportid` int(11) NOT NULL AUTO_INCREMENT,
  `sportname` varchar(30) NOT NULL,
  PRIMARY KEY (`sportid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sport`
--

/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` (`sportid`,`sportname`) VALUES 
 (1,'足球'),
 (2,'羽毛球'),
 (3,'篮球'),
 (4,'台球'),
 (5,'乒乓球'),
 (6,'网球'),
 (7,'排球'),
 (8,'高尔夫'),
 (9,'保龄球'),
 (10,'健美操'),
 (11,'街舞'),
 (12,'瑜伽'),
 (13,'田径'),
 (14,'滑雪'),
 (15,'旱冰'),
 (16,'溜冰'),
 (17,'攀岩'),
 (18,'自行车'),
 (19,'太极'),
 (20,'广场舞'),
 (21,'散打'),
 (22,'拳击'),
 (23,'跆拳道'),
 (24,'空手道'),
 (25,'击剑'),
 (26,'钓鱼'),
 (27,'游泳');
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;


--
-- Definition of table `sporttreasure`
--

DROP TABLE IF EXISTS `sporttreasure`;
CREATE TABLE `sporttreasure` (
  `treasid` int(11) NOT NULL AUTO_INCREMENT,
  `sportid` int(11) DEFAULT NULL,
  `treaauthname` varchar(30) DEFAULT NULL,
  `treasname` varchar(30) NOT NULL,
  `treaspubtime` datetime DEFAULT NULL,
  `treascollecount` int(11) DEFAULT NULL,
  `treasviewcount` int(11) DEFAULT NULL,
  `treascont` text,
  `treasrespath` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`treasid`),
  KEY `FK_treastyppeid` (`sportid`),
  CONSTRAINT `FK_treastyppeid` FOREIGN KEY (`sportid`) REFERENCES `sport` (`sportid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sporttreasure`
--

/*!40000 ALTER TABLE `sporttreasure` DISABLE KEYS */;
INSERT INTO `sporttreasure` (`treasid`,`sportid`,`treaauthname`,`treasname`,`treaspubtime`,`treascollecount`,`treasviewcount`,`treascont`,`treasrespath`) VALUES 
 (1,1,'小黄蜂','这样锻炼','2014-07-30 12:00:00',1,9,'在中间，啊啊啊啊啊啊啊啊啊啊。啊你糊糊口响几声仄厅过的啦才啊胡扯啥匜BBB阿虎耍了阿虎学号断了的',NULL),
 (2,2,'大boss','一起锻炼','2014-07-30 10:00:00',1,6,'扭扭捏捏就爱哦接hi哦付费后上赛季考虑到的胜率那算了  三四年农产品是是常德市农村',NULL),
 (3,3,'小黄蜂','运动','2014-07-30 14:00:00',8,9,'NAJSIH ASUDHUNA sanappnsa;nmasudasnudasc sncasuima',NULL),
 (4,1,'官方','这样活动','2014-07-30 02:09:00',9,8,'就卡死了哈哈哈哈哈哈',NULL),
 (5,3,'官方','篮球','2014-08-01 10:08:00',3,NULL,'郑多燕减肥体操',NULL),
 (6,4,'小黄蜂','足球','2014-08-02 10:08:00',5,NULL,'世界杯',NULL);
/*!40000 ALTER TABLE `sporttreasure` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `regid` int(11) DEFAULT NULL,
  `spordec` varchar(50) DEFAULT NULL,
  `spornum` float DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `integ` bigint(20) DEFAULT NULL,
  `sportlabel` varchar(100) DEFAULT NULL,
  `isaccepmsg` int(11) DEFAULT NULL,
  `collestatusid` varchar(400) DEFAULT NULL,
  `colletreasid` varchar(400) DEFAULT NULL,
  `userpho` varchar(20) DEFAULT NULL,
  `userstatus` int(11) NOT NULL,
  `mark` text,
  `actiid` varchar(45) DEFAULT NULL,
  `zanactiid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK_Relationship_regid` (`regid`),
  CONSTRAINT `FK_Relationship_regid` FOREIGN KEY (`regid`) REFERENCES `person` (`regid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`,`regid`,`spordec`,`spornum`,`rank`,`integ`,`sportlabel`,`isaccepmsg`,`collestatusid`,`colletreasid`,`userpho`,`userstatus`,`mark`,`actiid`,`zanactiid`) VALUES 
 (1,1,'fffff',5,1,86,'1/2',0,NULL,'2/41/','3690598924771.jpg',1,'嗷嗷嗷','1/2/3/4/30/','1/2/3/4/'),
 (2,2,'我是最好的',4,1,22,'1/2/3',1,NULL,'3/4','02.jpg',0,'啦啦啦','1/2/','1/2/3/4/'),
 (3,3,'i can ',0.9,4,20,'1/2/3/4',0,NULL,'4','19518348421995.bmp',1,'呵呵','1/2/1/25/1/1/','1/2/3/4/'),
 (4,4,'北极',8,4,63,'1/2/3/4/5/6/7/8/9/10/11/12/13/14/15/16/17/18/19/20/21/22/23/24/25/26/27',0,NULL,'2/3','4117893474283.jpg',0,'哈哈','1/2/3/','1/3/4/5/'),
 (5,5,'冲啊',7,4,84,'1/2/',1,NULL,'1/4/3','05.jpg',1,'嘿嘿','2/3/11/10/','1/3/4/5/'),
 (6,6,'运动吧',8,5,52,'2/1',0,NULL,'1/2/3','06.jpg',1,NULL,'1/2/','1/3/4/5/'),
 (7,7,'TTT',9,5,6,'1/7/4',0,NULL,'2/3','07.jpg',1,NULL,'2/3/','1/3/4/5/'),
 (8,8,'萌萌',8,5,98,'1/4/',0,NULL,'1/4','08.jpg',1,NULL,'4/5/','1/3/4/5/');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `venue`
--

DROP TABLE IF EXISTS `venue`;
CREATE TABLE `venue` (
  `venueid` int(11) NOT NULL AUTO_INCREMENT,
  `venuename` varchar(50) NOT NULL,
  `vencomgrade` float DEFAULT NULL,
  `vencontext` text NOT NULL,
  `venplace` varchar(150) NOT NULL,
  `venprice` float NOT NULL,
  `vensportid` int(10) unsigned NOT NULL,
  `venimage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`venueid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venue`
--

/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` (`venueid`,`venuename`,`vencomgrade`,`vencontext`,`venplace`,`venprice`,`vensportid`,`venimage`) VALUES 
 (1,'星光',9,'场馆干净，萌萌','南开区',10,1,'07.jpg'),
 (2,'sport',8.9,'欢迎光临，么么哒','河西区',20,2,'08.jpg'),
 (3,'运动之光',9.1,'位置方便','滨江道',30,1,'09.jpg'),
 (4,'do ',7,'welcome','南开区',15,1,'10.jpg'),
 (5,'小黄蜂啊',7.9,'啦啦啦啦啦啦啦啦啦啦','南开区',32,1,'02.jpg'),
 (6,'大大',8.7,'啊啊啊啊啊啊','南开区',16,2,'03.jpg');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;


--
-- Definition of table `venuecomment`
--

DROP TABLE IF EXISTS `venuecomment`;
CREATE TABLE `venuecomment` (
  `vencomid` int(11) NOT NULL AUTO_INCREMENT,
  `venueid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `vencomcont` varchar(200) NOT NULL,
  `vencomstar` int(11) NOT NULL,
  `vencomresid` varchar(100) DEFAULT NULL,
  `vencomtime` datetime NOT NULL,
  PRIMARY KEY (`vencomid`),
  KEY `FK_comvenid` (`venueid`),
  KEY `FK_vencomuserid` (`userid`),
  CONSTRAINT `FK_comvenid` FOREIGN KEY (`venueid`) REFERENCES `venue` (`venueid`),
  CONSTRAINT `FK_vencomuserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `venuecomment`
--

/*!40000 ALTER TABLE `venuecomment` DISABLE KEYS */;
INSERT INTO `venuecomment` (`vencomid`,`venueid`,`userid`,`vencomcont`,`vencomstar`,`vencomresid`,`vencomtime`) VALUES 
 (1,1,1,'感觉棒极了',5,NULL,'2014-08-10 10:00:00'),
 (2,1,2,'非常好',7,NULL,'2014-07-30 01:00:00'),
 (3,2,1,'么么哒',8,NULL,'2014-07-30 12:00:00'),
 (4,3,6,'哈哈哈哈哈哈',9,NULL,'2014-07-30 12:20:00'),
 (5,4,7,'啊啊啊啊啊啊啊',8,NULL,'2014-07-30 09:00:00'),
 (6,5,4,'nonono',5,NULL,'2014-07-30 08:30:00'),
 (7,3,4,'地点',9,NULL,'2014-08-11 19:36:10'),
 (8,1,4,'发货哈',4,NULL,'2014-08-11 19:37:45'),
 (9,1,4,'地点',4,NULL,'2014-08-11 19:49:26'),
 (10,1,4,'地点',4,NULL,'2014-08-11 19:52:55'),
 (11,1,2,'为什么评不上',10,NULL,'2014-08-17 12:39:33'),
 (12,1,2,'挺好的',9,NULL,'2014-08-17 12:45:27'),
 (13,1,3,'爱生活，爱运动',10,NULL,'2014-08-19 13:31:25'),
 (14,1,3,'爱生活，爱运动',9,NULL,'2014-08-19 13:37:53');
/*!40000 ALTER TABLE `venuecomment` ENABLE KEYS */;


--
-- Definition of view `actihuo`
--

DROP TABLE IF EXISTS `actihuo`;
DROP VIEW IF EXISTS `actihuo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `actihuo` AS select `a`.`actiid` AS `actiid`,`a`.`actiname` AS `actiname`,`u`.`userid` AS `userid`,`p`.`nickname` AS `nickname`,`u`.`userpho` AS `userpho`,`u`.`rank` AS `rank`,`s`.`sportid` AS `sportid`,`s`.`sportname` AS `sportname`,`a`.`actiusercount` AS `actiusercount`,`a`.`actibegtime` AS `actibegtime`,`a`.`actiendtime` AS `actiendtime`,`a`.`acticont` AS `acticont`,`a`.`actiplace` AS `actiplace`,`a`.`actizancount` AS `actizancount`,`a`.`actisettime` AS `actisettime` from (((`user` `u` join `person` `p`) join `sport` `s`) join `activityinvitation` `a`) where ((`u`.`regid` = `p`.`regid`) and (`a`.`sportid` = `s`.`sportid`) and (`a`.`userid` = `u`.`userid`));

--
-- Definition of view `activity`
--

DROP TABLE IF EXISTS `activity`;
DROP VIEW IF EXISTS `activity`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `activity` AS select `a`.`actiid` AS `actiid`,`a`.`actiname` AS `actiname`,`u`.`userid` AS `userid`,`p`.`nickname` AS `nickname`,`u`.`userpho` AS `userpho`,`u`.`rank` AS `rank`,`s`.`sportid` AS `sportid`,`s`.`sportname` AS `sportname`,`a`.`actiusercount` AS `actiusercount`,`a`.`actibegtime` AS `actibegtime`,`a`.`actiendtime` AS `actiendtime`,`a`.`acticont` AS `acticont`,`a`.`actiplace` AS `actiplace`,`a`.`actizancount` AS `actizancount`,`a`.`actisettime` AS `actisettime` from (((`user` `u` join `person` `p`) join `sport` `s`) join `activityinvitation` `a`) where ((`u`.`regid` = `p`.`regid`) and (`a`.`sportid` = `s`.`sportid`) and (`a`.`userid` = `u`.`userid`));

--
-- Definition of view `peruser`
--

DROP TABLE IF EXISTS `peruser`;
DROP VIEW IF EXISTS `peruser`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `peruser` AS select `u`.`userid` AS `userid`,`p`.`account` AS `account`,`p`.`nickname` AS `nickname`,`p`.`reggender` AS `gender`,`u`.`colletreasid` AS `colletreasid`,`u`.`zanactiid` AS `zanactiid`,`u`.`actiid` AS `actiid`,`u`.`userpho` AS `userpho`,`u`.`sportlabel` AS `sportlabel` from (`person` `p` join `user` `u`) where (`p`.`regid` = `u`.`userid`);

--
-- Definition of view `vdiary`
--

DROP TABLE IF EXISTS `vdiary`;
DROP VIEW IF EXISTS `vdiary`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vdiary` AS select `m`.`mdiaryid` AS `mdiaryid`,`u`.`userid` AS `userid`,`u`.`userpho` AS `userpho`,`u`.`sportlabel` AS `sportlabel`,`m`.`mdiarytime` AS `mdiarytime`,`m`.`mdiaryname` AS `mdiaryname`,`m`.`mdiarycont` AS `mdiarycont` from (`user` `u` join `mydiary` `m`) where (`u`.`userid` = `m`.`userid`);

--
-- Definition of view `vshuoshuo`
--

DROP TABLE IF EXISTS `vshuoshuo`;
DROP VIEW IF EXISTS `vshuoshuo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vshuoshuo` AS select `s`.`staid` AS `staid`,`u`.`userid` AS `userid`,`p`.`nickname` AS `nickname`,`u`.`sportlabel` AS `sportlabel`,`u`.`userpho` AS `userpho`,`s`.`stacontext` AS `stacontext`,`s`.`stapubtime` AS `stapubtime` from ((`publishstatus` `s` join `user` `u`) join `person` `p`) where ((`u`.`userid` = `p`.`regid`) and (`u`.`userid` = `s`.`userid`));



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
