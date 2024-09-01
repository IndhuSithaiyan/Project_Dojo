<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Page</title>
</head>
<body>
    <form:form>
     <h1 align="center"> Welcome to Loan Section!</h2>
     <br>
     <h3><font color="blue"><a href="/loan/loan-request-page"><input type="button" value="Apply loan"/></a></font></h3>
     <h3><font color="blue"><a href="/loan/loan-account-page"><input type="button" value="Loan details"/></a></font></h3>
     <a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
     </form:form>
</body>
</html>