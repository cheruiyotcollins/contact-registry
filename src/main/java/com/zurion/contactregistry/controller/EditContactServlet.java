package com.zurion.contactregistry.controller;

import com.zurion.contactregistry.dao.ContactDAO;
import com.zurion.contactregistry.model.Contact;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editContact")
public class EditContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contactId = request.getParameter("id");

        if (contactId != null) {
            // Get the contact from the database using the contactId
            ContactDAO contactDAO = new ContactDAO();
            Contact contact = contactDAO.getContactById(Integer.parseInt(contactId));

            if (contact != null) {
                // Set the contact as a request attribute to be used in the JSP page
                request.setAttribute("contact", contact);
                RequestDispatcher dispatcher = request.getRequestDispatcher("editContact.jsp");
                dispatcher.forward(request, response);
            } else {
                // If contact is not found, redirect to the list page
                response.sendRedirect("ContactListServlet");
            }
        } else {
            // If no contactId is provided, redirect to the list page
            response.sendRedirect("ContactListServlet");
        }
    }
}
