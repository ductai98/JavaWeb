/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ronin
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/xoasanpham"})
public class DeleteProductServlet extends HttpServlet {

    
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masp = request.getParameter("masanpham");
        sanPhamDAO.xoaSanPham(masp);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/deleteproduct.jsp");
        rd.forward(request, response);
        
        response.sendRedirect(request.getContextPath() + "/quanlyloaisanpham");
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
        doGet(request, response);
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
