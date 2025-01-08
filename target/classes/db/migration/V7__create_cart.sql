CREATE TABLE IF NOT EXISTS cart (
                                         id BIGINT PRIMARY KEY,
                                         user_id BIGINT references user_info(id),
                                        product_id bigint references product_info(id)


    );

create sequence cart_sequence;