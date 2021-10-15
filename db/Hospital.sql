-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospitaldb
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `appointment_date` date DEFAULT NULL,
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `appointment_id` int NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `fk_appointment_doctor_idx` (`doctor_id`),
  KEY `fk_appointment_patient_idx` (`patient_id`),
  CONSTRAINT `fk_appointment_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_appointment_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `years_experience` int NOT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `medical_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_doctor_medical_idx` (`medical_id`),
  KEY `fk_doctor_user_idx` (`user_id`),
  CONSTRAINT `fk_doctor_medical` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_doctor_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Nguyễn Bá','Hợp','1989-09-12','Nam','0989076812','NBHHop@gmail.com',10,'https://res.cloudinary.com/ikj/image/upload/v1632564324/BSHOP_vfpqqo.jpg',1,1),(2,'Nguyễn Thanh','Tâm','1989-03-19','Nam','0903456788','NTTTam@gmail.com',10,'https://res.cloudinary.com/ikj/image/upload/v1632564324/BSLAM_gsgeav.jpg',2,2);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug` (
  `id` int NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `unit_price` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quantity` int NOT NULL,
  `expiry` date NOT NULL,
  `manufacturer` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug`
--

LOCK TABLES `drug` WRITE;
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` VALUES (1,'panaldon','10000',12,'2023-01-12','2021-01-12'),(2,'panamax','10000',12,'2025-01-01','2021-10-02'),(3,'alaxan ','20000',12,'2025-01-02','2021-01-12');
/*!40000 ALTER TABLE `drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_detail`
--

DROP TABLE IF EXISTS `drug_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_detail` (
  `prescription_id` int NOT NULL,
  `drug_id` int NOT NULL,
  `user_guide` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  KEY `fk_drug_detail_idx` (`drug_id`),
  KEY `fk_drug_detail_prescription_idx` (`prescription_id`),
  CONSTRAINT `fk_drug_detail_drug` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id`),
  CONSTRAINT `fk_drug_detail_prescription` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_detail`
--

LOCK TABLES `drug_detail` WRITE;
/*!40000 ALTER TABLE `drug_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `drug_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL,
  `day` varchar(45) DEFAULT NULL,
  `fee` int DEFAULT NULL,
  `prescription_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_prescription_idx` (`prescription_id`),
  CONSTRAINT `fk_invoice_prescription` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_detial`
--

