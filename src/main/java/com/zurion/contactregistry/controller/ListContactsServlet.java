/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.controller;

/**
 *
 * @author cheruiyotkelvincollins
 */

import com.zurion.contactregistry.dao.ContactDAO;
import com.zurion.contactregistry.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListContactsServlet extends HttpServlet {

    private ContactDAO contactDAO;

    @Override
    public void init() throws ServletException {
        contactDAO = new ContactDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Contact> contactList = contactDAO.getAllContacts();
        request.setAttribute("contactList", contactList);
        request.getRequestDispatcher("jsp/contactList.jsp").forward(request, response);
    }
}
