-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.59 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 spider 的数据库结构
CREATE DATABASE IF NOT EXISTS `spider` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spider`;


-- 导出  表 spider.t_article 结构
CREATE TABLE IF NOT EXISTS `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ref_id` int(11) DEFAULT NULL,
  `source_type` tinyint(4) NOT NULL,
  `title` varchar(256) NOT NULL,
  `article_category` tinyint(4) NOT NULL,
  `post_time` datetime NOT NULL,
  `content_id` int(11) NOT NULL,
  `source_url` varchar(1024) NOT NULL,
  `page_view` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `submit_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_source_type_title` (`source_type`,`title`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 spider.t_article_content 结构
CREATE TABLE IF NOT EXISTS `t_article_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `css` text NOT NULL,
  `content` text NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 spider.t_video 结构
CREATE TABLE IF NOT EXISTS `t_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ref_id` int(11) DEFAULT NULL,
  `source_type` tinyint(4) NOT NULL,
  `title` varchar(256) NOT NULL,
  `cover_img_url` varchar(1024) NOT NULL,
  `video_category` tinyint(4) NOT NULL,
  `post_time` datetime NOT NULL,
  `source_url` varchar(1024) NOT NULL,
  `flashvars` varchar(1024) DEFAULT NULL,
  `content_id` int(11) DEFAULT NULL,
  `video_source` varchar(1024) DEFAULT NULL,
  `video_type` tinyint(4) NOT NULL COMMENT '1:source_url 2:iframe 3:content_html 4:embed',
  `page_view` int(11) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL,
  `submit_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_source_type_title` (`source_type`,`title`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
