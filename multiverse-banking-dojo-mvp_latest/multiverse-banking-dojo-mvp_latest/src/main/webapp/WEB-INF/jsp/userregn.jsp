<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" %>
<%@page import= "org.springframework.http.HttpHeaders"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style type="text/css">

.required-field::after {
    content: "*";
    color: red;
}

 .container {
    width: 200px;
    clear: both;
  }

  .container input {
    width: 100%;
    clear: both;
  }

    .container select {
      width: 100%;
      clear: both;
    }


</style>
<script>

function validateAmount(){
    var amt = document.getElementById('amount').value;
    if(!amt.match(/^\d+/))
    {
    alert("Please enter numerical digits only")
    event.preventDefault();
    }
    if (amt < 5000){
    alert("Deposit Amount could not be less than 5K")
    event.preventDefault();
    }

}

</script>
</head>
<body>
     <h1 align="center"> USER REGISTRATION</h2>

     <h3><font color="red">Please enter all the mandatory fields</a></font></h3>

    <div class="container">

     <form:form action="/user-regn/createAccount" method="post" modelAttribute="userRequestModel" onsubmit="validateAmount();">
     <div class="required-field">First Name   :</div>     <form:input pattern="^[a-zA-Z]+$" title="Please enter only alphabet characters, special characters not allowed" required="required" path="firstName"/>
     <br>
     <br>
     <div class="required-field">Last Name    :</div>    <form:input pattern="^[a-zA-Z]+$" title="Please enter only alphabet characters, special characters not allowed" required="required" path="lastName"/>
     <br>
     <br>
     <div class="required-field">Password      :</div>    <form:password minlength="8" maxlength="20" required="required" path="passWord"/>
     <br>
     <br>
     <div class="required-field">Account Type :</div> <form:select required="required" path="accountType">
     <form:option value="" label="None"/>
     <form:option value="Savings" label="Savings Account"/>
     <form:option value="Current" label="Current Account"/>
     </form:select>
     <br>
     <br>
     <div class="required-field">PAN :</div> <form:input pattern="^[A-Z0-9]+$" title="Please enter only alphanumeric with capital letters, special characters not allowed" required="required" maxlength="10" path="pan"/>
     <br>
     <br>
     <div class="required-field">Mobile Num :</div> <form:input pattern="^[0-9]+$" title="Please enter a valid number" required="required" maxlength="10" path="mobileNumber"/>
     <br>
     <br>
     <div class="required-field">Email         :</div>    <form:input required="required" path="emailId"/>
     <br>
     <br>
     <div class="required-field">Amount       :</div>    <form:input type="number" required="required" path="amount"/>
     <br>
     <br>
     <input type="submit" value="Register"/>
     </form:form>
     </div>
</body>
</html>