create table customer
(
    id               int auto_increment comment '主键id'
        primary key,
    customer_id      varchar(255)  not null,
    username         varchar(255)  not null comment '用户名',
    gender           int           null comment '0：男  1：女',
    phone_number     varchar(255)  not null comment '用户手机号',
    email            varchar(255)  null comment '用户邮箱',
    province         varchar(255)  not null comment '省份',
    city             varchar(255)  not null comment '城市',
    district         varchar(255)  null,
    detailed_address varchar(255)  not null comment '详细地址',
    description      varchar(255)  null comment '简单描述',
    user_id          int default 0 not null,
    update_time      varchar(255)  null comment '更新时间',
    create_time      varchar(255)  null comment '创建时间',
    status           int default 1 not null
)
    auto_increment = 7;

INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (2, 'ce9d358f27d747429696d691f41d43e7', '史蒂夫', 1, '15213317526', '1397183579@qq.com', '35', '03', '04', '哈哈哈哈哈详细地址', '哈哈哈哈哈备注', 1, '1653142646084', '1652975730462', 0);
INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (3, 'e1011c512e584685a4829d7be90dcc61', '是是是', 0, '12222222222', '12222222222@qq.com', '50', '02', '38', 'sdfsdfsdfdsf', 'asdfsadfadsfds', 1, '1653142820947', '1653064210572', 1);
INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (4, '7c29107c6ba44ee88412a2da58cfad38', '胜多负少', 0, '12222222222', '12222222222@qq.com', '12', '01', '03', 'sdfsdfsdfdsf', 'asdfsadfadsfds', 1, '1653142624144', '1653064244308', 1);
INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (5, 'e0409ac4636a4550845dfba1a830909f', '斯蒂芬第三方', 0, '15213317529', '15213317529@qq.com', '12', '01', '03', '是的发送到发打扫', '阿斯顿发的说法味儿', 1, '1653143622290', '1653142412150', 1);
INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (6, '17c804f6e6374780b4d29fb050d77719', '黎佰恒', 1, '15213317525', '1397183579@qq.com', '50', '01', '11', '是的是的第三方代表', '', 1, '1653143588617', '1653143578116', 1);
INSERT INTO control_bac_system.customer (id, customer_id, username, gender, phone_number, email, province, city, district, detailed_address, description, user_id, update_time, create_time, status) VALUES (7, '1e688d17b5ae46d6a29efac6aaf2489f', '王小梅', 0, '15826089416', '1434346375@qq.com', '50', '01', '11', '嘻嘻嘻嘻', '嘻嘻嘻嘻', 15, '1653205745111', '1653205745111', 1);
