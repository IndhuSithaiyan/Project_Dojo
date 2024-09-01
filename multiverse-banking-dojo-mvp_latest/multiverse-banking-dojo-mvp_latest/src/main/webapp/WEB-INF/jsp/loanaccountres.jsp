<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Account Details</title>
</head>
<body>
   <form:form>
     <h1 align="center"> Loan Description </h2><br/>
     <a href="/home-page"><input type="button" value="Back"/></a><br/><br/>
     <b><font color="blue">Loan Account Number : ${loanResModel.loanAcctNumber} </font></b><br/>
     <b><font color="blue">Loan Type : ${loanResModel.loanType} Loan </font></b><br/>
     <b><font color="blue">Interest Type : ${loanResModel.interestType}  </font></b><br/>
     <b><font color="blue">Issued Date : ${loanResModel.issuedDate} </font></b><br/>
     <b><font color="blue">Principal Amount: ${loanResModel.principalAmount}  </font></b><br/>
     <b><font color="blue">Loan Tenure : ${loanResModel.loanDuration} </font></b><br/>
     <b><font color="blue">Rate Of Interest : ${loanResModel.roi}  </font></b><br/>
     <b><font color="blue">Next Pay EMI : ${loanResModel.emi}  </font></b><br/>
  </form:form>
</body>
</html>