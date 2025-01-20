<%-- 
    Document   : CreateRoute
    Created on : Sep 17, 2024, 3:56:44 PM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Route</title>
        <link rel="stylesheet" href="StyleForm.css">
        <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
        <style>
        .error-message {
            color: red;
            font-size: 0.9em;
        }
    </style>
    </head>
    <body>
        <c:if test="${sessionScope.currentUser.getRoleID() == null}">
            <c:redirect url="AccessDenied.jsp" />
        </c:if>
        <%@include file="Header.jsp" %>
        <div class="form-containter">
            <div class="form-box">
                <h2>Create Route</h2>  
        <form action="create" method="post">
            <input type="hidden" name="action" value="createRoute">
            
            
                    <div class="input-group">
                        <label>Route Name: </label>
                        <input type="text" name="RouteName">
                     </div>
                    
                    <div class="input-group">
                        <label>Start Point</label>
                        <input type="text" name="StartPoint">
                     </div>
                    
                    <div class="input-group">
                        <label>End Point</label>
                        <input type="text" name="EndPoint">
                     </div>
                    
                    <div class="input-group">
                        <label>Start Time</label>
                        <input type="text" name="StartTime">
                     </div>
                    
                    <div class="input-group">
                        <label>End Time</label>
                        <input type="text" name="EndTime">
                     </div>
                    
                    <div class="input-group">
                        <label>Frequency (phut/ chuyen)</label>
                        <input type="number" name="Frequency">
                     </div>
                    
                    <div class="input-group">
                        <h2>Intermediate Station</h2>
                        
                     </div>
            <c:forEach items="${listStop}" var="o">
                <div class="input-group">
                    <label>${o.getStopName()}</label>
                    <input type="number" name="listOrder" value="" min="1" onchange="updateOrder()"   >

                </div>
            </c:forEach>
                    <div class="button-container">
                        <button type="submit">Create</button>
                     </div>
                
                    
        </form>
                </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
    <script>
//        function updateOrder() {
//    const inputs = document.querySelectorAll('input[name="listOrder"]');
//    const enteredNumbers = new Set(); 
//    const validNumbers = []; 
//
//    inputs.forEach(input => {
//        const value = parseInt(input.value, 10); 
//
//        if (!isNaN(value) && value > 0) {
//            if (enteredNumbers.has(value)) {
//                input.value = ''; 
//                alert(`Value ${value} duplicated, input again`); 
//            } else {
//                enteredNumbers.add(value);
//                validNumbers.push(value);
//            }
//        } else {
//            input.value = ''; 
//        }
//    });
//    // Update values for inputs that are empty
//    inputs.forEach((input, index) => {
//        if (input.value === '-') {
//            for (let i = index + 1; i < inputs.length; i++) {
//                const nextValue = parseInt(inputs[i].value, 10);
//                if (!isNaN(nextValue)) {
//                    inputs[i].value = nextValue - 1; // Decrease by 1
//                }
//            }
//        }
//
//    validNumbers.sort((a, b) => a - b); 
//    validNumbers.forEach((num, index) => {
//        inputs[index].value = index + 1; 
//    });
//
//    
//    });
//}

    
</script>
</html>
