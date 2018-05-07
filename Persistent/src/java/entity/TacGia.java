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
@Table(name = "TacGia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TacGia.findAll", query = "SELECT t FROM TacGia t")
    , @NamedQuery(name = "TacGia.findByMaTG", query = "SELECT t FROM TacGia t WHERE t.maTG = :maTG")
    , @NamedQuery(name = "TacGia.findByTentacgia", query = "SELECT t FROM TacGia t WHERE t.tentacgia = :tentacgia")
    , @NamedQuery(name = "TacGia.findByDiachi", query = "SELECT t FROM TacGia t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TacGia.findBySdt", query = "SELECT t FROM TacGia t WHERE t.sdt = :sdt")
    , @NamedQuery(name = "TacGia.findByEmail", query = "SELECT t FROM TacGia t WHERE t.email = :email")})
public class TacGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MaTG")
    private String maTG;
    @Size(max = 250)
    @Column(name = "Tentacgia")
    private String tentacgia;
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
    @OneToMany(mappedBy = "maTG", fetch = FetchType.EAGER)
    private List<Sach> sachList;

    public TacGia() {
    }

    public TacGia(String maTG) {
        this.maTG = maTG;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
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
        hash += (maTG != null ? maTG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TacGia)) {
            return false;
        }
        TacGia other = (TacGia) object;
        if ((this.maTG == null && other.maTG != null) || (this.maTG != null && !this.maTG.equals(other.maTG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TacGia[ maTG=" + maTG + " ]";
    }
    
}
