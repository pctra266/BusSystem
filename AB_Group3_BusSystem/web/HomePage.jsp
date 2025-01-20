<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Bus System</title>
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

        </style>
    </head>
    <body>
        
        <%@include file="Header.jsp" %>
        <div class="container">
            <!-- Filter Form -->
            <form class="filter-form" action="load" method="post">
                <label >From: </label>
                <select class="form-control"  name="StopID1">
                    <c:forEach items="${listBS}" var="o">
                        <option value="${o.getStopID()}" ${o.getStopID()==StopID1?"selected":""}>${o.getStopName()}</option>
                    </c:forEach>
                </select>

                <label >To:</label>
                <!--<select id="category" name="category">-->
                <select class="form-control"  name="StopID2">
                    <c:forEach items="${listBS}" var="o">
                        <option value="${o.getStopID()}" ${o.getStopID()==StopID2?"selected":""}>${o.getStopName()}</option>
                    </c:forEach>
                </select>

                <button type="submit" >Search</button>
            </form>

            <!-- Table -->
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Route Name</th>
                        <th>Start Point</th>
                        <th>Intermediate Station</th>
                        <th>End Point</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Frequency</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listR}" var="o">
                        <tr>
                            <td>${o.getRouteName()}</td>
                            <td>${o.getStartPoint()}</td>
                            <td>${o.getIntermediateStation()}</td>
                            <td>${o.getEndPoint()}</td>
                            <td>${o.getStartTime()}</td>
                            <td>${o.getEndTime()}</td>
                            <td>${o.getFrequency()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
