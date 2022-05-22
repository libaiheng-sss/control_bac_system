create table user_role
(
    id      int auto_increment
        primary key,
    user_id int not null,
    role_id int not null
)
    auto_increment = 3;

INSERT INTO control_bac_system.user_role (id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO control_bac_system.user_role (id, user_id, role_id) VALUES (2, 15, 2);
