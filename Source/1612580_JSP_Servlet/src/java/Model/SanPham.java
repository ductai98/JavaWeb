/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ronin
 */
@Entity
@Table(name = "sanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
    , @NamedQuery(name = "SanPham.findByMaSanPham", query = "SELECT s FROM SanPham s WHERE s.maSanPham = :maSanPham")
    , @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham")
    , @NamedQuery(name = "SanPham.findByHinhSanPham", query = "SELECT s FROM SanPham s WHERE s.hinhSanPham = :hinhSanPham")
    , @NamedQuery(name = "SanPham.findByGiaTien", query = "SELECT s FROM SanPham s WHERE s.giaTien = :giaTien")
    , @NamedQuery(name = "SanPham.findBySoLuong", query = "SELECT s FROM SanPham s WHERE s.soLuong = :soLuong")
    , @NamedQuery(name = "SanPham.findByNhaSanXuat", query = "SELECT s FROM SanPham s WHERE s.nhaSanXuat = :nhaSanXuat")
    , @NamedQuery(name = "SanPham.findByXuatXu", query = "SELECT s FROM SanPham s WHERE s.xuatXu = :xuatXu")
    , @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa")})
public class SanPham implements Serializable, Comparable<SanPham> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MaSanPham")
    private String maSanPham;
    @Size(max = 255)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    @Size(max = 255)
    @Column(name = "HinhSanPham")
    private String hinhSanPham;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GiaTien")
    private Double giaTien;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Size(max = 255)
    @Column(name = "NhaSanXuat")
    private String nhaSanXuat;
    @Size(max = 255)
    @Column(name = "XuatXu")
    private String xuatXu;
    @Size(max = 255)
    @Column(name = "MoTa")
    private String moTa;
    @JoinColumn(name = "MaLoaiSanPham", referencedColumnName = "MaLoaiSanPham")
    @ManyToOne
    private LoaiSanPham maLoaiSanPham;

    public SanPham() {
    }

    public SanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public SanPham(String maSanPham, String tenSanPham, String hinhSanPham, Double giaTien, Integer soLuong, String nhaSanXuat, String xuatXu, String moTa, LoaiSanPham maLoaiSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhSanPham = hinhSanPham;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
        this.xuatXu = xuatXu;
        this.moTa = moTa;
        this.maLoaiSanPham = maLoaiSanPham;
    }
    
    

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhSanPham() {
        return hinhSanPham;
    }

    public void setHinhSanPham(String hinhSanPham) {
        this.hinhSanPham = hinhSanPham;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LoaiSanPham getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(LoaiSanPham maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSanPham != null ? maSanPham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSanPham == null && other.maSanPham != null) || (this.maSanPham != null && !this.maSanPham.equals(other.maSanPham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.SanPham[ maSanPham=" + maSanPham + " ]";
    }

    @Override
    public int compareTo(SanPham o) {
        return this.getGiaTien().compareTo(o.getGiaTien());
    }
    
}
