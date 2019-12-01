/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.SanPhamDAO;
import Model.SanPham;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/detail"})
public class ProductDetailServlet extends HttpServlet {

    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String masanpham = request.getParameter("masanpham");
        SanPham sanpham = sanPhamDAO.getThongTinChiTiet(masanpham);
        ArrayList<SanPham> sanPhamList = sanPhamDAO.getSanPhamCungLoai(sanpham.getMaLoaiSanPham().getMaLoaiSanPham());
        request.setAttribute("sanpham", sanpham);
        request.setAttribute("sanPhamList", sanPhamList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/product_detail.jsp");
        rd.include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
