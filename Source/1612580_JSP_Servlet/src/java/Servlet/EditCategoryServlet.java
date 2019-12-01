/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LoaiSanPhamDAO;
import Model.LoaiSanPham;
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
@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/sualoaisanpham"})
public class EditCategoryServlet extends HttpServlet {

    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maloai = request.getParameter("maloai");
        LoaiSanPham item = loaiSanPhamDAO.getLoaiSanPham(maloai);
        request.setAttribute("item", item);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editcategory.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maloai = request.getParameter("id");
        String name = request.getParameter("name");
        LoaiSanPham loaiSanPham = new LoaiSanPham(maloai, name);
        loaiSanPhamDAO.suaLoaiSanPham(loaiSanPham);
        
        response.sendRedirect(request.getContextPath() + "/quanlyloaisanpham");
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
