package com.asifsid88.myexpense.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static com.asifsid88.myexpense.configuration.Properties.*;

/**
 * Created by mhussaa on 5/1/17.
 */
@Component
public class HibernateUtil {

    @Autowired
    private Environment environment;

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();

        //configuration.addAnnotatedClass(org.gradle.Person.class);
        configuration.setProperty("hibernate.connection.driver_class", environment.getProperty(DATABASE_DRIVER.getPropertyName()));
        configuration.setProperty("hibernate.connection.url", environment.getProperty(DATABASE_URL.getPropertyName()));
        configuration.setProperty("hibernate.connection.username", environment.getProperty(DATABASE_USERNAME.getPropertyName()));
        configuration.setProperty("hibernate.connection.password", environment.getProperty(DATABASE_PASSWORD.getPropertyName()));
        configuration.setProperty("hibernate.dialect", environment.getProperty(HIBERNATE_DIALECT.getPropertyName()));
        configuration.setProperty("hibernate.hbm2ddl.auto", environment.getProperty(HIBERNATE_CREATE_MODE.getPropertyName()));
        configuration.setProperty("hibernate.show_sql", environment.getProperty(HIBERNATE_SHOW_SQL.getPropertyName()));
        configuration.setProperty("hibernate.connection.pool_size", environment.getProperty(HIBERNATE_CONNECTION_POOL_SIZE.getPropertyName()));

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }
}
