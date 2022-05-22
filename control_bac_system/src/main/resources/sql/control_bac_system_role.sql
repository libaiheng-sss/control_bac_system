create table role
(
    id          int auto_increment comment '主键ID'
        primary key,
    parent_id   int          not null comment '父角色ID，如果没有父角色，就写0',
    role_name   varchar(64)  not null comment '角色名称',
    description varchar(255) null comment '角色描述',
    createTime  varchar(64)  not null comment '创建时间'
)
    auto_increment = 3;

INSERT INTO control_bac_system.role (id, parent_id, role_name, description, createTime) VALUES (1, 0, 'admin', '超级管理员', '0');
INSERT INTO control_bac_system.role (id, parent_id, role_name, description, createTime) VALUES (2, 0, '黎佰恒', '测试权限1', '0');
