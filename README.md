
# Contact Registry Web App & APIs

This project is a Java-based web application that allows users to catalog contact details, including personal information such as full names, phone numbers, email addresses, ID numbers, dates of birth, gender, and county of residence. The app supports basic CRUD operations and features an admin dashboard with graphical stats. Additionally, users can generate a printable report of contact details filtered by county of residence.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Admin Dashboard](#admin-dashboard)
- [Database Setup](#database-setup)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used
- **Backend:** Java Servlets, JSP (JavaServer Pages)
- **Framework:** Spring (optional)
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Build Tool:** Maven
- **Version Control:** Git
- **Server:** Apache Tomcat
- **Others:** jQuery, Bootstrap (optional), React/Angular (optional)

## Installation

### Prerequisites:
- Linux OS (preferred)
- Apache NetBeans IDE (preferred)
- Apache Tomcat
- MySQL
- Git

### Steps to set up:
1. **Clone the repository:**
   ```bash
   git clone https://github.com/username/contact-registry-web-app.git
   Set up the Database:

2. **Create a MySQL database called contact_registry.**

Run the SQL script `database_setup.sql` to create the necessary tables.

```sql
CREATE DATABASE contact_registry;
USE contact_registry;

CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    id_number VARCHAR(20),
    dob DATE,
    gender VARCHAR(10),
    county_of_residence VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
3. **Set up the project in Apache NetBeans:**

Open Apache NetBeans and import the project as a new Maven project.

4. **Configure the project to use the Apache Tomcat server:**

In NetBeans, go to **Services > Servers**, register your Apache Tomcat instance, and assign it to this project.

5. **Configure Database Connection:**

Update the `db.properties` file with your MySQL connection details:

```properties
db.url=jdbc:mysql://localhost:3306/contact_registry
db.username=your_mysql_username
db.password=your_mysql_password
```
## API Endpoints

### Create Contact
- **Method:** `POST`
- **Endpoint:** `/api/contacts`
- **Request Body:**
```json
{
  "fullName": "John Doe",
  "phoneNumber": "1234567890",
  "email": "john.doe@example.com",
  "idNumber": "A1234567",
  "dob": "1990-01-01",
  "gender": "Male",
  "countyOfResidence": "Nairobi"
}
```
### Get All Contacts
- **Method:** 'GET'

### Update Contact
- **Method:** 'PUT'

- **Request Body:**

```json
{
"fullName": "John Doe Updated",
"phoneNumber": "0987654321",
"email": "john.doe.updated@example.com",
"idNumber": "A1234567",
"dob": "1990-01-01",
"gender": "Male",
"countyOfResidence": "Nairobi"
}
```
### Delete Contact
- **Method:** `DELETE`


### Get Contact Report (Filtered by County)
- **Method:** `GET`

## Admin Dashboard

The admin dashboard provides the following features:

- 📊 **Bar Chart:** Displays the number of users grouped by **Gender**.
- 📍 **Bar Chart:** Displays the number of users grouped by **County of Residence**.
- 🕵️ **Recent Contacts Table:** Lists the 5 most recently added contacts with the following details:
   - **Full Name**
   - **Phone Number**
   - **Email Address**
   - **County of Residence**


