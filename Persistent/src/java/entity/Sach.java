/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Trong Tran
 */
@Entity
@Table(name = "Sach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sach.findAll", query = "SELECT s FROM Sach s")
    , @NamedQuery(name = "Sach.findByMaSach", query = "SELECT s FROM Sach s WHERE s.maSach = :maSach")
    , @NamedQuery(name = "Sach.findByTensach", query = "SELECT s FROM Sach s WHERE s.tensach LIKE :tensach")
    , @NamedQuery(name = "Sach.findByTomtat", query = "SELECT s FROM Sach s WHERE s.tomtat = :tomtat")
    , @NamedQuery(name = "Sach.findByTenanh", query = "SELECT s FROM Sach s WHERE s.tenanh = :tenanh")
    , @NamedQuery(name = "Sach.findByTenfile", query = "SELECT s FROM Sach s WHERE s.tenfile = :tenfile")})
public class Sach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MaSach")
    private String maSach;
    @Size(max = 250)
    @Column(name = "Tensach")
    private String tensach;
    @Size(max = 250)
    @Column(name = "Tomtat")
    private String tomtat;
    @Size(max = 250)
    @Column(name = "Tenanh")
    private String tenanh;
    @Size(max = 250)
    @Column(name = "Tenfile")
    private String tenfile;
    @JoinColumn(name = "MaLoai", referencedColumnName = "MaLoai")
    @ManyToOne(fetch = FetchType.EAGER)
    private LoaiSach maLoai;
    @JoinColumn(name = "MaNXB", referencedColumnName = "MaNXB")
    @ManyToOne(fetch = FetchType.EAGER)
    private NhaXB maNXB;
    @JoinColumn(name = "MaTG", referencedColumnName = "MaTG")
    @ManyToOne(fetch = FetchType.EAGER)
    private TacGia maTG;

    public Sach() {
    }

    public Sach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }

    public String getTenanh() {
        return tenanh;
    }

    public void setTenanh(String tenanh) {
        this.tenanh = tenanh;
    }

    public String getTenfile() {
        return tenfile;
    }

    public void setTenfile(String tenfile) {
        this.tenfile = tenfile;
    }

    public LoaiSach getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiSach maLoai) {
        this.maLoai = maLoai;
    }

    public NhaXB getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(NhaXB maNXB) {
        this.maNXB = maNXB;
    }

    public TacGia getMaTG() {
        return maTG;
    }

    public void setMaTG(TacGia maTG) {
        this.maTG = maTG;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSach != null ? maSach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sach)) {
            return false;
        }
        Sach other = (Sach) object;
        if ((this.maSach == null && other.maSach != null) || (this.maSach != null && !this.maSach.equals(other.maSach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sach[ maSach=" + maSach + " ]";
    }
    
}
