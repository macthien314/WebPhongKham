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
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` date DEFAULT NULL,
  `description` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
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
INSERT INTO `appointment` VALUES (1,'2020-12-12','123',NULL,NULL,NULL,NULL,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Nguy???n','Ph????ng Dung','2000-12-31','N???','0989054761','NPDDung@gmail.com','h??n 5 n??m','https://res.cloudinary.com/ikj/image/upload/v1634963674/nguyen-phuong-dung_lcv4mo.jpg',1,9,NULL),(2,'Nguy???n','Th??? Doan','1990-02-28','N???','01684346876','NTDDoan@gmail.com','h??n 20 n??m','https://res.cloudinary.com/ikj/image/upload/v1634963870/nguyen-thi-doan_kzdtzt.jpg',1,4,NULL),(3,'V??','V??n Anh','2000-12-31','Nam','0989054794','VVAAnh@gmail.com','h??n 15 n??m','https://res.cloudinary.com/ikj/image/upload/v1634961259/vo-van-anh_brx3pj.jpg',1,5,NULL),(4,'Nguy???n','Tr??m Anh','2000-12-31','N???','0989054100','NTATTram@gmail.com','h??n 5 n??m','https://res.cloudinary.com/ikj/image/upload/v1634964426/nguyen-thi-ai-tram_z0i5ki.jpg',1,6,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug`
--

LOCK TABLES `drug` WRITE;
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` VALUES (1,'panadol extra',15000,1,'2021-12-12','2020-12-12'),(2,'Zolpidem',2000,222,'2025-07-17','2021-11-10'),(3,'Memantine',5000,2222,'2025-07-17','2021-11-10'),(4,'Levothyroxine',3000,1000,'2025-10-13','2021-11-24'),(5,'Etonogestrel +',5000,3000,'2025-07-09','2021-11-13'),(6,'Vitamin D',6000,1000,'2025-10-13','2021-11-13'),(7,'Varenicline',4000,1000,'2026-11-13','2021-11-17');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='t??? ch???c y khoa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES (1,'Khoa Tim M???ch','Ch???a c??c b???nh li??n quan m???t thi???t ?????n tim.','https://res.cloudinary.com/ikj/image/upload/v1634963439/khoanoitongquat_bfjvq9.jpg'),(2,'Khoa T??m l??','Ch???a c??c b???nh v??? t??m sinh l??.','https://res.cloudinary.com/ikj/image/upload/v1634963260/IMG_1830_hucd9j.jpg'),(3,'Khoa Da Li???u','C??c v???n ????? b???nh l?? Da li???u ???????c ch???n ??o??n, ??i???u tr???','https://res.cloudinary.com/ikj/image/upload/v1634963168/rhm_uudtci.png'),(4,'Khoa Tai M??i H???ng','Chuy??n kh??m v?? ??i???u tr??? :\r\n  ??au tai, ch???y m?? tai v?? ?? tai, ng???a tai, nghe k??m, th???ng m??ng nh??, ch???n th????ng tai.??au h???ng, nu???t v?????ng, kh?? nu???t, h??i th??? h??i.Ch???n th????ng m??i, d??? v???t v??ng TMH, h??c x????ng, c??c kh???i u v?? ???????ng d?? c??? m???t.Ng???a m??i, h???t x??, s??? m??i, ch???y m??u m??i, ??au m??i, ngh???t m??i, m???t m??i.N???i soi ch???n ??o??n h??nh ???nh r?? ?????p, \r\nch??nh x??c ph??t hi???n s???m c??c b???nh l?? ung th?? v??m m??i h???ng, thanh qu???n gi??p ??i???u tr??? nhanh ch??ng hi???u qu???.','https://res.cloudinary.com/ikj/image/upload/v1634961452/9_NOI_SOI_TAI_ooj1xj.jpg'),(5,'Khoa Nhi','Ph??ng kh??m chuy??n khoa Nhi ???????c Bs CKI v??? nhi khoa nhi???u kinh nghi???m ?????m tr??ch c??ng ?????i ng?? nh??n vi??n lu??n nhi???t t??nh, vui v??? v???i ?????y ????? c??c trang thi???t b??? y t???, x??t nghi???m m???i nh???t. Kh??ng gian ph??ng kh??m tho??ng m??t s???ch ?????p, t???o m??i tr?????ng th??n thi???n v???i c??c b???nh Nhi.','https://res.cloudinary.com/ikj/image/upload/v1634961785/khamnhi2_ojumoi.jpg'),(6,'Khoa  M???t',' Kh??m chuy??n s??u v?? ??i???u tr??? hi???u qu??? c??c b???nh l?? c???a m???t.   Kh??m ph??t hi???n s???m v?? ??i???u tr??? hi???u qu???  c??c tr?????ng h???p b???nh l?? c?????m n?????c - t??ng nh??n ??p v?? c?????m kh?? - ?????c th??? th???y tinh .  Ph???i h???p li??n chuy??n khoa m???t v?? n???i ti???t ????? ??i???u tr??? hi???u qu??? b???nh l?? v??ng m???c do ti???u ???????ng.??o kh??c x??? - k??nh ch??nh x??c v?? t?? v???n nhi???u ph????ng ph??p ??i???u tr??? chuy??n s??u c??c b???t th?????ng kh??c x??? c???a m???t.  ??i???u tr??? hi???u qu??? c??c b???nh l?? b??? m???t gi??c m???c: nh?? b???nh l?? kh?? m???t, vi??m k???t m???c c???p t??nh ho???c m??n t??nh.','https://res.cloudinary.com/ikj/image/upload/v1634962015/khoamat_ewitdt.jpg'),(7,'Khoa c???p c???u','Khoa c???p c???u v?? h??? tr???','https://res.cloudinary.com/ikj/image/upload/v1636700664/medical/oinnllqhv8zr60xldrdq.png');
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
INSERT INTO `medical_examination_card` VALUES (1,2,'2021-11-14 14:14:30',90000,'??au n???a ?????u, ???i m???a s???t co gi???t','d???t kinh phong',1,1,2,_binary '\0'),(2,3,'2021-11-14 14:14:38',90000,'kh?? ng?? ng???t ','??au tim',1,1,2,_binary '\0'),(3,3,'2021-11-14 14:37:53',90000,'kh?? ng???','kh?? ng???',1,1,2,_binary '\0'),(4,1,'2021-11-14 15:01:10',90000,'??au n???a ?????u, ???i m???a s???t co gi???t','d???t kinh phong',2,1,3,_binary '\0'),(5,1,'2021-11-16 12:34:45',90000,'kh?? ng?? ng???t ','??au tim',5,1,2,_binary ''),(6,2,'2021-11-16 12:37:46',90000,'Kh?? ngu','thi???u m??u tim',6,1,2,_binary '');
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
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nurse`
--

