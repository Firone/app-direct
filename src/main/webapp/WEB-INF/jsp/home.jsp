<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Subscriptions pages</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

<h1>Hello ${user.firstName} !</h1>
Your OpenId : ${user.openId}

<h2>Your order events</h2>
<p>
    <c:choose>
        <c:when test="${empty personalOrders}">
            No order event referring to you.
        </c:when>
        <c:otherwise>
        Your orders events
            <c:forEach items="${personalOrders}" var="orderEvent">
                <p>
                    Event type : ${orderEvent.type}<br/>
                    By ${orderEvent.user.firstName} with openId ${orderEvent.user.openId}<br/>
                    Edition code of the order : ${orderEvent.payload.order.editionCode}<br/>
                    Return url : ${orderEvent.returnUrl}
                </p>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</p>

<h2>All order events</h2>
<c:choose>
    <c:when test="${empty globalOrders}">
        <p>No order event in the system.</p>
    </c:when>

    <c:otherwise>
        <c:forEach items="${globalOrders}" var="orderEvent">
            <p>
                Event type : ${orderEvent.type}<br/>
                By ${orderEvent.user.firstName} with openId ${orderEvent.user.openId}<br/>
                Edition code of the order : ${orderEvent.payload.order.editionCode}<br/>
                Return url : ${orderEvent.returnUrl}
            </p>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>
