package com.asifsid88.myexpense.services;

import com.asifsid88.myexpense.dal.ExpenseDAOService;
import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import com.asifsid88.myexpense.mapper.ExpenseModelDaoMapper;
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

    private ExpenseDAOService expenseDAOService;
    private ExpenseModelDaoMapper expenseModelDaoMapper;

    @Autowired
    public ExpenseService(ExpenseDAOService expenseDAOService, ExpenseModelDaoMapper expenseModelDaoMapper) {
        this.expenseDAOService = expenseDAOService;
        this.expenseModelDaoMapper = expenseModelDaoMapper;
    }

    public String createExpense(Expense expense) {
        ExpenseDAO expenseDAO = expenseModelDaoMapper.toDao(expense);
        expenseDAOService.save(expenseDAO);

        return "123";
    }

    public Expense getExpenseById(String expenseId) {
        ExpenseDAO expenseDAO = expenseDAOService.findByExpenseId(expenseId);
        return expenseModelDaoMapper.toModel(expenseDAO);
    }
}
