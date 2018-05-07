/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

import entity.LoaiSach;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import model.LoaiSachFacade;

/**
 *
 * @author Trong Tran
 */
@ManagedBean
@Named(value = "bookKindManagerBean")
@Dependent
public class BookKindManagerBean {

    @EJB
    private LoaiSachFacade loaiSachFacade;

    /**
     * Creates a new instance of BookKindManagerBean
     */
    public BookKindManagerBean() {
    }
    
    private List<LoaiSach> dsLoaiSach;

    public List<LoaiSach> getDsLoaiSach() {
        dsLoaiSach = loaiSachFacade.findAll();
        return dsLoaiSach;
    }

    public void setDsLoaiSach(List<LoaiSach> dsLoaiSach) {
        this.dsLoaiSach = dsLoaiSach;
    }

}
