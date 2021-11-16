-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitaldb
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
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` date DEFAULT NULL,
  `description` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `fk_appointment_doctor_idx` (`doctor_id`),
  KEY `fk_appointment_patient_idx` (`patient_id`),
  CONSTRAINT `fk_appointment_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_appointment_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,'2020-12-12','123',1,1,NULL,NULL,NULL,NULL);
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
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `years_experience` varchar(45) NOT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `medical_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_doctor_medical_idx` (`medical_id`),
  KEY `fk_doctor_user_idx` (`user_id`),
  CONSTRAINT `fk_doctor_medical` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fk_doctor_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Nguyễn','Phương Dung','2000-12-31','Nữ','0989054761','NPDDung@gmail.com','hơn 5 năm','https://res.cloudinary.com/ikj/image/upload/v1634963674/nguyen-phuong-dung_lcv4mo.jpg',1,NULL,NULL),(2,'Nguyễn','Thị Doan','1990-02-28','Nữ','01684346876','NTDDoan@gmail.com','hơn 20 năm','https://res.cloudinary.com/ikj/image/upload/v1634963870/nguyen-thi-doan_kzdtzt.jpg',1,15,NULL),(3,'Võ','Văn Anh','2000-12-31','Nam','0989054794','VVAAnh@gmail.com','hơn 15 năm','https://res.cloudinary.com/ikj/image/upload/v1634961259/vo-van-anh_brx3pj.jpg',1,16,NULL),(4,'Nguyễn','Trâm Anh','2000-12-31','Nữ','0989054100','NTATTram@gmail.com','hơn 5 năm','https://res.cloudinary.com/ikj/image/upload/v1634964426/nguyen-thi-ai-tram_z0i5ki.jpg',1,24,NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `unit_price` decimal(10,0) NOT NULL,
  `quantity` int NOT NULL,
  `expiry` date NOT NULL,
  `manufacturer` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug`
--

LOCK TABLES `drug` WRITE;
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` VALUES (1,'panadol extra',15000,1,'2021-12-12','2020-12-12'),(2,'Zolpidem',2000,222,'2025-07-17','2021-11-10'),(3,'Memantine',5000,2222,'2025-07-17','2021-11-10'),(5,'Levothyroxine',3000,1000,'2025-10-13','2021-11-24'),(6,'Etonogestrel +',5000,3000,'2025-07-09','2021-11-13'),(7,'Vitamin D',6000,1000,'2025-10-13','2021-11-13'),(8,'Varenicline',4000,1000,'2026-11-13','2021-11-17');
/*!40000 ALTER TABLE `drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `prescription_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_prescription_idx` (`prescription_id`),
  KEY `fk_invoice_nurse_idx` (`nurse_id`),
  CONSTRAINT `fk_invoice_nurse` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`),
  CONSTRAINT `fk_invoice_prescription` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'2020-12-12 00:00:00',20000,1,1),(2,'2020-11-12 00:00:00',10000,1,1),(3,'2020-11-12 00:00:00',10000,1,1),(4,'2021-11-25 00:00:00',20000,1,1),(5,'2021-11-25 00:00:00',0,1,1),(6,'2021-11-09 01:46:46',90000,1,1),(7,'2021-11-09 01:47:15',90000,1,1),(8,'2022-09-09 01:47:15',90000,1,1),(9,'2021-11-14 16:18:22',90000,4,1);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tổ chức y khoa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES (1,'Khoa Tim Mạch','Chữa các bệnh liên quan mật thiết đến tim.cc','https://res.cloudinary.com/ikj/image/upload/v1634963439/khoanoitongquat_bfjvq9.jpg'),(2,'Khoa Tâm lý','Chữa các bệnh về tâm sinh lý','https://res.cloudinary.com/ikj/image/upload/v1634963260/IMG_1830_hucd9j.jpg'),(3,'Khoa Da Liễu','Các vấn đề bệnh lý Da liễu được chẩn đoán, điều trị','https://res.cloudinary.com/ikj/image/upload/v1634963168/rhm_uudtci.png'),(4,'Khoa Tai Mũi Họng','Chuyên khám và điều trị :\r\n  Đau tai, chảy mũ tai và ù tai, ngứa tai, nghe kém, thủng màng nhĩ, chấn thương tai.Đau họng, nuốt vướng, khó nuốt, hơi thở hôi.Chấn thương mũi, dị vật vùng TMH, hóc xương, các khối u và đường dò cổ mặt.Ngứa mũi, hắt xì, sổ mũi, chảy máu mũi, đau mũi, nghẹt mũi, mất mùi.Nội soi chẩn đoán hình ảnh rõ đẹp, \r\nchính xác phát hiện sớm các bệnh lí ung thư vòm mũi họng, thanh quản giúp điều trị nhanh chóng hiệu quả.','https://res.cloudinary.com/ikj/image/upload/v1634961452/9_NOI_SOI_TAI_ooj1xj.jpg'),(5,'Khoa Nhi','   Phòng khám chuyên khoa Nhi được Bs CKI về nhi khoa nhiều kinh nghiệm đảm trách cùng đội ngũ nhân viên luôn nhiệt tình, vui vẻ với đầy đủ các trang thiết bị y tế, xét nghiệm mới nhất. Không gian phòng khám thoáng mát sạch đẹp, tạo môi trường thân thiện với các bệnh Nhi.','https://res.cloudinary.com/ikj/image/upload/v1634961785/khamnhi2_ojumoi.jpg'),(6,'Khoa  Mắt',' Khám chuyên sâu và điều trị hiệu quả các bệnh lý của mắt.   Khám phát hiện sớm và điều trị hiệu quả  các trường hợp bệnh lý cườm nước - tăng nhãn áp và cườm khô - đục thể thủy tinh .  Phối hợp liên chuyên khoa mắt và nội tiết để điều trị hiệu quả bệnh lý võng mạc do tiểu đường.Đo khúc xạ - kính chính xác và tư vấn nhiều phương pháp điều trị chuyên sâu các bất thường khúc xạ của mắt.  Điều trị hiệu quả các bệnh lý bề mặt giác mạc: như bệnh lý khô mắt, viêm kết mạc cấp tính hoặc mãn tính.','https://res.cloudinary.com/ikj/image/upload/v1634962015/khoamat_ewitdt.jpg'),(9,'Khoa cấp cứu','Khoa cấp cứu và hỗ trợ','https://res.cloudinary.com/ikj/image/upload/v1636700664/medical/oinnllqhv8zr60xldrdq.png');
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
  `num` int NOT NULL,
  `date` datetime DEFAULT NULL,
  `fee` decimal(10,0) NOT NULL,
  `sympton` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diagnosis` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `receive` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `fk_medical_examination_card_nurse_idx` (`nurse_id`),
  KEY `fk_medical_examination_card_patient_idx` (`patient_id`),
  KEY `fk_medical_examination_card_doctor_idx` (`doctor_id`),
  CONSTRAINT `fk_medical_examination_card_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_medical_examination_card_nurse` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`),
  CONSTRAINT `fk_medical_examination_card_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_examination_card`
--

LOCK TABLES `medical_examination_card` WRITE;
/*!40000 ALTER TABLE `medical_examination_card` DISABLE KEYS */;
INSERT INTO `medical_examination_card` VALUES (1,2,'2021-11-14 14:14:30',90000,'đau nữa đầu, ỗi mữa sốt co giật','dựt kinh phong',1,1,2,_binary '\0'),(2,3,'2021-11-14 14:14:38',90000,'khó ngũ ngất ','Đau tim',1,1,2,_binary '\0'),(3,3,'2021-11-14 14:37:53',90000,'khó ngủ','khó ngủ',1,1,2,_binary '\0'),(4,1,'2021-11-14 15:01:10',90000,'đau nữa đầu, ỗi mữa sốt co giật','dựt kinh phong',2,1,3,_binary '\0'),(5,1,'2021-11-16 12:34:45',90000,'khó ngũ ngất ','Đau tim',5,1,2,_binary ''),(6,2,'2021-11-16 12:37:46',90000,'Khó ngu','thiếu máu tim',6,1,2,_binary '');
/*!40000 ALTER TABLE `medical_examination_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
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
  `address` varchar(1000) DEFAULT NULL,
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
INSERT INTO `nurse` VALUES (1,'Lê','Thị thanh','2000-03-16','Nữ','0989076898','Thanh@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,14,NULL),(2,'Lý','Nhã Hân','2000-02-16','Nữ','0989076844','Han@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,25,NULL),(3,'Lê','Tuệ Như','1998-02-16','Nữ','0989076844','Nhu@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,26,NULL);
/*!40000 ALTER TABLE `nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_patient_user_idx` (`user_id`),
  CONSTRAINT `fk_patient_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Lê','Thị Vy','2000-12-31','Nữ','098765433','59481@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'Gò vấp, HCM'),(2,'Trần','Lê','2000-12-31','Nam','098765433','132@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'tân bình'),(3,'Lee','Ly','2000-12-12','Nam','0987654','1@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,NULL),(4,'nguyễn','mơ','2000-12-31','Nam','333','333','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'bà rịa vũng tàu'),(5,'Lê','Thị Hòa Binh','2000-12-31','Nữ','05839582048','jhk@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'TP Hòa Bình'),(6,'Trần','Hồng Thấm','2000-12-31','Nữ','123555','jhk@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637029278/patient/mgktusvshuubmsntz5rj.jpg',NULL,'tân bình');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription`
--

DROP TABLE IF EXISTS `prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `diagnosis` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescription_doctor_idx` (`doctor_id`),
  KEY `fk_prescription_patient_idx` (`patient_id`),
  CONSTRAINT `fk_prescription_doctor` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `fk_prescription_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription` DISABLE KEYS */;
