/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : cookieshop

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 02/02/2023 17:12:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品表主键',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `cover` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品封面图',
  `image1` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情图1',
  `image2` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情图2',
  `price` float NULL DEFAULT NULL COMMENT '商品价格',
  `intro` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `stock` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_type_id_idx`(`type_id`) USING BTREE,
  CONSTRAINT `fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 181 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (9, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (10, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 3);
INSERT INTO `goods` VALUES (11, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 3);
INSERT INTO `goods` VALUES (12, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (13, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (14, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (15, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (16, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (18, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (19, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 4);
INSERT INTO `goods` VALUES (20, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 4);
INSERT INTO `goods` VALUES (21, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (23, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (24, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (25, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (26, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (27, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (28, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (29, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (30, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (31, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (32, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (33, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (34, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (35, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (36, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (37, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (38, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (39, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 5);
INSERT INTO `goods` VALUES (40, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 5);
INSERT INTO `goods` VALUES (41, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (42, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 8);
INSERT INTO `goods` VALUES (43, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (44, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (45, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 11);
INSERT INTO `goods` VALUES (46, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (47, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 8);
INSERT INTO `goods` VALUES (48, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (49, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 8);
INSERT INTO `goods` VALUES (50, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (51, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (52, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (53, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 11);
INSERT INTO `goods` VALUES (54, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (55, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (56, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (57, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (58, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (59, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (60, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (61, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (62, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (63, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (64, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (65, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (66, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (67, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (68, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (69, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (70, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (71, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (72, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (73, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (74, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (75, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (76, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (77, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (78, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (79, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (80, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (81, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (82, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (83, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (84, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (85, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (86, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (87, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (88, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (89, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (90, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (91, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (92, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (93, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (94, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (95, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (97, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (98, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (99, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (100, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (101, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (102, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (103, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (104, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (105, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (106, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (108, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (109, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (110, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (111, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (112, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (113, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (114, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (115, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (116, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (117, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (118, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (119, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (120, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (121, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (122, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (123, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (124, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (125, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (126, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (127, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (128, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (129, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (130, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (131, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (132, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (133, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (134, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (135, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (136, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (137, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (138, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (139, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (140, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (141, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (142, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (143, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (144, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (145, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (146, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (147, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (148, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (149, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (150, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (151, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (152, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (153, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (154, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (155, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (156, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (157, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (158, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (159, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (160, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (161, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (162, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (163, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (164, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (165, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (166, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (167, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (168, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (169, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (170, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (171, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);
INSERT INTO `goods` VALUES (172, '蜂蜜蛋糕', '/picture/13-1.jpg', '/picture/13-1.jpg', '/picture/13-1.jpg', 36, '蛋黄与蜂蜜,淡奶油共同演绎的曼妙之旅.口感Q糯浓郁,回味绵软柔长.皱巴巴的造型,甜蜜蜜的感受.', 10, 2);
INSERT INTO `goods` VALUES (173, '意大利芝士饼干', '/picture/14-1.jpg', '/picture/14-1.jpg', '/picture/14-1.jpg', 39, '采用帕玛森芝士为主要原材料制作的意大利芝士饼,奶香浓郁,鲜香可口.', 10, 2);
INSERT INTO `goods` VALUES (174, '小熊乐园', '/picture/8-1.jpg', '/picture/8-2.jpg', '/picture/8-3.jpg', 299, '走进小熊乐园,与可爱的小熊一起准备过冬的食物吧,摘颗草莓藏放在巧克力做的房子里,好朋友一起分享劳动的果实.\r\n主口味:草莓奶油味 主要原料:乳脂奶油,纯巧克力,朗姆酒,幼砂糖,鲜草莓 甜度:二星（满五星） 最佳食用温度：5-7摄氏度', 10, 3);
INSERT INTO `goods` VALUES (175, '草莓冰淇淋', '/picture/9-1.jpg', '/picture/9-2.jpg', '/picture/9-3.jpg', 299, '甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.\r\n主口味:草莓口味 主要原料:草莓果溶 草莓  甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度', 10, 1);
INSERT INTO `goods` VALUES (176, '玫瑰舒芙蕾', '/picture/10-1.jpg', '/picture/10-2.jpg', '/picture/10-3.jpg', 28, '优选法国芝士,奶香浓郁,质地柔滑,口感细腻.法国芝士有助于提升糕点的整体口感,完美平衡酸度与甜味,制作出的糕点更加洁白纯美.', 10, 2);
INSERT INTO `goods` VALUES (177, '半熟芝士', '/picture/11-1.jpg', '/picture/11-1.jpg', '/picture/11-1.jpg', 38, '为了保证芝士的香醇,半熟芝士借鉴日本温泉煮鸡蛋的做法,把芝士,牛奶,鸡蛋,天然奶油,砂糖,小麦粉拌成面糊,通过水浴蒸烤,保证芝士蛋糕细嫩,柔软,留住芝士的香醇细滑.', 10, 2);
INSERT INTO `goods` VALUES (178, '青森芝士条', '/picture/12-1.jpg', '/picture/1-2.jpg', '/picture/12-1.jpg', 36, '青森芝士和风轻拂,,奶香浓郁,质地柔滑,口感细腻.', 10, 2);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表主键',
  `total` float NULL DEFAULT NULL COMMENT '商品总额',
  `amount` int(6) NULL DEFAULT NULL COMMENT '商品数量',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '支付状态',
  `paytype` tinyint(1) NULL DEFAULT NULL COMMENT '支付方式',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `datetime` datetime(0) NULL DEFAULT NULL COMMENT '订单日期',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_id_idx`(`user_id`) USING BTREE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (75, 28, 1, 4, 2, '管理员', '1333333333', '中华人民共和国', '2019-10-07 12:31:07', 1);
INSERT INTO `order` VALUES (76, 10465, 35, 3, 1, '管理员', '1333333333', '中华人民共和国', '2023-01-29 08:19:44', 1);
INSERT INTO `order` VALUES (77, 299, 1, 2, 2, '管理员', '1333333333', '中华人民共和国', '2023-01-30 06:53:31', 1);
INSERT INTO `order` VALUES (78, 337, 2, 2, 1, '管理员', '1333333333', '中华人民共和国', '2023-01-30 07:11:35', 1);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项表主键',
  `price` float NULL DEFAULT NULL COMMENT '商品价格',
  `amount` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order_id_idx`(`order_id`) USING BTREE,
  INDEX `fk_orderitem_goods_id_idx`(`goods_id`) USING BTREE,
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orderitem_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (78, 28, 1, 10, 75);

-- ----------------------------
-- Table structure for recommend
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '推荐栏表主键',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '商品类别',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_goods_id_idx`(`goods_id`) USING BTREE,
  CONSTRAINT `fk_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES (9, 2, 9);
INSERT INTO `recommend` VALUES (10, 3, 10);
INSERT INTO `recommend` VALUES (11, 3, 12);
INSERT INTO `recommend` VALUES (12, 3, 13);
INSERT INTO `recommend` VALUES (13, 3, 14);
INSERT INTO `recommend` VALUES (14, 3, 15);
INSERT INTO `recommend` VALUES (15, 3, 16);
INSERT INTO `recommend` VALUES (17, 3, 18);
INSERT INTO `recommend` VALUES (18, 3, 19);
INSERT INTO `recommend` VALUES (29, 1, 42);
INSERT INTO `recommend` VALUES (33, 2, 10);
INSERT INTO `recommend` VALUES (34, 2, 11);
INSERT INTO `recommend` VALUES (35, 2, 12);
INSERT INTO `recommend` VALUES (36, 2, 13);
INSERT INTO `recommend` VALUES (37, 2, 14);
INSERT INTO `recommend` VALUES (38, 2, 15);
INSERT INTO `recommend` VALUES (39, 2, 16);
INSERT INTO `recommend` VALUES (40, 2, 18);
INSERT INTO `recommend` VALUES (41, 2, 26);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类别表主键',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '冰淇淋系列');
INSERT INTO `type` VALUES (2, '零食系列');
INSERT INTO `type` VALUES (3, '儿童系列');
INSERT INTO `type` VALUES (4, '法式系列');
INSERT INTO `type` VALUES (5, '经典系列');
INSERT INTO `type` VALUES (8, '节日系列');
INSERT INTO `type` VALUES (11, '买不起系列');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `isadmin` bit(1) NULL DEFAULT NULL COMMENT '是否为管理员',
  `isvalidate` bit(1) NULL DEFAULT NULL COMMENT '账户是否有效',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_UNIQUE`(`username`) USING BTREE,
  UNIQUE INDEX `email_UNIQUE`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin@vilicode.com', 'admin', '管理员', '1333333333', '中华人民共和国', b'1', b'0');
INSERT INTO `user` VALUES (2, 'vili', 'vili@vilicode.com', 'vili', 'vili', '1344444444', '中华人民共和国', b'0', b'0');

SET FOREIGN_KEY_CHECKS = 1;
