<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello Worldokokok</h2>
<c:forEach items="${users}" var="user">
    ${user.id}: ${user.username}<br/>
</c:forEach>
</body>
</html>