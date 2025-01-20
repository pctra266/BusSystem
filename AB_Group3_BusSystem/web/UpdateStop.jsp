<%-- 
    Document   : UpdateStop
    Created on : Sep 17, 2024, 5:06:38 PM
    Author     : Tra Pham
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Stop</title>
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
                <h2>Update Stop</h2>
        <form action="update" method="post">
            <input type="hidden" name="action" value="updateStop">
            
                     <div class="input-group">
                        <label>Stop ID</label>
                        <input type="text" readonly="" value="${updateStop.getStopID()}" name="StopID">
                   </div>
                    
                     <div class="input-group">
                        <label>Stop Name</label>
                        <input type="text" value="${updateStop.getStopName()}" name="StopName">
                    </div>
                    
                    <div class="button-container">
                        <button>Update</button>
                   </div>

        </form>
                    </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
