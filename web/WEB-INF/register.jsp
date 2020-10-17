<%-- 
    Document   : register
    Created on : Oct 16, 2020, 5:43:30 PM
    Author     : 718707
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <label>Username:</label>
            <input type="text" name="username"/> 
            <input type="hidden" name="action" value="register">
            <input type="Submit" value="Register name"/>            
        </form>
        
        
    </body>
</html>
