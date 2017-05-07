package com.asifsid88.myexpense.configuration;

import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

import static com.asifsid88.myexpense.configuration.Properties.*;

/**
 * Created by mhussaa on 5/1/17.
 */
@Component
@Log4j2
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setPackagesToScan(HIBERNATE_DAO_PACKAGE_ROOT);

        return sessionFactory;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(DATABASE_DRIVER));
        dataSource.setUrl(environment.getProperty(DATABASE_URL));
        dataSource.setUsername(environment.getProperty(DATABASE_USERNAME));
        dataSource.setPassword(environment.getProperty(DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty(HIBERNATE_CONNECTION_DRIVER, environment.getProperty(DATABASE_DRIVER));
                setProperty(HIBERNATE_CONNECTION_URL, environment.getProperty(DATABASE_URL));
                setProperty(HIBERNATE_CONNECTION_USERNAME, environment.getProperty(DATABASE_USERNAME));
                setProperty(HIBERNATE_CONNECTION_PASSWORD, environment.getProperty(DATABASE_PASSWORD));
                setProperty(HIBERNATE_DIALECT, environment.getProperty(HIBERNATE_DIALECT));
                setProperty(HIBERNATE_CREATE_MODE, environment.getProperty(HIBERNATE_CREATE_MODE));
                setProperty(HIBERNATE_SHOW_SQL, environment.getProperty(HIBERNATE_SHOW_SQL));
                setProperty(HIBERNATE_CONNECTION_POOL_SIZE, environment.getProperty(HIBERNATE_CONNECTION_POOL_SIZE));
            }
        };
    }
}
