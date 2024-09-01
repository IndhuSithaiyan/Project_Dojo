<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="ISO-8859-1">

<title>Customer Profile</title>
</head>
<body style="background-color:white;">

     <h1 align="center">Customer Profile</h2><br/>
     <form:form>
     <b><font color="blue">Successfully logged in Customer Id: ${updateDetailsModel.customerId} </font></b><br/>
     <b><font color="blue">Account Number: ${updateDetailsModel.accountNumber} </font></b><br/><br/>
     <b><font color="blue">Account Balance: ${updateDetailsModel.amount} </font></b><br/><br/>
     <h3><font color="blue"><a href="/show/user-registration-update?customerId=${updateDetailsModel.customerId}"><input type="button" value="Update User details"/></a></font></h3><br/><br/>
     <select onChange="window.location.href=this.value">
     <option selected="true" disabled="disabled" value="">Loan Section</option>
     <option value="/loan/loan-request-page">Apply loan</option>
     <option value="/loan/loan-account-page">Loan Account details</option>
     </select><br/><br/>
     <a href="${pageContext.servletContext.contextPath}/logout">Logout</a><br/>
     <br>
     </form:form>
</html>
