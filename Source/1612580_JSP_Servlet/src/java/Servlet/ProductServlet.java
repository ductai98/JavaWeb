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
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    String maloaisp = null;
    ArrayList<SanPham> sanPhamList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("timkiem") != null)
        {
            String tensp = request.getParameter("timkiem");
            System.out.println("Ten san pham: " + tensp);
            sanPhamList = sanPhamDAO.timSanPham(tensp);
            request.setAttribute("sanPhamList", sanPhamList);
            request.getRequestDispatcher("/products.jsp").include(request, response);
            return;
        }
        maloaisp = request.getParameter("maloai");
        sanPhamList = sanPhamDAO.getSanPhamTheoLoaiSanPham(maloaisp);
        request.setAttribute("sanPhamList", sanPhamList);
        System.out.println(sanPhamList.get(0).getHinhSanPham());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/products.jsp");
        rd.include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("tangdan") != null)
        {
            System.out.println("Chạy tăng dần");
            Collections.sort(sanPhamList);
            request.setAttribute("sanPhamList", sanPhamList);
            request.getRequestDispatcher("/products.jsp").include(request, response);
        }
        
        if(request.getParameter("giamdan") != null)
        {
            Collections.sort(sanPhamList, Collections.reverseOrder());
            request.setAttribute("sanPhamList", sanPhamList);
            request.getRequestDispatcher("/products.jsp").include(request, response);
        }
                
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
