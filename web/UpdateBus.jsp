<%-- 
    Document   : UpdateBus
    Created on : Sep 9, 2024, 9:15:20 PM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Bus</title>
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
                <h2>Update Bus</h2>
                <form action="update" method="post">
                    <input type="hidden" name="action" value="updateBus">
                    <div class="input-group">
                        <label> Bus ID </label>
                        <input type="text" name="busID" readonly="" value="${updateBus.getBusID()}">
                    </div>

                    <div class="input-group">
                        <label> Bus Number </label>
                        <input type="text" name="busNum" value="${updateBus.getBusNumber()}">
                    </div>

                    <div class="input-group">
                        <label> Select Route Name </label>
                        <select name="routeID">
                            <option value="" ${updateBus.getRouteName()==""?"selected":""}> no Route </option>
                            <c:forEach items="${listRoute}" var="o">
                                <option value="${o.getRouteID()}" ${o.getRouteName()==updateBus.getRouteName()?"selected":""}>${o.getRouteName()}</option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="button-container">
                        <button type="submit">Update</button>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
