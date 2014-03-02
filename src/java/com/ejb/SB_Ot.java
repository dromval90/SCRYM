/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entities.Detordentrabajo;
import com.entities.DetordentrabajoFacade;
import com.entities.Ordentrabajo;
import com.entities.OrdentrabajoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
    
   
   public String insertarRequisicion(Ordentrabajo EncOrden, List<Detordentrabajo> DetalleReq){
       String msg ="";
       try{
           ordentrabajoFacade.edit(EncOrden);
          
           
           msg="**Encabezado Requisicion Almacenado Correctamente";
           for(Detordentrabajo DetReq : DetalleReq){
                DetReq.setIdDetOrden(null);
                //DetReq.getIdOrden().setIdOrden(EncOrden.getIdOrden());
                detordentrabajoFacade.edit(DetReq);
            }
           msg+=" **Detalle Requisicion Almacenado Correctamente";
          
     
       }catch(Exception ex){
           msg="Ocurrior Un Error, No pudo completarse el Ingreso de la Requisicion:";
       }   
       return msg;
   }

}
