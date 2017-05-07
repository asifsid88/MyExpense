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
    private Long expenseId;

    @Column(name = "expense_type")
    private String expenseType;

    private String amount;
    private String description;

    @Column(name = "expense_date")
    private String dateOfExpense;

    @Column(name = "create_date")
    private String expenseCreationDate;

    @Column(name = "modified_date")
    private String expenseModifiedDate;
    private String comment;

    @Column(name = "user_id")
    private String userId;
}
