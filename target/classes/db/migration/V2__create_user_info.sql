Create table  if not exists user_info(
       id bigint primary key,
       active boolean,
       date_of_created timestamp,
       password varchar,
       email varchar,
       name varchar,
       number_phone varchar,
       surname varchar,
       role_id  bigint references  role(id)
);

       create sequence user_info_seq;
