package com.asifsid88.myexpense.constants;

/**
 * Created by mhussaa on 4/30/17.
 */
public interface WebURLs {
    String CREATE_EXPENSE = "/expense/create";
    String GET_EXPENSE_BY_ID = "/expense/{expenseId}";
    String UPDATE_EXPENSE = "/expense/update";
    String DELETE_EXPENSE = "/expense/delete/{expenseId}";
    String EXPENSE_LIST = "/expense/getall";
    String GET_EXPENSE_LIST_BY_SIZE = "/expense/list/{size}";
}
