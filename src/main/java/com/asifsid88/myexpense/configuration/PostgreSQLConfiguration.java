package com.asifsid88.myexpense.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static com.asifsid88.myexpense.configuration.Properties.*;

/**
 * Created by mhussaa on 4/30/17.
 */
@Component
public class PostgreSQLConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(DATABASE_DRIVER.getPropertyName()));
        dataSource.setUrl(environment.getProperty(DATABASE_URL.getPropertyName()));
        dataSource.setUsername(environment.getProperty(DATABASE_USERNAME.getPropertyName()));
        dataSource.setPassword(environment.getProperty(DATABASE_PASSWORD.getPropertyName()));

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
