/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.dao;

/**
 *
 * @author cheruiyotkelvincollins
 */

import com.zurion.contactregistry.model.Contact;
import com.zurion.contactregistry.utils.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

package com.contactregistry.dao;

import com.contactregistry.models.Contact;
import com.contactregistry.utils.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

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

    public void updateContact(Contact contact) {
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

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
}
