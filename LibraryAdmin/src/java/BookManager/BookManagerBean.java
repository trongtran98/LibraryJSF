/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

import entity.LoaiSach;
import entity.NhaXB;
import entity.Sach;
import entity.TacGia;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import model.SachFacade;

/**
 *
 * @author Trong Tran
 */
@ManagedBean(name = "bookManagerBean")
public class BookManagerBean {

    @EJB
    private SachFacade sachFacade;

    /**
     * Creates a new instance of BookManagerBean
     */
    public BookManagerBean() {

    }

    private String maSach;
    private String tenSach;
    private String maTG;
    private String maNXB;
    private String maLS;
    private String tomtat;
    
    private List<Sach> listBooks;
    private String maxId;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getMaLS() {
        return maLS;
    }

    public void setMaLS(String maLS) {
        this.maLS = maLS;
    }

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }


    public void setListBooks(List<Sach> listBooks) {
        this.listBooks = listBooks;
    }

    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    public String getMaxId() {
        this.maxId = sachFacade.getMaxId();
        return maxId;
    }

    public List<Sach> getListBooks() {
        listBooks = sachFacade.findAll();
        return listBooks;
    }

    public String themSach() {
        Sach sach = new Sach();
        sach.setMaSach(sachFacade.getMaxId());
        sach.setTensach(tenSach);
        sach.setTomtat(tomtat);
        
        NhaXB nhaXB = new NhaXB();
        nhaXB.setMaNXB(maNXB);
        sach.setMaNXB(nhaXB);
        
        TacGia tacGia = new TacGia();
        tacGia.setMaTG(maTG);
        sach.setMaTG(tacGia);
        
        LoaiSach loaiSach = new LoaiSach();
        loaiSach.setMaLoai(maLS);
        sach.setMaLoai(loaiSach);
     
        sachFacade.create(sach);
        
        return "success";
    }
}
