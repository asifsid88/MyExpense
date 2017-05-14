package com.asifsid88.myexpense.dal;

import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mhussaa on 5/1/17.
 */
@Repository
@Transactional
@Log4j2
public class ExpenseDAOService {

    private BaseDAOService daoService;

    @Autowired
    public ExpenseDAOService(BaseDAOService daoService) {
        this.daoService = daoService;
    }

    public ExpenseDAO save(ExpenseDAO expense) {
        ExpenseDAO createdExpense = null;
        try {
            final String expenseId = String.valueOf(daoService.getCurrentSession().save(expense));
            if(expenseId != null) {
                createdExpense = findByExpenseId(expenseId);
            }
        } catch(Exception e) {
            log.error("Exception while saving Expense:{}. Exception:{}", expense, e);
        }

        return createdExpense;
    }

    public boolean update(ExpenseDAO expense) {
        boolean success = Boolean.FALSE;
        try {
            daoService.getCurrentSession().update(expense);
            success = Boolean.TRUE;
        } catch(Exception e) {
            log.error("Exception while updating Expense:{}. Exception:{}", expense, e);
        }

        return success;
    }

    public boolean delete(ExpenseDAO expense) {
        boolean success = Boolean.FALSE;
        try {
            daoService.getCurrentSession().delete(expense);
            success = Boolean.TRUE;
        } catch(Exception e) {
            log.error("Exception while deleting Expense:{}. Exception:{}", expense, e);
        }

        return success;
    }

    public ExpenseDAO findByExpenseId(String expenseId) {
        ExpenseDAO expenseDAO = null;
        try {
            expenseDAO = daoService.getCurrentSession().get(ExpenseDAO.class, Long.parseLong(expenseId));
        } catch(Exception e) {
            log.error("Exception while finding ExpenseById:{}. Exception:{}", expenseId, e);
        }

        return expenseDAO;
    }
}
