drop table if exists shops cascade;

drop table if exists products cascade;

create table shops
(
    id      serial not null,
    name    varchar(255),
    address varchar(350),
    deleted boolean,
    primary key (id)
);

create table products
(
    id      serial not null,
    name    varchar(255),
    price   int8,
    deleted boolean,
    shop_id int4,
    primary key (id)
);

alter table products
    add constraint FK_1
        foreign key (shop_id)
            references shops;

insert into shops (name, address, deleted)
VALUES ('Магазин №1', 'г.Кемерово, пр.Ленина 71', false),
       ('Магазин №2', 'г.Кемерово, ул.Весенняя 15', false);

create table usr
(
    id serial,
    username varchar(50) not null unique,
    password varchar(50) not null,
    email varchar(50) unique,
    non_locked boolean not null,
    enabled boolean not null,
    primary key (id)
);

create table user_role (
    "user_id" int4 not null,
    role varchar(40)
);

alter table user_role
    add constraint FK1
        foreign key ("user_id")
            references "user";

insert into usr (username, password, email, non_locked, enabled)
VALUES ('user1', '123456', 'user1@gmail.com', true, true)


-- create table roles
-- (
--     id serial,
--     name varchar(50) not null,
--     primary key (id)
-- );
--
-- create table users_roles
-- (
--     user_id int not null,
--     role_id int not null,
--     primary key (user_id, role_id),
--     foreign key (user_id) references users (id),
--     foreign key (role_id) references roles (id)
-- );

-- insert into roles (name)
-- values ('ROLE_ADMIN'), ('ROLE_MANUFACTURER'), ('ROLE_USER');
--
-- insert into users (username, password, email, locked)
-- values ('user1', '123', 'user1@gmail.com', false);
--
-- insert into users_roles (user_id, role_id)
-- values (1,1);




-- insert into products (name, price, deleted, shop_id) VALUES ('Кока кола', 4550, false, 1)

-- delete from shops where id=8;

-- drop table users cascade;
-- drop table user_role cascade;
--
-- create table users
-- (
--     id       serial       not null,
--     username varchar(50)  not null,
--     password varchar(100) not null,
--     enabled  boolean      not null,
--     primary key (id)
-- );
--
-- insert into users (username, password, enabled)
-- values ('user1', '{noop}123', true),
--        ('user2', '{noop}123', true);
--
--
-- drop table if exists user_role cascade;
-- create table user_role
-- (
--     user_id int4        not null,
--     role    varchar(50) not null
-- );
--
-- alter table user_role
--     add constraint user_role_idx
--         unique (user_id, role);
--
-- alter table user_role
--     add constraint authorities_fk_1
--         foreign key (user_id)
--             references users (id);
--
-- INSERT INTO user_role
-- VALUES (1, 'ADMIN'),
--        (1, 'USER'),
--        (2, 'USER');