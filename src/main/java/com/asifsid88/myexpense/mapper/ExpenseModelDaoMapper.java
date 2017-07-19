package com.asifsid88.myexpense.mapper;

import com.asifsid88.myexpense.dal.dao.ExpenseDAO;
import com.asifsid88.myexpense.model.Expense;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mhussaa on 5/5/17.
 */
@Component
public class ExpenseModelDaoMapper implements ModelDaoMapper<ExpenseDAO, Expense> {

    public List<ExpenseDAO> toDaoList(List<Expense> modelList) {
        if(modelList == null) return null;

        List<ExpenseDAO> expenseDAOList = new LinkedList<ExpenseDAO>();
        if(modelList.size() == 0) return expenseDAOList;

        for(Expense expense : modelList) {
            ExpenseDAO expenseDAO = toDao(expense);
            expenseDAOList.add(expenseDAO);
        }

        return expenseDAOList;
    }

    public ExpenseDAO toDao(Expense model) {
        if(model == null) return null;

        ExpenseDAO dao = new ExpenseDAO();

        if(model.getExpenseId() != null) {
            dao.setExpenseId(Long.parseLong(model.getExpenseId()));
        }

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

    public List<Expense> toModelList(List<ExpenseDAO> daoList) {
        if(daoList == null) return null;

        List<Expense> expenseList = new LinkedList<Expense>();
        if(daoList.size() == 0) return expenseList;

        for(ExpenseDAO expenseDAO : daoList) {
            Expense expense = toModel(expenseDAO);
            expenseList.add(expense);
        }

        return expenseList;
    }

    public Expense toModel(ExpenseDAO dao) {
        if(dao == null) return null;

        Expense model = new Expense();
        model.setExpenseId(String.valueOf(dao.getExpenseId()));
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
