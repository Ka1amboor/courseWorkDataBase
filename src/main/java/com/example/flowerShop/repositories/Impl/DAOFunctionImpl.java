package com.example.flowerShop.repositories.Impl;

import com.example.flowerShop.repositories.DAOFunction;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DAOFunctionImpl implements DAOFunction {

//    private final JdbcTemplate jdbcTemplate;
    private static final String example = "INSERT INTO role (id, name) VALUES (?, ?)";

    @Override
    public int getCountAllFlowers(Long id, String value) {
        //jdbcTemplate.update(example, id, value);
//        jdbcTemplate.execute("insert into user_role (id, user_id, roles) values(1, 1, 'test')");
        return 0;
    }
}
