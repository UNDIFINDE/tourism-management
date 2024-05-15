-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travel_management
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `group_purchase_record`
--

DROP TABLE IF EXISTS `group_purchase_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_purchase_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `gid` int NOT NULL COMMENT '导游id',
  `tg_id` int NOT NULL COMMENT '旅游团id',
  `tid` int NOT NULL COMMENT '游客id',
  `travel_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '旅游时间',
  `cost` double NOT NULL COMMENT '总花费的金额',
  `deleted` int NOT NULL DEFAULT '0',
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `gid` (`gid`),
  KEY `tg_id` (`tg_id`),
  KEY `tid` (`tid`),
  CONSTRAINT `gid` FOREIGN KEY (`gid`) REFERENCES `guide` (`gid`),
  CONSTRAINT `tg_id` FOREIGN KEY (`tg_id`) REFERENCES `tourist_groups` (`tg_id`),
  CONSTRAINT `tid` FOREIGN KEY (`tid`) REFERENCES `tourist` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='团购记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_purchase_record`
--

LOCK TABLES `group_purchase_record` WRITE;
/*!40000 ALTER TABLE `group_purchase_record` DISABLE KEYS */;
INSERT INTO `group_purchase_record` VALUES (1,2,1,1,'2024-05-14 03:17:04',521,0,0),(2,1,1,1,'2024-05-14 13:30:02',0,0,0);
/*!40000 ALTER TABLE `group_purchase_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guide` (
  `gid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` int DEFAULT NULL COMMENT '性别，0是女，1是男',
  `entry_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  `context` varchar(255) DEFAULT NULL COMMENT '职业描述',
  `flag` int DEFAULT '0',
  `separation_time` date DEFAULT NULL COMMENT '离职时间',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='向导表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES `guide` WRITE;
/*!40000 ALTER TABLE `guide` DISABLE KEYS */;
INSERT INTO `guide` VALUES (1,'夜倾',22,1,'2024-05-13 14:55:31','成都导游，熟悉成都欢乐谷片区的所有景点路线',0,NULL,'四川成都金牛区',0,1),(2,'苏清河',15,0,'2024-05-14 03:43:56','绵阳兼职导游',0,NULL,'四川绵阳',1,0),(3,'萧河',20,1,'2024-05-14 13:08:53','这个导游没话说..............................就会.....',0,NULL,'蓬莱岛',0,1),(4,'萧河',20,1,'2024-05-15 01:08:03','这个导游话不多',0,NULL,'蓬莱岛',0,0);
/*!40000 ALTER TABLE `guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist`
--

DROP TABLE IF EXISTS `tourist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourist` (
  `tid` int NOT NULL AUTO_INCREMENT COMMENT '游客id',
  `name` varchar(12) DEFAULT NULL COMMENT '游客名称',
  `card` varchar(32) DEFAULT NULL COMMENT '游客身份证号码',
  `deleted` int NOT NULL DEFAULT '0',
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='游客表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist`
--

LOCK TABLES `tourist` WRITE;
/*!40000 ALTER TABLE `tourist` DISABLE KEYS */;
INSERT INTO `tourist` VALUES (1,'江煜生','55555555555555555555',0,0),(2,'夜倾的小号','464646464646',0,0);
/*!40000 ALTER TABLE `tourist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist_groups`
--

DROP TABLE IF EXISTS `tourist_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tourist_groups` (
  `tg_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id，唯一标识',
  `tg_name` varchar(32) DEFAULT NULL COMMENT '旅游团名称',
  `price` double DEFAULT NULL COMMENT '旅游团价格',
  `address` varchar(32) DEFAULT NULL COMMENT '旅游团地址',
  `context` varchar(255) DEFAULT NULL COMMENT '旅游团的描述内容容',
  `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist_groups`
--

LOCK TABLES `tourist_groups` WRITE;
/*!40000 ALTER TABLE `tourist_groups` DISABLE KEYS */;
INSERT INTO `tourist_groups` VALUES (1,'四川省成都市金牛区旅游A团',521,'四川省成都市','曾有人云，侠之大者，为国为民。私认为，则游之大者，四处皆景。',0,1),(2,'成都欢乐谷旅游团',999,'四川成都','曾有人云，侠之大者，为国为民。私认为，则游之大者，四处皆景。',0,1),(3,'四川绵阳旅游B团',350,'四川绵阳安州','曾有人云，侠之大者，为国为民。私认为，则游之大者，四处皆景。',0,0),(4,'四川绵阳旅游B团',350,'四川绵阳安州','曾有人云，侠之大者，为国为民。私认为，则游之大者，四处皆景。',0,0);
/*!40000 ALTER TABLE `tourist_groups` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-15 16:09:37
