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
public class DetordentrabajoFacade extends AbstractFacade<Detordentrabajo> {
    @PersistenceContext(unitName = "scrymPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetordentrabajoFacade() {
        super(Detordentrabajo.class);
    }
    
}
