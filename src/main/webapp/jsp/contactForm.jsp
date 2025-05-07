<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Form</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <h2>Add Contact</h2>
    <form action="createContact" method="post">
        <label>Full Name:</label><br>
        <input type="text" name="fullName" required><br><br>

        <label>Phone Number:</label><br>
        <input type="text" name="phone" required><br><br>

        <label>Email Address:</label><br>
        <input type="email" name="email" required><br><br>

        <label>ID Number:</label><br>
        <input type="text" name="idNumber" required><br><br>

        <label>Date of Birth:</label><br>
        <input type="date" name="dob" required><br><br>

        <label>Gender:</label><br>
        <select name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>

        <label>County of Residence:</label><br>
        <input type="text" name="county" required><br><br>

        <button type="submit">Save Contact</button>
    </form>
</body>
</html>