DROP TABLE IF EXISTS `invoice_detial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_detial` (
  `invoice_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  KEY `fk_invoice_detail_invoice_idx` (`invoice_id`),
  KEY `fk_invoice_detail_patient_idx` (`patient_id`),
  CONSTRAINT `fk_invoice_detail_invoice` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_detail_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_detial`
--

LOCK TABLES `invoice_detial` WRITE;
/*!40000 ALTER TABLE `invoice_detial` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_detial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tổ chức y khoa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES (1,'Tim mạch','aaa','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png'),(2,'Tâm lý','sss','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png'),(3,'sssssssss','ssssssssssss','https://res.cloudinary.com/ikj/image/upload/v1633074112/medical/vzwwq7gfg7n0lovtztm8.png'),(4,'Răng hàm','1234','https://res.cloudinary.com/ikj/image/upload/v1634229947/medical/kmolmgweznyc1irle1my.jpg');
/*!40000 ALTER TABLE `medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_examination_card`
--

DROP TABLE IF EXISTS `medical_examination_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_examination_card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fee` decimal(10,0) NOT NULL,
  `sympton` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diagnosis` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medical_examination_card_patient_idx` (`patient_id`),
  KEY `fk_medical_examination_card_nurse_idx` (`nurse_id`),
  CONSTRAINT `fk_medical_examination_card_nurse` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`),
  CONSTRAINT `fk_medical_examination_card_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_examination_card`
--

LOCK TABLES `medical_examination_card` WRITE;
/*!40000 ALTER TABLE `medical_examination_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_examination_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_examination_card_detail`
--

DROP TABLE IF EXISTS `medical_examination_card_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_examination_card_detail` (
  `medical_examination_card_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `symptom` varchar(45) DEFAULT NULL,
  `diagnosis` varchar(45) DEFAULT NULL,
  KEY `fk_medical_examination_card_detail_medical_examination_card_idx` (`medical_examination_card_id`),
  KEY `fk_medical_examination_card_detail_doctor_idx` (`doctor_id`),
  CONSTRAINT `fk_medical_examination_card_detail_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_medical_examination_card_detail_medical_examination_card` FOREIGN KEY (`medical_examination_card_id`) REFERENCES `medical_examination_card` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_examination_card_detail`
--

LOCK TABLES `medical_examination_card_detail` WRITE;
/*!40000 ALTER TABLE `medical_examination_card_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_examination_card_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_record`
--

DROP TABLE IF EXISTS `medical_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_medical_record_patient_idx` (`patient_id`),
  KEY `fk_medical_record_doctor_idx` (`doctor_id`),
  CONSTRAINT `fk_medical_record_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_medical_record_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_record`
--

LOCK TABLES `medical_record` WRITE;
/*!40000 ALTER TABLE `medical_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nurse`
--

DROP TABLE IF EXISTS `nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nurse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `medical_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nurse_medical_idx` (`medical_id`),
  KEY `fk_nurse_user_idx` (`user_id`),
  CONSTRAINT `fk_nurse_medical` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`),
  CONSTRAINT `fk_nurse_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES (1,'Thị Quỳnh','Nguyễn ','1999-12-12','Nữ','0989076754','NTQQuynh@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',1,1),(2,'Tuệ An','Tống ','1997-01-12','Nữ','0989076172','TTAAn@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',1,2),(3,'Hoàng Châu','Ma ','1998-01-23','Nữ','0989051821','MHCChau@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',1,3);
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_patient_user_idx` (`user_id`),
  CONSTRAINT `fk_patient_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Lê','Tuân','1999-05-12','Nam','0903356900','Tuan@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',1),(2,'Huỳnh','An Lộc','1991-07-18','Nam','0989051283','Loc@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',2),(3,'Lê','Tuấn Anh','2001-11-12','Nam','0989065128','Anh@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1631282315/login-img_pqwwl4.png',3);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescription_doctor_idx` (`doctor_id`),
  KEY `fk_prescription_patient_idx` (`patient_id`),
  CONSTRAINT `fk_prescription_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_prescription_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `medical_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_service_medical_idx` (`medical_id`),
  CONSTRAINT `fk_service_medical` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_invoice`
--

DROP TABLE IF EXISTS `service_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_invoice` (
  `id` int NOT NULL,
  `fee` decimal(10,0) DEFAULT NULL,
  `created_day` date DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_service_invoice_service_idx` (`service_id`),
  KEY `fk_service_invoice_patient_idx` (`patient_id`),
  KEY `fk_service_invoice_nurse_idx` (`nurse_id`),
  CONSTRAINT `fk_service_invoice_nurse` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`),
  CONSTRAINT `fk_service_invoice_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `fk_service_invoice_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_invoice`
--

LOCK TABLES `service_invoice` WRITE;
/*!40000 ALTER TABLE `service_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slide`
--

DROP TABLE IF EXISTS `slide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slide` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `image` varchar(100) NOT NULL,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slide`
--

LOCK TABLES `slide` WRITE;
/*!40000 ALTER TABLE `slide` DISABLE KEYS */;
/*!40000 ALTER TABLE `slide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `user_role` varchar(45) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `active` bit(1) DEFAULT b'1',
  `image` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','admin','admin','ledientai16@gmail.com','ROLE_ADMIN','089879752',_binary '',''),(2,'ohlala12313','$2a$10$3MEIGr3H9XqHM9eaOmQ.cOUe1/oGm/Jh/MU/0KmccWm8OGlYEf63m','admin1','ddaohlaa@gmail.com','ohlala12313@gmail.com','ROLE_USER','1',NULL,''),(3,'ww','$2a$10$hDakl2UupzNOP77ddeLyUOV/EoNuc.qfK5jUkd1wnIYjZ0iYmJVdq','ww','www','ohlala12313@gmail.com','ROLE_USER','123555',NULL,''),(4,'2222','$2a$10$pQMdR6F9ijFTYmWjjf7rs.bogKECAPPvwkl1upx6WaGeiNsRRI136','admin12','1111','ohlala12313@gmail.com','ROLE_USER','sss',NULL,''),(5,'admin13','$2a$10$CyO13x5EmzoS40rL2qYGBunEyfBjoJC3hLCBf3ZnS4sl7lu9HN/tO','dsaaaaaa','sadddd','jhk@gmail.com','ROLE_USER','333',NULL,''),(6,'user999','$2a$10$1B5ol9cROZPuXPg3VtiB9OEgTWqjJuFpGdtY4QLQrDXlBLbl7mnH2','Lê','dđ','sss@gmail.com','ROLE_USER','333',NULL,'https://res.cloudinary.com/ikj/image/upload/v1632043130/tvoztwrxa8u1hfxitbab.jpg'),(7,'ohlala12314','$2a$10$Kkiaj4AZKe2JyFn9eoPfOuKHxu36H0T8Sn.2vYwuKR07fyMNfmmH6','Lê','ddarr','ohlala12313@gmail.com','ROLE_USER','7777777777',NULL,'https://res.cloudinary.com/ikj/image/upload/v1632239770/j17q1edtzrcw5brbhbhv.png'),(8,'admin12345','$2a$10$u3zTlS7.24ETia5fxO7esOu6ZPwVcseIucW9RIrxcmwv5hAQKO3Qe','ssssssss333','ssssssss333','sss@gmail.com','ROLE_USER','123555',NULL,'https://res.cloudinary.com/ikj/image/upload/v1632239900/lxacjygnav268epmshnv.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-15 14:30:08
