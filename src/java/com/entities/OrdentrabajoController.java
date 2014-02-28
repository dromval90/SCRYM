package com.entities;

import com.entities.util.JsfUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "ordentrabajoController")
@ViewScoped
public class OrdentrabajoController extends AbstractController<Ordentrabajo> implements Serializable {

    @EJB
    private OrdentrabajoFacade ejbFacade;
    
    Detordentrabajo DetalleRequisicion;
    //List LDetordentrabajo = new ArrayList();
    List <Detordentrabajo> LDetordentrabajo = new ArrayList<Detordentrabajo>() ;

    public OrdentrabajoController() {
        super(Ordentrabajo.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    @Override
    protected void initializeEmbeddableKey() {  
        
        try{
            Date hoy = new Date();
            this.getSelected().setFechaOrden(hoy);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     public Detordentrabajo prepareCreate2(ActionEvent event) {
        Detordentrabajo newItem;
        try {           
             newItem = Detordentrabajo.class.newInstance();
             this.DetalleRequisicion = newItem;
             return newItem;
        } catch (InstantiationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OrdentrabajoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(OrdentrabajoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public Detordentrabajo getDetalleRequisicion() {
        return DetalleRequisicion;
    }

    public void setDetalleRequisicion(Detordentrabajo DetalleRequisicion) {
        this.DetalleRequisicion = DetalleRequisicion;
    }

    public List<Detordentrabajo> getLDetordentrabajo() {
        return LDetordentrabajo;
    }

    public void setLDetordentrabajo(List<Detordentrabajo> LDetordentrabajo) {
        this.LDetordentrabajo = LDetordentrabajo;
    }

  
     public void addDetalleRequisicion(){
        
       try{
          
            this.DetalleRequisicion.setIdDetOrden(1);
            this.DetalleRequisicion.setIdOrden(this.getSelected());
            this.getLDetordentrabajo().add(this.DetalleRequisicion);   
            JsfUtil.addSuccessMessage("Producto Agregado Correctamente");
       }catch(Exception ex){
           ex.toString();
       }
     }
     
      public void deleteDetalleRequisicion(Detordentrabajo SelectDetOrden){
        try{
           this.getLDetordentrabajo().remove(SelectDetOrden);
           JsfUtil.addSuccessMessage("Producto Eliminado Correctamente");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
