package com.asifsid88.myexpense.controllers;

import com.asifsid88.myexpense.constants.ResponseStatus;
import com.asifsid88.myexpense.constants.WebURLs;
import com.asifsid88.myexpense.helper.ResponseBuilder;
import com.asifsid88.myexpense.model.Expense;
import com.asifsid88.myexpense.model.Response;
import com.asifsid88.myexpense.services.ExpenseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mhussaa on 4/30/17.
 */
@Controller
@Log4j2
public class MyExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public MyExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = WebURLs.GET_EXPENSE_BY_ID, method = RequestMethod.GET)
    public @ResponseBody Response getExpenseById(@PathVariable(name = "expenseId") String expenseId) {
        Expense expense = expenseService.getExpenseById(expenseId);
        return ResponseBuilder.buildResponse(ResponseStatus.COMPLETE, expense);
    }


    @RequestMapping(value = WebURLs.CREATE_EXPENSE, method = RequestMethod.POST)
    public @ResponseBody Response createExpense() {

        return ResponseBuilder.buildResponse(ResponseStatus.COMPLETE, new Expense());
    }


    @RequestMapping(value = WebURLs.UPDATE_EXPENSE, method = RequestMethod.POST)
    public @ResponseBody Response updateExpense() {

        return ResponseBuilder.buildResponse(ResponseStatus.COMPLETE, new Expense());
    }


    @RequestMapping(value = WebURLs.DELETE_EXPENSE, method = RequestMethod.GET)
    public @ResponseBody Response deleteExpense() {

        return ResponseBuilder.buildResponse(ResponseStatus.COMPLETE, new Expense());
    }


    @RequestMapping(value = WebURLs.EXPENSE_LIST, method = RequestMethod.GET)
    public @ResponseBody Response getAllExpenses() {

        return ResponseBuilder.buildResponse(ResponseStatus.COMPLETE, new Expense());
    }
}
