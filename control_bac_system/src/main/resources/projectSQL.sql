CREATE TABLE `customer` (
                            `id` int(16) NOT NULL COMMENT '主键id',
                            `customer_id` varchar(64) NOT NULL,
                            `username` varchar(255) NOT NULL COMMENT '用户名',
                            `phone_number` varchar(255) NOT NULL COMMENT '用户手机号',
                            `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
                            `province` varchar(255) NOT NULL COMMENT '省份',
                            `city` varchar(255) NOT NULL COMMENT '城市',
                            `detailed_address` varchar(255) NOT NULL COMMENT '详细地址',
                            `description` varchar(255) DEFAULT NULL COMMENT '简单描述',
                            `update_time` varchar(255) DEFAULT NULL COMMENT '更新时间',
                            `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `districts` (
                             `id` int(16) NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             `province_code` varchar(4) DEFAULT NULL COMMENT '省份编码',
                             `city_code` varchar(4) DEFAULT NULL COMMENT '城市编码',
                             `county_code` varchar(4) DEFAULT NULL COMMENT '区县编码',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3212 DEFAULT CHARSET=utf8

CREATE TABLE `order` (
                         `id` int(16) NOT NULL AUTO_INCREMENT,
                         `customer_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
                         `order_id` int(64) NOT NULL COMMENT '订单编号',
                         `order_status` int(4) NOT NULL COMMENT '1:未付款,2:已付款,3:已发货,4:已签收,5:退货申请,6:退货中,7:已退货,8:取消交易',
                         `product_count` int(4) NOT NULL COMMENT '商品数量',
                         `product_amount_total` decimal(10,2) NOT NULL COMMENT ' 商品总价',
                         `order_amount_total` decimal(10,2) DEFAULT NULL COMMENT '实际付款金额',
                         `logistics_fee` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
                         `pay_time` varchar(255) DEFAULT NULL COMMENT '支付时间',
                         `send_time` varchar(255) DEFAULT NULL COMMENT '发货时间',
                         `order_settlement_time` varchar(255) DEFAULT NULL COMMENT '订单结算时间',
                         `update_time` varchar(255) NOT NULL COMMENT '修改时间',
                         `create_time` varchar(255) NOT NULL COMMENT '创建时间',
                         PRIMARY KEY (`id`,`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `product` (
                           `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                           `parent_id` int(4) NOT NULL DEFAULT '0' COMMENT '产品父id',
                           `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
                           `product_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编码',
                           `description` varchar(15) NOT NULL COMMENT '产品描述',
                           `price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
                           `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建时间',
                           `status` tinyint(4) DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8

CREATE TABLE `role` (
                        `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                        `parent_id` int(16) NOT NULL COMMENT '父角色ID，如果没有父角色，就写0',
                        `role_name` varchar(64) NOT NULL COMMENT '角色名称',
                        `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
                        `createTime` varchar(64) NOT NULL COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE TABLE `role_permission` (
                                   `id` int(16) NOT NULL AUTO_INCREMENT,
                                   `role_id` int(16) NOT NULL,
                                   `permission_id` int(16) NOT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user` (
                        `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                        `username` varchar(255) NOT NULL COMMENT '用户名',
                        `password` varchar(255) NOT NULL COMMENT '密码',
                        `phoneNumber` varchar(15) NOT NULL COMMENT '手机号',
                        `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
                        `updateTime` varchar(64) DEFAULT NULL COMMENT '修改时间',
                        `createTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建时间',
                        `status` tinyint(4) DEFAULT '0' COMMENT '0:启用,1:停用,2:删除',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8

CREATE TABLE `user_role` (
                             `id` int(16) NOT NULL AUTO_INCREMENT,
                             `user_id` int(16) NOT NULL,
                             `role_id` int(16) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

