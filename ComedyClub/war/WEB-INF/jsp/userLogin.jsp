<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title><fmt:message key="title"/></title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>

<body>
<h1>Welcome to Comedy Club!</h1>

<form method="post" action="/userLogin.html">
    <table bgcolor="f8f8ff" cellspacing="0" cellpadding="5">
        <spring:bind path="userToLogin.name">
            <tr>
                <td align="right">name:</td>
                <td>
                    <input type="text" name="name" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </tr>
        </spring:bind>
        <spring:bind path="userToLogin.password">
            <tr>
                <td align="right">password:</td>
                <td>
                    <input type="password" name="password" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </tr>
        </spring:bind>
        <tr>
            <td/>
            <td>
                <input type="submit" align="right" value="login">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <spring:hasBindErrors name="userToLoign">
                    <b>Enter correct name, or register if you are visit for the first time</b>
                </spring:hasBindErrors>
            </td>
        </tr>
    </table>
    <br/>
    <a href="registerUser.html">register</a>
</form>
</body>
</html>

