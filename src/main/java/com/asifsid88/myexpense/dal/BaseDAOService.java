package com.asifsid88.myexpense.dal;

import com.asifsid88.myexpense.dal.dao.IDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mhussaa on 5/7/17.
 */
@Repository
public class BaseDAOService {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(IDao dao) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(dao);
        session.getTransaction().commit();
    }
}
