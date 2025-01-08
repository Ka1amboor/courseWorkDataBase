CREATE TABLE IF NOT EXISTS user_role (
                                         id BIGINT PRIMARY KEY,
                                         user_id BIGINT,
                                         roles varchar,
                                         FOREIGN KEY (user_id) REFERENCES user_info(id) ON DELETE CASCADE

);