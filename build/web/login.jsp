<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="StyleForm.css">
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
    </style>
</head>
   
<body>
    
    <%@include file="Header.jsp" %>
    <div class="form-containter">
        <div class="form-box">
            <h2>Login</h2>
            
            <form action="login" method="post">
                
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="use" required>
                </div>
                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="pass" required>
                </div>
                <div class="button-container">
                    <button type="submit">Login</button>
                </div>
                
            </form>
            <div class="message">${mess}</div>
        </div>
    </div>
    <%@include file="Footer.jsp" %>
</body>
</html>
