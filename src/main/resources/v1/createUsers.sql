CREATE TABLE IF NOT EXISTS users (
    id       integer      not null primary key,
    name     varchar(200) not null,
    email    varchar(254) not null,
    phone    varchar(50)  not null,
    password varchar(128) default '{noop}123'::character varying,
    role     varchar(32)
);