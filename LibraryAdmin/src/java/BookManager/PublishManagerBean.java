/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

import entity.NhaXB;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import model.NhaXBFacade;

/**
 *
 * @author Trong Tran
 */
@ManagedBean
@Named(value = "publishManagerBean")
@Dependent
public class PublishManagerBean {

    @EJB
    private NhaXBFacade nhaXBFacade;

    /**
     * Creates a new instance of PublishManagerBean
     */
    public PublishManagerBean() {
    }

    private List<NhaXB> dsNhaXB;

    public List<NhaXB> getDsNhaXB() {
        dsNhaXB = nhaXBFacade.findAll();
        return dsNhaXB;
    }

    public void setDsNhaXB(List<NhaXB> dsNhaXB) {
        this.dsNhaXB = dsNhaXB;
    }

}
