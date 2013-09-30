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
<h1>All stories of ${user.name}</h1>
<table>
    <tr>
        <td width="200">
            <b>Title</b>
        </td>
        <td width="80">
            <b>Is Public?</b>
        </td>
        <td width="60">
            <b>Rating</b>
        </td>
    </tr>
    <c:forEach items="${extendedUserStories}" var="extendedStory">
        <tr>
            <td>${extendedStory.story.title}</td>
            <td>${extendedStory.story.isPublic}</td>
            <td>${extendedStory.averageRating}</td>
            <td width="50">
                <a href="readUserStory.html?story=${extendedStory.story.id}">read</a>
            </td>
            <td width="50">
                <a href="rateUserStory.html?story=${extendedStory.story.id}">rate</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="listUsers.html">back</a>

</body>
</html>