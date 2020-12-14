/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatorservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DZ
 */
@WebServlet(name = "InterestCalculatorServlet", urlPatterns = {"/InterestCalculatorServlet"})
public class InterestCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            BigDecimal investment = new BigDecimal(request.getParameter("investment"));
            BigDecimal annualInterest = new BigDecimal(request.getParameter("interest"));
            int yearsToInvest = Integer.parseInt(request.getParameter("years"));
            
            int interestCompound;
            int yearCount = 0;
            BigDecimal beginPrincipal;
            BigDecimal endPrincipal;
            BigDecimal interestEarned;

            beginPrincipal = invest;
            
            for (int i = 0; i < yearsToInvest; i++) {
                yearCount++;
                interestEarned = beginPrincipal.multiply(annInter);
                endPrincipal = beginPrincipal.add(interestEarned);
                view.printYearResult(yearCount, beginPrincipal.setScale(2, RoundingMode.HALF_DOWN),
                        interestEarned.setScale(2, RoundingMode.HALF_DOWN), endPrincipal.setScale(2, RoundingMode.HALF_DOWN));
                beginPrincipal = endPrincipal;
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
