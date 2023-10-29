-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: fdv_smartphones
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `priceofsmartphones`
--

DROP TABLE IF EXISTS `priceofsmartphones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `priceofsmartphones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(50) NOT NULL,
  `model` varchar(70) NOT NULL,
  `performance` int NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `model_UNIQUE` (`model`),
  CONSTRAINT `performance_constraint` CHECK (((`performance` >= 0) and (`performance` <= 100))),
  CONSTRAINT `price_constraint` CHECK ((`price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priceofsmartphones`
--

LOCK TABLES `priceofsmartphones` WRITE;
/*!40000 ALTER TABLE `priceofsmartphones` DISABLE KEYS */;
INSERT INTO `priceofsmartphones` VALUES (1,'Xiaomi','Redmi Note 5',22,140),(2,'Xiaomi','Poco F3',76,435),(3,'Xiaomi','11 Ultra',85,950),(4,'OnePlus','10 Pro',91,700),(5,'OnePlus','9 Pro',85,680),(6,'OnePlus','Ace',83,600),(7,'Realme','GT Neo 3',83,600),(8,'Realme','C11',15,110),(9,'Google Pixel','6 Pro',78,950),(10,'Samsung','Galaxy S22 Ultra',87,1450),(11,'IPhone','13 Pro Max',99,1500),(12,'IPhone','11',86,570);
/*!40000 ALTER TABLE `priceofsmartphones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-23 17:31:27
