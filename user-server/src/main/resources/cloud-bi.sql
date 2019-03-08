/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.24 : Database - cloud-bi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cloud-bi` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `cloud-bi`;

/*Table structure for table `bi_menu_list` */

DROP TABLE IF EXISTS `bi_menu_list`;

CREATE TABLE `bi_menu_list` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父亲节点id,0为父级节点',
  `menu_enname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '英文标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_menu_list` */

insert  into `bi_menu_list`(`id`,`menu_name`,`parent_id`,`menu_enname`) values (1,'系统设置',0,'system_setting'),(2,'标签管理',0,'tag_management'),(3,'系统管理',1,'sys_management'),(4,'角色管理',3,'role_management'),(5,'权限管理',3,'per_management'),(6,'用户管理',3,'user_management'),(7,'菜单管理',3,'menu_management');

/*Table structure for table `bi_permission` */

DROP TABLE IF EXISTS `bi_permission`;

CREATE TABLE `bi_permission` (
  `permission_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permission_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` bigint(11) DEFAULT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  `permission_auth` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_permission` */

insert  into `bi_permission`(`permission_id`,`permission_name`,`permission_url`,`parent_id`,`role_id`,`permission_auth`) values (155,'系统设置','system_setting',NULL,1,NULL),(156,'系统管理','sys_management',NULL,1,NULL),(157,'角色管理','role_management',NULL,1,NULL),(158,'权限管理','per_management',NULL,1,NULL),(159,'系统设置','system_setting',NULL,4,NULL),(160,'系统管理','sys_management',NULL,4,NULL),(161,'角色管理','role_management',NULL,4,NULL),(162,'权限管理','per_management',NULL,4,NULL),(163,'用户管理','user_management',NULL,4,NULL),(164,'菜单管理','menu_management',NULL,4,NULL),(165,'标签管理','tag_management',NULL,4,NULL),(166,'系统设置','system_setting',NULL,3,NULL),(167,'系统管理','sys_management',NULL,3,NULL),(168,'角色管理','role_management',NULL,3,NULL),(169,'权限管理','per_management',NULL,3,NULL),(170,'系统设置','system_setting',NULL,2,NULL),(171,'系统管理','sys_management',NULL,2,NULL),(172,'角色管理','role_management',NULL,2,NULL),(173,'权限管理','per_management',NULL,2,NULL),(174,'用户管理','user_management',NULL,2,NULL);

/*Table structure for table `bi_role` */

DROP TABLE IF EXISTS `bi_role`;

CREATE TABLE `bi_role` (
  `role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_role` */

insert  into `bi_role`(`role_id`,`role_name`) values (1,'用户管理员'),(2,'角色管理员'),(3,'权限管理员'),(4,'超级管理员');

/*Table structure for table `bi_role_permission` */

DROP TABLE IF EXISTS `bi_role_permission`;

CREATE TABLE `bi_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_role_permission` */

insert  into `bi_role_permission`(`id`,`role_id`,`permission_id`) values (1,4,2),(2,4,3),(3,4,4),(4,4,6),(5,4,7),(6,4,8),(7,4,9),(8,4,11),(9,4,12),(10,4,13),(11,4,14),(12,1,1),(13,1,2);

/*Table structure for table `bi_user` */

DROP TABLE IF EXISTS `bi_user`;

CREATE TABLE `bi_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_role_names` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_account` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_telphone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_user` */

insert  into `bi_user`(`user_id`,`user_name`,`user_role_names`,`user_account`,`user_password`,`user_telphone`) values (1,'admin','超级管理员','刘','123456',NULL),(3,'sssss','用户管理员','sss','123456','22222'),(4,'leo','角色管理员','liu','123456',''),(5,'yufang','角色管理员','三生三世','123456','');

/*Table structure for table `bi_user_role` */

DROP TABLE IF EXISTS `bi_user_role`;

CREATE TABLE `bi_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `bi_user_role` */

insert  into `bi_user_role`(`id`,`user_id`,`role_id`) values (1,1,4),(2,2,1),(4,3,1),(5,4,2),(6,5,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
