/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.TacGia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trong Tran
 */
@Stateless
public class TacGiaFacade extends AbstractFacade<TacGia> {

    @PersistenceContext(unitName = "PersistentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TacGiaFacade() {
        super(TacGia.class);
    }
    
}
