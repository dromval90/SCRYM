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
@Table(name = "entidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e"),
    @NamedQuery(name = "Entidades.findByIdEntidad", query = "SELECT e FROM Entidades e WHERE e.idEntidad = :idEntidad"),
    @NamedQuery(name = "Entidades.findByNombreEntidad", query = "SELECT e FROM Entidades e WHERE e.nombreEntidad = :nombreEntidad"),
    @NamedQuery(name = "Entidades.findByNumNit", query = "SELECT e FROM Entidades e WHERE e.numNit = :numNit"),
    @NamedQuery(name = "Entidades.findByNumNrc", query = "SELECT e FROM Entidades e WHERE e.numNrc = :numNrc"),
    @NamedQuery(name = "Entidades.findByDireccion", query = "SELECT e FROM Entidades e WHERE e.direccion = :direccion")})
public class Entidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntidad")
    private Integer idEntidad;
    @Size(max = 255)
    @Column(name = "nombreEntidad")
    private String nombreEntidad;
    @Size(max = 16)
    @Column(name = "numNit")
    private String numNit;
    @Size(max = 16)
    @Column(name = "numNrc")
    private String numNrc;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private List<Ordentrabajo> ordentrabajoList;
    @JoinColumn(name = "idMunicipio", referencedColumnName = "idMunicipio")
    @ManyToOne
    private Municipios idMunicipio;

    public Entidades() {
    }

    public Entidades(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getNumNit() {
        return numNit;
    }

    public void setNumNit(String numNit) {
        this.numNit = numNit;
    }

    public String getNumNrc() {
        return numNrc;
    }

    public void setNumNrc(String numNrc) {
        this.numNrc = numNrc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Ordentrabajo> getOrdentrabajoList() {
        return ordentrabajoList;
    }

    public void setOrdentrabajoList(List<Ordentrabajo> ordentrabajoList) {
        this.ordentrabajoList = ordentrabajoList;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Entidades[ idEntidad=" + idEntidad + " ]";
    }
    
}
