package com.asifsid88.myexpense.configuration;

/**
 * Created by mhussaa on 5/5/17.
 */
/*
public enum Properties {
    DATABASE_DRIVER = "jdbc.driver";
    DATABASE_URL = "jdbc.url";
    DATABASE_USERNAME = "jdbc.username";
    DATABASE_PASSWORD = "jdbc.password";

    HIBERNATE_DIALECT = "hibernate.dialect";
    HIBERNATE_CREATE_MODE = "hibernate.hbm2ddl.auto";
    HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    HIBERNATE_CONNECTION_POOL_SIZE = "hibernate.connection.pool_size";
    HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS = "thread");

    private String propertyName;

    Properties = String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName = ) {
        return this.propertyName;
    }
}
*/

public interface Properties {
    String DATABASE_DRIVER = "jdbc.driver";
    String DATABASE_URL = "jdbc.url";
    String DATABASE_USERNAME = "jdbc.username";
    String DATABASE_PASSWORD = "jdbc.password";

    String HIBERNATE_DAO_PACKAGE_ROOT = "com.asifsid88.myexpense.dal.dao";
    String HIBERNATE_CONNECTION_DRIVER = "hibernate.connection.driver_class";
    String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
    String HIBERNATE_CONNECTION_USERNAME = "hibernate.connection.username";
    String HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";
    String HIBERNATE_DIALECT = "hibernate.dialect";
    String HIBERNATE_CREATE_MODE = "hibernate.hbm2ddl.auto";
    String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    String HIBERNATE_CONNECTION_POOL_SIZE = "hibernate.connection.pool_size";
    String HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS = "hibernate.current_session_context_class";

}