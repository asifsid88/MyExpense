package com.asifsid88.myexpense.controllers;

import com.asifsid88.myexpense.constants.ResponseStatus;
import com.asifsid88.myexpense.constants.WebURLs;
import com.asifsid88.myexpense.helper.ResponseBuilder;
import com.asifsid88.myexpense.model.Expense;
import com.asifsid88.myexpense.model.IModel;
import com.asifsid88.myexpense.model.Response;
import com.asifsid88.myexpense.services.ExpenseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mhussaa on 4/30/17.
 */
@Controller
@Log4j2
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @CrossOrigin
    @RequestMapping(value = WebURLs.CREATE_EXPENSE, method = RequestMethod.POST)
    public @ResponseBody Response createExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.createExpense(expense);
        return buildResponse(createdExpense);
    }

    @RequestMapping(value = WebURLs.UPDATE_EXPENSE, method = RequestMethod.POST)
    public @ResponseBody Response updateExpense(@RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(expense);
        return buildResponse(updatedExpense);
    }

    @RequestMapping(value = WebURLs.DELETE_EXPENSE, method = RequestMethod.GET)
    public @ResponseBody Response deleteExpense() {
        return ResponseBuilder.buildResponse(ResponseStatus.OK, new Expense());
    }

    @RequestMapping(value = WebURLs.GET_EXPENSE_BY_ID, method = RequestMethod.GET)
    public @ResponseBody Response getExpenseById(@PathVariable(name = "expenseId") String expenseId) {
        Expense expense = expenseService.getExpenseById(expenseId);
        return buildResponse(expense);
    }

    @RequestMapping(value = WebURLs.EXPENSE_LIST, method = RequestMethod.GET)
    public @ResponseBody Response getAllExpenses() {
        return ResponseBuilder.buildResponse(ResponseStatus.OK, new Expense());
    }

    @RequestMapping(value = WebURLs.GET_EXPENSE_LIST_BY_SIZE, method = RequestMethod.GET)
    public @ResponseBody Response getExpenseListBySize(@PathVariable(name = "size") String size) {
        log.debug("i am called>> size wala:: " + size);

        final List<IModel> expenseList = new LinkedList<IModel>();
        for(int i=1; i<=Integer.parseInt(size); i++) {
            expenseList.add(getExpense(i));
        }

        return ResponseBuilder.buildResponse(ResponseStatus.OK, expenseList);
    }

    // temporary--> get it from DB
    private Expense getExpense(int expenseId) {
        Expense expense = new Expense();
        expense.setExpenseId(String.valueOf(expenseId));
        expense.setAmount(String.valueOf(expenseId * 10));
        expense.setExpenseType("Paytm");
        expense.setDescription("Lunch");
        expense.setComment("Comment: " + expenseId);

        return expense;
    }

    private Response buildResponse(Expense expense) {
        Response response;
        if(expense == null) {
            response = ResponseBuilder.buildErrorResponse(ResponseStatus.FAIL);
        } else {
            response = ResponseBuilder.buildResponse(ResponseStatus.OK, expense);
        }

        return response;
    }
}
