package com.asifsid88.myexpense.model;

import com.asifsid88.myexpense.constants.ExpenseType;
import lombok.Data;

/**
 * Created by mhussaa on 4/30/17.
 */
@Data
public class Expense implements IModel {
    private String expenseId;
    private ExpenseType expenseType;
    private String amount;
    private String description;
    private String dateOfExpense;
    private String expenseCreationDate;
    private String expenseUpdateDate;
    private String comment;
}
