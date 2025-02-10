<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Access Denied</title>
        <link rel="stylesheet" href="StyleForm.css">
        <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">
        <style>
            /* Button Container */
            .button-container {
                display: flex;
                justify-content: space-around;
                gap: 20px;
            }

            .button-container a {
                text-decoration: none;
                padding: 12px 20px;
                background-color: #00ca4c;
                color: #fff;
                border-radius: 8px;
                font-size: 16px;
                transition: background-color 0.3s ease;
                flex: 1;
            }

            .button-container a:hover {
                background-color: #009e3c;
            }

            .button-container a {
                background-color: #00ca4c;
            }

        </style>
    </head>
    <body>
        <div class="form-containter">
            <div class="form-box">
                <h2>ERROR</h2>
                <p>YOU DO NOT HAVE PERMISSION TO ACCESS THIS PAGE!
                    IT MAY BE BECAUSE YOU ARE TRYING TO ACCESS AN UNAUTHORIZED ADDRESS,
                    OR YOUR LOGIN SESSION HAS EXPIRED.</p>
                <div class="button-container">
                    <a href="load">Back Home</a>
                    <a href="login">Login</a>
                </div>
            </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
