<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applied Loan Details</title>
</head>
<body>
   <form:form>
     <h1 align="center"> Applied Loan Details </h2><br/>
     <a href="/home-page"><input type="button" value="Back"/></a><br/><br/>
     <b><font color="blue">Loan Description : ${loanResModel.loanDescription} Loan </font></b><br/>
     <b><font color="blue">Loan Avail for : ${loanResModel.loanType} </font></b><br/>
     <b><font color="blue">Interest Type : ${loanResModel.interestType} </font></b><br/>
     <b><font color="blue">Issued Date : ${loanResModel.issuedDate} </font></b><br/>
     <b><font color="blue">Applied Principal Amount: ${loanResModel.principalAmount} </font></b><br/>
     <b><font color="blue">Loan Tenure : ${loanResModel.loanDuration} </font></b><br/>
     <b><font color="blue">ROI : ${loanResModel.roi} </font></b><br/>
   </form:form>
</body>
</html>