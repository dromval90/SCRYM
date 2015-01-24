/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entities.Detordentrabajo;
import com.entities.DetordentrabajoFacade;
import com.entities.Ordentrabajo;
import com.entities.OrdentrabajoFacade;
import com.entities.util.JsfUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author dromero
 */
@Stateless
public class SB_Ot {
    @EJB
    private DetordentrabajoFacade detordentrabajoFacade;
    @EJB
    private OrdentrabajoFacade ordentrabajoFacade;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   
   public void insertarRequisicion(Ordentrabajo EncOrden, List<Detordentrabajo> DetalleReq){
       String msg="";
       try{
           ordentrabajoFacade.edit(EncOrden);

           //em.refresh(EncOrden);
           
           msg="**Encabezado Requisicion Almacenado Correctamente";
           for(Detordentrabajo DetReq : DetalleReq){
                DetReq.setIdDetOrden(null);
                //DetReq.getIdOrden().setIdOrden(EncOrden.getIdOrden());
                detordentrabajoFacade.edit(DetReq);
                DetReq.setIdDetOrden(1);
            }
           msg+=" **Detalle Requisicion Almacenado Correctamente";
           JsfUtil.addSuccessMessage(msg);
       }catch(Exception ex){
           msg="Ocurrior Un Error, No pudo completarse el Ingreso de la Orden de Trabajo:";
           JsfUtil.addErrorMessage(msg);
       }   
   }
   
   public void borrarRequisicion(Ordentrabajo EncOrden, List<Detordentrabajo> DetalleReq){
       String msg="";
       try{
           
           for(Detordentrabajo DetReq : DetalleReq){
                detordentrabajoFacade.remove(DetReq);
            }
           msg+=" **Detalle Requisicion Eliminado Correctamente";
           ordentrabajoFacade.remove(EncOrden);
           msg="**Encabezado Requisicion Eliminado Correctamente";
           JsfUtil.addSuccessMessage(msg);
       }catch(Exception ex){
           msg="Ocurrior Un Error, No pudo completarse el Ingreso de la Orden de Trabajo:";
           JsfUtil.addErrorMessage(msg);
       }   
   }
   /*Ultima Revision de code en mini*/

}
