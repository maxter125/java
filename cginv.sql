-- MySQL dump 10.15  Distrib 10.0.21-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: cg-invoice
-- ------------------------------------------------------
-- Server version	10.0.21-MariaDB

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
-- Table structure for table `cgadmins`
--
create database if not exists invoice;
  use invoice;
DROP TABLE IF EXISTS `cgadmins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgadmins` (
  `admin_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(40) NOT NULL DEFAULT '',
  `admin_password` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgadmins`
--

LOCK TABLES `cgadmins` WRITE;
/*!40000 ALTER TABLE `cgadmins` DISABLE KEYS */;
INSERT INTO `cgadmins` VALUES (1,'admin','pass');
/*!40000 ALTER TABLE `cgadmins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgclients`
--

DROP TABLE IF EXISTS `cgclients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgclients` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `item` varchar(80) NOT NULL,
  `code` varchar(60) NOT NULL,
  `value` varchar(60) NOT NULL,
  `upc` varchar(125) NOT NULL,
  `din` varchar(20) NOT NULL,
  `dout` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgclients`
--

LOCK TABLES `cgclients` WRITE;
/*!40000 ALTER TABLE `cgclients` DISABLE KEYS */;
INSERT INTO `cgclients` VALUES (1,'johnnywalkerpop.com','on pacificbuilders.com linuxvps.net host','HTML5 static site Bootstrap new theme XYZ','login johnnywa pass #HiJkLmN0P','2015-09-01','2015-09-02'),(2,'Harsh','345','67','dfsdfs','2015-12-10','');
/*!40000 ALTER TABLE `cgclients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgcontacts`
--

DROP TABLE IF EXISTS `cgcontacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgcontacts` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `first` varchar(25) NOT NULL,
  `last` varchar(25) NOT NULL,
  `address` varchar(125) NOT NULL,
  `phone` varchar(65) NOT NULL,
  `mobile` varchar(65) NOT NULL,
  `email` varchar(65) NOT NULL,
  `website` varchar(65) NOT NULL,
  `comment` varchar(250) NOT NULL,
  `date` varchar(65) NOT NULL,
  `category` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgcontacts`
--

LOCK TABLES `cgcontacts` WRITE;
/*!40000 ALTER TABLE `cgcontacts` DISABLE KEYS */;
INSERT INTO `cgcontacts` VALUES (1,'Dave','Thorenson','301 E Ash Ave\r\nCasa Grande, AZ 85122','602-555-1111','800-555-1234','dave@jackofallmedia.org','http://jackofallmedia.com','','2015-09-02',0),(2,'Larry','Oliver','1444 W. Gazink\r\nPhoenix, AZ\r\n85029','520-555-1234','','support@tradesouthwest.com','http://tradesouthwest.com','comments go here','2015-09-02',0),(3,'Ajay','Sinha','T - 7 Adarsh Nagar','9039070770','9039070770','ajayksinha@rediffmail.com','0space.org','test','2016-06-13',0);
/*!40000 ALTER TABLE `cgcontacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgevents`
--

DROP TABLE IF EXISTS `cgevents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgevents` (
  `event_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `event_day` int(2) NOT NULL DEFAULT '0',
  `event_month` int(2) NOT NULL DEFAULT '0',
  `event_year` int(4) NOT NULL DEFAULT '0',
  `event_time` varchar(5) NOT NULL DEFAULT '',
  `event_title` varchar(200) NOT NULL DEFAULT '',
  `event_desc` text NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgevents`
--

LOCK TABLES `cgevents` WRITE;
/*!40000 ALTER TABLE `cgevents` DISABLE KEYS */;
INSERT INTO `cgevents` VALUES (1,3,9,2015,'12:00','New Event','Get there on time');
/*!40000 ALTER TABLE `cgevents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cginvoice`
--

DROP TABLE IF EXISTS `cginvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cginvoice` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL DEFAULT '',
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `invnum` varchar(25) DEFAULT NULL,
  `cust` varchar(12) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `work` text NOT NULL,
  `sub` int(7) DEFAULT NULL,
  `tax` int(7) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `paid` varchar(50) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cginvoice`
--

LOCK TABLES `cginvoice` WRITE;
/*!40000 ALTER TABLE `cginvoice` DISABLE KEYS */;
INSERT INTO `cginvoice` VALUES (1,'Billy Bob','602-555-5555','1234 What A St\r\nPhoenix, AZ 85009','11/22/2013','112213-2','counter','clone','needs repair of noisy gate',0,0,0,'',0),(2,'Billy Bob Nostrole','415-555-2222','1000 E. Samuel Dr\r\nJacksonville, HI','2015-08-31','83129-1','','Sale','1 - blue widget               $5\r\n3 - green widgets           $15\r\n2 - giant widgets             $20\r\n',40,0,40,'paid 8/31/2015',0),(3,'Billy Bob Nostrole','415-555-2222','1000 E. Samuel Dr\r\nJacksonville, HI','2015-09-03','83129-1','','Sale','1 - blue widget               $5\r\n3 - green widgets           $15\r\n2 - giant widgets             $20\r\n',40,0,40,'paid 8/31/2015',1),(4,'Billy Bob Nostrole','415-555-2222','1000 E. Samuel Dr\r\nJacksonville, HI','2015-09-03','83129-1','','Sale','1 - blue widget               $5\r\n3 - green widgets           $15\r\n2 - giant widgets             $20\r\n',40,0,40,'paid 9/3/2015',2);
/*!40000 ALTER TABLE `cginvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgquote`
--

DROP TABLE IF EXISTS `cgquote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgquote` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL DEFAULT '',
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  `invnum` varchar(25) DEFAULT NULL,
  `work` text NOT NULL,
  `sub` int(7) DEFAULT NULL,
  `tax` int(7) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `paid` varchar(50) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgquote`
--

LOCK TABLES `cgquote` WRITE;
/*!40000 ALTER TABLE `cgquote` DISABLE KEYS */;
INSERT INTO `cgquote` VALUES (1,'Quote Person','','1234 Anywhere','2015-09-03','','2 thingys',0,0,44,'',0),(2,'Quote Person','','1234 Anywhere','2015-09-03','9032015-Q3','2 thingys 10.00\r\n1 big thingy 20.00\r\n3 green thingy 30.00',60,0,60,'',0);
/*!40000 ALTER TABLE `cgquote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgvendors`
--

DROP TABLE IF EXISTS `cgvendors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgvendors` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `business` varchar(80) NOT NULL,
  `phone` varchar(60) NOT NULL,
  `hours` varchar(500) NOT NULL,
  `address` varchar(125) NOT NULL,
  `note` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgvendors`
--

LOCK TABLES `cgvendors` WRITE;
/*!40000 ALTER TABLE `cgvendors` DISABLE KEYS */;
INSERT INTO `cgvendors` VALUES (1,'National Widget Distributors','602-555-1111','blue widgets 7.95\r\ngreen widgets 6.95\r\ngiant widgets 11.95\r\nlittle widget 4.95\r\ntry new entry\r\n','1444 N. Some St. Phoenix, AZ 85055','12prcnt discount on bulk and then some'),(2,'test','222333444','dasfsadfas','ererrerre','rerererer');
/*!40000 ALTER TABLE `cgvendors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` char(64) COLLATE utf8_unicode_ci NOT NULL,
  `salt` char(16) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','b2a0ea2a84c71ade5a75f46e476f02a18e52c124a9b073235e639b26c9c97444','a7d43b75a9a35ba','admin@nomail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-22 10:13:33
