<%-- 
    Document   : UpdateUser
    Created on : Sep 10, 2024, 8:10:55 PM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
        <link rel="stylesheet" href="StyleForm.css">
        <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
    </head>

    <body>
        <c:if test="${sessionScope.currentUser.getRoleID() == null || sessionScope.currentUser.getRoleID() != 1}">
            <c:redirect url="AccessDenied.jsp" />
        </c:if>
        
        
        <%@include file="Header.jsp" %>
        <div class="form-containter">
            <div class="form-box">
                <h2>Update User</h2>   
                <form action="update" method="post">
                    <input type="hidden" name="action" value="updateUser">

                    <div class="input-group">
                        <label>User ID</label>
                        <input type="text" name="UserID" readonly="" value="${userUpdate.getUserID()}">
                    </div>
                    <div class="input-group">
                        <label>User Name</label>
                        <input type="text" name="UserName" value="${userUpdate.getUserName()}">
                    </div>
                    <div class="input-group">
                        <label>Password</label>
                        <input type="text" name="Password" value="${userUpdate.getPassword()}">
                    </div>
                    <div class="input-group">
                        <label>Role Name</label>
                        <select name="RoleID">
                            <c:forEach items="${listRole}" var="o">
                                <option   value="${o.getRoleID()}" ${userUpdate.getRoleID()==o.getRoleID()?"selected":""}>${o.getRoleName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="button-container">
                        <button type="submit">Update</button>
                    </div>


                </form>
                    <div class="message">${mess}</div>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
