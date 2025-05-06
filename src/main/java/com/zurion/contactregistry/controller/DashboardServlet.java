/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zurion.contactregistry.controller;

/**
 *
 * @author cheruiyotkelvincollins
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import com.zurion.contactregistry.dao.ContactDAO;
import java.sql.SQLException;
import javax.servlet.ServletException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDAO dao = new ContactDAO();
        try {
            request.setAttribute("genderStats", dao.getGenderStats());
            request.setAttribute("countyStats", dao.getCountyStats());
            request.setAttribute("recentContacts", dao.getRecentContacts(5));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/dashboard.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

