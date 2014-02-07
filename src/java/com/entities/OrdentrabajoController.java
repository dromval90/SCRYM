package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ordentrabajoController")
@ViewScoped
public class OrdentrabajoController extends AbstractController<Ordentrabajo> implements Serializable {

    @EJB
    private OrdentrabajoFacade ejbFacade;

    public OrdentrabajoController() {
        super(Ordentrabajo.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
