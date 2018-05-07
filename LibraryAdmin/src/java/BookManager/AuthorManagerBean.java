/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;


import entity.TacGia;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import model.TacGiaFacade;

/**
 *
 * @author Trong Tran
 */
@ManagedBean
@Named(value = "authorManagerBean")
public class AuthorManagerBean {

   
    
    /**
     * Creates a new instance of AuthorManagerBean
     */
    public AuthorManagerBean() {
    }
    @EJB
    private TacGiaFacade tacGiaFacade;
    
    private List<TacGia> dsTacGia;

    public List<TacGia> getDsTacGia() {
        dsTacGia = tacGiaFacade.findAll();
        return dsTacGia;
    }

    public void setDsTacGia(List<TacGia> dsTacGia) {
        this.dsTacGia = dsTacGia;
    }
    
 
    
}
