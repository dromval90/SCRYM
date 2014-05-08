package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "invFamiliasController")
@ViewScoped
public class InvFamiliasController extends AbstractController<InvFamilias> implements Serializable {

    @EJB
    private InvFamiliasFacade ejbFacade;

    public InvFamiliasController() {
        super(InvFamilias.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
