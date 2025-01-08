CREATE TABLE IF NOT EXISTS user_product (
                                            id BIGINT  PRIMARY KEY,
                                            user_id BIGINT,
                                            product_id BIGINT,
                                            FOREIGN KEY (user_id) REFERENCES user_info(id) ON DELETE CASCADE,
                                            FOREIGN KEY (product_id) REFERENCES product_info(id) ON DELETE CASCADE
);
