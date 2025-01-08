Create table  if not exists image_info(
                                         id bigint primary key,
                                         original_file_name varchar,
                                         size bigint,
                                         content_type varchar,
                                         is_preview_image boolean,
                                         image oid,
    product_id bigint,
                                         FOREIGN KEY (product_id) REFERENCES product_info(id)

);

create sequence image_info_seq;
