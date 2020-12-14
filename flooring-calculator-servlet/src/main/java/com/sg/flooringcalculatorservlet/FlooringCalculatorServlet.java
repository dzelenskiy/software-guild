package com.sg.flooringcalculatorservlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DZ
 */
@WebServlet(urlPatterns = {"/FlooringCalculatorServlet"})
public class FlooringCalculatorServlet extends HttpServlet {

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
            
            BigDecimal floorWidth = new BigDecimal(request.getParameter("floorWidth"));
            BigDecimal floorLength = new BigDecimal(request.getParameter("floorLength"));
            BigDecimal costPerSqFt = new BigDecimal(request.getParameter("costPerSqFt"));
            
            BigDecimal totalSqFt = floorWidth.multiply(floorLength);
            BigDecimal matCost = totalSqFt.multiply(costPerSqFt);
            
            BigDecimal labCostPerHour = new BigDecimal("86");          
            BigDecimal sqFtPerHour = new BigDecimal("20");
            BigDecimal hour = new BigDecimal("60");
            
            MathContext mc = MathContext.DECIMAL32;
            
            BigDecimal laborRatePerMin = sqFtPerHour.divide(hour, mc);
            BigDecimal laborTime = totalSqFt.divide(laborRatePerMin, mc);
            BigDecimal laborHour = laborTime.divide(hour, 2, RoundingMode.HALF_UP);
            BigDecimal quarter = new BigDecimal("4");
            BigDecimal laborQuarters = laborHour.multiply(quarter);
            BigDecimal labCostPerQuarter = labCostPerHour.divide(quarter, mc);
                                
            BigDecimal labCost = labCostPerQuarter.multiply(laborQuarters).setScale(2, RoundingMode.HALF_UP);
           
            BigDecimal total = matCost.add(labCost);
            
            request.setAttribute("totalSqFt", totalSqFt);
            request.setAttribute("costPerSqFt", costPerSqFt);
            request.setAttribute("laborHour", laborHour);
            request.setAttribute("labCost", labCost);
            request.setAttribute("total", total);
            
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
    
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
