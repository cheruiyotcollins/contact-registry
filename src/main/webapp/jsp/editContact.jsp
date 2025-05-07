<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.zurion.contactregistry.model.Contact" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <h2>Edit Contact</h2>
    <form action="updateContact" method="post">
        <input type="hidden" name="id" value="${contact.id}">

        <label>Full Name:</label><br>
        <input type="text" name="fullName" value="${contact.fullName}" required><br><br>

        <label>Phone Number:</label><br>
        <input type="text" name="phone" value="${contact.phoneNumber}" required><br><br>

        <label>Email Address:</label><br>
        <input type="email" name="email" value="${contact.email}" required><br><br>

        <label>ID Number:</label><br>
        <input type="text" name="idNumber" value="${contact.idNumber}" required><br><br>

        <label>Date of Birth:</label><br>
        <input type="date" name="dob" value="${contact.dateOfBirth}" required><br><br>

       <label>Gender:</label><br>
<select name="gender" required>
    <option value="Male" ${'Male'.equals(contact.gender) ? 'selected' : ''}>Male</option>
    <option value="Female" ${'Female'.equals(contact.gender) ? 'selected' : ''}>Female</option>
    <option value="Other" ${'Other'.equals(contact.gender) ? 'selected' : ''}>Other</option>
</select><br><br>

        <label>County of Residence:</label><br>
        <input type="text" name="county" value="${contact.county}" required><br><br>

        <button type="submit">Update Contact</button>
    </form>
</body>
</html>
