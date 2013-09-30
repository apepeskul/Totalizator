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
<h1>Rate story</h1>

<form method="post" action="rateUserStory.html">
    <table bgcolor="f8f8ff" cellspacing="0" cellpadding="5">
        <tr>
            <td align="right">Input rating:</td>
            <spring:bind path="rating.rate">
                <td>
                    <input type="text" name="rate" value="${status.value}">
                </td>
                <td>
                    <input type="submit" align="middle" value="rate">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <td colspan="4">
                <spring:hasBindErrors name="rating">
                    <b>Please check inputs!</b>
                </spring:hasBindErrors>
            </td>
        </tr>
    </table>
</form>

<br/>
<a href="readUserStory.html?story=${rating.storyId}">back</a>

</body>
</html>



