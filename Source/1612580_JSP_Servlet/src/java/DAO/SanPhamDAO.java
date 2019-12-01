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
import Model.SanPham;

/**
 *
 * @author ronin
 */
public class SanPhamDAO {
    
    public ArrayList<SanPham> getSanPhamTheoLoaiSanPham(String maloaisp)
    {
        Connection connection = DBConnector.getConnection();
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        if(maloaisp==null)
        {
            String sqlQuerry1 = "SELECT * FROM sanpham ORDER BY MaSanPham DESC LIMIT 10";
            try {
                PreparedStatement statement = connection.prepareStatement(sqlQuerry1);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next() == true) 
                {                    
                    SanPham sanPham = new SanPham();
                    sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                    sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                    sanPham.setGiaTien(resultSet.getDouble("GiaTien"));
                    sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                    sanPham.setSoLuong(resultSet.getInt("SoLuong"));
                    sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                    sanPham.setXuatXu(resultSet.getString("XuatXu"));
                    sanPham.setMoTa(resultSet.getString("MoTa"));
                    LoaiSanPhamDAO loaispDAO = new LoaiSanPhamDAO();
                    LoaiSanPham loaisp = loaispDAO.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                    sanPham.setMaLoaiSanPham(loaisp);
                    listSanPham.add(sanPham);
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listSanPham;
        }
        String sqlQuerry = "SELECT * FROM sanpham WHERE MaLoaiSanPham='" + maloaisp + "'" + " ORDER BY TenSanPham ASC";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next() == true)
            {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setGiaTien(resultSet.getDouble("GiaTien"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setSoLuong(resultSet.getInt("SoLuong"));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO loaispDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = loaispDAO.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
                listSanPham.add(sanPham);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPham;
    }
    
    public ArrayList<SanPham> getSanPhamCungLoai(String maloaisp)
    {
        Connection connection = DBConnector.getConnection();
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String sqlQuerry = "SELECT * FROM sanpham WHERE MaLoaiSanPham='" + maloaisp + "'" + " ORDER BY RAND() LIMIT 5";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next() == true) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setGiaTien(resultSet.getDouble("GiaTien"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setSoLuong(resultSet.getInt("SoLuong"));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO loaispDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = loaispDAO.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
                listSanPham.add(sanPham);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPham;
    }
    
    public SanPham getThongTinChiTiet(String masanpham)
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "SELECT * FROM sanpham WHERE MaSanPham='" + masanpham + "'";
        SanPham sanPham = new SanPham();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()== true) {
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setGiaTien(resultSet.getDouble("GiaTien"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setSoLuong(resultSet.getInt("SoLuong"));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO loaispDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = loaispDAO.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPham;
    }
    
    public ArrayList<SanPham> getDanhSachSanPham()
    {
        Connection connection = DBConnector.getConnection();
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String sqlQuerry = "SELECT * FROM sanpham";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next() == true)
            {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setGiaTien(resultSet.getDouble("GiaTien"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setSoLuong(resultSet.getInt("SoLuong"));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO loaispDAO = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = loaispDAO.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
                listSanPham.add(sanPham);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSanPham;
    }
    
    public SanPham getSanPham(String masp)
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "SELECT * FROM sanpham WHERE sanpham.MaSanPham =" + masp;
        SanPham sanPham = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next() == true)
            {
                sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setGiaTien(Double.parseDouble(resultSet.getString("GiaTien")));
                sanPham.setSoLuong(Integer.parseInt(resultSet.getString("SoLuong")));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = dao.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sanPham;
    }
    
    public ArrayList<SanPham> timSanPham(String tensp) {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "SELECT * FROM sanpham WHERE sanpham.TenSanPham LIKE '%" + tensp + "%'";
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next() == true) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getString("MaSanPham"));
                sanPham.setTenSanPham(resultSet.getString("TenSanPham"));
                sanPham.setHinhSanPham(resultSet.getString("HinhSanPham"));
                sanPham.setGiaTien(Double.parseDouble(resultSet.getString("GiaTien")));
                sanPham.setSoLuong(Integer.parseInt(resultSet.getString("SoLuong")));
                sanPham.setNhaSanXuat(resultSet.getString("NhaSanXuat"));
                sanPham.setXuatXu(resultSet.getString("XuatXu"));
                sanPham.setMoTa(resultSet.getString("MoTa"));
                LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
                LoaiSanPham loaisp = dao.getLoaiSanPham(resultSet.getString("MaLoaiSanPham"));
                sanPham.setMaLoaiSanPham(loaisp);
                listSanPham.add(sanPham);
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listSanPham;
    }
    
    public void themSanPham(SanPham sanPham)
    {
        Connection connection = DBConnector.getConnection();
        String masanpham = sanPham.getMaSanPham();
        String tensanpham = sanPham.getTenSanPham();
        String hinhsp = sanPham.getHinhSanPham();
        Double giatien = sanPham.getGiaTien();
        int soluong = sanPham.getSoLuong();
        String nhasx = sanPham.getNhaSanXuat();
        String xuatxu = sanPham.getXuatXu();
        String mota = sanPham.getMoTa();
        String maloaisp = sanPham.getMaLoaiSanPham().getMaLoaiSanPham();

        String sqlQuerry = "INSERT INTO sanpham VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            statement.setString(1, masanpham);
            statement.setString(2, tensanpham);
            statement.setString(3,maloaisp);
            statement.setString(4,hinhsp);
            statement.setDouble(5,giatien);
            statement.setInt(6, soluong);
            statement.setString(7,nhasx);
            statement.setString(8,xuatxu);
            statement.setString(9,mota);
            
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void suaSanPham(SanPham sanPham)
    {
        Connection connection = DBConnector.getConnection();
        String masanpham = sanPham.getMaSanPham();
        String tensanpham = sanPham.getTenSanPham();
        String hinhsp = sanPham.getHinhSanPham();
        Double giatien = sanPham.getGiaTien();
        int soluong = sanPham.getSoLuong();
        String nhasx = sanPham.getNhaSanXuat();
        String xuatxu = sanPham.getXuatXu();
        String mota = sanPham.getMoTa();
        String maloaisp = sanPham.getMaLoaiSanPham().getMaLoaiSanPham();
        
        String sqlQuery = "UPDATE sanpham SET MaSanPham = ?, TenSanPham = ?, MaLoaiSanPham = ?, HinhSanPham = ?, GiaTien = ?,"
                + "SoLuong = ?, NhaSanXuat = ?, XuatXu = ?, MoTa = ? WHERE MaSanPham = "+ masanpham;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, masanpham);
            statement.setString(2, tensanpham);
            statement.setString(3,maloaisp);
            statement.setString(4,hinhsp);
            statement.setDouble(5,giatien);
            statement.setInt(6, soluong);
            statement.setString(7,nhasx);
            statement.setString(8,xuatxu);
            statement.setString(9,mota);
            
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void xoaSanPham(String masp)
    {
        Connection connection = DBConnector.getConnection();
        String sqlQuerry = "DELETE FROM sanpham WHERE MaSanPham =" + masp;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuerry);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
