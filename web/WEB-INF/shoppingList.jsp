<%-- 
    Document   : shoppingList
    Created on : Oct 16, 2020, 5:43:47 PM
    Author     : 718707
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username} <a href="<c:url value="/ShoppingList">
                             <c:param name="action" value="logout"></c:param>
                        </c:url>">Logout</a></p>
        
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            <label>Add item: </label>
            <input type="hidden" name="action" value="add" />
            <input type="text" name="item" required/>
            <input type="submit" value="Add"/>
        </form>
        
         <c:if test="${!empty list}">
            <form method="post" action="ShoppingList">
                <c:forEach items="${list}" var="item">
                   <label><input type="radio" name="listItem" value="${item}"> ${item}</label>
                    <br>
                </c:forEach>
                    <br>
                    <input type="hidden" name="action" value="delete"/>
                 <input type="submit" value="Delete" />
            </form>
        </c:if>
        
    </body>
</html>
