<html>
<body>
<h2>MyExpense is up and running !!!</h2>


<h3>Create Expense</h3>
<form action="/expense/create" name="create-expense" id="create-expense" method="post">
Expense Type:
<select name="expenseType" id="expenseType">
    <option value="Credit Card">Credit Card</option>
    <option value="Cash">Cash</option>
    <option value="Debit Card">Debit Card</option>
    <option value="Netbanking">Netbanking</option>
</select>

Amount: <input type="text" name="amount" id="amount" />
Description: <input type="text" name="description" id="description" />
Comment: <input type="text" name="comment" id="comment" />

<input type="submit" value="Create" name="create" id="create" />
<input type="reset" value="Reset" name="reset" id="reset" />
</form>

</body>
</html>
