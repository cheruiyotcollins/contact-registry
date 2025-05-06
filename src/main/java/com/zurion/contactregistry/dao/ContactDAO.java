package com.zurion.contactregistry.dao;

import com.zurion.contactregistry.model.Contact;
import com.zurion.contactregistry.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class ContactDAO {

    // Insert a new contact into the database
    public void insertContact(Contact contact) {
        String sql = "INSERT INTO contacts (full_name, phone_number, email, id_number, date_of_birth, gender, county) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getFullName());
            stmt.setString(2, contact.getPhoneNumber());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getIdNumber());
            stmt.setDate(5, Date.valueOf(contact.getDateOfBirth()));
            stmt.setString(6, contact.getGender());
            stmt.setString(7, contact.getCounty());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all contacts from the database
    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts ORDER BY created_at DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setFullName(rs.getString("full_name"));
                contact.setPhoneNumber(rs.getString("phone_number"));
                contact.setEmail(rs.getString("email"));
                contact.setIdNumber(rs.getString("id_number"));
                contact.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                contact.setGender(rs.getString("gender"));
                contact.setCounty(rs.getString("county"));

                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    // Get a contact by its ID
    public Contact getContactById(int id) {
        Contact contact = null;
        String sql = "SELECT * FROM contacts WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setFullName(rs.getString("full_name"));
                contact.setPhoneNumber(rs.getString("phone_number"));
                contact.setEmail(rs.getString("email"));
                contact.setIdNumber(rs.getString("id_number"));
                contact.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                contact.setGender(rs.getString("gender"));
                contact.setCounty(rs.getString("county"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }

    // Update a contact in the database
    public boolean updateContact(Contact contact) {
        boolean isUpdated = false;
        String sql = "UPDATE contacts SET full_name = ?, phone_number = ?, email = ?, id_number = ?, " +
                     "date_of_birth = ?, gender = ?, county = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getFullName());
            stmt.setString(2, contact.getPhoneNumber());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getIdNumber());
            stmt.setDate(5, Date.valueOf(contact.getDateOfBirth()));
            stmt.setString(6, contact.getGender());
            stmt.setString(7, contact.getCounty());
            stmt.setInt(8, contact.getId());

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    // Delete a contact from the database by ID
    public void deleteContact(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Map<String, Integer> getGenderStats() throws SQLException {
    Map<String, Integer> stats = new HashMap<>();
    String sql = "SELECT gender, COUNT(*) FROM contacts GROUP BY gender";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            stats.put(rs.getString(1), rs.getInt(2));
        }
    }
    return stats;
}

public Map<String, Integer> getCountyStats() throws SQLException {
    Map<String, Integer> stats = new HashMap<>();
    String sql = "SELECT county, COUNT(*) FROM contacts GROUP BY county";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            stats.put(rs.getString(1), rs.getInt(2));
        }
    }
    return stats;
}

public List<Contact> getRecentContacts(int limit) throws SQLException {
    List<Contact> list = new ArrayList<>();
    String sql = "SELECT * FROM contacts ORDER BY id DESC LIMIT ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, limit);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Contact c = new Contact( /* populate fields */ );
            list.add(c);
        }
    }
    return list;
}
public List<Contact> getContactsByCounty(String county) throws SQLException {
    List<Contact> list = new ArrayList<>();
    String sql = "SELECT * FROM contacts WHERE county = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, county);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Contact c = new Contact( /* populate fields */ );
            list.add(c);
        }
    }
    return list;
}

}
