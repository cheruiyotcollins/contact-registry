<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome - Contact Registry</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            padding-top: 50px;
        }
        h1 {
            margin-bottom: 40px;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 12px 24px;
            text-decoration: none;
            background-color: #007BFF;
            color: white;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Contact Registry</h1>

    <a href="jsp/contactForm.jsp">Add New Contact</a>
    <a href="listContacts">Contact List</a>
    <a href="dashboard">Dashboard</a>
    <a href="report">Generate Report</a>
</body>
</html>
