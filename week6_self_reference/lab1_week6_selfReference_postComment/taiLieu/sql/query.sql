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


-- Dumping database structure for mydb_w6
CREATE DATABASE IF NOT EXISTS `mydb_w6` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `mydb_w6`;

-- Dumping structure for table mydb_w6.post
CREATE TABLE IF NOT EXISTS `post` (
  `created_at` date NOT NULL,
  `published` tinyint(4) NOT NULL DEFAULT 0,
  `published_at` date DEFAULT NULL,
  `summary` char(1) DEFAULT NULL,
  `update_at` date DEFAULT NULL,
  `author_id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) NOT NULL,
  `meta_title` varchar(100) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FK5yhuvatu7cubfxyltetys1c3n` (`parent_id`),
  KEY `FK12njtf8e0jmyb45lqfpt6ad89` (`author_id`),
  CONSTRAINT `FK12njtf8e0jmyb45lqfpt6ad89` FOREIGN KEY (`author_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK5yhuvatu7cubfxyltetys1c3n` FOREIGN KEY (`parent_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w6.post: ~0 rows (approximately)

-- Dumping structure for table mydb_w6.post_comment
CREATE TABLE IF NOT EXISTS `post_comment` (
  `create_at` date NOT NULL,
  `published` tinyint(4) NOT NULL DEFAULT 0,
  `published_at` date DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `pc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pc_id`),
  KEY `FKna4y825fdc5hw8aow65ijexm0` (`post_id`),
  KEY `FKmqxhu8q0j94rcly3yxlv0u498` (`parent_id`),
  KEY `FKtc1fl97yq74q7j8i08ds731s1` (`user_id`),
  CONSTRAINT `FKmqxhu8q0j94rcly3yxlv0u498` FOREIGN KEY (`parent_id`) REFERENCES `post_comment` (`pc_id`),
  CONSTRAINT `FKna4y825fdc5hw8aow65ijexm0` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`),
  CONSTRAINT `FKtc1fl97yq74q7j8i08ds731s1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w6.post_comment: ~0 rows (approximately)

-- Dumping structure for table mydb_w6.user
CREATE TABLE IF NOT EXISTS `user` (
  `intro` char(1) DEFAULT NULL,
  `registered_at` date DEFAULT NULL,
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(15) DEFAULT NULL,
  `password_hasd` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_login` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table mydb_w6.user: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
