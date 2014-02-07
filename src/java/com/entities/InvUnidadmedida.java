/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "inv_unidadmedida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvUnidadmedida.findAll", query = "SELECT i FROM InvUnidadmedida i"),
    @NamedQuery(name = "InvUnidadmedida.findByIdUnidad", query = "SELECT i FROM InvUnidadmedida i WHERE i.idUnidad = :idUnidad"),
    @NamedQuery(name = "InvUnidadmedida.findByNombreUnidad", query = "SELECT i FROM InvUnidadmedida i WHERE i.nombreUnidad = :nombreUnidad"),
    @NamedQuery(name = "InvUnidadmedida.findByAbreviatura", query = "SELECT i FROM InvUnidadmedida i WHERE i.abreviatura = :abreviatura")})
public class InvUnidadmedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidad")
    private Integer idUnidad;
    @Size(max = 50)
    @Column(name = "nombreUnidad")
    private String nombreUnidad;
    @Size(max = 10)
    @Column(name = "abreviatura")
    private String abreviatura;
    @OneToMany(mappedBy = "idUnidad")
    private List<InvProductos> invProductosList;

    public InvUnidadmedida() {
    }

    public InvUnidadmedida(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @XmlTransient
    public List<InvProductos> getInvProductosList() {
        return invProductosList;
    }

    public void setInvProductosList(List<InvProductos> invProductosList) {
        this.invProductosList = invProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvUnidadmedida)) {
            return false;
        }
        InvUnidadmedida other = (InvUnidadmedida) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.InvUnidadmedida[ idUnidad=" + idUnidad + " ]";
    }
    
}
