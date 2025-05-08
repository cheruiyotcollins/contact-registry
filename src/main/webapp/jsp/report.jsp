<%@ page import="java.util.List" %>
<%@ page import="com.zurion.contactregistry.model.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
   
    <title>Contact Report</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <style>
        table, th, td {
            border: 1px solid #ccc;
            border-collapse: collapse;
            padding: 8px;
        }
    </style>
</head>
<body>
 <jsp:include page="/jsp/includes/navbar.jsp" />
<h2>Printable Contact Report</h2>

<form method="get" action="report">
    <label for="county">Filter by County:</label>
    <input type="text" id="county" name="county" required />
    <button type="submit">Generate Report</button>
    <button onclick="window.print(); return false;">Print</button>
</form>

<br/>

<%
    List<Contact> results = (List<Contact>) request.getAttribute("results");
    if (results != null && !results.isEmpty()) {
%>
    <table>
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>ID Number</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>County</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Contact c : results) {
        %>
            <tr>
                <td><%= c.getFullName() %></td>
                <td><%= c.getPhoneNumber()%></td>
                <td><%= c.getEmail() %></td>
                <td><%= c.getIdNumber() %></td>
                <td><%= c.getDateOfBirth() %></td>
                <td><%= c.getGender() %></td>
                <td><%= c.getCounty() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
<%
    } else if (request.getParameter("county") != null) {
%>
    <p>No contacts found for county: <strong><%= request.getParameter("county") %></strong></p>
<%
    }
%>

</body>
</html>
