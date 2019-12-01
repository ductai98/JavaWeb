/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connector.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.LoaiSanPham;

/**
 *
 * @author ronin
 */
public class LoaiSanPhamDAO {
    public ArrayList<LoaiSanPham> getDanhSachLoaiSanPham()
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "SELECT * FROM `loaisanpham`";
        ArrayList<LoaiSanPham> listLoaiSanPham = new ArrayList<>();
        
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next() == true)
            {
                LoaiSanPham loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                loaiSanPham.setTenLoaiSanPham(resultSet.getString("TenLoaiSanPham"));
                
                listLoaiSanPham.add(loaiSanPham);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLoaiSanPham;
    }
    
    public LoaiSanPham getLoaiSanPham(String maloaisp)
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "SELECT * FROM loaisanpham WHERE loaisanpham.MaLoaiSanPham =" + maloaisp;
        LoaiSanPham loaiSanPham = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next() == true)
            {
                loaiSanPham = new LoaiSanPham();
                loaiSanPham.setMaLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                loaiSanPham.setTenLoaiSanPham(resultSet.getString("TenLoaiSanPham"));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiSanPham;
    }
    
    public void themLoaiSanPham(LoaiSanPham loaiSanPham)
    {
        Connection connection = DBConnector.getConnection();
        String maloaisp = loaiSanPham.getMaLoaiSanPham();
        String tenloaisp = loaiSanPham.getTenLoaiSanPham();
        String sqlQuerry = "INSERT INTO loaisanpham VALUES(" + maloaisp + "," + "'" + tenloaisp + "')";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void suaLoaiSanPham(LoaiSanPham loaiSanPham)
    {
        Connection connection = DBConnector.getConnection();
        String maloaisp = loaiSanPham.getMaLoaiSanPham();
        String tenloaisp = loaiSanPham.getTenLoaiSanPham();
        String sqlQuerry = "UPDATE loaisanpham SET MaLoaiSanPham =" + maloaisp + ","
                + "TenLoaiSanPham =" + "'" + tenloaisp + "'" + "WHERE MaLoaiSanPham =" + maloaisp;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void xoaLoaiSanPham(String maloaisp)
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "DELETE FROM loaisanpham WHERE MaLoaiSanPham =" + maloaisp;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
