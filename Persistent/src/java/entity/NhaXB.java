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
@Table(name = "NhaXB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaXB.findAll", query = "SELECT n FROM NhaXB n")
    , @NamedQuery(name = "NhaXB.findByMaNXB", query = "SELECT n FROM NhaXB n WHERE n.maNXB = :maNXB")
    , @NamedQuery(name = "NhaXB.findByTenNXB", query = "SELECT n FROM NhaXB n WHERE n.tenNXB = :tenNXB")
    , @NamedQuery(name = "NhaXB.findByDiachi", query = "SELECT n FROM NhaXB n WHERE n.diachi = :diachi")
    , @NamedQuery(name = "NhaXB.findBySdt", query = "SELECT n FROM NhaXB n WHERE n.sdt = :sdt")
    , @NamedQuery(name = "NhaXB.findByEmail", query = "SELECT n FROM NhaXB n WHERE n.email = :email")})
public class NhaXB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MaNXB")
    private String maNXB;
    @Size(max = 250)
    @Column(name = "TenNXB")
    private String tenNXB;
    @Size(max = 250)
    @Column(name = "Diachi")
    private String diachi;
    @Size(max = 20)
    @Column(name = "SDT")
    private String sdt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "maNXB", fetch = FetchType.EAGER)
    private List<Sach> sachList;

    public NhaXB() {
    }

    public NhaXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (maNXB != null ? maNXB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaXB)) {
            return false;
        }
        NhaXB other = (NhaXB) object;
        if ((this.maNXB == null && other.maNXB != null) || (this.maNXB != null && !this.maNXB.equals(other.maNXB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.NhaXB[ maNXB=" + maNXB + " ]";
    }
    
}
