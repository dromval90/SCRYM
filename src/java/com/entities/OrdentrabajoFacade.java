/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public Long findPk(){
        Long val;
        try{
            Query q =  em.createNativeQuery("select IfNULL(MAX(idOrden),0) + 1 from ordentrabajo ");
                val = (Long) q.getSingleResult();
               
            return val;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
        

    } 
    
}
