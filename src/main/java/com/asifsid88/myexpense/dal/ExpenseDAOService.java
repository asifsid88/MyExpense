package com.asifsid88.myexpense.dal;

import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public ExpenseDAO save(final ExpenseDAO expense) {
        ExpenseDAO createdExpense = null;
        try {
            expense.setExpenseCreationDate(getCurrentTime());
            final String expenseId = String.valueOf(daoService.getCurrentSession().save(expense));
            if(expenseId != null) {
                createdExpense = findByExpenseId(expenseId);
            }
        } catch(Exception e) {
            log.error("Exception while saving Expense:{}. Exception:{}", expense, e);
        }

        return createdExpense;
    }

    public ExpenseDAO update(final ExpenseDAO expense) {
        ExpenseDAO updatedExpense = null;
        try {
            ExpenseDAO currentExpense = findByExpenseId(String.valueOf(expense.getExpenseId()));
            updatedExpense = mergeExpense(currentExpense, expense);
            log.debug("Updated Expense: {}", updatedExpense);
            daoService.getCurrentSession().update(currentExpense);
        } catch(Exception e) {
            log.error("Exception while updating Expense:{}. Exception:{}", expense, e);
        }

        return updatedExpense;
    }

    public boolean delete(final ExpenseDAO expense) {
        boolean success = Boolean.FALSE;
        try {
            daoService.getCurrentSession().delete(expense);
            success = Boolean.TRUE;
        } catch(Exception e) {
            log.error("Exception while deleting Expense:{}. Exception:{}", expense, e);
        }

        return success;
    }

    public ExpenseDAO findByExpenseId(final String expenseId) {
        ExpenseDAO expenseDAO = null;
        try {
            expenseDAO = daoService.getCurrentSession().get(ExpenseDAO.class, Long.parseLong(expenseId));
        } catch(Exception e) {
            log.error("Exception while finding ExpenseById:{}. Exception:{}", expenseId, e);
        }

        return expenseDAO;
    }

    private ExpenseDAO mergeExpense(final ExpenseDAO oldExpense, final ExpenseDAO newExpense) {
        final ExpenseDAO mergeExpense = new ExpenseDAO();
        mergeExpense.setExpenseId(newExpense.getExpenseId());

        if(newExpense.getAmount() != null) {
            mergeExpense.setAmount(newExpense.getAmount());
        } else {
            mergeExpense.setAmount(oldExpense.getAmount());
        }

        if(newExpense.getComment() != null) {
            mergeExpense.setComment(newExpense.getComment());
        } else {
            mergeExpense.setComment(oldExpense.getComment());
        }

        if(newExpense.getDescription() != null) {
            mergeExpense.setDescription(newExpense.getDescription());
        } else {
            mergeExpense.setDescription(oldExpense.getDescription());
        }

        if(newExpense.getDateOfExpense() != null) {
            mergeExpense.setDateOfExpense(newExpense.getDateOfExpense());
        } else {
            mergeExpense.setDateOfExpense(oldExpense.getDateOfExpense());
        }

        if(newExpense.getExpenseType() != null) {
            mergeExpense.setExpenseType(newExpense.getExpenseType());
        } else {
            mergeExpense.setExpenseType(oldExpense.getExpenseType());
        }

        mergeExpense.setExpenseModifiedDate(getCurrentTime());
        mergeExpense.setExpenseCreationDate(oldExpense.getExpenseCreationDate());
        mergeExpense.setUserId(oldExpense.getUserId());

        return mergeExpense;
    }

    private String getCurrentTime() {
        final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(calendar.getTime());
    }
}
