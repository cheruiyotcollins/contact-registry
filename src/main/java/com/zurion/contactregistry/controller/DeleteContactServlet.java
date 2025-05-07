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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactIdParam = request.getParameter("contactId");
        
   
        if (contactIdParam != null && !contactIdParam.isEmpty()) {
            try {
                int contactId = Integer.parseInt(contactIdParam);
                
     
                ContactDAO contactDAO = new ContactDAO();
                contactDAO.deleteContact(contactId);

                response.sendRedirect("listContacts");  

            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid contact ID.");
            }
        } else {
            // If contactId is missing, send an error response
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Contact ID is required.");
        }
    }
}

