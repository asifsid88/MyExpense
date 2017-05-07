package com.asifsid88.myexpense.model;

import com.google.gson.Gson;
import lombok.Data;

/**
 * Created by mhussaa on 4/30/17.
 */
@Data
public class Expense implements IModel {
    private String expenseId;
    private String expenseType;
    private String amount;
    private String description;
    private String dateOfExpense;
    private String expenseCreationDate;
    private String expenseModifiedDate;
    private String comment;
    private String userId;

    public String toJSON(IModel model) {
        return new Gson().toJson(model);
    }

    public Expense fromJSON(String data) {
        return new Gson().fromJson(data, Expense.class);
    }
}
