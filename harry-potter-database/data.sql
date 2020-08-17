-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.29

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
-- Dumping data for table `await_commit_shopping_cart`
--

LOCK TABLES `await_commit_shopping_cart` WRITE;
/*!40000 ALTER TABLE `await_commit_shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `await_commit_shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Harry Potter and the Philosopher\'s Stone',11.99,0,'https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg/220px-Harry_Potter_and_the_Philosopher%27s_Stone_Book_Cover.jpg'),(2,'Harry Potter and the Chamber of Secrets',12,0,'https://upload.wikimedia.org/wikipedia/en/thumb/5/5c/Harry_Potter_and_the_Chamber_of_Secrets.jpg/220px-Harry_Potter_and_the_Chamber_of_Secrets.jpg'),(3,'Harry Potter and the Prisoner of Azkaban',11.99,2,'https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/Harry_Potter_and_the_Prisoner_of_Azkaban.jpg/220px-Harry_Potter_and_the_Prisoner_of_Azkaban.jpg'),(4,'Harry Potter and the Goblet of Fire',11.99,0,'https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Harry_Potter_and_the_Goblet_of_Fire_cover.png/220px-Harry_Potter_and_the_Goblet_of_Fire_cover.png'),(5,'Harry Potter and the Order of the Phoenix',11.99,1,'https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Harry_Potter_and_the_Order_of_the_Phoenix.jpg/220px-Harry_Potter_and_the_Order_of_the_Phoenix.jpg'),(6,'Harry Potter and the Half-Blood Prince',11.99,1,'https://upload.wikimedia.org/wikipedia/en/thumb/b/b5/Harry_Potter_and_the_Half-Blood_Prince_cover.png/220px-Harry_Potter_and_the_Half-Blood_Prince_cover.png'),(7,'Harry Potter and the Deathly Hallows',11.99,0,'https://upload.wikimedia.org/wikipedia/en/a/a9/Harry_Potter_and_the_Deathly_Hallows.jpg');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (24,NULL,'2020-08-17 19:06:30'),(25,1,'2020-08-17 20:19:04'),(26,1,'2020-08-17 20:34:18'),(27,1,'2020-08-17 20:34:46'),(28,1,'2020-08-17 20:34:58'),(29,1,'2020-08-17 20:35:30'),(30,1,'2020-08-17 20:35:57'),(31,1,'2020-08-17 20:36:23'),(32,1,'2020-08-17 20:36:33'),(33,1,'2020-08-17 20:38:01'),(34,1,'2020-08-17 20:39:10'),(35,1,'2020-08-17 21:13:38'),(36,1,'2020-08-17 21:14:35'),(37,1,'2020-08-17 21:22:37');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shopping_cart_detail`
--

LOCK TABLES `shopping_cart_detail` WRITE;
/*!40000 ALTER TABLE `shopping_cart_detail` DISABLE KEYS */;
INSERT INTO `shopping_cart_detail` VALUES (25,24,1,1),(26,24,2,1),(27,24,3,1),(28,25,1,1),(29,26,1,2),(30,27,1,2),(31,28,1,2),(32,29,1,2),(33,30,1,2),(34,31,1,2),(35,32,1,2),(36,33,1,1),(37,34,2,1),(38,36,1,1),(39,37,3,1),(40,37,4,1);
/*!40000 ALTER TABLE `shopping_cart_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-17 16:54:45
