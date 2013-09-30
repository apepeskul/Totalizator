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
	<h1>Users</h1>
	<table>
	<c:forEach items="${users}" var="user">
		<tr>
			<td width="100">
  				<a href="userSummary.html?user=${user.id}">
                      <b>${user.name}</b>
                </a>  				
  			</td>			
			<td width="80">
  				<a href="listUserStories.html?user=${user.id}">stories</a>
  			</td>
			<td width="80">
  				<a href="addFriend.html?user=${user.id}">make friends</a>
  			</td>
			<td width="80">
  				<a href="deleteFriend.html?user=${user.id}">break off with</a>
  			</td>  			
  		</tr>
	</c:forEach>
	</table>
	
	<br/>	
	<a href="userStartPage.html">back</a>
</body>
</html>
    