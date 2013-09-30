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
<h1>Create new story</h1>

<form method="post" action="addStory.html">
    <table bgcolor="f8f8ff" cellspacing="0" cellpadding="5">
        <tr>
            <spring:bind path="story.title">
                <td align="right">Title:</td>
                <td>
                    <input type="text" name="title" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <td align="right">Is public:</td>
            <td>
                <spring:bind path="story.isPublic">
                    <select name="${status.expression}">
                        <c:forEach items="${trueFalse}" var="trueFalse">
                            <spring:transform value="${trueFalse}" var="typeString"/>
                            <c:choose>
                                <c:when test="${status.value == typeString}">
                                    <option value="${typeString}" selected>${typeString}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${typeString}">${typeString}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </spring:bind>
            </td>
        </tr>

        <tr>
            <spring:bind path="story.content">
                <td align="right">Content:</td>
                <td>
                    <input type="text" name="content" value="${status.value}">
                </td>
                <td>
                    <font color="red">${status.errorMessage}</font>
                </td>
            </spring:bind>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" align="middle" value="create">
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <spring:hasBindErrors name="rating">
                    <b>Please check your inputs!</b>
                </spring:hasBindErrors>
            </td>
        </tr>
    </table>
</form>

<br/>
<a href="listMyStories.html">back</a>

</body>
</html>



