<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zurion.contactregistry.model.Contact" %>
<%
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
    <h2>Contact List</h2>
    <a href="jsp/contactForm.jsp">Add New Contact</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>ID Number</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>County</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            if (contacts != null && !contacts.isEmpty()) {
                for (Contact contact : contacts) {
        %>
            <tr>
                <td><%= contact.getFullName() %></td>
                <td><%= contact.getPhoneNumber() %></td>
                <td><%= contact.getEmail() %></td>
                <td><%= contact.getIdNumber() %></td>
                <td><%= contact.getDateOfBirth() %></td>
                <td><%= contact.getGender() %></td>
                <td><%= contact.getCounty() %></td>
                <td>
                    <a href="editContact?id=<%= contact.getId() %>">Edit</a> |
                    <a href="deleteContact?id=<%= contact.getId() %>" onclick="return confirm('Are you sure you want to delete this contact?');">Delete</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="8">No contacts available.</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
