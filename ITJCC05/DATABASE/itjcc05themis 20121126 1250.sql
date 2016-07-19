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
-- Create schema `itjcc05-themis`
--

CREATE DATABASE IF NOT EXISTS `itjcc05-themis`;
USE `itjcc05-themis`;

--
-- Definition of table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
CREATE TABLE `monitor` (
  `software` varchar(50) NOT NULL,
  `user` varchar(45) NOT NULL,
  `reqdate` varchar(45) NOT NULL,
  `sla` varchar(100) NOT NULL,
  `id` varchar(45) NOT NULL,
  `resdate` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monitor`
--

/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;


--
-- Definition of table `receivesla`
--

DROP TABLE IF EXISTS `receivesla`;
CREATE TABLE `receivesla` (
  `name` varchar(50) NOT NULL,
  `slacsp` varchar(100) NOT NULL,
  `slauser` varchar(100) NOT NULL,
  `sw` varchar(45) NOT NULL,
  `DATE` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receivesla`
--

/*!40000 ALTER TABLE `receivesla` DISABLE KEYS */;
INSERT INTO `receivesla` (`name`,`slacsp`,`slauser`,`sw`,`DATE`) VALUES 
 ('arun','E:/THEMIS/ITJCC05-Themis/WebContent/SLA/arun-EDITOR.pdf','E:/THEMIS/ITJCC05-Themis/WebContent/USLA/arun-EDITOR.pdf','EDITOR','Sun Nov 25 00:24:13 IST 2012'),
 ('vikky','E:/THEMIS/ITJCC05-Themis/WebContent/SLA/vikky-EDITOR.pdf','E:/THEMIS/ITJCC05-Themis/WebContent/USLA/vikky-EDITOR.pdf','EDITOR','Sun Nov 25 01:40:26 IST 2012'),
 ('vikky','E:/THEMIS/ITJCC05-Themis/WebContent/SLA/vikky-EDITOR.pdf','E:/THEMIS/ITJCC05-Themis/WebContent/USLA/vikky-EDITOR.pdf','EDITOR','Sun Nov 25 01:40:26 IST 2012'),
 ('raj','E:/THEMIS/ITJCC05-Themis/WebContent/SLA/raj-EDITOR.pdf','E:/THEMIS/ITJCC05-Themis/WebContent/USLA/raj-EDITOR.pdf','EDITOR','Sun Nov 25 04:25:51 IST 2012');
/*!40000 ALTER TABLE `receivesla` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
