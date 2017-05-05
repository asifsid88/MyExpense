package com.asifsid88.myexpense.configuration;

/**
 * Created by mhussaa on 5/5/17.
 */
public enum Properties {
    DATABASE_DRIVER("jdbc.driver"),
    DATABASE_URL("jdbc.url"),
    DATABASE_USERNAME("jdbc.username"),
    DATABASE_PASSWORD("jdbc.password"),

    HIBERNATE_DIALECT("hibernate.dialect"),
    HIBERNATE_CREATE_MODE("hibernate.hbm2ddl.auto"),
    HIBERNATE_SHOW_SQL("hibernate.show_sql"),
    HIBERNATE_CONNECTION_POOL_SIZE("hibernate.connection.pool_size");

    private String propertyName;

    Properties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return this.propertyName;
    }
}
