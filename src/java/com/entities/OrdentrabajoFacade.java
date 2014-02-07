/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dromero
 */
@Stateless
public class OrdentrabajoFacade extends AbstractFacade<Ordentrabajo> {
    @PersistenceContext(unitName = "scrymPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdentrabajoFacade() {
        super(Ordentrabajo.class);
    }
    
}
