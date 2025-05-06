CREATE DATABASE contact_registry;

USE contact_registry;

CREATE TABLE contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100),
    phone_number VARCHAR(20),
    email VARCHAR(100),
    id_number VARCHAR(50),
    date_of_birth DATE,
    gender ENUM('MALE', 'FEMALE', 'OTHER'),
    county VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
