-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '传记');
INSERT INTO `category` VALUES ('2', '小说');
INSERT INTO `category` VALUES ('3', '教科书');
INSERT INTO `category` VALUES ('4', '学术论文');



-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) unsigned NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `category_id` int(11) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`id`)
  KEY `book_type_on_id`(`category_id`),
  CONSTRAINT `book_type_on_id` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'lzh', '帅的定义', '华南理工大学出版社', '学术论文');

-- ----------------------------
-- Table structure for borrowlist
-- ----------------------------
DROP TABLE IF EXISTS `borrowlist`;
CREATE TABLE `borrowlist` (
  `id` int(11) unsigned NOT NULL, 
  `b_id` int(11) unsigned NOT NULL,
  `u_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
  KEY `borrowed_book_on_id`(`b_id`),
  KEY `borrowed_user_on_id`(`u_id`),
  CONSTRAINT `borrowed_book_on_id` FOREIGN KEY (`b_id`) REFERENCES `book`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
  CONSTRAINT `borrowed_user_on_id` FOREIGN KEY (`u_id`) REFERENCES `user`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowlist
-- ----------------------------
INSERT INTO `borrowlist` VALUES ('1', '1', '1');
