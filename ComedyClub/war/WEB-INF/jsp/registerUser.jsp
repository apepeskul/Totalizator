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
<h1>New user registration</h1>

<form method="post" action="registerUser.html">
    <table bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
        <tr>
            <td align="right">User name:</td>
            <spring:bind path="userToRegister.name">
                <td>
                    <input type="text" name="name" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <td align="right">User password:</td>
            <spring:bind path="userToRegister.password">
                <td>
                    <input type="password" name="password" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <td colspan="2"/>
            <td>
                <input type="submit" align="right" value="register">
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <spring:hasBindErrors name="userToRegister">
                    <b>Name can't be empty or equals to already registered user name</b>
                </spring:hasBindErrors>
            </td>
        </tr>
    </table>
    <br/>
    <a href="userLogin.html">back</a>
</form>
</body>
</html>

