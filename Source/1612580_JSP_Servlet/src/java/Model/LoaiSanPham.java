/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ronin
 */
@Entity
@Table(name = "loaisanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiSanPham.findAll", query = "SELECT l FROM LoaiSanPham l")
    , @NamedQuery(name = "LoaiSanPham.findByMaLoaiSanPham", query = "SELECT l FROM LoaiSanPham l WHERE l.maLoaiSanPham = :maLoaiSanPham")
    , @NamedQuery(name = "LoaiSanPham.findByTenLoaiSanPham", query = "SELECT l FROM LoaiSanPham l WHERE l.tenLoaiSanPham = :tenLoaiSanPham")})
public class LoaiSanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MaLoaiSanPham")
    private String maLoaiSanPham;
    @Size(max = 255)
    @Column(name = "TenLoaiSanPham")
    private String tenLoaiSanPham;
    @OneToMany(mappedBy = "maLoaiSanPham")
    private Collection<SanPham> sanPhamCollection;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public LoaiSanPham(String maLoaiSanPham, String tenLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }
    
    

    public String getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(String maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public String toString() {
        return "Model.LoaiSanPham[ maLoaiSanPham=" + maLoaiSanPham + " ]";
    }
    
}
