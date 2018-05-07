/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.LoaiSach;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Trong Tran
 */
@Stateless
public class LoaiSachFacade extends AbstractFacade<LoaiSach> {

    @PersistenceContext(unitName = "PersistentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoaiSachFacade() {
        super(LoaiSach.class);
    }
    
}
