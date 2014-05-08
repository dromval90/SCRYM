package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "entidadesController")
@ViewScoped
public class EntidadesController extends AbstractController<Entidades> implements Serializable {

    @EJB
    private EntidadesFacade ejbFacade;

    public EntidadesController() {
        super(Entidades.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
