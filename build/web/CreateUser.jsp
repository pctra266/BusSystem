<%-- 
    Document   : CreateUser
    Created on : Sep 10, 2024, 5:31:41 PM
    Author     : Tra Pham
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
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
                <h2>Create User</h2>    

                <form action="create" method="post">
                    <input type="hidden" name="action" value="createUser">

                    <div class="input-group">
                        <label>User Name</label>
                        <input type="text" name="UserName" required="" >
                    </div>

                    <div class="input-group">
                        <label>Password</label>
                        <input type="text" name="Password" required="">
                    </div>

                    <div class="input-group">
                        <label>Role Name</label>
                        <div><select name="RoleID">
                                <c:forEach items="${listRole}" var="o">
                                    <option value="${o.getRoleID()}"  > ${o.getRoleName()}</option>
                                </c:forEach>
                            </select></div>
                    </div>

                    <div class="button-container">
                        <button type="submit">Create</button>
                    </div>



                </form>
                 <div class="message">${mess}</div>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
