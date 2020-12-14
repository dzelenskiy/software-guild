<%-- 
    Document   : index
    Created on : Jun 12, 2018, 9:19:07 AM
    Author     : DZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alice Text Parser</title>
    </head>
    <body>
        <h1>Welcome to the Alice Text Parser</h1>
        <p>
            Please enter word to count:
        </p>
        <form method="post" action="AliceTextParseServlet">
            <input type="text" name="wordToCount"/><br/>
            <input type="submit" value="Count words!"/>
        </form>
    </body>
</html>
