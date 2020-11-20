-- ----------------------------
-- Drop statements
-- 注意要根据引用顺序来删表
-- ----------------------------
DROP TABLE IF EXISTS `borrowlist`;
DROP TABLE IF EXISTS `book`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `rolePermission`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `permission`;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
CREATE TABLE `permission` (
  `permissionid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `actualPermissionid` varchar(255) DEFAULT NULL,
  
  PRIMARY KEY (`permissionid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', './sample');



-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `roleid` int(11) unsigned NOT NULL AUTO_INCREMENT,
	`rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1','图书馆管理员');
INSERT INTO `role` VALUES ('2','书籍管理员');
INSERT INTO `role` VALUES ('3','用户管理员');
INSERT INTO `role` VALUES ('4','读者');


-- ----------------------------
-- Table structure for rolePermission
-- ----------------------------
CREATE TABLE `rolePermission` (
  `permissionid` int(11) unsigned NOT NULL,
  `roleid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`roleid`,`permissionid`),
  CONSTRAINT `role_id` FOREIGN KEY (`roleid`) REFERENCES `role`(`roleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permission_ID` FOREIGN KEY (`permissionid`) REFERENCES `permission`(`permissionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolePermission
-- ----------------------------
INSERT INTO `rolePermission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `role_id` int(11) UNSIGNED DEFAULT 4,
  PRIMARY KEY (`id`),
  KEY `user_role_on_id`(`role_id`),
  CONSTRAINT `user_role_on_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`roleid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '123456789', 4);
INSERT INTO `user` VALUES ('2', 'lzh', '123456', '123456789', 3);
INSERT INTO `user` VALUES ('3', 'lcc', '123456', '123456789', 2);
INSERT INTO `user` VALUES ('4', 'lj', '123456', '123456789', 1);
INSERT INTO `user` VALUES ('5', 'ld', '123456', '123456789', 2);
INSERT INTO `user` VALUES ('6', 'xn', '123456', '123456789', 3);
INSERT INTO `user` VALUES ('7', 'wwq', '123456', '123456789', 4);
-- ----------------------------
-- Table structure for category
-- ----------------------------
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
INSERT INTO `category` VALUES ('5', '漫画');
INSERT INTO `category` VALUES ('6', '剧本');



-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `cate_id` int(11) UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_type_on_id`(`cate_id`),
  CONSTRAINT `book_type_on_id` FOREIGN KEY (`cate_id`) REFERENCES `category`(`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'lzh', '帅的定义', '华南理工大学出版社', '4');
INSERT INTO `book` VALUES ('2', 'lzh', 'cxk教你打篮球', '华南理工大学出版社', '1');
INSERT INTO `book` VALUES ('3', '奥尼尔', '如何增重', 'NBA', '2');
INSERT INTO `book` VALUES ('4', 'c罗', '踢球的艺术', 'football', '3');
INSERT INTO `book` VALUES ('5', 'lj', '如何泡妞', '青春文学', '5');
INSERT INTO `book` VALUES ('6', 'haha', '冲冲冲', '全村的希望', '6');

-- ----------------------------
-- Table structure for borrowlist
-- ----------------------------
CREATE TABLE `borrowlist` (
  `b_id` int(11) unsigned NOT NULL,
  `u_id` int(11) unsigned NOT NULL,
  `date` varchar(255) NOT NULL,
  `havereturn` boolean DEFAULT FALSE,
  PRIMARY KEY (`b_id`, `u_id`, `date`),
  Key `borrowed_book_on_id`(`b_id`),
  KEY `borrowed_user_on_id`(`u_id`),
  CONSTRAINT `borrowed_book_on_id` FOREIGN KEY (`b_id`) REFERENCES `book`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrowed_user_on_id` FOREIGN KEY (`u_id`) REFERENCES `user`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowlist
-- ----------------------------
INSERT INTO `borrowlist` VALUES ('1', '1', '2020.11.15', '0');
INSERT INTO `borrowlist` VALUES ('1', '3', '2020.11.15', '1');
INSERT INTO `borrowlist` VALUES ('1', '2', '2020.11.16', '0');
INSERT INTO `borrowlist` VALUES ('2', '1', '2020.11.17', '1');
INSERT INTO `borrowlist` VALUES ('2', '2', '2020.11.16', '1');
INSERT INTO `borrowlist` VALUES ('3', '1', '2020.11.18', '1');
INSERT INTO `borrowlist` VALUES ('2', '3', '2020.11.19', '0');
INSERT INTO `borrowlist` VALUES ('3', '2', '2020.11.13', '0');

