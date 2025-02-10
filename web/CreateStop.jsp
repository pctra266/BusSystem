<%-- 
    Document   : CreateStop
    Created on : Sep 17, 2024, 4:44:47 PM
    Author     : Tra Pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Stop</title>
        <link rel="stylesheet" href="StyleForm.css">
        <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
    </head>
    <body>
        <c:if test="${sessionScope.currentUser.getRoleID() == null}">
            <c:redirect url="AccessDenied.jsp" />
        </c:if>
        
        <%@include file="Header.jsp" %>
        <div class="form-containter">
            <div class="form-box">
                <h2>Create Stop</h2>
                
        <form action="create" method="post">
            <input type="hidden" name="action" value="createStop">
            
                   <div class="input-group">
                        <label>Stop Name</label>
                        <input type="text" name="StopName">
                   </div>
            
                    <div class="button-container">
                        <button>Create</button>
                    </div>
                

        </form>
                
                </div>
        </div>
            
        <%@include file="Footer.jsp" %>
    </body>
</html>
