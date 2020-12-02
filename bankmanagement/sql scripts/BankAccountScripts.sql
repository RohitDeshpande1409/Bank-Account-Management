CREATE DATABASE  IF NOT EXISTS `bk_account` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bk_account`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bk_account
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` varchar(100) NOT NULL,
  `cust_id` varchar(100) DEFAULT NULL,
  `balance` decimal(10,0) NOT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `ifsc_code` varchar(45) DEFAULT NULL,
  `account_type` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `customer_id_idx` (`cust_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('A104','104',1000,'Whitefield','BAK0089','Savings'),('A105','105',2000,'Marathalli','BAK0076','Savings'),('A106','106',2000,'Marathalli','BAK0076','Savings'),('A107','107',5000,'Marathalli','BAK0076','Savings'),('A108','108',2000,'Marathalli','BAK0076','Savings'),('A109','109',2000,'Marathalli','BAK0076','Savings');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankemployee`
--

DROP TABLE IF EXISTS `bankemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankemployee` (
  `employee_id` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankemployee`
--

LOCK TABLES `bankemployee` WRITE;
/*!40000 ALTER TABLE `bankemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `bankemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` varchar(100) NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('101','Rohit','Deshpande','Active','2020-11-28 21:11:50','2020-11-28 21:11:50',0),('102','gita','singh','Active','2020-11-29 06:00:18','2020-11-29 06:30:05',1),('103','Neha','Sharma','Active','2020-11-29 12:10:52','2020-11-29 12:10:52',0),('104','Rajeev','Mehta','Active','2020-11-29 12:30:07','2020-11-29 12:30:07',0),('105','Sanklap','Kholi','Active','2020-11-29 13:10:26','2020-11-29 13:10:26',0),('106','Sam','Public','Active','2020-11-29 14:41:21','2020-11-29 14:41:21',0),('107','Mike','Marshal','Active','2020-11-29 16:13:28','2020-11-29 16:13:28',0),('108','Nidhi','csk','Active','2020-12-01 14:42:42','2020-12-01 14:42:42',0),('109','jack','son','Active','2020-12-02 16:55:12','2020-12-02 16:55:12',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payee`
--

DROP TABLE IF EXISTS `payee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payee` (
  `payee_id` varchar(100) NOT NULL,
  `payee_name` varchar(100) NOT NULL,
  `payee_nick_name` varchar(45) NOT NULL,
  `branch_name` varchar(45) NOT NULL,
  `ifsc_code` varchar(45) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  `cust_id` varchar(100) NOT NULL,
  PRIMARY KEY (`payee_id`),
  KEY `customer_id_idx` (`cust_id`),
  CONSTRAINT `fk_customer_id` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payee`
--

LOCK TABLES `payee` WRITE;
/*!40000 ALTER TABLE `payee` DISABLE KEYS */;
INSERT INTO `payee` VALUES ('P107','Sriram','ram','Whitefield','IC0023','ICIC','107'),('P108','Jack','jack','Whitefield','ICI0025','ICIC','105');
/*!40000 ALTER TABLE `payee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `acc_id` varchar(100) NOT NULL,
  `cust_id` varchar(100) NOT NULL,
  `transaction_type` varchar(6) NOT NULL,
  `date` datetime NOT NULL,
  `amount` double NOT NULL,
  `remark` varchar(200) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `fk_customer_tran_id_idx` (`cust_id`),
  CONSTRAINT `fk_customer_tran_id` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'A107','107','credit','2020-12-01 10:46:00',1000,'ATM',3000),(2,'A107','107','debit','2020-12-01 12:24:18',1000,'Fund transferred to ram',2000),(3,'A107','107','debit','2020-12-02 16:23:21',1000,'Fund transferred to ram',1000),(4,'A107','107','debit','2020-12-02 16:23:53',1000,'Fund transferred to ram',0),(5,'A107','107','credit','2020-12-02 16:28:52',1000,'ATM',1000),(6,'A107','107','credit','2020-12-02 16:36:28',1000,'ATM',2000),(7,'A107','107','credit','2020-12-02 16:38:00',1000,'ATM',3000),(8,'A107','107','credit','2020-12-02 16:46:54',1000,'ATM',4000),(9,'A107','107','credit','2020-12-02 16:54:30',1000,'ATM',5000);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 22:41:09
