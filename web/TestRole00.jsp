<%-- 
    Document   : TestRole00
    Created on : Sep 9, 2024, 7:31:06 AM
    Author     : Tra Pham
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bus Management</title>
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
        <c:if test="${sessionScope.currentUser.getRoleID() == null}">
            <c:redirect url="AccessDenied.jsp" />
        </c:if>
        <%@include file="Header.jsp" %>
        <div class="container">
            <h2>List Bus</h2>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>BusID </th>
                        <th>BusNumber</th>
                        <th>Route Name</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listB}" var="o">
                        <tr>
                            <td>${o.getBusID()}</td>
                            <td>${o.getBusNumber()}</td>
                            <td>${o.getRouteName()}</td>
                            <td><a href="load?BusID=${o.getBusID()}&action=loadUpdateBus">Update</a></td>
                            <td><a href="#" onclick="doDelete(${o.getBusID()}, 'deleteBus')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="action-buttons">
                <a href="load?action=loadCreateBus">Create a bus</a>
            </div>


            <h2>List Route</h2>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Route ID</th>
                        <th>Route Name</th>
                        <th>Start Point</th>
                        <th>Intermediate Station</th>
                        <th>End Point</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Frequency</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listR}" var="o">
                        <tr>
                            <td>${o.getRouteID()}</td>
                            <td>${o.getRouteName()}</td>
                            <td>${o.getStartPoint()}</td>
                            <td>${o.getIntermediateStation()}</td>
                            <td>${o.getEndPoint()}</td>
                            <td>${o.getStartTime()}</td>
                            <td>${o.getEndTime()}</td>
                            <td>${o.getFrequency()}</td>
                            <td><a href="load?RouteID=${o.getRouteID()}&action=loadUpdateRoute">Update</a></td>
                            <td><a href="#" onclick="doDelete(${o.getRouteID()}, 'deleteRoute')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="action-buttons">
                <a href="load?action=loadCreateRoute">Create a route</a>
            </div>


            <h2> List Stop</h2>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Stop ID</th>
                        <th>Stop Name</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listStop}" var="o">
                        <tr>
                            <td>${o.getStopID()}</td>
                            <td>${o.getStopName()}</td>
                            <td><a href="load?StopID=${o.getStopID()}&action=loadUpdateStop">Update</a></td>
                            <td><a href="#" onclick="doDelete(${o.getStopID()}, 'deleteStop')">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="action-buttons">
                <a href="load?action=loadCreateStop">Create a Stop</a>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
    <script type="text/javascript">
        function doDelete(ID, action) {
            window.event?.preventDefault(); 
            var paramID;
            switch (action) {
                case "deleteBus":
                    paramID = "BusID";
                    break;
                case "deleteRoute":
                    paramID = "RouteID";
                    break;
                case "deleteStop":
                    paramID = "StopID";
                    break;
                default :
                    break;
            }
            if (confirm("Are you sure you want to delete this " + action.replace('delete', '').toLowerCase() + " with ID= " + ID + "?")) {
                window.location = "delete?" + paramID + "=" + ID + "&action=" + action;
            }
        }
    </script>
</html>
