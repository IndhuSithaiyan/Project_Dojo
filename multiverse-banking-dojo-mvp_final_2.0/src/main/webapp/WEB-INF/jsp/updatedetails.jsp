<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration Details</title>
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
</head>
<body>
<h1 align="center"> UPDATE REGISTRATION DETAILS</h2>


<h3><font color="red">Please enter all the mandatory fields</a></font></h3>

<div class="container">

<form:form action="/user/user-details-updated" method="post" modelAttribute="user">


<div class="required-field">First Name :</div> <form:input required="required" path="firstName" pattern="^[a-zA-Z0-9]+$" title="Please enter only alphanumeric characters, special characters not allowed"/>
<br>
<br>
<div class="required-field">Last Name :</div> <form:input path="lastName" pattern="^[a-zA-Z0-9]+$" title="Please enter only alphanumeric characters, special characters not allowed"/>
<br>
<br>
<div class="required-field">PAN :</div> <form:input path="pan" pattern="^[a-zA-Z0-9]+$" title="Please enter only alphanumeric characters, special characters not allowed"/>
<br>
<br>
<div class="required-field" >Mobile Num :</div> <form:input path="mobileNumber" pattern="^[0-9]+$" title="Please enter a valid mobile number"/>
<br>
<br>
<div class="required-field">Email :</div> <form:input path="emailId" title ="Please Enter a Valid Email_Id"/>
<br>
<br>
<form:hidden path="accountType"/>
<form:hidden path="passWord"/>
<form:hidden path="accountNumber"/>
<form:hidden path="customerId"/>
<form:hidden path="amount"/>
<input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>