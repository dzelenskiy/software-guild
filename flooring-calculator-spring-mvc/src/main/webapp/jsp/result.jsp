<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator Result</title>
    </head>
    <body>
        <h1>Thank you for using Dmitriy's Flooring Calculator</h1>
        <p>Your flooring installation of ${totalSqFt} sq feet at ${costPerSqFt} dollars per sq. foot is going to take ${laborHour} hours at $86.00 per hour...</p>
        <p>...for a grand total of ${total} dollars. <a href="index.jsp">Calculate another?</a>
    </body>
</html>

