-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: usersdb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `salt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `password` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Mary123','Mary','7b90ec2ecd553a642370c460f951a8d50fbfe1af0aacd94d5a9abc2a7c3abe3f','Mara','patient','kcS/w61jDTIBXQsgrkn/tw=='),(2,'Nara90','Nara','e38ab52d8f4b7f7bd26cd5118fd5b7f97411c14496c36f9f63ed7c08d6b0d768','Narou','doctor','kcS/w61jDTIBXQsgrkn/tw=='),(3,'Sally2','Saly','9d3ae12534f23bcabfe5225c9da0e9ee6fd77f898c91d97e02d0c1c251866ac4','Salu','admin','kcS/w61jDTIBXQsgrkn/tw=='),(4,'Kana1','Kana','1016304f1bce18c9fcac5cf6f991d54d563599e62c4a05a55ca7104c503356de','Kanou','patient','kcS/w61jDTIBXQsgrkn/tw=='),(5,'Marios212','Marios','72d7640c961e4754716ab871b5f4cde125b00b7d45d842e50c5f5ec1d58fbafb','Georgiou','admin','kcS/w61jDTIBXQsgrkn/tw=='),(6,'Nota1','Nota','7b90ec2ecd553a642370c460f951a8d50fbfe1af0aacd94d5a9abc2a7c3abe3f','Notaru','doctor','kcS/w61jDTIBXQsgrkn/tw=='),(7,'Mara','Maran','7b90ec2ecd553a642370c460f951a8d50fbfe1af0aacd94d5a9abc2a7c3abe3f','Notaru','doctor','kcS/w61jDTIBXQsgrkn/tw==');
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

-- Dump completed on 2021-09-08 15:20:33
