package com.asifsid88.myexpense.services;

import com.asifsid88.myexpense.dbclient.dao.ExpenseDAO;
import com.asifsid88.myexpense.model.Expense;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mhussaa on 4/30/17.
 */
@Service
@Log4j2
public class ExpenseService {

    private ExpenseDAO expenseDAO;

    @Autowired
    public ExpenseService(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public Expense getExpenseById(String expenseId) {
        log.info("creating expense:{}", expenseId);
        Expense expense = new Expense();
        expense.setExpenseId(expenseId);

        return expense;
    }
}
