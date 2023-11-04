-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for mydb_w9_lab7
CREATE DATABASE IF NOT EXISTS `mydb_w9_lab7` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `mydb_w9_lab7`;

-- Dumping structure for table mydb_w9_lab7.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) NOT NULL,
  `cust_name` varchar(150) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `address` varchar(250) NOT NULL,
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.customer: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `dob` date NOT NULL,
  `status` tinyint(4) NOT NULL CHECK (`status` between 0 and 2),
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(15) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `full_name` varchar(150) NOT NULL,
  `address` varchar(250) NOT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.employee: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `cust_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  `order_date` datetime(6) NOT NULL,
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`order_id`),
  KEY `FK89iy70txskld506d7n1cfpmpx` (`cust_id`),
  KEY `FKog5v9ga2g2ukytypn4ocip6b4` (`employee_id`),
  CONSTRAINT `FK89iy70txskld506d7n1cfpmpx` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `FKog5v9ga2g2ukytypn4ocip6b4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.orders: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.order_detail
CREATE TABLE IF NOT EXISTS `order_detail` (
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`),
  CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.order_detail: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.product
CREATE TABLE IF NOT EXISTS `product` (
  `status` tinyint(4) DEFAULT NULL CHECK (`status` between 0 and 2),
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `unit` varchar(25) NOT NULL,
  `manufacturer_name` varchar(100) NOT NULL,
  `name` varchar(150) NOT NULL,
  `description` varchar(250) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.product: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.product_image
CREATE TABLE IF NOT EXISTS `product_image` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `alternative` varchar(250) DEFAULT NULL,
  `path` varchar(250) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`),
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.product_image: ~0 rows (approximately)

-- Dumping structure for table mydb_w9_lab7.product_price
CREATE TABLE IF NOT EXISTS `product_price` (
  `price` double NOT NULL,
  `price_date_time` datetime(6) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`price_date_time`,`product_id`),
  KEY `FKeupemu63ifqfc4txkskyy1hyi` (`product_id`),
  CONSTRAINT `FKeupemu63ifqfc4txkskyy1hyi` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w9_lab7.product_price: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