INSERT INTO `prescription` VALUES (1,'2020-12-12 00:00:00',1,1,'s'),(2,'2020-12-12 00:00:00',2,2,'s'),(3,'2020-12-12 00:00:00',2,2,'s'),(4,'2021-11-10 00:00:00',2,1,''),(5,'2021-11-16 00:00:00',2,6,'Lo lắng dẫn đến suy nhược'),(6,'2021-11-16 00:00:00',2,5,'lười vận động');
/*!40000 ALTER TABLE `prescription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescription_drug`
--

DROP TABLE IF EXISTS `prescription_drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescription_drug` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_guide` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `prescription_id` int NOT NULL,
  `drug_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prescription_drug_idx` (`drug_id`),
  KEY `fk_prescription_drug_prescription_idx` (`prescription_id`),
  CONSTRAINT `fk_prescription_drug` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id`),
  CONSTRAINT `fk_prescription_drug_prescription` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_drug`
--

LOCK TABLES `prescription_drug` WRITE;
/*!40000 ALTER TABLE `prescription_drug` DISABLE KEYS */;
INSERT INTO `prescription_drug` VALUES (4,'',1,4,1),(5,'sáng 1 viên chiều 1 viên',30,5,7),(6,'sáng 1 viên',15,5,8),(7,'Uống 1 sáng 1 chiều',20,6,1),(8,'1 sáng 1 chiều',20,6,5);
/*!40000 ALTER TABLE `prescription_drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fee` decimal(10,0) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Đo điện tim(Ecg)',100000,'https://res.cloudinary.com/ikj/image/upload/v1636719495/service/sraix48ca54cv4t9gvzw.jpg'),(2,'Khám sức khỏe tổng quát',90000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png'),(3,'Xét nghiệm máu',200000,NULL),(4,'Chụp x quang kỹ thuật số',200000,NULL),(5,'Răng hàm mặt',200000,NULL),(6,'Nội soi tai mũi họng',200000,NULL);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services_invoice`
--

DROP TABLE IF EXISTS `services_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services_invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fee` decimal(10,0) NOT NULL,
  `created_date` datetime NOT NULL,
  `service_id` int NOT NULL,
  `patient_id` int NOT NULL,
  `nurse_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_services_invoice_services_idx` (`service_id`),
  KEY `fk_services_invoice__idx` (`patient_id`),
  KEY `fk_services_invoice__idx1` (`nurse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services_invoice`
--

LOCK TABLES `services_invoice` WRITE;
/*!40000 ALTER TABLE `services_invoice` DISABLE KEYS */;
INSERT INTO `services_invoice` VALUES (1,20000,'2020-12-12 00:00:00',1,1,1),(2,10000,'2020-11-11 00:00:00',1,1,1),(3,1,'2021-11-05 00:00:00',1,1,1),(4,1,'2021-11-05 00:00:00',1,1,1),(5,1,'2021-11-05 00:00:00',1,1,1),(6,1,'2021-12-05 00:00:00',1,1,1),(7,1,'2021-11-05 00:00:00',1,1,1),(8,1000000,'2021-11-05 00:00:00',1,1,1),(9,2112,'2021-11-05 00:00:00',2,1,1),(10,1000000,'2021-11-05 00:00:00',1,2,1),(11,2112,'2021-12-05 00:00:00',2,2,1),(12,1000000,'2021-11-05 00:00:00',1,2,1),(13,1000000,'2021-11-05 00:00:00',1,1,1),(14,1000000,'2021-11-05 23:38:03',1,1,1),(15,2112,'2021-11-05 23:38:54',2,1,1),(16,1000000,'2021-11-05 23:39:02',1,1,1),(17,1000000,'2021-11-05 23:45:09',1,1,1),(18,1000000,'2021-11-05 23:48:29',1,1,1),(19,1000000,'2021-11-05 23:48:57',1,1,1),(20,1000000,'2021-11-05 23:49:21',1,1,1),(21,1000000,'2021-11-05 23:49:23',1,1,1),(22,1000000,'2021-11-05 23:49:34',1,1,1),(23,1000000,'2021-11-05 23:51:43',1,1,1),(24,2112,'2021-11-06 00:51:00',2,1,1),(25,1000000,'2021-11-06 00:52:19',1,1,1),(26,2112,'2021-11-08 16:59:54',2,1,1),(27,2112,'2026-11-08 17:08:23',2,1,1),(28,200000,'2021-11-13 16:24:30',4,1,1),(29,200000,'2021-11-13 16:24:50',4,1,1),(30,2112,'2021-11-14 00:53:17',2,1,1),(31,1000000,'2021-11-14 01:53:44',1,1,1),(32,200000,'2021-11-14 14:46:51',4,1,1),(33,200000,'2021-11-15 23:11:21',4,1,1),(34,200000,'2021-11-15 23:12:56',3,1,1);
/*!40000 ALTER TABLE `services_invoice` ENABLE KEYS */;
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
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slide`
--

LOCK TABLES `slide` WRITE;
/*!40000 ALTER TABLE `slide` DISABLE KEYS */;
INSERT INTO `slide` VALUES (1,'Phòng chống covid','https://res.cloudinary.com/ikj/image/upload/v1636699203/slide/xymg8ls3dp4ryvhtsctu.png','Chung tay chống covid',_binary ''),(2,'Kính bảo hộ','https://res.cloudinary.com/ikj/image/upload/v1636699285/slide/a3xrgbmk7yduhuyvhhgq.png','Kính bảo hộ',_binary ''),(3,'Ngưng','https://res.cloudinary.com/ikj/image/upload/v1636699361/slide/jx7mnxvr0rwfgebcqzen.png ','Ngưng hoạt động',_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'admin12345','$2a$10$m9UGDIjt4jU1sxQA599dNeqoj.z.ZijlhkrBblYRy/AndbsqcdrwK','433333','Lê điền tài','0kg@gmail.com','ROLE_ADMIN','123555',NULL,'https://res.cloudinary.com/ikj/image/upload/v1633071771/Doctor/ttsqktplgif3udby8kcz.png'),(12,'1doctorphuongdung','123','123','123','123','ROLE_DOCTOR','123',_binary '','https://res.cloudinary.com/ikj/image/upload/v1634963674/nguyen-phuong-dung_lcv4mo.jpg'),(14,'1nurseleff','$2a$10$4qP/ywFPozmP5Doizl7MXOfjMlBKfJMRk5ClFV3s09xfxLMPcvZny','Lê','ff','ss@gmail.com','ROLE_NURSE','123555',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634561416/nurse/znfsjellubqebnedepue.png'),(15,'2doctorthidoannguyen','$2a$10$VF8mkx08De8pyB1XDt6jfecPpqt6kufJDzw/CJmp/PlbOLSOTK/C6','Thị Doan','Nguyễn','NTDDoan@gmail.com','ROLE_DOCTOR','01684346876',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634963870/nguyen-thi-doan_kzdtzt.jpg'),(16,'3doctorvananhvo','$2a$10$o6y22xSDDNQtGuX/Ox7Atej5q2T25Jaczns8OE3ci40xG3q.YWst2','Văn Anh','Võ','VVAAnh@gmail.com','ROLE_DOCTOR','0989054794',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634961259/vo-van-anh_brx3pj.jpg'),(24,'4doctorthiaitramnguyen','$2a$10$zkQ.iF3CZRHY6kcwrAl5Ye1nMlNSwUumHtinRs4zCRdcxZdD296Xe','Thị Ái Trâm','Nguyễn','NTATTram@gmail.com','ROLE_DOCTOR','0989054100',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634964426/nguyen-thi-ai-tram_z0i5ki.jpg'),(25,'3nurselethi','$2a$10$TBnQFxQVkHXVu8hfNvUINuicS8MyFxkOieWHGiTkACNhms5xq5XMq','Lê','thị','ss@gmail.com','ROLE_NURSE','333',NULL,'https://res.cloudinary.com/ikj/image/upload/v1636197790/nurse/gfvz6eexk5whidxmx7ye.png'),(26,'3nurselethi3','$2a$10$TBnQFxQVkHXVu8hfNvUINuicS8MyFxkOieWHGiTkACNhms5xq5XMq','Lê','thị','ss@gmail.com','ROLE_NURSE','3333',_binary '','https://res.cloudinary.com/ikj/image/upload/v1636197790/nurse/gfvz6eexk5whidxmx7ye.png');
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

-- Dump completed on 2021-11-16 21:39:33
