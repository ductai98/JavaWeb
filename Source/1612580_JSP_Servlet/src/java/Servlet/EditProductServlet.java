/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import Model.LoaiSanPham;
import Model.SanPham;
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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/suasanpham"})
public class EditProductServlet extends HttpServlet {

    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masanpham = request.getParameter("masanpham");
        SanPham item = sanPhamDAO.getSanPham(masanpham);
        request.setAttribute("item", item);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editproduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String tensp = request.getParameter("tensp");
        String maloai = request.getParameter("maloai");
        String hinhanh = request.getParameter("hinhanh");
        Double giatien = Double.parseDouble(request.getParameter("giatien"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String nhasx = request.getParameter("nhasx");
        String xuatsu = request.getParameter("xuatsu");
        String mota = request.getParameter("mota");
        LoaiSanPham loaisp = loaiSanPhamDAO.getLoaiSanPham(maloai);
        
        SanPham sanpham = new SanPham(id, tensp, hinhanh, giatien, soluong, nhasx, xuatsu, mota, loaisp);
        System.out.println("Xuất sứ: " + sanpham.getXuatXu());
        sanPhamDAO.suaSanPham(sanpham);
        response.sendRedirect(request.getContextPath() + "/quanlysanpham");
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
