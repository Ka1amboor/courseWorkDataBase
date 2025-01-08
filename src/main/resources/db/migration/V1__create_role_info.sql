CREATE TABLE role (
                       id BIGINT PRIMARY KEY,
                       name VARCHAR(255)
);
insert into role(id,name) values
                              (1,'ROLE_USER'),
                              (2, 'ROLE_ADMIN');

create sequence role_seq start 3 increment  1;
