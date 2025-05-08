<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome - Contact Registry</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f7fa;
            margin: 0;
            padding: 0;
            color: #333;
        }
        
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        
        header {
            background-color: #2c3e50;
            color: white;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        
        h1 {
            margin: 0;
            font-size: 2.5rem;
        }
        
        .subtitle {
            font-size: 1.2rem;
            opacity: 0.9;
            margin-top: 10px;
        }
        
        .main-content {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 40px 20px;
        }
        
        .features {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin: 40px 0;
            width: 100%;
        }
        
        .feature-card {
            background: white;
            border-radius: 8px;
            padding: 25px;
            width: 250px;
            margin: 15px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            text-align: center;
            transition: transform 0.3s ease;
        }
        
        .feature-card:hover {
            transform: translateY(-5px);
        }
        
        .feature-icon {
            font-size: 2.5rem;
            color: #3498db;
            margin-bottom: 15px;
        }
        
        .feature-title {
            font-size: 1.3rem;
            margin-bottom: 10px;
            color: #2c3e50;
        }
        
        .action-buttons {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            margin-top: 30px;
        }
        
        .btn {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            padding: 12px 28px;
            text-decoration: none;
            border-radius: 6px;
            font-weight: 600;
            transition: all 0.3s ease;
            min-width: 180px;
        }
        
        .btn-primary {
            background-color: #3498db;
            color: white;
        }
        
        .btn-secondary {
            background-color: #2ecc71;
            color: white;
        }
        
        .btn-tertiary {
            background-color: #e74c3c;
            color: white;
        }
        
        .btn-outline {
            background-color: transparent;
            border: 2px solid #3498db;
            color: #3498db;
        }
        
        .btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        
        .btn-primary:hover {
            background-color: #2980b9;
        }
        
        .btn-secondary:hover {
            background-color: #27ae60;
        }
        
        .btn-tertiary:hover {
            background-color: #c0392b;
        }
        
        .btn-outline:hover {
            background-color: #3498db;
            color: white;
        }
        
        .btn i {
            margin-right: 8px;
        }
        
        footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 20px 0;
            margin-top: 50px;
        }
        
        .stats {
            display: flex;
            justify-content: space-around;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            width: 80%;
            max-width: 800px;
            margin: 30px auto;
        }
        
        .stat-item {
            text-align: center;
        }
        
        .stat-number {
            font-size: 2rem;
            font-weight: bold;
            color: #3498db;
        }
        
        .stat-label {
            font-size: 0.9rem;
            color: #7f8c8d;
        }
        
        @media (max-width: 768px) {
            .features {
                flex-direction: column;
                align-items: center;
            }
            
            .stats {
                flex-direction: column;
                gap: 20px;
            }
        }
    </style>
</head>
<body>
     <jsp:include page="/jsp/includes/navbar.jsp" />
    <header>
        <div class="container">
            <h1>Contact Registry System</h1>
            <p class="subtitle">Efficiently manage all your contacts in one place</p>
        </div>
    </header>
    
    <div class="main-content">
        <div class="stats">
            <div class="stat-item">
                <div class="stat-number">${totalContacts}</div>
                <div class="stat-label">Total Contacts</div>
            </div>
            <div class="stat-item">
                <div class="stat-number">${recentAdded}</div>
                <div class="stat-label">Added This Week</div>
            </div>
            <div class="stat-item">
                <div class="stat-number">${activeUsers}</div>
                <div class="stat-label">Active Users</div>
            </div>
        </div>
        
        <div class="features">
            <div class="feature-card">
                <div class="feature-icon">
                    <i class="fas fa-user-plus"></i>
                </div>
                <h3 class="feature-title">Add Contacts</h3>
                <p>Quickly add new contacts with all necessary details including phone, email, and address.</p>
            </div>
            
            <div class="feature-card">
                <div class="feature-icon">
                    <i class="fas fa-users"></i>
                </div>
                <h3 class="feature-title">Manage Contacts</h3>
                <p>View, edit, and organize your contacts with our intuitive interface.</p>
            </div>
            
            <div class="feature-card">
                <div class="feature-icon">
                    <i class="fas fa-chart-bar"></i>
                </div>
                <h3 class="feature-title">Analytics</h3>
                <p>Get insights with visual dashboards showing your contact distribution and activity.</p>
            </div>
            
            <div class="feature-card">
                <div class="feature-icon">
                    <i class="fas fa-file-export"></i>
                </div>
                <h3 class="feature-title">Reports</h3>
                <p>Generate and export detailed reports in multiple formats for your records.</p>
            </div>
        </div>
        
        <div class="action-buttons">
            <a href="jsp/contactForm.jsp" class="btn btn-primary">
                <i class="fas fa-plus"></i> Add New Contact
            </a>
            <a href="listContacts" class="btn btn-secondary">
                <i class="fas fa-list"></i> View Contacts
            </a>
            <a href="dashboard" class="btn btn-outline">
                <i class="fas fa-chart-pie"></i> Dashboard
            </a>
            <a href="report" class="btn btn-tertiary">
                <i class="fas fa-file-pdf"></i> Generate Report
            </a>
        </div>
    </div>
    
    <footer>
        <div class="container">
            <p>&copy; 2023 Contact Registry System. All rights reserved.</p>
            <p>Need help? <a href="mailto:support@contactregistry.com" style="color: #3498db;">Contact our support team</a></p>
        </div>
    </footer>
</body>
</html>