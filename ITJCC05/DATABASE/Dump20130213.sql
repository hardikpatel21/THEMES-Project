CREATE DATABASE  IF NOT EXISTS `itjcc05` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `itjcc05`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: itjcc05
-- ------------------------------------------------------
-- Server version	5.5.25a

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `forbank`
--

DROP TABLE IF EXISTS `forbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forbank` (
  `name` varchar(50) DEFAULT NULL,
  `software` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forbank`
--

LOCK TABLES `forbank` WRITE;
/*!40000 ALTER TABLE `forbank` DISABLE KEYS */;
INSERT INTO `forbank` VALUES ('arun','rocky',100000),('arun','rocky',100000),('arun','kasi',5555),('io','uiui',90),('arun','kasi',5555),('arun','kasi',0),('arun','kasi',6555),('arun','kasi',5555);
/*!40000 ALTER TABLE `forbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_from_user`
--

DROP TABLE IF EXISTS `request_from_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_from_user` (
  `software` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_from_user`
--

LOCK TABLES `request_from_user` WRITE;
/*!40000 ALTER TABLE `request_from_user` DISABLE KEYS */;
INSERT INTO `request_from_user` VALUES ('kasi','arun','Mon Feb 11 15:51:42 IST 2013'),('kasi','arun','Mon Feb 11 19:16:56 IST 2013');
/*!40000 ALTER TABLE `request_from_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `response` (
  `software` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `sla` varchar(45) NOT NULL,
  `id` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` VALUES ('kasi','arun','D:/arun-kasi.pdf','5983','Mon Feb 11 15:52:03 IST 2013'),('kasi','arun','D:/arun-kasi.pdf','5293','Mon Feb 11 19:17:09 IST 2013');
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload`
--

DROP TABLE IF EXISTS `upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload` (
  `image` varchar(1000) DEFAULT NULL,
  `software` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `validity` varchar(50) DEFAULT NULL,
  `cost` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload`
--

LOCK TABLES `upload` WRITE;
/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` VALUES ('Chrysanthemum.jpg','I_Writer_Assign.class','kasi','50','5555');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `name` varchar(25) DEFAULT NULL,
  `user_name` varchar(25) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  `email_id` varchar(35) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `account_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('arun','arun','arun12','9874561230','gg@gmai.com','xxx,\r\nyyy.',1460),('kasi','kasi','kasi12','1234567890','kasi@gmail.com','agsdg',23432412),('nirmal','nirmal','nirmal','9874563210','n@sm.com','saravanan st,\r\nmeenakshipuram,\r\nChennai.',4567897),('raj','raj','raj123','1236547890','aa@aa.con','ggg,nnn.',2581473),('ram','ram','ram123','1234567890','aa@aa.com','ddd,zzz.',1234576),('Vignesh','vikky','vikky','9597163265','dm_vignesh@yahoo.co.in','jj',1245722);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-13 16:00:30
