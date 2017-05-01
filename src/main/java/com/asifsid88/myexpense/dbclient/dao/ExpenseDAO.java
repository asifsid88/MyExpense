package com.asifsid88.myexpense.dbclient.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by mhussaa on 5/1/17.
 */
@Repository
public class ExpenseDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExpenseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
