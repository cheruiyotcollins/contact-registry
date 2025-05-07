/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.controller;

/**
 *
 * @author cheruiyotkelvincollins
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zurion.contactregistry.dao.ContactDAO;
import com.zurion.contactregistry.model.Contact;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;

public class UpdateContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the updated contact information from the form
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Create the contact object with the updated data
        Contact contact = new Contact(id, firstName, lastName, email, phone);

        // Update the contact in the database
        ContactDAO contactDAO = new ContactDAO();
        boolean isUpdated = contactDAO.updateContact(contact);

        // Redirect to the contact list page or show an error message if the update failed
        if (isUpdated) {
            response.sendRedirect("ContactListServlet");
        } else {
            // Display an error message or redirect to an error page
            request.setAttribute("errorMessage", "Failed to update contact");
            RequestDispatcher dispatcher = request.getRequestDispatcher("editContact.jsp");
            dispatcher.forward(request, response);
        }
    }
}

