<html>
<body>
<h2>MyExpense is up and running !!!</h2>


<h3>Create Expense</h3>

<div id="message"></div>

<form action="#" name="create-expense" id="create-expense" method="post">
Expense Type:
<select name="expenseType" id="expenseType">
    <option value="Credit Card">Credit Card</option>
    <option value="Cash">Cash</option>
    <option value="Debit Card">Debit Card</option>
    <option value="Netbanking">Netbanking</option>
</select>
</br>
Amount: <input type="text" name="amount" id="amount" /></br>
Description: <input type="text" name="description" id="description" /></br>
Comment: <input type="text" name="comment" id="comment" /></br>

<input type="button" value="Create" name="create" id="create" />
<input type="reset" value="Reset" name="reset" id="reset" />
</form>


<script src="resources/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#create").bind('click', function() {
        $.ajax({
            url: "/expense/create",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            data: JSON.stringify(getFormData($("#create-expense"))),
            success: function(response) {
                console.log(response);
                $("#message").html(response);
            },
            error: function(data) {
                console.log("error");
            }
        });
    });

    var getFormData = function(form) {
        return $("#create-expense").serializeArray().reduce(function(a, x) { a[x.name] = x.value; return a; }, {})
    };
});
</script>
</body>
</html>
