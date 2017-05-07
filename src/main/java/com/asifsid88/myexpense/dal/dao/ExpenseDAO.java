package com.asifsid88.myexpense.dal.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by mhussaa on 4/30/17.
 */
@Data
@Entity
@Table(name = "Expense")
public class ExpenseDAO implements IDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id", unique = true, nullable = false)
    private String expenseId;

    private String expenseType;
    private String amount;
    private String description;
    private String dateOfExpense;
    private String expenseCreationDate;
    private String expenseModifiedDate;
    private String comment;
    private String userId;
}
