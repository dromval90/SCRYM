/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    public List<Detordentrabajo> findNumOrden(Integer numOrden){
	 TypedQuery<Detordentrabajo> q;
         try{
                q = em.createNamedQuery("Detordentrabajo.findByIdOrden", Detordentrabajo.class )		    
		    .setParameter("idOrden",  numOrden );
                return q.getResultList();
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return null;
    
    }
}
