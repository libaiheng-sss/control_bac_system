create table role_permission
(
    id            int auto_increment
        primary key,
    role_id       int not null,
    permission_id int not null
);

INSERT INTO control_bac_system.role_permission (id, role_id, permission_id) VALUES (1, 2, 1);
INSERT INTO control_bac_system.role_permission (id, role_id, permission_id) VALUES (2, 2, 2);
INSERT INTO control_bac_system.role_permission (id, role_id, permission_id) VALUES (3, 2, 3);
