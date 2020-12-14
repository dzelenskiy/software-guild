<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Welcome to Dmitriy's Flooring Calculator</h1>
        <form method="post" action="calculate">
            <label for="width">Enter floor width:</label>
            <input type="text" id="width" name="floorWidth"/>
            <label for="length">Enter floor length:</label>
            <input type="text" id="length" name="floorLength"/>
            <label for="cost">Enter material cost per square foot:</label>
            <input type="text" id="cost" name="costPerSqFt"/>
            <input type="submit" value="calculate"/>
        </form>
    </body>
</html>