LOCK TABLES `nurse` WRITE;
/*!40000 ALTER TABLE `nurse` DISABLE KEYS */;
INSERT INTO `nurse` VALUES (1,'L??','Th??? Thanh','2000-03-16','N???','0989076898','Thanh@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,3,NULL),(2,'L??','Nh?? H??n','2000-02-16','N???','0989076844','Han@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,7,NULL),(3,'L??','Tu??? Nh??','1998-02-16','N???','0989076844','Nhu@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045285/9_mibbl7.jpg',1,8,NULL),(4,'yoo jung','kim ','2001-02-16','N???','0987654','1@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1640425410/nurse/btsoin3ehcixsxytfntl.jpg',1,10,NULL);
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
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'L??','Th??? Vy','2000-12-31','N???','098765433','59481@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'G?? v???p, HCM'),(2,'L??','Anh','2000-12-31','Nam','098765433','132@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'t??n b??nh'),(3,'Ly','Lee','2000-12-12','Nam','0987654','1@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,NULL),(4,'m??','nguy???n','2000-12-31','Nam','333','333','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'b?? r???a v??ng t??u'),(5,'L??','Th??? H??a Binh','2000-12-31','N???','05839582048','jhk@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637045613/12_exbseu.jpg',NULL,'TP H??a B??nh'),(6,'Tr???n','H???ng Th???m','2000-12-31','N???','123555','jhk@gmail.com','https://res.cloudinary.com/ikj/image/upload/v1637029278/patient/mgktusvshuubmsntz5rj.jpg',NULL,'t??n b??nh');
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
INSERT INTO `prescription` VALUES (1,'2020-12-12 00:00:00',1,1,'s'),(2,'2020-12-12 00:00:00',2,2,'s'),(3,'2020-12-12 00:00:00',2,2,'s'),(4,'2021-11-10 00:00:00',2,1,''),(5,'2021-11-16 00:00:00',2,6,'Lo l???ng d???n ?????n suy nh?????c'),(6,'2021-11-16 00:00:00',2,5,'l?????i v???n ?????ng');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescription_drug`
--

LOCK TABLES `prescription_drug` WRITE;
/*!40000 ALTER TABLE `prescription_drug` DISABLE KEYS */;
INSERT INTO `prescription_drug` VALUES (1,'s??ng 1 vi??n chi???u 1 vi??n',1,4,1),(2,'s??ng 1 vi??n chi???u 1 vi??n',30,5,4),(3,'s??ng 1 vi??n',15,5,2),(4,'U???ng 1 s??ng 1 chi???u',20,6,4),(5,'1 s??ng 1 chi???u',20,6,5);
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
INSERT INTO `services` VALUES (1,'??o ??i???n tim(Ecg)',100000,'https://res.cloudinary.com/ikj/image/upload/v1636719495/service/sraix48ca54cv4t9gvzw.jpg'),(2,'Kh??m s???c kh???e t???ng qu??t',90000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png'),(3,'X??t nghi???m m??u',200000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png'),(4,'Ch???p x quang k??? thu???t s???',200000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png'),(5,'R??ng h??m m???t',200000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png'),(6,'N???i soi tai m??i h???ng',200000,'https://res.cloudinary.com/ikj/image/upload/v1637068533/1_ydmg48.png');
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
  KEY `fk_services_invoice__idx1` (`nurse_id`),
  CONSTRAINT `fk_services_invoice_nurse` FOREIGN KEY (`nurse_id`) REFERENCES `nurse` (`id`),
  CONSTRAINT `fk_services_invoice_patient` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `fk_services_invoice_services` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`)
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
INSERT INTO `slide` VALUES (1,'Ph??ng ch???ng covid','https://res.cloudinary.com/ikj/image/upload/v1636699203/slide/xymg8ls3dp4ryvhtsctu.png','Chung tay ch???ng covid',_binary ''),(2,'K??nh b???o h???','https://res.cloudinary.com/ikj/image/upload/v1636699285/slide/a3xrgbmk7yduhuyvhhgq.png','K??nh b???o h???',_binary ''),(3,'Ng??ng','https://res.cloudinary.com/ikj/image/upload/v1636699361/slide/jx7mnxvr0rwfgebcqzen.png ','Ng??ng ho???t ?????ng',_binary '');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin12345','$2a$10$m9UGDIjt4jU1sxQA599dNeqoj.z.ZijlhkrBblYRy/AndbsqcdrwK','433333','L?? ??i???n t??i','0kg@gmail.com','ROLE_ADMIN','123555',NULL,'https://res.cloudinary.com/ikj/image/upload/v1633071771/Doctor/ttsqktplgif3udby8kcz.png'),(2,'1doctorphuongdung','123','123','123','123','ROLE_DOCTOR','123',_binary '','https://res.cloudinary.com/ikj/image/upload/v1634963674/nguyen-phuong-dung_lcv4mo.jpg'),(3,'1nurseleff','$2a$10$4qP/ywFPozmP5Doizl7MXOfjMlBKfJMRk5ClFV3s09xfxLMPcvZny','L??','ff','ss@gmail.com','ROLE_NURSE','123555',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634561416/nurse/znfsjellubqebnedepue.png'),(4,'2doctorthidoannguyen','$2a$10$VF8mkx08De8pyB1XDt6jfecPpqt6kufJDzw/CJmp/PlbOLSOTK/C6','Th??? Doan','Nguy???n','NTDDoan@gmail.com','ROLE_DOCTOR','01684346876',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634963870/nguyen-thi-doan_kzdtzt.jpg'),(5,'3doctorvananhvo','$2a$10$o6y22xSDDNQtGuX/Ox7Atej5q2T25Jaczns8OE3ci40xG3q.YWst2','V??n Anh','V??','VVAAnh@gmail.com','ROLE_DOCTOR','0989054794',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634961259/vo-van-anh_brx3pj.jpg'),(6,'4doctorthiaitramnguyen','$2a$10$zkQ.iF3CZRHY6kcwrAl5Ye1nMlNSwUumHtinRs4zCRdcxZdD296Xe','Th??? ??i Tr??m','Nguy???n','NTATTram@gmail.com','ROLE_DOCTOR','0989054100',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634964426/nguyen-thi-ai-tram_z0i5ki.jpg'),(7,'3nurselethi','$2a$10$TBnQFxQVkHXVu8hfNvUINuicS8MyFxkOieWHGiTkACNhms5xq5XMq','L??','th???','ss@gmail.com','ROLE_NURSE','333',NULL,'https://res.cloudinary.com/ikj/image/upload/v1636197790/nurse/gfvz6eexk5whidxmx7ye.png'),(8,'3nurselethi3','$2a$10$TBnQFxQVkHXVu8hfNvUINuicS8MyFxkOieWHGiTkACNhms5xq5XMq','L??','th???','ss@gmail.com','ROLE_NURSE','3333',_binary '','https://res.cloudinary.com/ikj/image/upload/v1636197790/nurse/gfvz6eexk5whidxmx7ye.png'),(9,'1doctorphuongdungnguyen','$2a$10$dMW5kP7oLyR0CMqRY.PGb.ELo0egmPFcVvDUdrjjXXvQYy4u1ek.O','Ph????ng Dung','Nguy???n','NPDDung@gmail.com','ROLE_DOCTOR','0989054761',NULL,'https://res.cloudinary.com/ikj/image/upload/v1634963674/nguyen-phuong-dung_lcv4mo.jpg'),(10,'4nursekimyoojung','$2a$10$RWNPTvJrsONU93V48kkeAuB/b08UQwUbddrd6xgv7JOe9jyriQhVy','kim ','yoo jung','1@gmail.com','ROLE_NURSE','0987654',NULL,'https://res.cloudinary.com/ikj/image/upload/v1640425410/nurse/btsoin3ehcixsxytfntl.jpg');
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

-- Dump completed on 2021-12-25 20:31:41
