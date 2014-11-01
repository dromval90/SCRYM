package com.entities;

import com.ejb.SB_Ot;
import com.ejb.SB_Reportes;
import com.entities.util.JsfUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "ordentrabajoController")
@ViewScoped
public class OrdentrabajoController extends AbstractController<Ordentrabajo> implements Serializable {
    @EJB
    private DetordentrabajoFacade detordentrabajoFacade;
    @EJB
    private SB_Ot sB_Ot;

    @EJB
    private OrdentrabajoFacade ejbFacade;
     @EJB
    private SB_Reportes reportes;
    
    Detordentrabajo DetalleRequisicion;
    //List LDetordentrabajo = new ArrayList();
    List <Detordentrabajo> LDetordentrabajo = new ArrayList<Detordentrabajo>() ;
    List <Detordentrabajo> listDetorden;
    double ttotal=0;
    
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
            this.getSelected().setEntregado("N");
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

    
    public List<Detordentrabajo> getListDetorden() {
         if(this.getSelected()!=null ){
           // this.setListDetorden(detordenFacade.findNumOrden(this.getSelected().getOrdenencPK().getCodCia(), this.getSelected().getOrdenencPK().getNumOrden()));
            //detordentrabajoFacade
             this.setListDetorden(detordentrabajoFacade.findNumOrden(this.getSelected().getIdOrden()));
             return listDetorden;
        }
        return listDetorden;
    }

    public void setListDetorden(List<Detordentrabajo> listDetorden) {
        this.listDetorden = listDetorden;
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
      
    public void saveNewRequisicion(){
        Long NumOT;
        NumOT = ejbFacade.findPk();
        this.getSelected().setIdOrden(NumOT.intValue());
        sB_Ot.insertarRequisicion(this.getSelected(), this.getLDetordentrabajo());
    }
    
     public String imprimirRequisicion() throws NamingException, SQLException, JRException, IOException{
        try{
            HashMap params = new HashMap();  
            
            params.put("pidorden", this.getSelected().getIdOrden()); 
            reportes.GenerarReporte("/reportes/OT.jasper", params);    
        }catch(Exception ex){
            ex.printStackTrace();
        }    
        return "";
    } 
     
    public void handleChangeCantidad(AjaxBehaviorEvent vce){
      double cantidad= (double) ((UIOutput) vce.getSource()).getValue();
      this.getDetalleRequisicion().setCantidad(cantidad);
    }
     
    public void handleChangePrecio(AjaxBehaviorEvent vce){
      double precio= (double) ((UIOutput) vce.getSource()).getValue();
      this.getDetalleRequisicion().setPrecio(precio);
    }
     
    public void handleChangeSubtotal(AjaxBehaviorEvent vce){
      double subtotal=0;
      double descuento= (double) ((UIOutput) vce.getSource()).getValue();
      subtotal = (this.getDetalleRequisicion().getCantidad() * this.getDetalleRequisicion().getPrecio()) - descuento;
      this.getDetalleRequisicion().setSubtotal(subtotal);
    }
    
    public double getttotal() {
        double valtotal = 0;
        for(Detordentrabajo DetReq : this.getLDetordentrabajo()){
                valtotal = valtotal + DetReq.getSubtotal();
                //this.ttotal = this.ttotal + DetReq.getSubtotal();
            }
            this.settotal(valtotal);
        return this.ttotal;
    }

    public void settotal(double ttotal) {
        this.ttotal= ttotal;
    }
    
   public void delete(){
       sB_Ot.borrarRequisicion(this.getSelected(), this.getLDetordentrabajo());
   }
}
