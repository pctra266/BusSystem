<%-- 
    Document   : NavBar
    Created on : Oct 8, 2024, 11:27:06 AM
    Author     : Tra Pham
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
        
/* Navbar Styles */
.navbar {
    background-color:  #00ca4c;
    color: white;
    padding: 1em;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.navbar ul {
    list-style: none;
    display: flex;
}

.navbar ul li {
    margin-left: 1em;
}

.navbar ul li a {
    color: white;
    text-decoration: none;
}
          

.nav-item .nav-link {
    padding: 1.6em 1em;
    font-size: 12px;
    text-transform: uppercase;
    letter-spacing: .1em;
    font-weight: 400;
}
.nav-item .nav-link.active {
    color: #fff;
    font-weight: 400;
}
.brand {
    text-transform: uppercase;
    text-decoration: none;
    letter-spacing: .3em;
    color: white;
    font-size: 20px;
}
    </style>
    </head>
    
    <body>
        <nav class="navbar">
            <a class="brand" href="load">brand</a>

            <ul>
                <li class="nav-item "><a class="nav-link" href="load">Home</a></li>
                
                <c:if test="${sessionScope.currentUser.getRoleID() != null}">
                    <li class="nav-item"><a class="nav-link" href="load?action=loadRole00">Bus Management</a></li>
                    </c:if>

                <c:if test="${sessionScope.currentUser.getRoleID() == 1}">
                    <li class="nav-item"><a class="nav-link" href="load?action=loadRole01">User Management</a></li>
                    </c:if>

                <c:if test="${sessionScope.currentUser == null}">
                    <li class="nav-item"><a class="nav-link" href="login">Login</a></li>
                    </c:if>
                    <c:if test="${sessionScope.currentUser != null}">
                    <li class="nav-item"><a class="nav-link" href="load?action=logout">Logout</a></li>
                    </c:if>
            </ul>
        </nav>
    </body>
</html>
