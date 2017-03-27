<%-- 
    Document   : index
    Created on : 02-03-2017, 14:43:25
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Main" method="post">
            <h3>UserID:</h3> 
            <input type="text" name="userID" />
            <h3>Pasword:</h3> 
            <input type="password" name="password" />
            <input type="submit" value="Login">
            <input type="hidden" name="action" value="login">
        </form>
    </body>

    

