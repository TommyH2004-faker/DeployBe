-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: websitenhua
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `id_cart` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `id_plastic_item` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_cart`),
  KEY `FKeefncso02uj7v4rxtos60ns8m` (`id_plastic_item`),
  KEY `FKikbqppvx730nfh1pu7av14wr3` (`id_user`),
  CONSTRAINT `FKeefncso02uj7v4rxtos60ns8m` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`),
  CONSTRAINT `FKikbqppvx730nfh1pu7av14wr3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (35,7,52,1),(36,1,53,1);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `id_delivery` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fee_delivery` double DEFAULT NULL,
  `name_delivery` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_delivery`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,'Giao hàng tiêu chuẩn',15000,'Standard Delivery'),(2,'Giao hàng nhanh',30000,'Express Delivery');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite_item`
--

DROP TABLE IF EXISTS `favorite_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite_item` (
  `id_favorite_item` int NOT NULL AUTO_INCREMENT,
  `id_plastic_item` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_favorite_item`),
  KEY `FK3odna1dgfh5c0avvs919jwrgc` (`id_plastic_item`),
  KEY `FKkfkak4f5vynjrodngrvii4xe8` (`id_user`),
  CONSTRAINT `FK3odna1dgfh5c0avvs919jwrgc` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`),
  CONSTRAINT `FKkfkak4f5vynjrodngrvii4xe8` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite_item`
--

LOCK TABLES `favorite_item` WRITE;
/*!40000 ALTER TABLE `favorite_item` DISABLE KEYS */;
INSERT INTO `favorite_item` VALUES (5,7,2),(6,15,3),(7,20,4),(8,25,5),(10,10,2),(11,12,3),(12,18,4),(13,30,5),(26,52,1),(31,77,1);
/*!40000 ALTER TABLE `favorite_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id_feedback` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `is_readed` bit(1) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_feedback`),
  KEY `FKiymqqp517nmqvubr9ye5rlrf1` (`id_user`),
  CONSTRAINT `FKiymqqp517nmqvubr9ye5rlrf1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Sản phẩm rất tốt','2025-05-25',_binary '','Hài lòng',1),(2,'Cần giao hàng nhanh hơn','2025-05-26',_binary '','Vận chuyển',2),(4,'bdb','2025-06-10',_binary '','vdbd',1),(5,'tuti','2025-06-12',_binary '','thtj',1),(6,'kykyuk','2025-06-12',_binary '','iuioykhk',1),(7,'lulul','2025-06-12',_binary '','uloulyky',1);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id_genre` int NOT NULL AUTO_INCREMENT,
  `name_genre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_genre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Đồ gia dụng'),(2,'Nhà bếp'),(3,'Đựng thực phẩm'),(4,'Nội thất nhựa'),(5,'Đồ trẻ em'),(6,'Vệ sinh nhà cửa'),(9,'Trồng cây'),(10,'Đựng nước');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id_image` int NOT NULL AUTO_INCREMENT,
  `data_image` longtext COLLATE utf8mb4_general_ci,
  `name_image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_thumbnail` bit(1) DEFAULT NULL,
  `url_image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_plastic_item` int NOT NULL,
  PRIMARY KEY (`id_image`),
  KEY `FKpm3d8ncbuu3embits68vr02ej` (`id_plastic_item`),
  CONSTRAINT `FKpm3d8ncbuu3embits68vr02ej` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,NULL,'img1.jpg',_binary '\0','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/145.o-bau-2t4-1_pv1hql.jpg',1),(2,NULL,'img2.jpg',_binary '\0','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/145.o-bau-2t4-1_pv1hql.jpg',2),(3,NULL,'img3.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/145.o-bau-2t4-1_pv1hql.jpg',3),(4,NULL,'img4.jpg',_binary '\0','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/145.o-bau-2t4-1_pv1hql.jpg',4),(5,NULL,'img5.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/10l-vang_s7hv6b.jpg',5),(6,NULL,'img6.jpg',_binary '\0','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/binh-thuy-3lit2-la-dam_n5tskd.png',6),(7,NULL,'img7.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/007.la_bwmiij.jpg',7),(8,NULL,'img8.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/bo-lau-nha-qn-xam_qbscyk.png',8),(9,NULL,'img9.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959974/146.ro-bau-3t0_boxuhs.jpg',9),(10,NULL,'img10.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959975/ca-chu-nhat-3l-tim_hbrkpy.png',10),(11,NULL,'img11.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959975/ke-da-nang-4t-xam_bj5ety.png',11),(12,NULL,'img12.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959975/147.ro-bau-3t2_wqz9pk.jpg',12),(13,NULL,'img13.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959975/250_nmtshm.jpg',13),(14,NULL,'img14.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959975/ca-cach-nhiet-nho---duong_kpkvks.jpg',14),(15,NULL,'img15.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/ke-nho-2024-2n-xam_xbhyrg.png',15),(16,NULL,'img16.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/ke-nho-2024-3n-xam_f8r5kz.png',16),(17,NULL,'img17.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/OIP_1_jgutim.jpg',17),(18,NULL,'img18.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/ke-trung-2024-4n-la_gtxg6z.png',18),(19,NULL,'img19.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/dsc00878_rgfhlw.jpg',19),(20,NULL,'img20.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959977/OIP_2_tuahpb.jpg',20),(21,NULL,'img21.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959977/OIP_jry1bb.jpg',21),(22,NULL,'img22.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959977/OIP_3_rfwbof.jpg',22),(23,NULL,'img23.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959976/ke-lon-2024-4n-duong_sjbfzm.png',23),(24,NULL,'img24.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959982/ro-bau-chung.48_xutzbo.jpg',24),(25,NULL,'img25.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959983/thung-da-minice-3-hong_yxcome.jpg',25),(26,NULL,'img26.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959983/thot-2-mau-lon-vang_y4auuc.jpg',26),(27,NULL,'img27.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959984/thung-da-minice-lon-xam_tdqmxd.jpg',27),(28,NULL,'img28.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959984/xo-12-do_otvgh3.jpg',28),(29,NULL,'img29.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960049/9015-la.jpg_evyyy2.jpg',29),(30,NULL,'img30.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748959984/sot-chu-nhat-dan-duong_elewe3.png',30),(31,NULL,'img31.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960493/3-_1_zea1dx.jpg',31),(32,NULL,'img32.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960493/3-_1_zea1dx.jpg',33),(33,NULL,'img34.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960529/khay-tron-2_obh8ja.jpg',34),(34,NULL,'img35.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960599/f1243-hu-gia-vi-vuong_ybhdi2.jpg',35),(35,NULL,'img36.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960692/may-dan-6_tg51om.jpg',36),(36,NULL,'img37.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960692/may-dan-6_tg51om.jpg',37),(37,NULL,'img38.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960722/090.nau_zizpno.jpg',38),(38,NULL,'img39.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960732/b2_xc1aws.jpg',39),(39,NULL,'img40.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960732/b2_xc1aws.jpg',40),(40,NULL,'img41.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960745/gh%E1%BA%BF-pisa-v%C3%A0ng_lhm4h2.jpg',41),(41,NULL,'img42.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960766/b%C3%A0n-cali-vu%C3%B4ng-3-ch%C3%A2n_ls1rfj.jpg',42),(42,NULL,'img43.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960775/ghe-nido-mau-trang-duy-tan_ja5udz.jpg',43),(43,NULL,'img44.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960775/ghe-nido-mau-trang-duy-tan_ja5udz.jpg',44),(44,NULL,'img45.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960844/tu-tabi-4n-hoa-buom_rfpnsv.png',45),(45,NULL,'img46.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960873/38_g23xft.jpg',46),(46,NULL,'img47.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960891/tu-tomi-diamond-nho-4ngan-la_tsxe9q.jpg',47),(47,NULL,'img48.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960899/ghe-lun-anh-sao-do-do_nhusg3.jpg',48),(48,NULL,'img49.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960899/ghe-lun-anh-sao-do-do_nhusg3.jpg',49),(49,NULL,'img50.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960928/ca-quai-2mau-doden_sw4d5x.jpg',50),(50,NULL,'img51.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960953/asset-12_yk5fhx.png',51),(51,NULL,'img52.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960938/ca-2-mau-duong_rf9nmd.png',52),(52,NULL,'img53.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960953/asset-12_yk5fhx.png',53),(54,NULL,'img53.jpg',_binary '','https://res.cloudinary.com/duhi7od89/image/upload/v1748960953/asset-12_yk5fhx.png',54),(59,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1749703193/ImagePlastic/Plastic_56.jpg',56),(61,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1749783477/Plastic_62.jpg',62),(62,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1749883850/Plastic_74.jpg',74),(64,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1750305806/ImagePlastic/3762af43-1030-48bd-b0d9-1dd8421549e9.jpg.jpg',77),(65,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1750305823/ImagePlastic/7d052b1c-290d-4351-af62-297b2407e79b.jpg.jpg',75),(66,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750305825/ImagePlastic/88fc204c-752a-4ca6-b321-51972a355abc.jpg.jpg',75),(67,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750305827/ImagePlastic/4faba891-d47e-4215-8319-319b6fd4dbfc.jpg.jpg',75),(68,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750305828/ImagePlastic/6263a99a-1ba2-42ad-af9d-a9862b4403bf.jpg.jpg',75),(69,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750305830/ImagePlastic/029fe347-a2b2-41f7-99be-fca13c14ab0e.jpg.jpg',75),(70,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750305832/ImagePlastic/d7d2f706-1089-4ac1-890f-174f25f4ddda.jpg.jpg',75),(77,NULL,NULL,_binary '','http://res.cloudinary.com/duhi7od89/image/upload/v1750424449/ImagePlastic/9fc52484-25d1-43ba-a7b2-1fe58208cf20.jpg.jpg',79),(78,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750424452/ImagePlastic/bdcc0b01-8554-4685-9c5e-783fcab2f387.jpg.jpg',79),(79,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750424454/ImagePlastic/ab4cff20-904c-46fc-91c5-0179ccf192b2.jpg.jpg',79),(80,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750424456/ImagePlastic/c6a10755-cafc-4731-95f9-674e22d430a2.jpg.jpg',79),(81,NULL,NULL,_binary '\0','http://res.cloudinary.com/duhi7od89/image/upload/v1750424458/ImagePlastic/002372ac-3894-4f24-99c9-faa1017dd83d.jpg.jpg',79);
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id_order_detail` bigint NOT NULL AUTO_INCREMENT,
  `is_review` bit(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `id_order` int NOT NULL,
  `id_plastic_item` int NOT NULL,
  PRIMARY KEY (`id_order_detail`),
  KEY `FKsta0q8hk1lt2vdu92u4e5vr4a` (`id_order`),
  KEY `FK23bu1kmq68dhy9vthoma3s7er` (`id_plastic_item`),
  CONSTRAINT `FK23bu1kmq68dhy9vthoma3s7er` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`),
  CONSTRAINT `FKsta0q8hk1lt2vdu92u4e5vr4a` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (3,_binary '\0',180000,4,3,1),(4,_binary '\0',57850,1,3,51),(5,_binary '\0',30940,1,3,47),(6,_binary '\0',32900,1,3,48),(7,_binary '\0',420000,2,3,49),(8,_binary '\0',30400,1,4,52),(9,_binary '\0',121600,4,5,52),(10,_binary '\0',400200,1,6,54),(11,_binary '\0',111110,1,7,56),(12,_binary '\0',400200,1,7,54),(13,_binary '\0',40500,1,7,50),(14,_binary '\0',57850,1,7,51),(15,_binary '\0',25760,1,7,53),(16,_binary '\0',30400,1,7,52),(17,_binary '\0',400200,1,8,54),(18,_binary '\0',25760,1,8,53),(19,_binary '\0',210000,1,8,49),(20,_binary '\0',400200,1,9,54),(21,_binary '\0',25760,1,9,53),(22,_binary '\0',210000,1,9,49),(23,_binary '\0',18000,1,10,9),(24,_binary '\0',12106257,1,10,75),(25,_binary '\0',27000,1,11,3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `date_created` date DEFAULT NULL,
  `delivery_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fee_delivery` double DEFAULT NULL,
  `fee_payment` double DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `total_price_product` double DEFAULT NULL,
  `id_delivery` int DEFAULT NULL,
  `id_payment` int DEFAULT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FK4cdgfu14t6vi93xhiugkyin2d` (`id_delivery`),
  KEY `FK5phng0rr9yex7v321tef65svq` (`id_payment`),
  KEY `FKp1jglhdt6fpf5plvbns0gp5ns` (`id_user`),
  CONSTRAINT `FK4cdgfu14t6vi93xhiugkyin2d` FOREIGN KEY (`id_delivery`) REFERENCES `delivery` (`id_delivery`),
  CONSTRAINT `FK5phng0rr9yex7v321tef65svq` FOREIGN KEY (`id_payment`) REFERENCES `payment` (`id_payment`),
  CONSTRAINT `FKp1jglhdt6fpf5plvbns0gp5ns` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'2025-06-10','123 Đường ABC',NULL,NULL,'Nguyễn Văn A','','0123456789','Thành công',721690,721690,NULL,1,1),(4,'2025-06-10','123 Đường ABC',NULL,NULL,'Nguyễn Văn A','','0123456789','Thành công',30400,30400,NULL,1,1),(5,'2025-06-12','123 Đường ABC',NULL,NULL,'Nguyễn Văn Hiep','','0123456789','Thành công',121600,121600,NULL,1,1),(6,'2025-06-12','123 Đường ABC',NULL,NULL,'Nguyễn Văn Hiep','','0123456789','Thành công',400200,400200,NULL,2,1),(7,'2025-06-13','ha noi',NULL,NULL,'tran hiep','','0387236324','Thành công',665820,665820,NULL,1,7),(8,'2025-06-14','123 Đường ABC',NULL,NULL,'Nguyễn Văn Hiep','','0123456789','Đang xử lý',635960,635960,NULL,2,1),(9,'2025-06-14','123 Đường ABC',NULL,NULL,'Nguyễn Văn Hiep','','0123456789','Đang xử lý',635960,635960,NULL,2,1),(10,'2025-06-14','123 Đường ABC',NULL,NULL,'Nguyễn Văn Hiep','','0123456789','Thành công',12124257,12124257,NULL,1,1),(11,'2025-06-14','456 Đường XYZ',NULL,NULL,'Trần Thị B','','0987654321','Đang xử lý',27000,27000,NULL,1,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id_payment` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fee_payment` double DEFAULT NULL,
  `name_payment` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_payment`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'Thanh toán khi nhận hàng',0,'COD'),(2,'Thanh toán qua ví điện tử',5000,'VnPAY');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plastic_item`
--

DROP TABLE IF EXISTS `plastic_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plastic_item` (
  `id_plastic_item` int NOT NULL AUTO_INCREMENT,
  `avg_rating` double DEFAULT NULL,
  `description` longtext COLLATE utf8mb4_general_ci,
  `discount_percent` int DEFAULT NULL,
  `list_price` double DEFAULT NULL,
  `manufacturer` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name_plastic_item` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `sold_quantity` int DEFAULT NULL,
  PRIMARY KEY (`id_plastic_item`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plastic_item`
--

LOCK TABLES `plastic_item` WRITE;
/*!40000 ALTER TABLE `plastic_item` DISABLE KEYS */;
INSERT INTO `plastic_item` VALUES (1,4.8,'Hộp nhựa cao cấp, an toàn cho thực phẩm.',10,50000,'Nhựa Việt Nam','Hộp nhựa đựng thực phẩm',96,45000,54),(2,4.5,'Ly nhựa tiện lợi, dùng một lần.',10,20000,'Nhựa Sài Gòn','Ly nhựa dùng một lần',200,18000,100),(3,4.7,'Chai nhựa bền, dung tích 1L.',10,30000,'Nhựa Hà Nội','Chai nhựa đựng nước',149,27000,81),(4,4.6,'Bộ dụng cụ nhà bếp tiện lợi.',10,100000,'Nhựa Đà Nẵng','Bộ dụng cụ nhà bếp bằng nhựa',50,90000,30),(5,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(6,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(7,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(8,4.8,'Hộp nhựa cao cấp, an toàn cho thực phẩm.',10,50000,'Nhựa Việt Nam','Hộp nhựa đựng thực phẩm',100,45000,50),(9,4.5,'Ly nhựa tiện lợi, dùng một lần.',10,20000,'Nhựa Sài Gòn','Ly nhựa dùng một lần',199,18000,101),(10,4.7,'Chai nhựa bền, dung tích 1L.',10,30000,'Nhựa Hà Nội','Chai nhựa đựng nước',150,27000,80),(11,4.6,'Bộ dụng cụ nhà bếp tiện lợi.',10,100000,'Nhựa Đà Nẵng','Bộ dụng cụ nhà bếp bằng nhựa',50,90000,30),(12,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(13,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(14,4.9,'Thùng nhựa lớn, bền chắc.',10,150000,'Nhựa Cần Thơ','Thùng nhựa đựng đồ',70,135000,40),(15,4.5,'Bình nước nhựa 1.5L chịu nhiệt tốt',10,50000,'Nhựa Việt Nhật','Bình nước 1.5L',100,45000,20),(16,3.8,'Thùng rác nhựa 20L dùng cho gia đình',15,120000,'Hưng Thịnh','Thùng rác 20L',50,102000,10),(17,4.2,'Hộp nhựa đựng thực phẩm 1L',5,30000,'Duy Tân','Hộp thực phẩm 1L',200,28500,45),(18,4.7,'Rổ nhựa tròn đựng rau',8,25000,'Việt Mỹ','Rổ đựng rau',150,23000,60),(19,4.1,'Ghế nhựa thấp dùng ngoài trời',12,80000,'Hòa Phát','Ghế nhựa thấp',80,70400,25),(20,3.5,'Bình đựng nước nhựa có vòi 5L',20,150000,'Duy Tân','Bình nước 5L vòi',40,120000,18),(21,4.9,'Tủ nhựa mini 3 ngăn tiện lợi',10,350000,'Song Long','Tủ nhựa 3 ngăn',30,315000,12),(22,4,'Thau nhựa tròn 40cm',7,40000,'Đại Đồng Tiến','Thau nhựa 40cm',120,37200,33),(23,4.3,'Cốc nhựa nhiều màu 300ml',5,10000,'Minh Tân','Cốc nhựa 300ml',500,9500,150),(24,3.9,'Kệ nhựa để giày dép 3 tầng',18,180000,'Song Long','Kệ để giày 3 tầng',60,147600,22),(25,4.6,'Giỏ nhựa đựng đồ đa năng',9,32000,'Duy Tân','Giỏ đựng đồ',140,29120,40),(26,4.4,'Bộ hộp nhựa 3 cái đủ kích cỡ',11,75000,'Việt Nhật','Hộp nhựa bộ 3 cái',90,66750,28),(27,3.7,'Chậu nhựa trồng cây 20cm',6,28000,'Hưng Thịnh','Chậu cây nhựa',170,26320,35),(28,4.8,'Ghế nhựa xếp gọn cao cấp',14,145000,'Duy Tân','Ghế xếp nhựa',45,124700,19),(29,3.6,'Khay nhựa đựng đá 24 ô',10,22000,'Việt Mỹ','Khay đá 24 ô',110,19800,21),(30,4,'Thùng đựng nước có nắp 20L',13,170000,'Đại Đồng Tiến','Thùng nước 20L',35,147900,9),(31,4.1,'Ca nhựa tay cầm dung tích 1L',5,18000,'Minh Tân','Ca nhựa 1L',180,17100,55),(32,4.6,'Tủ nhựa lớn 5 tầng kéo',20,550000,'Song Long','Tủ nhựa 5 tầng',25,440000,8),(33,3.9,'Kệ nhựa đựng sách mini',8,190000,'Duy Tân','Kệ sách mini',40,174800,14),(34,4.4,'Thùng rác đạp chân 15L',10,135000,'Việt Nhật','Thùng rác 15L',55,121500,23),(35,4.2,'Hộp đựng dụng cụ học tập nhựa',12,60000,'Minh Tân','Hộp bút nhựa',75,52800,27),(36,4,'Hộp cơm nhựa 3 ngăn',15,95000,'Đại Đồng Tiến','Hộp cơm 3 ngăn',100,80750,34),(37,3.8,'Hộp nhựa đựng thuốc cá nhân',9,28000,'Hưng Thịnh','Hộp thuốc nhựa',130,25480,30),(38,4.5,'Tủ nhựa trẻ em in hình',18,480000,'Song Long','Tủ trẻ em',20,393600,7),(39,4.1,'Thau nhựa giặt đồ 60L',7,52000,'Duy Tân','Thau giặt đồ 60L',65,48360,15),(40,4.3,'Rổ nhựa vuông nhiều màu',5,27000,'Việt Mỹ','Rổ nhựa vuông',100,25650,31),(41,3.9,'Ca nhựa có nắp đậy 500ml',6,21000,'Minh Tân','Ca nhựa có nắp',90,19740,12),(42,4.4,'Hộp nhựa đựng bánh kẹo 2 tầng',10,60000,'Đại Đồng Tiến','Hộp bánh 2 tầng',80,54000,16),(43,4,'Kệ nhựa nhiều tầng đựng đồ nhà tắm',15,220000,'Duy Tân','Kệ nhà tắm',50,187000,18),(44,4.6,'Tủ nhựa đựng quần áo mini',17,390000,'Song Long','Tủ mini quần áo',28,323700,11),(45,3.7,'Thùng rác mini để bàn',8,22000,'Việt Nhật','Thùng rác mini',110,20240,44),(46,4.1,'Ghế nhựa trẻ em nhiều màu',12,72000,'Hòa Phát','Ghế trẻ em',70,63360,20),(47,4.5,'Giỏ nhựa xách tay đựng đồ đi chợ',9,34000,'Việt Nhật','Giỏ đi chợ',84,30940,25),(48,3.8,'Chậu nhựa trồng hoa 30cm',6,35000,'Duy Tân','Chậu hoa 30cm',99,32900,27),(49,4.7,'Kệ nhựa đa năng 4 tầng',16,250000,'Song Long','Kệ nhựa 4 tầng',26,210000,14),(50,4,'Bình nhựa uống nước thể thao 750ml',10,45000,'Đại Đồng Tiến','Bình thể thao 750ml',119,40500,37),(51,4.2,'Hộp đựng gia vị 4 ngăn',11,65000,'Minh Tân','Hộp gia vị 4 ngăn',88,57850,21),(52,4.3,'Rổ nhựa có quai xách',5,32000,'Việt Mỹ','Rổ có quai',134,30400,35),(53,3.9,'Ca nhựa đo lường có chia vạch',8,28000,'Hưng Thịnh','Ca đo nhựa',82,25760,20),(54,4.5,'Tủ nhựa 4 ngăn có bánh xe',13,460000,'Song Long','Tủ 4 ngăn bánh xe',18,400200,13),(56,0,'Sản phẩm đẹp ',10,123456,'Việt nhật','giổ giá thời 4.0',99,111110,1),(62,0,'sfs',4,123456342,'Việt nhật','Truyện Ngụ Ngôn Thế Giới Chọnfef Lọc - Con Mèo Ngoan Đạo',100,118518088,0),(74,0,'dgdg',2,123533,'Việt nhật','Truyện Ngụ Ngôn Thế Giới Chdgdọnfefsfsfgdgdhgd Lọc -hdh Con Mèo Ngoan Đạo',100,121062,0),(75,0,'gdgd',2,12353323,'Việt nhật','hieptran123456nfnf',99,12106257,1),(77,0,'ege',0,12353323,'Việt nhậthrhr','Truyện Ngụ Ngôn Thế Giới Chọn Lọc - Coehn Mèo Ngoan Đạog',100,12353323,0),(79,0,'San pha mtot ',10,12345,'Tran Hiep','Nhua TiTan',1234,11110,0);
/*!40000 ALTER TABLE `plastic_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plastic_item_genre`
--

DROP TABLE IF EXISTS `plastic_item_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plastic_item_genre` (
  `id_plastic_item` int NOT NULL,
  `id_genre` int NOT NULL,
  KEY `FKedruw3i4m8bd9aifvpr9t9itl` (`id_genre`),
  KEY `FKhko3q4cqprc2jlwp8p6vdfewh` (`id_plastic_item`),
  CONSTRAINT `FKedruw3i4m8bd9aifvpr9t9itl` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id_genre`),
  CONSTRAINT `FKhko3q4cqprc2jlwp8p6vdfewh` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plastic_item_genre`
--

LOCK TABLES `plastic_item_genre` WRITE;
/*!40000 ALTER TABLE `plastic_item_genre` DISABLE KEYS */;
INSERT INTO `plastic_item_genre` VALUES (1,1),(1,2),(1,3),(2,2),(2,3),(2,4),(3,3),(3,4),(3,5),(4,4),(4,5),(4,6),(5,5),(5,6),(6,6),(7,1),(8,1),(8,2),(9,1),(9,2),(9,3),(10,2),(10,3),(10,4),(11,3),(11,4),(11,5),(12,4),(12,5),(12,6),(13,5),(13,6),(14,6),(15,1),(16,1),(16,2),(17,1),(17,2),(17,3),(18,2),(18,3),(18,4),(19,3),(19,4),(19,5),(20,4),(20,5),(20,6),(21,5),(21,6),(22,6),(23,1),(24,1),(24,2),(25,1),(25,2),(25,3),(26,2),(26,3),(26,4),(27,3),(27,4),(27,5),(28,4),(28,5),(28,6),(29,5),(29,6),(30,6),(31,1),(33,1),(33,2),(33,3),(34,2),(34,3),(34,4),(35,3),(35,4),(35,5),(36,4),(36,5),(36,6),(37,5),(37,6),(38,6),(39,1),(40,1),(40,2),(41,1),(41,2),(41,3),(42,2),(42,3),(42,4),(43,3),(43,4),(43,5),(44,4),(44,5),(44,6),(45,5),(45,6),(46,6),(47,1),(48,1),(48,2),(49,1),(49,2),(49,3),(50,2),(50,3),(50,4),(51,3),(51,4),(51,5),(52,4),(52,5),(52,6),(53,5),(53,6),(54,6),(56,2),(56,9),(56,10),(32,1),(32,2),(62,2),(62,3),(62,4),(74,1),(74,2),(74,3),(77,1),(77,2),(75,2),(75,3),(75,4),(79,1),(79,2),(79,3);
/*!40000 ALTER TABLE `plastic_item_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id_review` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rating_point` float DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `id_order_detail` bigint DEFAULT NULL,
  `id_plastic_item` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_review`),
  UNIQUE KEY `UK3tpuisov8qyurqh23uu8ctmwp` (`id_order_detail`),
  KEY `FKcwsvpy7ctb635kmv24ctgtjci` (`id_plastic_item`),
  KEY `FKebfdb78chwertfckv3kgu9anx` (`id_user`),
  CONSTRAINT `FKbflf4ds01tlvwpvvcxidwvj9d` FOREIGN KEY (`id_order_detail`) REFERENCES `order_detail` (`id_order_detail`),
  CONSTRAINT `FKcwsvpy7ctb635kmv24ctgtjci` FOREIGN KEY (`id_plastic_item`) REFERENCES `plastic_item` (`id_plastic_item`),
  CONSTRAINT `FKebfdb78chwertfckv3kgu9anx` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'Hộp nhựa rất tốt, an toàn cho thực phẩm.',5,'2023-10-01 12:00:00.000000',NULL,1,1),(2,'Ly nhựa tiện lợi, giá hợp lý.',4.5,'2023-10-02 14:00:00.000000',NULL,2,2),(3,'Chai nhựa bền, dễ sử dụng.',4.7,'2023-10-03 16:00:00.000000',NULL,3,3),(4,'Bộ dụng cụ nhà bếp rất tiện lợi.',4.6,'2023-10-04 18:00:00.000000',NULL,4,4),(5,'Thùng nhựa rất chắc chắn.',4.9,'2023-10-05 20:00:00.000000',NULL,5,5);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` int NOT NULL AUTO_INCREMENT,
  `name_role` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `activation_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `delivery_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ACT001','http://res.cloudinary.com/duhi7od89/image/upload/v1749717955/User_1.jpg','1990-01-01','123 Đường ABC','vana@example.com',_binary '','Nguyễn','M','Văn Hiep','$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He','0123456789','admin'),(2,NULL,'http://res.cloudinary.com/duhi7od89/image/upload/v1749717452/User_2.jpg','1992-05-15','456 Đường XYZ','thib@example.com',_binary '','Trần','F','Thị B','$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He','0987654321','user'),(3,NULL,'avatar3.png','1985-03-20','789 Đường DEF','vanc@example.com',_binary '','Lê','M','Văn C','$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He','0912345678','admin1'),(4,'ACT004','avatar4.png','1995-07-10','321 Đường GHI','thid@example.com',_binary '','Phạm','F','Thị D','$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He','0934567890','phamthid'),(5,NULL,'avatar5.png','1988-11-25','654 Đường JKL','vane@example.com',_binary '','Hoàng','M','Văn E','$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He','0945678901','hoangvane'),(6,'c91d958e-33e6-40a6-aed8-c90d559ad7c9','',NULL,NULL,NULL,_binary '\0',NULL,'\0',NULL,'$2a$12$emdNkp5vOLcs60wlne/IZ.6zoqIe7al1aaLX9ZONZozzFs8YDd5He',NULL,'admin1'),(7,NULL,'http://res.cloudinary.com/duhi7od89/image/upload/v1749785091/User_7.jpg','1970-01-01',NULL,'hiept81331@gmail.com',_binary '\0','tran','M','hiep','$2a$10$PHDsqKPVYXmh9pKj2aGCYOITzMlyYQdSuN7FTRs3utXL73bAOsRHa','0387236324','admintran'),(8,NULL,'http://res.cloudinary.com/duhi7od89/image/upload/v1749865908/User_0.jpg','2000-01-01','ha noi','hiept81332@gmail.com',_binary '\0','hieptran123456','M','hieptran','$2a$10$y4fARqf/.V7fdBqVheLcUuCH7r2O3aexRUT0BNsM44xGAR5/HZw.m','0387236324','tranminhhiep');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id_user` int NOT NULL,
  `id_role` int NOT NULL,
  KEY `FK2aam9nt2tv8vcfymi3jo9c314` (`id_role`),
  KEY `FKfhxaael2m459kbk8lv8smr5iv` (`id_user`),
  CONSTRAINT `FK2aam9nt2tv8vcfymi3jo9c314` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  CONSTRAINT `FKfhxaael2m459kbk8lv8smr5iv` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(4,1),(8,1),(7,2),(5,2),(2,2),(3,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-28 21:41:06
