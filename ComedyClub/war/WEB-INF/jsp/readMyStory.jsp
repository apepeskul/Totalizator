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
<table>
    <tr>
        <td>
            <b>Title:</b>
        </td>
        <td>${story.title}</td>
    </tr>
    <tr>
        <td>
            <br/>
            ${story.content}
        </td>
    </tr>
</table>

<br/>
<a href="listMyStories.html">back</a>
</body>
</html>