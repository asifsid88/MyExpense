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
        sessionFactory.setPackagesToScan("com.asifsid88.myexpense.dal.dao");

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

    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.connection.driver_class", environment.getProperty(DATABASE_DRIVER.getPropertyName()));
                setProperty("hibernate.connection.url", environment.getProperty(DATABASE_URL.getPropertyName()));
                setProperty("hibernate.connection.username", environment.getProperty(DATABASE_USERNAME.getPropertyName()));
                setProperty("hibernate.connection.password", environment.getProperty(DATABASE_PASSWORD.getPropertyName()));
                setProperty("hibernate.dialect", environment.getProperty(HIBERNATE_DIALECT.getPropertyName()));
                setProperty("hibernate.hbm2ddl.auto", environment.getProperty(HIBERNATE_CREATE_MODE.getPropertyName()));
                setProperty("hibernate.show_sql", environment.getProperty(HIBERNATE_SHOW_SQL.getPropertyName()));
                setProperty("hibernate.connection.pool_size", environment.getProperty(HIBERNATE_CONNECTION_POOL_SIZE.getPropertyName()));
                //setProperty("hibernate.current_session_context_class", environment.getProperty(HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS.getPropertyName()));
            }
        };
    }
}
