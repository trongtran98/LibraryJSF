/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Trong Tran
 */
@Entity
@Table(name = "LoaiSach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiSach.findAll", query = "SELECT l FROM LoaiSach l")
    , @NamedQuery(name = "LoaiSach.findByMaLoai", query = "SELECT l FROM LoaiSach l WHERE l.maLoai = :maLoai")
    , @NamedQuery(name = "LoaiSach.findByTenloai", query = "SELECT l FROM LoaiSach l WHERE l.tenloai = :tenloai")})
public class LoaiSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MaLoai")
    private String maLoai;
    @Size(max = 250)
    @Column(name = "Tenloai")
    private String tenloai;
    @OneToMany(mappedBy = "maLoai", fetch = FetchType.EAGER)
    private List<Sach> sachList;

    public LoaiSach() {
    }

    public LoaiSach(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @XmlTransient
    public List<Sach> getSachList() {
        return sachList;
    }

    public void setSachList(List<Sach> sachList) {
        this.sachList = sachList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoai != null ? maLoai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiSach)) {
            return false;
        }
        LoaiSach other = (LoaiSach) object;
        if ((this.maLoai == null && other.maLoai != null) || (this.maLoai != null && !this.maLoai.equals(other.maLoai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LoaiSach[ maLoai=" + maLoai + " ]";
    }
    
}
