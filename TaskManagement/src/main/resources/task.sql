/*
SQLyog Community v12.16 (64 bit)
MySQL - 10.1.9-MariaDB : Database - task
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`task` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `task`;

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mj80g2nrd9ga5bf7i06cn8615` (`users_id`),
  CONSTRAINT `FK_mj80g2nrd9ga5bf7i06cn8615` FOREIGN KEY (`users_id`) REFERENCES `user_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `authority` */

insert  into `authority`(`id`,`authority`,`username`,`users_id`) values 
(1,'ADMIN','deepanjan',1),
(2,'ADMIN','pankaj',2);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `task_taskId` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK_n4hh2od6900khu5v6w2vylnw2` (`task_taskId`),
  CONSTRAINT `FK_n4hh2od6900khu5v6w2vylnw2` FOREIGN KEY (`task_taskId`) REFERENCES `tasks` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `comments` */

insert  into `comments`(`comment_id`,`comment`,`u_name`,`task_taskId`) values 
(1,'Checked by deepanjan','deepanjan',1),
(2,'Checked by pankaj','pankaj',2),
(3,'Checked by deepanjan','deepanjan',2),
(4,'Checked by Pankaj','pankaj',1),
(5,'Checked by Sharmila ','sharmila',1),
(8,'skjadhckjd','dskjhfakjdhf',1),
(9,'gjhsagfjsj','Deepanjan',1),
(10,'kjshfadkjhsd','jyhdgs',1),
(11,'7y2437','jkehertlhsf',1),
(12,'32rew34','kjsdhfskjdhf',1);

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `task_taskId` int(11) DEFAULT NULL,
  `user_userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dn5d6sayf8rt3pkx3yd8k1xkp` (`task_taskId`),
  KEY `FK_nacbsaivwle6m2y314clvwnl5` (`user_userId`),
  CONSTRAINT `FK_dn5d6sayf8rt3pkx3yd8k1xkp` FOREIGN KEY (`task_taskId`) REFERENCES `tasks` (`task_id`),
  CONSTRAINT `FK_nacbsaivwle6m2y314clvwnl5` FOREIGN KEY (`user_userId`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `history` */

/*Table structure for table `tasks` */

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK_ntoosed11971kog3knaeqrslk` (`user_userId`),
  CONSTRAINT `FK_ntoosed11971kog3knaeqrslk` FOREIGN KEY (`user_userId`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tasks` */

insert  into `tasks`(`task_id`,`msg`,`status`,`title`,`user_userId`) values 
(1,'Update1','Incomplete','Install',1),
(2,'Checked2','Complete','Update',1),
(3,'Install','Complete','Notification',3),
(4,'Notification','Complete','Install',2);

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_details` */

insert  into `user_details`(`id`,`enabled`,`password`,`username`) values 
(1,'','deepanjan','deepanjan'),
(2,'','pankaj','pankaj');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`u_name`,`user_name`) values 
(1,'Deepanjan','deepanjan'),
(2,'Pankaj','pankaj'),
(3,'Sharmila','sharmila');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
