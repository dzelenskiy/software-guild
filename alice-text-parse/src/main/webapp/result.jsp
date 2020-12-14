<%-- 
    Document   : result
    Created on : Jun 12, 2018, 9:19:31 AM
    Author     : DZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alice Text Parser Results</title>
    </head>
    <body>
        <h1>Thank you for using the Alice Text Parser</h1>
        <p>${wordToCount} appears ${wordCount} times in alice.txt</p>
        <p>
            <a href="index.jsp">Count another word</a>
        </p>
    </body>
</html>
