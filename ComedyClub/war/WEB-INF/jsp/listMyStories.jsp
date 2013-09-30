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
<h1>My stories</h1>
<a href="addStory.html">Create new story</a>
<br/>
<br/>
<table>
    <tr>
        <td width="200">
            <b>Title</b>
        </td>
        <td width="90">
            <b>Is public?</b>
        </td>
        <td width="60" align="left">
            <b>Rating</b>
        </td>
    </tr>
    <c:forEach items="${extendedUserStories}" var="extendedStory">
        <c:choose>
            <c:when test="${extendedStory.story.id % 2 == 1}">
                <tr class="b">
            </c:when>
            <c:otherwise>
                <tr>
            </c:otherwise>
        </c:choose>
            <td>
                    ${extendedStory.story.title}
            </td>
            <td>
                    ${extendedStory.story.isPublic}
            </td>
            <td>
                    ${extendedStory.averageRating}
            </td>
            <td width="60">
                <a href="readMyStory.html?story=${extendedStory.story.id}">read</a>
            </td>
            <td width="60">
                <a href="editStory.html?story=${extendedStory.story.id}">edit</a>
            </td>
            <td width="60">
                <a href="deleteStory.html?story=${extendedStory.story.id}">delete</a>
            </td>
        </tr>
        <!-- <tr>
        <td>&nbsp</td>
        </tr> -->
    </c:forEach>
</table>

<br/>
<a href="userStartPage.html">back</a>

</body>
</html>