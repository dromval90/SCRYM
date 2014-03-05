/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "ordentrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordentrabajo.findAll", query = "SELECT o FROM Ordentrabajo o"),
    @NamedQuery(name = "Ordentrabajo.findByIdOrden", query = "SELECT o FROM Ordentrabajo o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "Ordentrabajo.findByFechaOrden", query = "SELECT o FROM Ordentrabajo o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Ordentrabajo.findByEntregado", query = "SELECT o FROM Ordentrabajo o WHERE o.entregado = :entregado"),
    @NamedQuery(name = "Ordentrabajo.findByObservaciones", query = "SELECT o FROM Ordentrabajo o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "Ordentrabajo.findByCliente", query = "SELECT o FROM Ordentrabajo o WHERE o.cliente = :cliente"),
    @NamedQuery(name = "Ordentrabajo.findByTelefono", query = "SELECT o FROM Ordentrabajo o WHERE o.telefono = :telefono")})
public class Ordentrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idOrden")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaOrden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "entregado")
    private String entregado;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 100)
    @Column(name = "cliente")
    private String cliente;
    @Size(max = 75)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad")
    @ManyToOne(optional = false)
    private Entidades idEntidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrden")
    private List<Detordentrabajo> detordentrabajoList;

    public Ordentrabajo() {
    }

    public Ordentrabajo(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Ordentrabajo(Integer idOrden, Date fechaOrden, String entregado) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.entregado = entregado;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    @XmlTransient
    public List<Detordentrabajo> getDetordentrabajoList() {
        return detordentrabajoList;
    }

    public void setDetordentrabajoList(List<Detordentrabajo> detordentrabajoList) {
        this.detordentrabajoList = detordentrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordentrabajo)) {
            return false;
        }
        Ordentrabajo other = (Ordentrabajo) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Ordentrabajo[ idOrden=" + idOrden + " ]";
    }
    
}
