create table user
(
    id          int auto_increment comment '主键ID'
        primary key,
    username    varchar(255)      not null comment '用户名',
    password    varchar(255)      not null comment '密码',
    phoneNumber varchar(15)       not null comment '手机号',
    email       varchar(64)       not null comment '邮箱',
    updateTime  varchar(64)       null comment '修改时间',
    createTime  varchar(64)       not null comment '创建时间',
    status      tinyint default 0 null comment '0:启用,1:停用,2:删除'
)
    auto_increment = 15;

INSERT INTO control_bac_system.user (id, username, password, phoneNumber, email, updateTime, createTime, status) VALUES (1, 'admin', '$2a$10$.fs0/5f0ctpjVm2R0T06GendDxSZObjFaaEycwsqCuprv7Y5Wevva', '15213317526', '1397183579@qq.com', '0', '0', 0);
INSERT INTO control_bac_system.user (id, username, password, phoneNumber, email, updateTime, createTime, status) VALUES (15, '黎佰恒', '$2a$10$g6TulJjb0vEe6N3ICSDGBekjn3jLAcH4pWb31aSgxrW/siTzOF/Am', '15213317526', '1397183579@qq.com', '1653196340771', '1653196340771', 0);
