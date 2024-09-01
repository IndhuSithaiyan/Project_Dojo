<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script>
function validateform(){
    var username = document.forms["loginForm"]["username"].value;
    var password = document.forms["loginForm"]["password"].value;
    if (username.toString().length < 8){
    alert("Username should not be less than 8 digits")
    event.preventDefault();
    }
    if (username.toString().length > 8){
    alert("Username should not be greater-than 8 digits")
    event.preventDefault();
    }
    if(!username.match(/^\d+/))
    {
    alert("Please enter numerical digits only")
    event.preventDefault();
    }
}
</script>
</head>
<body>
    <h1 align="center"> Welcome to XYZ Bank!</h2>
	<form:form id="loginForm" name="loginForm" modelAttribute="login" action="loginProcess"
		method="post" onsubmit="validateform();">
		<table align="center">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><input type="text" required="required" name="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password required="required" path="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"/></td>
			</tr>
			<tr>
			    <td></td>
            	<td><h3><font color="blue"><a href="/show/user-regn-page"><input type="button" value="Click here to register with us"/></a></font></h3></td>
            </tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>