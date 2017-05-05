package com.asifsid88.myexpense.dal.dao;

import com.asifsid88.myexpense.dal.CustomHibernateDaoSupport;
import com.asifsid88.myexpense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mhussaa on 5/1/17.
 */
@Repository
public class ExpenseDAO extends CustomHibernateDaoSupport {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExpenseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Expense expense){
        getHibernateTemplate().save(expense);
    }

    public void update(Expense expense){
        getHibernateTemplate().update(expense);
    }

    public void delete(Expense expense){
        getHibernateTemplate().delete(expense);
    }

    public Expense findByExpenseId(String expenseId){
        List list = getHibernateTemplate().find(
                "from Expense where expenseId=?",expenseId
        );
        return (Expense)list.get(0);
    }

}
