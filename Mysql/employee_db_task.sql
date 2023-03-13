-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employee_db
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id_assigned_to` int DEFAULT NULL,
  `title` varchar(40) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `given_at` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `finished_at` date DEFAULT NULL,
  KEY `employee_to_tasks` (`id_assigned_to`),
  CONSTRAINT `employee_to_tasks` FOREIGN KEY (`id_assigned_to`) REFERENCES `employee` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (5,'new changed','Description of task 1','2022-06-10','2023-04-01','2024-02-11'),(5,'Task 1','Description of task 1','2022-06-10','2023-04-15','2023-02-01'),(7,'Task 1','Description of task 1','2022-06-10','2023-03-15','2023-02-01'),(8,'Task 1','Description of task 1','2022-06-10','2023-04-01','2023-02-01'),(9,'Task 1','Description of task 1','2022-06-10','2023-04-15','2023-02-01'),(12,'Task 1','Description of task 1','2022-06-10','2023-03-15','2023-02-01'),(13,'Task 1','Description of task 1','2022-06-10','2023-04-01','2023-02-01'),(14,'Task 1','Description of task 1','2022-06-10','2023-04-15','2023-02-01'),(17,'Task 1','Description of task 1','2022-06-10','2023-03-15','2023-02-01'),(18,'Task 1','Description of task 1','2022-06-10','2023-04-01','2023-02-01'),(20,'New updated task','Description of task 1','2022-06-10','2023-09-09','2023-02-01'),(20,'Task 1','Description of task 1','2022-06-10','2023-03-15','2023-02-01'),(21,'Task 1','Description of task 1','2022-06-10','2023-04-01','2023-02-01'),(23,'Task 1','Description of task 1','2022-06-10','2023-04-15','2023-02-01'),(5,'new changed','test task from console','2022-02-02','2022-02-06',NULL),(5,'new changed','second task added from console','2021-02-02','2023-04-05',NULL),(4,'task added from app','description description 12411','2023-03-12','2024-03-03',NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13  1:48:02
