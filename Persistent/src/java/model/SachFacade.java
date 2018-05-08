/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Sach;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trong Tran
 */
@Stateless
public class SachFacade extends AbstractFacade<Sach> {

    @PersistenceContext(unitName = "PersistentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SachFacade() {
        super(Sach.class);
    }
    
    public List<Sach> getBooks(String keyword){
        return em.createNamedQuery("Sach.findByTensach").setParameter("tensach", "%"+keyword+"%").getResultList();
    }
    
    public String getMaxId() {
        String maxTemp = (String) em.createNamedQuery("Sach.getMaxId").setMaxResults(1).getSingleResult();
        return "MS"+(Integer.parseInt(maxTemp.substring(2))+1);
    }
    
}
