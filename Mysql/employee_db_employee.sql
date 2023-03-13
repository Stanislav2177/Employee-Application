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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `date_of_adding` date NOT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `completed_tasks` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Иван Иванов','ivan@ets.bg','0888123456','1990-01-01','2022-02-01',2500.00,2,1),(4,'Мария Маринова','maria@ets.bg','0888456789','1993-04-04','2022-02-04',2800.00,5,1),(5,'Анна Ангелова','anna@ets.bg','0888567890','1994-05-05','2022-02-05',2900.00,6,1),(6,'Димитър Димитров','dimitar@ets.bg','0888678901','1995-06-06','2022-02-06',3000.00,7,1),(7,'Стефан Стефанов','stefan@ets.bg','0888789012','1996-07-07','2022-02-07',3100.00,8,2),(8,'Николай Николов','nikolay@ets.bg','0888890123','1997-08-08','2022-02-08',3200.00,9,2),(9,'Елена Еленкова','elena@ets.bg','0888901234','1998-09-09','2022-02-09',3300.00,10,2),(10,'Светла Светлинова','svetla@ets.bg','0889012345','1999-10-10','2022-02-10',3400.00,11,2),(11,'Георги Маринов','georgi_m@ets.bg','0889123456','1990-11-11','2022-03-01',3500.00,12,2),(12,'Ивайло Иванов','ivaylo@ets.bg','0889234567','1991-12-12','2022-03-02',3600.00,13,2),(13,'Кристина Кръстева','kristina@ets.bg','0889345678','1992-01-13','2022-03-03',3700.00,14,3),(14,'Николина Николова','nikolina@ets.bg','0889456789','1993-02-14','2022-03-04',3800.00,15,3),(15,'Илия Илиев','iliya@ets.bg','0889567890','1994-03-15','2022-03-05',3900.00,16,3),(16,'Марин Маринов','marin@ets.bg','0889678901','1995-04-16','2022-03-06',4000.00,17,3),(17,'Мария Георгиева','mariq@ets.bg','0889789012','1996-05-17','2022-03-07',4100.00,18,3),(18,'Стефан Иванов','stefan_i@ets.bg','0889890123','1997-06-18','2022-03-08',4200.00,19,3),(19,'Елена Димитрова','elena_d@ets.bg','0889901234','1998-07-19','2022-03-09',4300.00,20,4),(20,'Камен Каменов','kamen@ets.bg','0889012345','1999-08-20','2022-03-10',4400.00,21,4),(21,'Радостина Йорданова','radostina@ets.bg','0889123456','1990-11-21','2022-03-11',4500.00,22,4),(22,'Марияна Иванова','mariq_i@ets.bg','0889234567','1991-12-22','2022-03-12',4600.00,23,4),(23,'Христофор Христов','hristofor@ets.bg','0889345678','1992-01-23','2022-03-13',4700.00,24,4),(24,'Христина Христова','hristina@ets.bg','0889456789','1993-02-24','2022-03-14',4800.00,25,4),(25,'Виктор Стефанов','viktor_s@ets.bg','0889567890','1994-03-25','2022-03-15',4900.00,26,5),(26,'Елена Каменова','elena_k@ets.bg','0889678901','1995-04-26','2022-03-16',5000.00,27,5),(27,'Ивайло Костадинов','ivaylo_k@ets.bg','0889789012','1996-05-27','2022-03-17',5100.00,28,5),(28,'Стефан Иванов','stefan_i2@ets.bg','0889890123','1997-06-28','2022-03-18',5200.00,29,5),(29,'Петя Димитрова','petq_d@ets.bg','0889901234','1998-07-29','2022-03-19',5300.00,30,5),(30,'Радослав Кръстев','radoslav_k@ets.bg','088918456','1990-11-21','2022-03-11',4500.00,0,5),(32,'Станислав Янков','stanislav@ets','0886232288','2002-06-26','2021-09-27',342.32,0,NULL),(33,'Венцислав Иванов','vencislav@ets.bg','0895064046','2002-05-25','2021-09-27',4432.00,0,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13  1:48:01
