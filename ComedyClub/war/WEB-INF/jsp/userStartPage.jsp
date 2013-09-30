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
<h1>Hello, ${user_name}</h1>
<br/>

<h2>All tasks:</h2>

<ul>
    <li><a href="listUsers.html">Show all users</a></li>
    <li><a href="listMyStories.html">Show my stories</a></li>
</ul>

<br/>
<a href="userLogin.html">back</a>

</body>
</html>