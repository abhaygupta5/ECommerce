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
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant` (
  `merchant_id` int(11) NOT NULL,
  `merchant_address` varchar(255) DEFAULT NULL,
  `merchant_email` varchar(255) DEFAULT NULL,
  `merchant_name` varchar(255) DEFAULT NULL,
  `merchant_phone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`merchant_id`),
  UNIQUE KEY `UK_8mxk85y1tp1d7s1a5gh3om7ks` (`merchant_email`),
  UNIQUE KEY `UK_9d99mmka6ug1kl85hatmdji3m` (`merchant_name`),
  UNIQUE KEY `UK_jqxp0bcuqmk0ec1lr6t0q3ouj` (`merchant_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
INSERT INTO `merchant`(`merchant_id`,`merchant_name`,`merchant_address`,`merchant_email`, `merchant_phone`) VALUES (1,'SuperComNet','H.No. 123, 13th cross road, bangalore, karnataka','anmol.gupta@coviam.com',9234325678),(2,'RohanCom','H.No. 54, 17th cross road, bangalore, karnataka','rohan.sharma@coviam.com',9298756708),(3,'Ablish Ltd','H.No. 1588, 11th cross road, bangalore, karnataka','abhilash.gupta@coviam.com',9298098508);

/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_rating`
--

DROP TABLE IF EXISTS `merchant_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant_rating` (
  `merchant_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`merchant_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_rating`
--

LOCK TABLES `merchant_rating` WRITE;
INSERT INTO `merchant_rating` VALUES (1,1,4),(1,2,3),(1,3,5),(2,1,5),(2,2,2),(3,2,4);

/*!40000 ALTER TABLE `merchant_rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchant_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_merchant`
--

DROP TABLE IF EXISTS `product_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_merchant` (
  `merchant_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_price` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`merchant_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_merchant`
--

LOCK TABLES `product_merchant` WRITE;
/*!40000 ALTER TABLE `product_merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_merchants`
--

DROP TABLE IF EXISTS `top_merchants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `top_merchants` (
  `product_id` int(11) NOT NULL,
  `merchant_list` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_merchants`
--

LOCK TABLES `top_merchants` WRITE;
/*!40000 ALTER TABLE `top_merchants` DISABLE KEYS */;
/*!40000 ALTER TABLE `top_merchants` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-23 12:52:32
