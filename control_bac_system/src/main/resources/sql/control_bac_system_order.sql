create table `order`
(
    id                    int auto_increment,
    order_id              varchar(64)    not null comment '订单编号',
    customer_id           varchar(64)    not null comment '用户id',
    user_id               int            null,
    product_id            int default 0  not null,
    price                 decimal        not null,
    product_count         int            not null comment '商品数量',
    product_amount_total  decimal(10, 2) not null comment ' 商品总价',
    logistics_fee         decimal(10, 2) null comment '运费金额',
    order_amount_total    decimal(10, 2) null comment '实际付款金额',
    order_status          int            not null comment '1:未付款,2:已付款,3:已发货,4:已退货,5:完结',
    `desc`                varchar(255)   null comment '备注',
    pay_time              varchar(255)   null comment '支付时间',
    send_time             varchar(255)   null comment '发货时间',
    order_settlement_time varchar(255)   null comment '订单结算时间',
    update_time           varchar(255)   not null comment '修改时间',
    create_time           varchar(255)   not null comment '创建时间',
    primary key (id, customer_id)
)
    auto_increment = 5;

INSERT INTO control_bac_system.`order` (id, order_id, customer_id, user_id, product_id, price, product_count, product_amount_total, logistics_fee, order_amount_total, order_status, `desc`, pay_time, send_time, order_settlement_time, update_time, create_time) VALUES (1, 'f83f3dd1edf545679c5462ab70831e48', '17c804f6e6374780b4d29fb050d77719', 1, 14, 12, 1, 12.00, 8.00, 20.00, 1, 'Column count doesn''t match value count at row 1', null, null, null, '1653190795453', '1653190795453');
INSERT INTO control_bac_system.`order` (id, order_id, customer_id, user_id, product_id, price, product_count, product_amount_total, logistics_fee, order_amount_total, order_status, `desc`, pay_time, send_time, order_settlement_time, update_time, create_time) VALUES (2, '21f87e98d742486e950acec9f0ba20f0', 'ce9d358f27d747429696d691f41d43e7', 1, 17, 90, 2, 180.00, 8.00, 188.00, 2, '这是个大订单', null, null, null, '1653193073683', '1653193073683');
INSERT INTO control_bac_system.`order` (id, order_id, customer_id, user_id, product_id, price, product_count, product_amount_total, logistics_fee, order_amount_total, order_status, `desc`, pay_time, send_time, order_settlement_time, update_time, create_time) VALUES (3, '78c9736e06204457b1e360cd23ec8f72', '1e688d17b5ae46d6a29efac6aaf2489f', 15, 14, 12, 1, 12.00, 8.00, 20.00, 0, '嘻嘻嘻嘻嘻', null, null, null, '1653205774280', '1653205774280');
