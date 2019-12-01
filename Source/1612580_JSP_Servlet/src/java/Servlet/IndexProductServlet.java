/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import Model.SanPham;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
@WebServlet(name = "IndexProductServlet", urlPatterns = {"/quanlysanpham"})
public class IndexProductServlet extends HttpServlet {

    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    ArrayList<SanPham> listItem = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        listItem = sanPhamDAO.getDanhSachSanPham();
        System.out.println("Size: " + listItem.size());
        request.setAttribute("listItem", listItem);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexproduct.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("sapxeptheoten") != null)
        {
            Collections.sort(listItem, (SanPham o1, SanPham o2) -> o1.getTenSanPham().compareTo(o2.getTenSanPham()));
            request.setAttribute("listItem", listItem);
            request.getRequestDispatcher("/indexproduct.jsp").forward(request, response);
        }
        
        if(request.getParameter("sapxeptheoid") != null)
        {
            Collections.sort(listItem, (SanPham o1, SanPham o2) -> o1.getMaSanPham().compareTo(o2.getMaSanPham()));
            request.setAttribute("listItem", listItem);
            request.getRequestDispatcher("/indexproduct.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
