<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>
    <form:form>
     <h1 align="center"> Thank you for banking with us.</h2><br/>
     <b><font color="blue">Your Account Number is: ${userRequestModel.accountNumber} </font></b><br/>
     <b><font color="blue">Your Customer ID is: ${userRequestModel.customerId}  </font></b><br/><br/>
     <a href="${pageContext.servletContext.contextPath}/logout">Login</a>
     </form:form>
</body>
</html>