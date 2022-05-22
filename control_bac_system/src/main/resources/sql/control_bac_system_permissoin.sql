create table permissoin
(
    id               int auto_increment
        primary key,
    permission_name  varchar(255) not null,
    permission_value varchar(255) not null,
    permission_code  varchar(255) null,
    parent_id        int          null
);

INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (1, '个人客户列表', '/customer/personal', 'customerPersonal', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (2, '团队客户列表', '/customer/team', 'customerTeam', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (3, '所有客户列表', '/customer/all', 'customerAll', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (4, '个人线上订单', '/order/personal', 'orderPersonal', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (5, '团队线上订单', '/order/team', 'orderTeam', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (6, '所有线上订单', '/order/all', 'orderAll', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (7, '添加线上订单', '/order/addOrderAndCustomer', 'orderAddOrderAndCustomer', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (8, '用户列表', '/user/userList', 'userUserList', 1);
INSERT INTO control_bac_system.permissoin (id, permission_name, permission_value, permission_code, parent_id) VALUES (9, '权限列表', '/user/rule', 'userRule', 1);
