-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.25a


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema itjcc05
--

CREATE DATABASE IF NOT EXISTS itjcc05;
USE itjcc05;

--
-- Definition of table `request_from_user`
--

DROP TABLE IF EXISTS `request_from_user`;
CREATE TABLE `request_from_user` (
  `software` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request_from_user`
--

/*!40000 ALTER TABLE `request_from_user` DISABLE KEYS */;
INSERT INTO `request_from_user` (`software`,`user`,`date`) VALUES 
 ('EDITOR','arun','Sat Nov 24 20:41:14 IST 2012'),
 ('EDITOR','vikky','Sun Nov 25 01:28:20 IST 2012'),
 ('EDITOR','raj','Sun Nov 25 04:22:18 IST 2012');
/*!40000 ALTER TABLE `request_from_user` ENABLE KEYS */;


--
-- Definition of table `response`
--

DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `software` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `sla` varchar(45) NOT NULL,
  `id` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `response`
--

/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` (`software`,`user`,`sla`,`id`,`date`) VALUES 
 ('EDITOR','arun','D:/arun-EDITOR.pdf','2055','Sat Nov 24 20:41:33 IST 2012'),
 ('EDITOR','vikky','D:/vikky-EDITOR.pdf','5650','Sun Nov 25 01:28:50 IST 2012'),
 ('EDITOR','raj','D:/raj-EDITOR.pdf','4307','Sun Nov 25 04:22:36 IST 2012');
/*!40000 ALTER TABLE `response` ENABLE KEYS */;


--
-- Definition of table `upload`
--

DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `image` varchar(1000) DEFAULT NULL,
  `software` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `validity` varchar(50) DEFAULT NULL,
  `cost` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `upload`
--

/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
INSERT INTO `upload` (`image`,`software`,`name`,`validity`,`cost`) VALUES 
 ('Chrysanthemum.jpg','I_Writer_Assign.class','EDITOR','50','5000'),
 ('Jellyfish.jpg','txt.class','tect','55','254');
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
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

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`name`,`user_name`,`password`,`phone_no`,`email_id`,`address`,`account_no`) VALUES 
 ('arun','arun','arun12','9874561230','gg@gmai.com','xxx,\r\nyyy.',12345789),
 ('kasi','kasi','kasi12','1234567890','kasi@gmail.com','agsdg',23432412),
 ('nirmal','nirmal','nirmal','9874563210','n@sm.com','saravanan st,\r\nmeenakshipuram,\r\nChennai.',4567897),
 ('raj','raj','raj123','1236547890','aa@aa.con','ggg,nnn.',2581473),
 ('ram','ram','ram123','1234567890','aa@aa.com','ddd,zzz.',1234576),
 ('Vignesh','vikky','vikky','9597163265','dm_vignesh@yahoo.co.in','jj',1245722);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
