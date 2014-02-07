package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "detordentrabajoController")
@ViewScoped
public class DetordentrabajoController extends AbstractController<Detordentrabajo> implements Serializable {

    @EJB
    private DetordentrabajoFacade ejbFacade;

    public DetordentrabajoController() {
        super(Detordentrabajo.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
