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
<h1>Summary of ${user.name}</h1>
<table>
    <tr>
        <td align="left">Name: ${user.name}</td>
    </tr>
    <tr>
        <td>${isFriend}</td>
    </tr>
    <tr>
        <td>
            <a href="listUserStories.html?user=${user.id}">stories</a>
        </td>
    </tr>
</table>

<br/>
<a href="listUsers.html">back</a>
</body>
</html>
    