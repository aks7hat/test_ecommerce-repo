-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: auth_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` binary(16) NOT NULL,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `zip_code` varchar(255) NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (_binary 'R���yB���\�dH\�\'','12w','123','2e','2w','12`','1234',_binary '�]�sBռ\�8%E�\�'),(_binary '\�Z\r9�M��\�m��\�','12w','as','12345654','123e','23','121321',_binary '�\�6!�Q@=�\�T6�y\�');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_authority`
--

DROP TABLE IF EXISTS `auth_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_authority` (
  `id` binary(16) NOT NULL,
  `role_code` varchar(255) NOT NULL,
  `role_description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_authority`
--

LOCK TABLES `auth_authority` WRITE;
/*!40000 ALTER TABLE `auth_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_user_authority`
--

DROP TABLE IF EXISTS `auth_user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auth_user_authority` (
  `user_model_id` binary(16) NOT NULL,
  `authorities_id` binary(16) NOT NULL,
  KEY `FKn7t2r8oft6j1w61po11wnb19w` (`authorities_id`),
  KEY `FKe3f4jv34w38e77wivt795pl4n` (`user_model_id`),
  CONSTRAINT `FKe3f4jv34w38e77wivt795pl4n` FOREIGN KEY (`user_model_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKn7t2r8oft6j1w61po11wnb19w` FOREIGN KEY (`authorities_id`) REFERENCES `auth_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_user_authority`
--

LOCK TABLES `auth_user_authority` WRITE;
/*!40000 ALTER TABLE `auth_user_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `auth_user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` binary(16) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (_binary 'bK \�\�oOW��\�Re�y\�','WOMEN','Women\'s Clothing','Women'),(_binary '�~���Og�\�Xo�ͪ','MEN','Men\'s Clothing','Men'),(_binary '\�\�R�ZF����dX�Z','KIDS','Kids Clothing','Kids');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_type`
--

DROP TABLE IF EXISTS `category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_type` (
  `id` binary(16) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmgwrsyriidy42m9273cybb8tr` (`category_id`),
  CONSTRAINT `FKmgwrsyriidy42m9273cybb8tr` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_type`
--

LOCK TABLES `category_type` WRITE;
/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
INSERT INTO `category_type` VALUES (_binary '0\��\�\�GI���\0���','SHIRTS','Women Shirts','Shirts',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary 'Hf]0+\�@^�\�p?�f\�','DRESSES','Women Dresses','Dresses',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary 'N�HpS�Bl�\Z�\�l��7','JEANS','Kids Jeans','Jeans',_binary '\�\�R�ZF����dX�Z'),(_binary 'Sb\'\�\�I���!Qz0��','COATS','Coats','Coats',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary 'i�5��Ga�-m=\�*\�1','JOGGERS','Men\'s Joggers','Joggers',_binary '�~���Og�\�Xo�ͪ'),(_binary 'q(Ò�J�>~�p@�7','T-SHIRTS','Women T-shirts','T-shirts',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary '���ༀH���\�\�J\�U�','SWEATSHIRT','Kids Hoodie/Sweatshirt','Hoodies/Sweatshirt',_binary '\�\�R�ZF����dX�Z'),(_binary '����\�H믎U�\���','SHORTS','Women Shorts','Shorts',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary '�\�]\�\��E��\n:�w\�','SHIRTS','Kids Shirts','Shirts',_binary '\�\�R�ZF����dX�Z'),(_binary '��(bICi�`�	_*��','SHIRTS','Men\'s Shirts','Shirts',_binary '�~���Og�\�Xo�ͪ'),(_binary '\�\�B\��[K��K/�\�9\�','HOODIE','Men\'s Hoodie','Hoodies',_binary '�~���Og�\�Xo�ͪ'),(_binary '\�[RMt\�N���\�-	�t','T-SHIRTS','Kids T-shirts','T-shirts',_binary '\�\�R�ZF����dX�Z'),(_binary '\��w\�@\ZB��\�S����V','SWEATSHIRT','Women Hoodie','Hoodies',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary '\�\n�&DGD����@	\n�\�','SHORTS','Kids Shorts','Shorts',_binary '\�\�R�ZF����dX�Z'),(_binary '\�1�M!�\��\�','SHORTS','Men\'s Shorts','Shorts',_binary '�~���Og�\�Xo�ͪ'),(_binary '\�j�Fq����s\�\�','CROP TOP','Women Crop top','Crop Top',_binary 'bK \�\�oOW��\�Re�y\�'),(_binary '\�.䃏�Gw���۴\�?','JEANS','Men\'s Jeans','Jeans',_binary '�~���Og�\�Xo�ͪ'),(_binary '\�/�Δ-O条C\�z�D','T-SHIRTS','Men\'s T-shirts','T-shirts',_binary '�~���Og�\�Xo�ͪ'),(_binary '��k��B\���\�Z��','KURTIES','Women Kurtis','Kurtis',_binary 'bK \�\�oOW��\�Re�y\�');
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` binary(16) NOT NULL,
  `item_price` double DEFAULT NULL,
  `product_variant_id` binary(16) DEFAULT NULL,
  `quantity` int NOT NULL,
  `order_id` binary(16) NOT NULL,
  `product_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbioxgbv59vetrxe0ejfubep1w` (`order_id`),
  KEY `FKocimc7dtr037rh4ls4l95nlfi` (`product_id`),
  CONSTRAINT `FKbioxgbv59vetrxe0ejfubep1w` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKocimc7dtr037rh4ls4l95nlfi` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (_binary '{țl\�\�J��\�}{\���',NULL,_binary '�\�\�>�D�}\�΅��',1,_binary '19\�\�|G\�έ>{�\�w',_binary '{\�0{wA��\�\�\�\�F�\�'),(_binary '��\��@\�N��1\�',NULL,_binary '��eE\n�\�x}�n��',1,_binary '19\�\�|G\�έ>{�\�w',_binary 'HYYΨJ��jm\�$\�\0'),(_binary '�VR|!Dߣ�\�\�A=o',NULL,_binary '\�p��9FO�\�S��iҠ',2,_binary '5��\�pA���˪g�d;',_binary '\r��y\�JI��_<��a\�\"');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` binary(16) NOT NULL,
  `discount` double DEFAULT NULL,
  `expected_delivery_date` datetime(6) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `order_status` enum('CANCELLED','CREATED','DELIVERED','IN_PROGRESS','PENDING','SHIPPED') NOT NULL,
  `payment_method` varchar(255) NOT NULL,
  `shipment_tracking_number` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `address_id` binary(16) NOT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhlglkvf5i60dv6dn397ethgpt` (`address_id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKhlglkvf5i60dv6dn397ethgpt` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (_binary '5��\�pA���˪g�d;',0,'2025-01-05 18:02:54.887000','2024-12-31 18:02:54.887000','CREATED','cod',NULL,119.98,_binary '\�Z\r9�M��\�m��\�',_binary '�\�6!�Q@=�\�T6�y\�'),(_binary '19\�\�|G\�έ>{�\�w',0,'2025-01-01 23:20:55.392000','2024-12-27 23:20:55.392000','CREATED','cod',NULL,89.98,_binary '\�Z\r9�M��\�m��\�',_binary '�\�6!�Q@=�\�T6�y\�');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token` (
  `id` binary(16) NOT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKf90ivichjaokvmovxpnlm5nin` (`user_id`),
  CONSTRAINT `FK83nsrttkwkb6ym0anu051mtxn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
INSERT INTO `password_reset_token` VALUES (_binary 'h�t}G��\�֠6�d�','2024-12-29 19:25:35.248436','d439d125-3862-41e4-967c-21cd077ef6be',_binary 'C(og�Y@՗*��*�F0');
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_resources`
--

DROP TABLE IF EXISTS `product_resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_resources` (
  `id` binary(16) NOT NULL,
  `is_primary` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `product_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3k1pn3x472fqhckh85qc6m6y7` (`product_id`),
  CONSTRAINT `FK3k1pn3x472fqhckh85qc6m6y7` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_resources`
--

LOCK TABLES `product_resources` WRITE;
/*!40000 ALTER TABLE `product_resources` DISABLE KEYS */;
INSERT INTO `product_resources` VALUES (_binary '\�\�Mi�JتN�\n�NJ',_binary '','flirtatious-poses.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/25806766/2023/11/27/9bc1794b-3338-4cc7-a057-eda55be2d43f1701067998219-Levis-Women-Sweatshirts-331701067997837-1.jpg',_binary 's�=|aBo���B\�\�\�|'),(_binary 'xm;3Hg�;�>�\�6\r',_binary '','crop-top-white.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2025/JANUARY/7/bnWj2em3_fa5f6fd8e5ba4133b702abefa3261c10.jpg',_binary '4Rq%\\Oռ�\�_L\n�'),(_binary '\�\Z6�\�J��;f�Dɩ8',_binary '','tshirt-white.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/18148556/2022/5/5/2848cc59-d7ea-468b-a500-d61cf1168d1b1651696473398STREET9WomenWhiteTypographyV-NeckBioFinishLooseOutdoorT-shir1.jpg',_binary '\�򵏆LD�7\�\"�3x'),(_binary '\�(h#B��������',_binary '','534dcd71-6ab7-4a24-99fe-1d678a9cfaa11710233512639StyleQuotientMenStraightFitLowDistressJeans1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/28203884/2024/3/12/534dcd71-6ab7-4a24-99fe-1d678a9cfaa11710233512639StyleQuotientMenStraightFitLowDistressJeans1.jpg',_binary 'hk�$�kHD���}}��\�'),(_binary '.\r&\�5aC8���Jz\�',_binary '','7e4777ab-4c47-47cb-a0ff-b1f81c4124771695632742778CampusSutraAcrylicDouble-BreastedLongCoat1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/25155738/2023/9/25/7e4777ab-4c47-47cb-a0ff-b1f81c4124771695632742778CampusSutraAcrylicDouble-BreastedLongCoat1.jpg',_binary '㓿^D(�4T�m/%'),(_binary 'A\�J5ʆI��v\�QzH�',_binary '','gray-shorts.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/17893214/2022/4/14/b1a757ac-c64c-4d85-b32e-5ab3068346cb1649945912219maxMenGreyMelangeLoungeShorts4.jpg',_binary 'HYYΨJ��jm\�$\�\0'),(_binary 'e\ZX�.RM\����\Z\�\Z�;',_binary '','3c20365d-62c0-4b7e-901e-b0e4cdd0ec641729769247117-HM-Pure-Cotton-Regular-Fit-Muslin-Resort-Shirt-7231729769246-1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/29651612/2024/10/24/3c20365d-62c0-4b7e-901e-b0e4cdd0ec641729769247117-HM-Pure-Cotton-Regular-Fit-Muslin-Resort-Shirt-7231729769246-1.jpg',_binary '{\�0{wA��\�\�\�\�F�\�'),(_binary 'x\�\"U\�<G���{_E�',_binary '','hoodie-purple.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2024/NOVEMBER/25/xrh55z0m_270f687b3e174336b283551974e9c96e.jpg',_binary '�L\�Aj@x��*X�CLh'),(_binary '��ȿ�N��\��\�\"\�	',_binary '','1beeb283-e681-402c-a2f5-18287dcb6a1e1701715925494Kurtis1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/26233768/2023/12/5/1beeb283-e681-402c-a2f5-18287dcb6a1e1701715925494Kurtis1.jpg',_binary 'g#}\�(�M��-z3\�B'),(_binary '�1(R\�N��F�HP\�\�',_binary '','black-hoodie.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2024/SEPTEMBER/14/983pmv08_a700851f8f7c4d49964091d2f5d0005d.jpg',_binary '6#\�D	�@�O$��ǽ'),(_binary '���\��yA��pIp]A\'',_binary '','sweatshirt-crewneck.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/30931879/2024/9/23/88eba284-1d86-4049-ba4d-79ce1f4eca6b1727086451234-French-Connection-Women-Sweatshirts-9901727086450802-1.jpg',_binary '�\�\�N}\�Iձ�\����%#'),(_binary '����\�D\�/�YOH�',_binary '','shorts-black.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/30063786/2024/8/24/d425c256-9881-491a-9a8a-d7696a832f661724495928094-Roadster-Women-Shorts-971724495927663-1.jpg',_binary '�N\Z\"C\�K;�\�\"�'),(_binary '��:\�SDu�J?�9N��',_binary '','2dd1cc94-8bed-4f0f-8c95-a785a9910a3c1665981279300HERENOWMenMulticolouredSlimFitPrintedCasualShirt1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/20421124/2022/10/17/2dd1cc94-8bed-4f0f-8c95-a785a9910a3c1665981279300HERENOWMenMulticolouredSlimFitPrintedCasualShirt1.jpg',_binary '>1\�\�e�B���\�r\��\�'),(_binary '\�K�[;O�}�o\�r',_binary '','white-hoodie.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/29580512/2024/12/2/c3bf9280-df3a-4cdb-b141-2dbc43c4364e1733133798865-WROGN-Men-Sweatshirts-521733133798154-1.jpg',_binary '\r��y\�JI��_<��a\�\"'),(_binary '̩?k�Fڼ�G�P�f\�',_binary '','mkVBeqqW_48618969dae542c1ae6c273ee919994c.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2024/NOVEMBER/12/mkVBeqqW_48618969dae542c1ae6c273ee919994c.jpg',_binary '}\�޹�1K�T^&\�\n&�'),(_binary 'άv\��\�E��\�\�d\0G\\7',_binary '','db10a94e-aa99-443c-81e6-e6a692576d5c1688387711291-ADIDAS-Kids-Mid-Rise-Loose-Fit-Pure-Cotton-U-D-PT-Joggers-56-1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/21951410/2023/7/3/db10a94e-aa99-443c-81e6-e6a692576d5c1688387711291-ADIDAS-Kids-Mid-Rise-Loose-Fit-Pure-Cotton-U-D-PT-Joggers-56-1.jpg',_binary '�\0\Zb\�GNN�$\�8'),(_binary '\�\�iL\��Nj�=�&V\�0',_binary '','dress-white-leaves.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/31069493/2025/1/9/58e12306-9f5b-48f6-8b72-22d95b56c32c1736413832462-HERENOW-Women-Dresses-3301736413831898-1.jpg',_binary '\���\r�@��Z0�*\�'),(_binary '\�.\��YH���)�\�\"',_binary '','4j0E1s3p_55f7c70b17db41bd9884527778e6cd33.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2024/SEPTEMBER/17/4j0E1s3p_55f7c70b17db41bd9884527778e6cd33.jpg',_binary '2*b��K��q4|}\�'),(_binary '\�\�\�;B|�`��yR�',_binary '','HIGHLANDER-Men-Blue-Tapered-Fit-Mid-Rise-Clean-Look-Stretchable-Jeans-7601522151773234-1.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/3880938/2018/3/27/11522151773410-HIGHLANDER-Men-Blue-Tapered-Fit-Mid-Rise-Clean-Look-Stretchable-Jeans-7601522151773234-1.jpg',_binary '�E/�B\�Œim\�Ց'),(_binary '�\�x\'C)����Q\�',_binary '','black-tshirt.jpeg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/32255445/2025/1/8/12ff4747-f125-4665-842e-ec1d56d7e07b1736318118103KAIDOMenPrintedDrop-ShoulderSleevesT-shirt1.jpg',_binary 'f\�:nvI{��\�X�Q\��'),(_binary '��\�Z`\�G��(������',_binary '','blue-jeans.jpg','image','https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/30392271/2024/10/22/5c77e74e-e880-4449-a3a1-dba771080eb41729587482126-Kook-N-Keech-Utility-Vibes-Cargo-Style-Jeans-471729587481321-1.jpg',_binary 'INv�\"A\���2q\r');
/*!40000 ALTER TABLE `product_resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variant`
--

DROP TABLE IF EXISTS `product_variant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variant` (
  `id` binary(16) NOT NULL,
  `color` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `stock_quantity` int NOT NULL,
  `product_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtk6wrh1xwqq4vn2pf11mwycgv` (`product_id`),
  CONSTRAINT `FKtk6wrh1xwqq4vn2pf11mwycgv` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variant`
--

LOCK TABLES `product_variant` WRITE;
/*!40000 ALTER TABLE `product_variant` DISABLE KEYS */;
INSERT INTO `product_variant` VALUES (_binary '\�(�\�3AN�\r(���','Blue','L',10,_binary '>1\�\�e�B���\�r\��\�'),(_binary '	�z���JZ�\�C\�\�p�','White','M',10,_binary '\���\r�@��Z0�*\�'),(_binary '�\��H���,0T','Black','L',10,_binary 'hk�$�kHD���}}��\�'),(_binary '��eE\n�\�x}�n��','Gray','L',10,_binary 'HYYΨJ��jm\�$\�\0'),(_binary '���\�N%�.�\��+\�','White','L',10,_binary '4Rq%\\Oռ�\�_L\n�'),(_binary 'ѭ�@\�O`�\")����','Blue','XL',10,_binary 'INv�\"A\���2q\r'),(_binary '\Z\�\�\�\�G���:ʆs$','Black','XL',10,_binary '�\0\Zb\�GNN�$\�8'),(_binary '\Z���N\�G�\�\\\�PZ)','White','S',10,_binary '\�򵏆LD�7\�\"�3x'),(_binary '\0$��AG��\"\n\r\�6/','Blue','M',10,_binary '>1\�\�e�B���\�r\��\�'),(_binary '��\�\�BIO�;�竖bK','Black','M',10,_binary '6#\�D	�@�O$��ǽ'),(_binary ']�+�C��3�b��7G','Black','XL',10,_binary 'hk�$�kHD���}}��\�'),(_binary '�\Z�H���J��\�dg','Brown','S',10,_binary '2*b��K��q4|}\�'),(_binary ' o�e�A���\���','Blue','L',10,_binary 'g#}\�(�M��-z3\�B'),(_binary '$t\��:K�\�\�QK>X','Brown','M',10,_binary '}\�޹�1K�T^&\�\n&�'),(_binary ')t�o�\�G̙(#�\��e\0','Blue','XL',10,_binary '{\�0{wA��\�\�\�\�F�\�'),(_binary '2\�I�H��_?Zr\�','White','M',10,_binary '\�򵏆LD�7\�\"�3x'),(_binary '4\���\�E羧\�x\�\�c�','Black','XL',10,_binary '6#\�D	�@�O$��ǽ'),(_binary '6]�^(\�A����+h�bV','Blue','L',10,_binary 'INv�\"A\���2q\r'),(_binary 'C5��\�@I���=�\�m0','Black','M',10,_binary 's�=|aBo���B\�\�\�|'),(_binary 'Mey��pO�@�\�N\��g','Brown','S',10,_binary '}\�޹�1K�T^&\�\n&�'),(_binary 'M�\��\�KU�(I5n;','White','L',10,_binary '\���\r�@��Z0�*\�'),(_binary 'S���EF�\"�E\�ᄝ','Purple','L',10,_binary '�L\�Aj@x��*X�CLh'),(_binary ']^� GM�-�1?\�','Black','L',10,_binary 's�=|aBo���B\�\�\�|'),(_binary '_\��E\�Z���\0#�','Black','S',10,_binary '㓿^D(�4T�m/%'),(_binary 'ap��-WJ\�).��wT�','Black','L',10,_binary '�\0\Zb\�GNN�$\�8'),(_binary 'h\�+�e\�I=���\�K��','Black','XL',10,_binary 'f\�:nvI{��\�X�Q\��'),(_binary 'j^�CQJq��\����g�','Brown','L',10,_binary '}\�޹�1K�T^&\�\n&�'),(_binary 't8���L��.G�[�','Black','L',10,_binary '�N\Z\"C\�K;�\�\"�'),(_binary 'z=π�EG���e\�','Black','L',10,_binary '6#\�D	�@�O$��ǽ'),(_binary 'zV�\�C�J���\�:��C','White','S',10,_binary '4Rq%\\Oռ�\�_L\n�'),(_binary '}T����B�\�}�G�','Gray','S',10,_binary '�\�\�N}\�Iձ�\����%#'),(_binary '��zq�tK\�\\��u\�','Brown','L',10,_binary '2*b��K��q4|}\�'),(_binary '�\�\�>�D�}\�΅��','Blue','L',10,_binary '{\�0{wA��\�\�\�\�F�\�'),(_binary '�\�\"Ѣ�E���s\�ce\�\�','Blue','M',10,_binary '�E/�B\�Œim\�Ց'),(_binary '�\�~Ѷ�F|��\'`\�\�\�','Black','L',10,_binary 'f\�:nvI{��\�X�Q\��'),(_binary '�K�xKK��%d\�\�)(�','Blue','M',10,_binary 'INv�\"A\���2q\r'),(_binary '��\n�B�O\\��hM\�N�','Black','L',10,_binary 's�=|aBo���B\�\�\�|'),(_binary '�{�U.H&��!\�ݔ\�','Black','M',10,_binary 'hk�$�kHD���}}��\�'),(_binary '�\�:�l�G��\�6�\�϶�','White','M',10,_binary '\r��y\�JI��_<��a\�\"'),(_binary '�\���$�J�j��A!\n1','Blue','XL',10,_binary '>1\�\�e�B���\�r\��\�'),(_binary '�=\�Mͻ�w��L\�','Blue','L',10,_binary '�E/�B\�Œim\�Ց'),(_binary '��Bi\�N\�\�D\�M�\�','Blue','M',10,_binary '{\�0{wA��\�\�\�\�F�\�'),(_binary '�G5�nE\�\�M�Ӌ','Black','M',10,_binary '㓿^D(�4T�m/%'),(_binary '�ԕu\��J��\��#�u\\','Brown','M',10,_binary '2*b��K��q4|}\�'),(_binary '����w\�Kb���\�\�u7','Blue','M',10,_binary 'g#}\�(�M��-z3\�B'),(_binary '��V\�\�E@�\�G���i�','Black','S',10,_binary 's�=|aBo���B\�\�\�|'),(_binary '��,\�N]�)1\�]\�R','Blue','S',10,_binary 's�=|aBo���B\�\�\�|'),(_binary '��VK\�FO��\\�W�]','Purple','M',10,_binary '�L\�Aj@x��*X�CLh'),(_binary '\�a \�\�\nJ֓\�$��zK','Gray','L',10,_binary '�\�\�N}\�Iձ�\����%#'),(_binary '˂ ���A\���~\�mt\�V','White','M',10,_binary '4Rq%\\Oռ�\�_L\n�'),(_binary '\�\�2%��A�����\�&��','White','L',10,_binary '\�򵏆LD�7\�\"�3x'),(_binary 'ҋs���@ϰC9��i','Blue','M',10,_binary 's�=|aBo���B\�\�\�|'),(_binary '\�\r�R\�IU�\�\�nP:B5','Blue','S',10,_binary 'g#}\�(�M��-z3\�B'),(_binary '\�\�)���MH��ir��\�','Blue','S',10,_binary '�E/�B\�Œim\�Ց'),(_binary '\�p��9FO�\�S��iҠ','White','L',10,_binary '\r��y\�JI��_<��a\�\"'),(_binary '\��\�쌒L��\�\��\�,\'','Gray','M',10,_binary 'HYYΨJ��jm\�$\�\0'),(_binary '\�H�&w\ZH �\0(ϵ�','White','XL',10,_binary '\r��y\�JI��_<��a\�\"'),(_binary '\�\�[L7@ڦ�N�\�\�$L','Gray','M',10,_binary '�\�\�N}\�Iձ�\����%#'),(_binary '\�D�5�N��\Z!A05:\�','Black','M',10,_binary '�N\Z\"C\�K;�\�\"�'),(_binary '\�U[YF��;L/�k�','Gray','XL',10,_binary 'HYYΨJ��jm\�$\�\0'),(_binary '\��Aq\�\�I\�\n�\�\�k@\�','Black','M',10,_binary 'f\�:nvI{��\�X�Q\��'),(_binary '\�G�X�@b�v�|<e(','Black','M',10,_binary '�\0\Zb\�GNN�$\�8'),(_binary '�V\�\'C��\�@>C��u','Black','L',10,_binary '㓿^D(�4T�m/%'),(_binary '�(\Z�8�A�H����Pq','Purple','S',10,_binary '�L\�Aj@x��*X�CLh'),(_binary '����F�AW��E���V�','Black','S',10,_binary '�N\Z\"C\�K;�\�\"�'),(_binary '��f\�\�K{�Y\�D\�R','White','S',10,_binary '\���\r�@��Z0�*\�');
/*!40000 ALTER TABLE `product_variant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` binary(16) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_new_arrival` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(38,2) NOT NULL,
  `rating` float DEFAULT NULL,
  `slug` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `category_id` binary(16) NOT NULL,
  `category_type_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKostq1ec3toafnjok09y9l7dox` (`slug`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  KEY `FK2pw105qhy1aca2a6bqc19rbxn` (`category_type_id`),
  CONSTRAINT `FK2pw105qhy1aca2a6bqc19rbxn` FOREIGN KEY (`category_type_id`) REFERENCES `category_type` (`id`),
  CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (_binary '{\�0{wA��\�\�\�\�F�\�','H & M','2024-12-20 00:04:26.806000','Men\'s Pure Cotton Regular Fit Muslin Resort Shirt',_binary '','Men\'s Casual Shirt',59.99,4.7,'027bd930-7b77-41f6-afc7-d2cee346f8d3','2024-12-20 00:04:26.806000',_binary '�~���Og�\�Xo�ͪ',_binary '��(bICi�`�	_*��'),(_binary '\r��y\�JI��_<��a\�\"','Adidas','2024-12-11 17:07:41.472000','Comfortable white hoodie for men',_binary '','White Hoodie',59.99,4.7,'0d908e79-e74a-49fb-995f-3caa8b61c322','2024-12-11 17:07:41.472000',_binary '�~���Og�\�Xo�ͪ',_binary '\�\�B\��[K��K/�\�9\�'),(_binary 'HYYΨJ��jm\�$\�\0','Puma','2024-12-11 17:12:12.203000','Comfortable gray shorts for men',_binary '','Gray Shorts',29.99,4.6,'0f485959-cea8-4ab8-a86a-6dc924d50012','2024-12-11 17:12:12.203000',_binary '�~���Og�\�Xo�ͪ',_binary '\�1�M!�\��\�'),(_binary 'INv�\"A\���2q\r','Levis','2024-12-11 17:09:23.967000','Stylish blue jeans for men',_binary '','Blue Jeans',49.99,4.6,'15494e76-8322-41ee-a017-b9957f32710d','2024-12-11 17:09:23.967000',_binary '�~���Og�\�Xo�ͪ',_binary '\�.䃏�Gw���۴\�?'),(_binary '2*b��K��q4|}\�','Roadster','2024-12-21 18:40:23.028000','The Lifestyle Co. Women Cuban Collar Vertical Striped Cotton Boxy Casual Shirt',_binary '','Women\'s Brown Black Stripped Shirt',54.99,4.5,'322a1562-8d8e-4b9b-980f-71347c1d7dc8','2024-12-21 18:40:23.028000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '0\��\�\�GI���\0���'),(_binary '4Rq%\\Oռ�\�_L\n�','TrendyWear','2024-12-11 16:52:17.931000','A trendy white graphic crop top for women',_binary '','White Graphic Crop Top',39.99,4.3,'34521c71-255c-4fd5-bcc1-d35f044c0a8b','2024-12-11 16:52:17.931000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '\�j�Fq����s\�\�'),(_binary '6#\�D	�@�O$��ǽ','Adidas','2024-12-11 17:14:39.604000','Comfortable black hoodie for men',_binary '','Black Hoodie',59.99,4.8,'3623e744-09f3-40f2-8e1f-4f24af9ac7bd','2024-12-11 17:14:39.604000',_binary '�~���Og�\�Xo�ͪ',_binary '\�\�B\��[K��K/�\�9\�'),(_binary '>1\�\�e�B���\�r\��\�','RoadSter','2024-12-20 15:17:06.813000','Men Navy blue & Off White abstract printed opaque Casual shirt ,has a mandarin collar, button placket, short regular sleeves, curved hem',_binary '','Men Navy Blue & Off White Slim Fit Printed Casual Shirt',49.99,4.5,'3e31cdc4-658a-4283-b88e-c372c40380c2','2024-12-20 15:17:06.813000',_binary '�~���Og�\�Xo�ͪ',_binary '��(bICi�`�	_*��'),(_binary 'f\�:nvI{��\�X�Q\��','Nike','2024-12-11 17:05:24.861000','Classic black t-shirt for men',_binary '','Black T-Shirt',24.99,4.5,'66c73a18-6e76-497b-b5f5-c958a551e9fc','2024-12-11 17:05:24.861000',_binary '�~���Og�\�Xo�ͪ',_binary '\�/�Δ-O条C\�z�D'),(_binary 'g#}\�(�M��-z3\�B','Biba','2024-12-19 23:52:28.217000','Women\'s Ethnic Motifs Self Design Knitted Sequined Straight Kurti',_binary '','Women\'s Ethnic Kurti',59.99,4.7,'67237dd3-28ab-4d16-94ad-022d7a33ec42','2024-12-19 23:52:28.217000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '��k��B\���\�Z��'),(_binary 'hk�$�kHD���}}��\�','Levis','2024-12-20 14:52:51.166000','Dark shade, no fade black jeans Straight fit, mid-rise Clean look for Men',_binary '','Men Relaxed Fit Mid Rise Clean Look Cotton Cargo Jeans',59.99,4.5,'686b9624-ff6b-4844-adfc-a07d7dba92eb','2024-12-20 14:52:51.166000',_binary '�~���Og�\�Xo�ͪ',_binary '\�.䃏�Gw���۴\�?'),(_binary 's�=|aBo���B\�\�\�|','Nike','2024-12-10 23:50:40.021000','100% Bio-washed Cotton – makes the fabric extra soft & silky. Flexible ribbed crew neck. Precisely stitched with no pilling & no fading. Provide  all-time comfort. Anytime, anywhere. Infinite range of matte-finish HD prints.',_binary '','Black Sweatshirt',49.99,4.5,'73903d7c-1c61-426f-af96-8942dbe7ed7c','2024-12-10 23:50:40.021000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '\��w\�@\ZB��\�S����V'),(_binary '}\�޹�1K�T^&\�\n&�','H & M','2024-12-20 14:33:58.240000','Women\'s Calf-length coat in fluffy fabric with a round neckline and concealed buttons at the front.',_binary '','Women\'s Fluffy Tie-Belt Coats',99.99,4.8,'7de0deb9-f031-4bf1-a054-5e26dc0a2688','2024-12-20 14:33:58.240000',_binary 'bK \�\�oOW��\�Re�y\�',_binary 'Sb\'\�\�I���!Qz0��'),(_binary '�\�\�N}\�Iձ�\����%#','TrendyWear','2024-12-11 16:58:39.278000','Comfortable crewneck sweatshirt for women',_binary '','Crewneck Sweatshirt',44.99,4.6,'9bd7c84e-7deb-49d5-b1bf-d0faf6a72523','2024-12-11 16:58:39.278000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '\��w\�@\ZB��\�S����V'),(_binary '�L\�Aj@x��*X�CLh','Nike','2024-12-11 16:39:18.942000','A cozy purple hoodie for women',_binary '','Purple Hoodie',69.99,4.5,'a84cc541-6a08-4078-9df5-2a58f1434c68','2024-12-11 16:39:18.942000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '\��w\�@\ZB��\�S����V'),(_binary '�E/�B\�Œim\�Ց','Highlander','2025-01-10 00:15:49.973000','Men Blue Tapered Fit Mid-Rise Clean Look Stretchable Cropped Jeans',_binary '','Men Blue Tapered Jeans',59.99,4.5,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/3880938/2018/3/27/11522151773410-HIGHLANDER-Men-Blue-Tapered-Fit-Mid-Rise-Clean-Look-Stretchable-Jeans-7601522151773234-1.jpg','2025-01-10 00:15:49.973000',_binary '�~���Og�\�Xo�ͪ',_binary '\�.䃏�Gw���۴\�?'),(_binary '�N\Z\"C\�K;�\�\"�','Nike','2024-12-11 16:54:47.219000','Stylish black shorts for women',_binary '','Black Shorts',34.99,4.3,'bd4e1a22-43ed-4b3b-9cc8-220b1cf28c90','2024-12-11 16:54:47.219000',_binary 'bK \�\�oOW��\�Re�y\�',_binary '����\�H믎U�\���'),(_binary '\�򵏆LD�7\�\"�3x','TrendyWear','2024-12-11 00:07:42.025000','A stylish white t-shirt for women',_binary '','White T-shirt',29.99,4.5,'d8f2b58f-864c-4418-8937-ec22b4337819','2024-12-11 00:07:42.025000',_binary 'bK \�\�oOW��\�Re�y\�',_binary 'q(Ò�J�>~�p@�7'),(_binary '\���\r�@��Z0�*\�','SummerVibes','2024-12-11 16:49:01.146000','A beautiful leaves pattern white dress for women',_binary '','Leaves Pattern White Dress',79.99,4.7,'dac1bd7f-0d88-40fa-835a-3012bf0e2ae8','2024-12-11 16:49:01.146000',_binary 'bK \�\�oOW��\�Re�y\�',_binary 'Hf]0+\�@^�\�p?�f\�'),(_binary '㓿^D(�4T�m/%','Biba','2024-12-20 14:47:17.776000','Black solid trench coat, has notched lapel, long sleeves, button closure, 2 pockets, a straight hem for Women',_binary '','Women\'s Notched Lapel Collar Longline Trench Coat',79.99,4.8,'e393bf5e-1810-4428-9b34-54a36d2f0825','2024-12-20 14:47:17.776000',_binary 'bK \�\�oOW��\�Re�y\�',_binary 'Sb\'\�\�I���!Qz0��'),(_binary '�\0\Zb\�GNN�$\�8','Adidas','2024-12-19 23:46:04.710000','Men\'s Mid-Rise Loose Fit Pure Cotton U D PT Joggers',_binary '','Men\'s Black Joggers',49.99,4.5,'f1001a62-d447-4e4e-9524-0ec21e381606','2024-12-19 23:46:04.710000',_binary '�~���Og�\�Xo�ͪ',_binary 'i�5��Ga�-m=\�*\�1');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `provider` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (_binary '	(i\r�I!�bD!Vh','akshat.16bec2051@abes.ac.in','Akshat','Aggarwal',NULL,NULL,'akshat.16bec2051@abes.ac.in',NULL,'Google'),(_binary 'C(og�Y@՗*��*�F0','esa@ds.com','ajsah','dszs','$2a$10$e5vIrOFGHYnBec/y7K5qR.UlSDjFHthaxbdkXUr6AaBVTXrPem1.K','129161718',NULL,'516312','Manual'),(_binary '{xɘ�\�O�4���\r\�','newuser@aa.com','new','user','$2a$10$927aSaPyLP/zvBUJOP8G..k2npAOt5.LK.YY1RabmYbRip/psNLmu','1234532',NULL,'581237','Manual'),(_binary '�\�6!�Q@=�\�T6�y\�','akshat@aa.com','akshat','aggarwal','$2a$10$mUM8HrZu.jnM2AJU3UnmhOeUwm5Ch4aElGeoEaeMR7FHmmaDNnrOS','9458531436',NULL,'988462','Manual'),(_binary '�]�sBռ\�8%E�\�','aks07hataggarwal@gmail.com','aks07hat','aggarwal',NULL,NULL,'aks07hataggarwal@gmail.com',NULL,'Google'),(_binary '�k�\�.I��Ş\�\Z�\�\�','aaakshataggarwal5@gmail.com','Akshat','Aggarwal',NULL,NULL,'aaakshataggarwal5@gmail.com',NULL,'Github');
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

-- Dump completed on 2025-01-30 20:40:01
