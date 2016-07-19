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
-- Create schema bank
--

CREATE DATABASE IF NOT EXISTS bank;
USE bank;

--
-- Definition of table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
CREATE TABLE `useraccount` (
  `name` varchar(25) DEFAULT NULL,
  `Designation` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `phon` varchar(20) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `pin` varchar(20) DEFAULT NULL,
  `Acno` varchar(20) NOT NULL DEFAULT '',
  `total` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Acno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccount`
--

/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` (`name`,`Designation`,`email`,`phon`,`Address`,`pin`,`Acno`,`total`) VALUES 
 ('vivek','java','viv@gm.com','9090909090','chennai','629101','1180','169001'),
 ('vignesh','java developer','dm@spiroit.com','9597163265','chennai','614600','1185','15607946'),
 ('rocky','sw engineer','rocy@r.com','9874563210','chepauk','600005','1235','9799835'),
 ('arunsg','java','arun@gm.com','9090909090','CHENNAI','629101','1520','146700'),
 ('arun','java-programeer','arun@gml.com','9095071610','chennai','620004','1564','200000'),
 ('pandian','java programmer','pandian@pandi.com','9874563210','USA','000001','1922','78000000');
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
