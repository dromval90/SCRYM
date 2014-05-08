package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "invSubfamiliasController")
@ViewScoped
public class InvSubfamiliasController extends AbstractController<InvSubfamilias> implements Serializable {

    @EJB
    private InvSubfamiliasFacade ejbFacade;

    public InvSubfamiliasController() {
        super(InvSubfamilias.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
