package com.asifsid88.myexpense.constants;

/**
 * Created by mhussaa on 4/30/17.
 */
public enum ExpenseType {
    CREDIT_CARD("Credit Card"),
    CASH("Cash"),
    DEBIT_CARD("Debit Card"),
    NET_BANKING("Net Banking");

    private String expenseType;

    ExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseType() {
        return this.expenseType;
    }
}
