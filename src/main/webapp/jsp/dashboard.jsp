<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.zurion.contactregistry.model.Contact" %>
<%
    Map<String, Integer> genderStats = (Map<String, Integer>) request.getAttribute("genderStats");
    Map<String, Integer> countyStats = (Map<String, Integer>) request.getAttribute("countyStats");
    List<Contact> recentContacts = (List<Contact>) request.getAttribute("recentContacts");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
     <jsp:include page="/jsp/includes/navbar.jsp" />
    <h2>Admin Dashboard</h2>
    <div style="width: 45%; float: left;">
        <h3>Gender Distribution</h3>
        <canvas id="genderChart"></canvas>
    </div>

    <div style="width: 50%; float: right;">
        <h3>County Distribution</h3>
        <canvas id="countyChart"></canvas>
    </div>

    <div style="clear: both; padding-top: 40px;">
        <h3>Recently Added Contacts</h3>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>County</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (recentContacts != null && !recentContacts.isEmpty()) {
                    for (Contact c : recentContacts) {
            %>
                <tr>
                    <td><%= c.getFullName() %></td>
                    <td><%= c.getEmail() %></td>
                    <td><%= c.getPhoneNumber() %></td>
                    <td><%= c.getCounty() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="4">No recent contacts available.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <script>
        const genderChart = new Chart(document.getElementById('genderChart'), {
            type: 'pie',
            data: {
                labels: [<%= genderStats != null ? "\"" + String.join("\",\"", genderStats.keySet()) + "\"" : "" %>],
                datasets: [{
                    label: 'Gender',
                    data: [<%= genderStats != null ? genderStats.values().stream().map(String::valueOf).reduce((a, b) -> a + "," + b).orElse("") : "" %>],
                    backgroundColor: ['#36A2EB', '#FF6384', '#FFCE56'],
                    borderWidth: 1
                }]
            }
        });

        const countyChart = new Chart(document.getElementById('countyChart'), {
            type: 'bar',
            data: {
                labels: [<%= countyStats != null ? "\"" + String.join("\",\"", countyStats.keySet()) + "\"" : "" %>],
                datasets: [{
                    label: 'Contacts per County',
                    data: [<%= countyStats != null ? countyStats.values().stream().map(String::valueOf).reduce((a, b) -> a + "," + b).orElse("") : "" %>],
                    backgroundColor: '#42a5f5',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: { beginAtZero: true }
                }
            }
        });
    </script>
</body>
</html>
