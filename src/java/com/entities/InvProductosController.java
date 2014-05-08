package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "invProductosController")
@ViewScoped
public class InvProductosController extends AbstractController<InvProductos> implements Serializable {

    @EJB
    private InvProductosFacade ejbFacade;

    public InvProductosController() {
        super(InvProductos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
