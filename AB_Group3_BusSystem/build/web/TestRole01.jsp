<%-- 
    Document   : TestRole01
    Created on : Sep 10, 2024, 3:33:45 PM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <link rel="stylesheet" href="StyleBus/StyleBus.css">
        <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
        <style>
            html, body {
                height: 100%;
                margin: 0;
                font-family: 'Work Sans', Arial, sans-serif;
                display: flex;
                flex-direction: column;
            }

            body {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }


            .container {
                flex: 1;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                padding: 20px;
            }
            
          /* action Button Styles */
            .action-buttons {
                margin-top: 20px;
            }

            .action-buttons a {
                padding: 10px 20px;
                background-color: #00ca4c;
                color: white;
                border-radius: 5px;
                text-decoration: none;
                margin-right: 10px;
            }

                .action-buttons a:hover {
                    background-color: #009e3c;  
                }
                
                .data-table a {
    color: #00ca4c; /* Primary color for links */
    text-decoration: none;
    font-weight: bold;
    padding: 5px 10px;
    border-radius: 4px;
}

.data-table a:hover {
/*    background-color: #00ca4c;  Background change on hover 
    color: white;  Text color change on hover */
    text-decoration: underline;
}

        </style>
    </head>
     
    <body>
        <c:if test="${sessionScope.currentUser.getRoleID() == null || sessionScope.currentUser.getRoleID() != 1}">
            <c:redirect url="AccessDenied.jsp" />
        </c:if>
        
        <%@include file="Header.jsp" %>
        <div class="container">
            <h2>List accounts </h2>
        <table  class="data-table">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Role Name</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listUser}" var="o">
                <tr>
                    <td>${o.getUserID()}</td>
                    <td>${o.getUserName()}</td>
                    <td>${o.getPassword()}</td>
                    <td>${o.getRoleName()}</td>
                    <td><a href="load?UserID=${o.getUserID()}&action=loadUpdateUser">Update</a></td>
                    <td><a href="#" onclick="doDelete(${o.getUserID()})">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
                <div class="action-buttons">
                <a href="load?action=loadCreateUser">Create a User</a>
            </div>
                </div>
                <%@include file="Footer.jsp" %>
    </body>
    <script type="text/javascript">
            function doDelete(ID) {
                window.event?.preventDefault(); 
                if (confirm("Are you sure want to delete user with ID = " + ID + "?")) {
                    window.location = "delete?UserID="+ID+"&action=deleteUser";
                }
            }
        </script>
</html>
