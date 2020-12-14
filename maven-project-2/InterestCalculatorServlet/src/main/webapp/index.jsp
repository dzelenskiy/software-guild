<%-- 
    Document   : index
    Created on : Jun 13, 2018, 2:30:31 PM
    Author     : DZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Welcome to Dmitriy's Interest Calculator</h1>
        <form method="post" action="FlooringCalculatorServlet">
            <label for="width">Enter your investment:</label>
            <input type="text" id="investment" name="investment"/>
            <label for="length">Enter your annual interest rate:</label>
            <input type="text" id="interest" name="interest"/>
            <label for="cost">Enter number of years to invest:</label>
            <input type="text" id="years" name="years"/>
            <input type="submit" value="calculate"/>
        </form>
    </body>
</html>
