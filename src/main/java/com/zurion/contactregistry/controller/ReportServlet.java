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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String county = request.getParameter("county");
        ContactDAO dao = new ContactDAO();
        try {
            List<Contact> results = dao.getContactsByCounty(county);
            request.setAttribute("results", results);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/report.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

