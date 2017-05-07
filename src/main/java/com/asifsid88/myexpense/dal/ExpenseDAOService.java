package com.asifsid88.myexpense.dal;

import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mhussaa on 5/1/17.
 */
@Repository
@Transactional
public class ExpenseDAOService {

    private BaseDAOService daoService;

    @Autowired
    public ExpenseDAOService(BaseDAOService daoService) {
        this.daoService = daoService;
    }

    public void save(ExpenseDAO expense){
        daoService.getCurrentSession().save(expense);
    }

    public void update(ExpenseDAO expense){
        daoService.getCurrentSession().update(expense);
    }

    public void delete(ExpenseDAO expense){
        daoService.getCurrentSession().delete(expense);
    }

    public ExpenseDAO findByExpenseId(String expenseId){
        return daoService.getCurrentSession().get(ExpenseDAO.class, Long.parseLong(expenseId));
    }
}
