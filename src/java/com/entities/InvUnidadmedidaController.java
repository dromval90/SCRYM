package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "invUnidadmedidaController")
@ViewScoped
public class InvUnidadmedidaController extends AbstractController<InvUnidadmedida> implements Serializable {

    @EJB
    private InvUnidadmedidaFacade ejbFacade;

    public InvUnidadmedidaController() {
        super(InvUnidadmedida.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
