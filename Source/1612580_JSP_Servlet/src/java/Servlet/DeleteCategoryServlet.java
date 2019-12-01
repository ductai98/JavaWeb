/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LoaiSanPhamDAO;
import java.io.IOException;
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
@WebServlet(name = "DeleteCategoryServlet", urlPatterns = {"/xoaloaisanpham"})
public class DeleteCategoryServlet extends HttpServlet {

    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maloai = request.getParameter("maloai");
        loaiSanPhamDAO.xoaLoaiSanPham(maloai);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/deletecategory.jsp");
        rd.forward(request, response);
        
        response.sendRedirect(request.getContextPath() + "/quanlyloaisanpham");
    }

   
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
