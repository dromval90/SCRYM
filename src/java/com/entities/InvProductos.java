/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "inv_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProductos.findAll", query = "SELECT i FROM InvProductos i"),
    @NamedQuery(name = "InvProductos.findByIdProducto", query = "SELECT i FROM InvProductos i WHERE i.idProducto = :idProducto"),
    @NamedQuery(name = "InvProductos.findByNombreProducto", query = "SELECT i FROM InvProductos i WHERE i.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "InvProductos.findByDescripcion", query = "SELECT i FROM InvProductos i WHERE i.descripcion = :descripcion")})
public class InvProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Size(max = 255)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idSubFamilia", referencedColumnName = "idSubFamilia")
    @ManyToOne
    private InvSubfamilias idSubFamilia;
    @JoinColumn(name = "idUnidad", referencedColumnName = "idUnidad")
    @ManyToOne
    private InvUnidadmedida idUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Detordentrabajo> detordentrabajoList;

    public InvProductos() {
    }

    public InvProductos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InvSubfamilias getIdSubFamilia() {
        return idSubFamilia;
    }

    public void setIdSubFamilia(InvSubfamilias idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public InvUnidadmedida getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(InvUnidadmedida idUnidad) {
        this.idUnidad = idUnidad;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProductos)) {
            return false;
        }
        InvProductos other = (InvProductos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.InvProductos[ idProducto=" + idProducto + " ]";
    }
    
}
