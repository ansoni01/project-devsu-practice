-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bd_devsu_practice
DROP DATABASE IF EXISTS `bd_devsu_practice`;
CREATE DATABASE IF NOT EXISTS `bd_devsu_practice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_devsu_practice`;

-- Volcando estructura para tabla bd_devsu_practice.tbl_account
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE IF NOT EXISTS `tbl_account` (
  `account_id` bigint NOT NULL AUTO_INCREMENT,
  `account_number` varchar(255) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  `initial_balance` double NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_devsu_practice.tbl_client
DROP TABLE IF EXISTS `tbl_client`;
CREATE TABLE IF NOT EXISTS `tbl_client` (
  `client_id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `persona_id` bigint DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `UK_5iwtii4vup4b4jlncgm4bw6xm` (`persona_id`),
  CONSTRAINT `FKcw1m47nyyc96wqsm1763aap0w` FOREIGN KEY (`persona_id`) REFERENCES `tbl_person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_devsu_practice.tbl_movement
DROP TABLE IF EXISTS `tbl_movement`;
CREATE TABLE IF NOT EXISTS `tbl_movement` (
  `movement_id` bigint NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `movement_type` varchar(255) DEFAULT NULL,
  `value` double NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`movement_id`),
  KEY `FKrj9qmy6blp62vh1fh5d9fpddv` (`account_id`),
  CONSTRAINT `FKrj9qmy6blp62vh1fh5d9fpddv` FOREIGN KEY (`account_id`) REFERENCES `tbl_account` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla bd_devsu_practice.tbl_person
DROP TABLE IF EXISTS `tbl_person`;
CREATE TABLE IF NOT EXISTS `tbl_person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `identification` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- La exportación de datos fue deseleccionada.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
