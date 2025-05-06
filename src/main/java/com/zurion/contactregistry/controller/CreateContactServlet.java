/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

import com.zurion.contactregistry.dao.ContactDAO;
import com.zurion.contactregistry.model.Contact;

@WebServlet("/createContact")
public class CreateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Contact contact = new Contact(
            request.getParameter("fullName"),
            request.getParameter("phone"),
            request.getParameter("email"),
            request.getParameter("idNumber"),
            LocalDate.parse(request.getParameter("dob")),
            request.getParameter("gender"),
            request.getParameter("county")
        );

        ContactDAO dao = new ContactDAO();
        dao.insertContact(contact);

        response.sendRedirect("contactList.jsp");
    }
}
