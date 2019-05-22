-- MySQL dump 10.13  Distrib 5.7.23, for osx10.14 (x86_64)
--
-- Host: localhost    Database: Merchants
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `Merchant`
--

DROP TABLE IF EXISTS `Merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Merchant` (
  `merchantId` int(11) NOT NULL,
  `merchantName` varchar(100) DEFAULT NULL,
  `merchantAddress` varchar(100) NOT NULL,
  `merchantEmail` varchar(100) DEFAULT NULL,
  `merchantPhone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`merchantId`),
  UNIQUE KEY `merchantName` (`merchantName`),
  UNIQUE KEY `merchantEmail` (`merchantEmail`),
  UNIQUE KEY `merchantPhone` (`merchantPhone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Merchant`
--

LOCK TABLES `Merchant` WRITE;
/*!40000 ALTER TABLE `Merchant` DISABLE KEYS */;
INSERT INTO `Merchant` VALUES (1,'SuperComNet','H.No. 123, 13th cross road, bangalore, karnataka','anmol.gupta@coviam.com',9234325678),(2,'RohanCom','H.No. 54, 17th cross road, bangalore, karnataka','rohan.sharma@coviam.com',9298756708),(3,'Ablish Ltd','H.No. 1588, 11th cross road, bangalore, karnataka','abhilash.gupta@coviam.com',9298098508);
/*!40000 ALTER TABLE `Merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MerchantRating`
--

DROP TABLE IF EXISTS `MerchantRating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MerchantRating` (
  `merchantId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`merchantId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MerchantRating`
--

LOCK TABLES `MerchantRating` WRITE;
/*!40000 ALTER TABLE `MerchantRating` DISABLE KEYS */;
INSERT INTO `MerchantRating` VALUES (1,1,4),(1,2,3),(1,3,5),(2,1,5),(2,2,2),(3,2,4);
/*!40000 ALTER TABLE `MerchantRating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductMerchant`
--

DROP TABLE IF EXISTS `ProductMerchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProductMerchant` (
  `merchantId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `stock` int(11) NOT NULL DEFAULT '0',
  `productPrice` double NOT NULL,
  PRIMARY KEY (`merchantId`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductMerchant`
--

LOCK TABLES `ProductMerchant` WRITE;
/*!40000 ALTER TABLE `ProductMerchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProductMerchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TopMerchants`
--

DROP TABLE IF EXISTS `TopMerchants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TopMerchants` (
  `productId` int(11) NOT NULL,
  `merchantList` text,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TopMerchants`
--

LOCK TABLES `TopMerchants` WRITE;
/*!40000 ALTER TABLE `TopMerchants` DISABLE KEYS */;
/*!40000 ALTER TABLE `TopMerchants` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-23  0:04:57
