create table if not exists product_info(

    id bigint primary key,
    title varchar,
    description text,
    price int,
    supplier varchar,
    date_of_created timestamp,
        preview_image_id BIGINT

);

    create sequence product_info_seq