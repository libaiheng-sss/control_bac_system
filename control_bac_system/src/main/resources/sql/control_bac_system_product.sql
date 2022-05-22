create table product
(
    id           int auto_increment comment '主键ID'
        primary key,
    parent_id    int     default 0 not null comment '产品父id',
    product_name varchar(255)      not null comment '产品名称',
    product_code varchar(255)      not null comment '产品编码',
    description  varchar(15)       not null comment '产品描述',
    price        decimal(10, 2)    null comment '产品价格',
    create_time  varchar(64)       not null comment '创建时间',
    status       tinyint default 0 null
)
    auto_increment = 22;

INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (2, 0, '哈哈哈', '76a2bf882d9d4e4d8e166d31015e544d', '啊哈哈哈', null, '1652341077107', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (3, 0, '哈哈哈', '23aa5c67b9c9411baf71adbe0dfd688d', '啊哈哈哈', null, '1652341093553', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (4, 0, '哈哈哈', 'c71e60b44c1e4e6f92c83f72dc137088', '啊哈哈哈', null, '1652341096411', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (5, 0, '哈哈哈', '2db472b92c9043afa82dd058306cb6e2', '啊哈哈哈', null, '1652341099089', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (7, 0, '哈哈哈', 'eea6c74413ed470d9612ebb85879356d', '啊哈哈哈', null, '1652341104244', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (8, 0, '哈哈哈', 'fc4e3a40fb2042e59e6bac34801355a9', '啊哈哈哈', null, '1652341106746', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (9, 0, '哈哈哈', '1b7be1089eaa4f35b754de236718b194', '啊哈哈哈', null, '1652341109776', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (10, 0, '哈哈哈', 'c49ec90287dc41c089927341b0d8c241', '啊哈哈哈', null, '1652341112913', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (11, 0, '哈哈哈', 'ec2fe764d67a44f2a45c585e2fa7c2c8', '啊哈哈哈', null, '1652341116683', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (13, 0, '', '72e3975cc0ec4fe6851d9125a61c7fa6', '', null, '1652363511951', 0);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (14, 2, 'dasas', 'asdasdasda', 'asdad', 12.00, '1651313213320', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (15, 2, 'asdg', 'asdfsdf', 'sdfsfd', 13.00, '1651313213320', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (16, 3, 'sdfds', 'fasdf', 'asdf', 19.00, '1651313213320', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (17, 14, 'sdf', 'asdf', 'asdf', 90.00, '1651313213320', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (18, 13, '', '245630a3bec9418fb2c1c6f6da2fba35', '', null, '1652452742767', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (19, 11, '嘻嘻嘻', '5fe46485d8ff448abec28d45718aba19', '测试', null, '1652453108402', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (20, 19, '嘻嘻', '1d592189bab04663be2cb0fbe8eebfe8', '测试22', 1.60, '1652454697119', 1);
INSERT INTO control_bac_system.product (id, parent_id, product_name, product_code, description, price, create_time, status) VALUES (21, 7, '胜多负少', 'f2c7f91eb0bd47ba9d51e8dbb2071fbf', '水电费水电费第三方', 234.00, '1652457204823', 1);
