package com.asifsid88.myexpense.mapper;

import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import com.asifsid88.myexpense.model.Expense;
import org.springframework.stereotype.Component;

/**
 * Created by mhussaa on 5/5/17.
 */
@Component
public class ExpenseModelDaoMapper implements ModelDaoMapper<ExpenseDAO, Expense> {
    public ExpenseDAO toDao(Expense model) {
        if(model == null) return null;

        ExpenseDAO dao = new ExpenseDAO();
        dao.setExpenseId(model.getExpenseId());
        dao.setExpenseType(model.getExpenseType());
        dao.setAmount(model.getAmount());
        dao.setDescription(model.getDescription());
        dao.setComment(model.getComment());
        dao.setDateOfExpense(model.getDateOfExpense());
        dao.setExpenseCreationDate(model.getExpenseCreationDate());
        dao.setExpenseModifiedDate(model.getExpenseModifiedDate());
        dao.setUserId(model.getUserId());

        return dao;
    }

    public Expense toModel(ExpenseDAO dao) {
        if(dao == null) return null;

        Expense model = new Expense();
        model.setExpenseId(dao.getExpenseId());
        model.setExpenseType(dao.getExpenseType());
        model.setAmount(dao.getAmount());
        model.setDescription(dao.getDescription());
        model.setComment(dao.getComment());
        model.setDateOfExpense(dao.getDateOfExpense());
        model.setExpenseCreationDate(dao.getExpenseCreationDate());
        model.setExpenseModifiedDate(dao.getExpenseModifiedDate());
        model.setUserId(dao.getUserId());

        return model;
    }
}
