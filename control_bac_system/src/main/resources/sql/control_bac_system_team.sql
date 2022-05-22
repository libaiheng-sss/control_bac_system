create table team
(
    id        int auto_increment
        primary key,
    team_id   varchar(255) not null,
    team_name varchar(255) not null,
    user_id   int          not null,
    constraint team_id_uindex
        unique (id)
)
    auto_increment = 2;

INSERT INTO control_bac_system.team (id, team_id, team_name, user_id) VALUES (1, '123123', '陈永', 1);
