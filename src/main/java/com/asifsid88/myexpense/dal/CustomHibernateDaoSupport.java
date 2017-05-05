package com.asifsid88.myexpense.dal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by mhussaa on 5/1/17.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
    @Autowired
    public void setSessionFactry(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
