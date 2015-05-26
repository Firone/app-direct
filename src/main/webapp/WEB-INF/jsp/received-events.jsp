<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Subscriptions pages</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<c:choose>
    <c:when test="${empty orderEvents}">
        <p>No subscription for now</p>
    </c:when>

    <c:otherwise>
        <c:forEach items="${orderEvents}" var="orderEvent">
            <p>
                Event type : ${orderEvent.type}<br/>
                By ${orderEvent.user.firstName} with email ${orderEvent.user.email} with uudi ${orderEvent.user.uuid}<br/>
                Return url : ${orderEvent.returnUrl}
            </p>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>