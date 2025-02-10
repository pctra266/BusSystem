<%-- 
    Document   : UpdateRoute
    Created on : Sep 19, 2024, 8:50:47 AM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import ="Model.Route" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Route</title>
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
                <h2>Update Route</h2>  
                <form action="update" method="post">
                    <input type="hidden" name="action" value="updateRoute">
                    
                    
                            <div class="input-group">
                                <label>Route ID: </label>
                                <input type="text" name="RouteID" value="${updateRoute.getRouteID()}" readonly="">
                             </div>
                            
                            <div class="input-group">
                                <label>Route Name: </label>
                                <input type="text" name="RouteName" value="${updateRoute.getRouteName()}">
                             </div>
                            
                            <div class="input-group">
                                <label>Start Point</label>
                                <input type="text" name="StartPoint" value="${updateRoute.getStartPoint()}">
                             </div>
                            
                            <div class="input-group">
                                <label>End Point</label>
                                <input type="text" name="EndPoint" value="${updateRoute.getEndPoint()}">
                             </div>
                            
                            <div class="input-group">
                                <label>Start Time</label>
                                <input type="text" name="StartTime" value="${updateRoute.getStartTime()}">
                             </div>
                            
                            <div class="input-group">
                                <label>End Time</label>
                                <input type="text" name="EndTime" value="${updateRoute.getEndTime()}">
                             </div>
                            
                            <div class="input-group">
                                <label>Frequency (minute frequency)</label>
                                <input type="text" name="Frequency" value="${updateRoute.getFrequency()}">
                             </div>
                            <div class="input-group">
                                <h2>Intermediate Station</h2>

                             </div>


                            <c:forEach items="${listStopHasOrder}" var="o">
                                <div class="input-group">
                                    <label>${o.getStopName()}</label>
                                    <input type="number" name="listOrder"  value="${o.getStopOrder()==0?"":o.getStopOrder()}"   > 
                                </div>
                            </c:forEach>

                            <div class="button-container">
                                <button type="submit">Update</button>
                            </div>
                            
                        
                </form>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
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
    </body>
</html>
