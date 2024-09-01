<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" %>
<%@page import= "org.springframework.http.HttpHeaders"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Request Form</title>
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

var store_type;
function updateROI(loanRequestType) {

      var type_index = loanRequestType.selectedIndex;
      var l_type = loanRequestType.options[type_index].value;
      store_type = l_type;
      chooseTenure();
      if(l_type == 'Personal')
          document.getElementById('roi').value= "15.00";
      else if(l_type == 'Education')
          document.getElementById('roi').value = "11.15";
      else if(l_type == 'Car')
          document.getElementById('roi').value = "8.75";
      else
          document.getElementById('roi').value = "9.50";
}

function changeROIPerIntType(interestType) {
      var type_index = interestType.selectedIndex;
      var int_type = interestType.options[type_index].value;

      if(store_type == 'Personal'){
        if(int_type == 'Variable')
            document.getElementById('roi').value = "15.00";
        else
            document.getElementById('roi').value = "15.80";
      }
      else if(store_type == 'Education'){
        if(int_type == 'Variable')
           document.getElementById('roi').value = "11.15";
        else
           document.getElementById('roi').value = "12.05";
      }
      else if(store_type == 'Car'){
        if(int_type == 'Variable')
           document.getElementById('roi').value = "8.75";
        else
           document.getElementById('roi').value = "9.80";
      }
      else {
        if(int_type == 'Variable')
           document.getElementById('roi').value = "9.50";
      else
          document.getElementById('roi').value = "10.95";
      }
}

function chooseTenure() {
       var myDiv = document.getElementById('loanDuration');
       if(store_type == 'Home'){
          var array = [20,15];
       }
       else if(store_type == 'Car'){
          var array = [7,5];
       }
       else if(store_type == 'Personal'){
          var array = [11,7,5,3,1];
       }
       else if(store_type == 'Education'){
          var array = [12,10,8,5,4];
       }
      for (var i = 0; i < array.length; i++) {
             var option = document.createElement('option');
             var label = document.createElement('label');
             option.setAttribute('value', array[i]);
             var node = document.createTextNode(array[i]);
             option.appendChild(node);
             document.getElementById('loanDuration').appendChild(option);
      }
}

</script>

</head>
<body>

     <h1 align="center"> LOAN REQUEST</h2>
     <a href="/home-page"><input type="button" value="Back"/></a></font><br><br>
     <h3><font color="red">Please enter all the mandatory fields</a></font></h3>
     <div class="container">
     <form:form action="/loan/loan-account-request" method="post" modelAttribute="loanRequestModel"><br>
     <div class="required-field">Loan Request Type :</div>
     <form:select id="loanRequestType" path="loanRequestType" onchange="updateROI(this.form.loanRequestType)" required="required">
     <form:option value="" label="none"/>
     <form:option value="Personal"  label="Personal"/>
     <form:option value="Education" label="Education"/>
     <form:option value="Car" label="Car"/>
     <form:option value="Home" label="Home"/>
     </form:select>
     <br>
     <br>
     <div>Interest Type :</div>
     <form:select path="interestType" onchange="changeROIPerIntType(this.form.interestType)" required="required">
     <form:option value="Variable" label="Variable"/>
     <form:option value="Fixed"  label="Fixed"/>
     </form:select>
     <br>
     <br>
     <div class="required-field">Loan Amount(in INR) :</div><form:input path="loanAmount" required="required" />
     <br>
     <br>
     <div class="required-field">Loan Duration(in years) :</div><form:select id="loanDuration" path="loanDuration" required="required">
     </form:select>
     <br>
     <br>
     <div for="roi">Rate of Interest(%) :</div> <form:input type="text" id="roi" path="roi" readonly="true"/></script>
     <br>
     <br>
     <input type="submit" value="Apply"/>
     </form:form>
     </div>
</body>
</html>