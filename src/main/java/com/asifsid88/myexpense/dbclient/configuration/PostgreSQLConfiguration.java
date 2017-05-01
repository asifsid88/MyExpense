package com.asifsid88.myexpense.dbclient.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by mhussaa on 4/30/17.
 */
@Component
@Log4j2
public class PostgreSQLConfiguration {

    @Value("#{systemProperties['jdbc.driver']}")
    private String databaseDriver;

    @Value("#{systemProperties['jdbc.url']}")
    private String databaseUrl;

    @Value("#{systemProperties['jdbc.username']}")
    private String databaseUsername;

    @Value("#{systemProperties['jdbc.password']}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
