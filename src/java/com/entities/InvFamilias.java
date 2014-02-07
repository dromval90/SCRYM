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
@Table(name = "inv_familias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvFamilias.findAll", query = "SELECT i FROM InvFamilias i"),
    @NamedQuery(name = "InvFamilias.findByIdFamilia", query = "SELECT i FROM InvFamilias i WHERE i.idFamilia = :idFamilia"),
    @NamedQuery(name = "InvFamilias.findByNombreFamilia", query = "SELECT i FROM InvFamilias i WHERE i.nombreFamilia = :nombreFamilia"),
    @NamedQuery(name = "InvFamilias.findByComentario", query = "SELECT i FROM InvFamilias i WHERE i.comentario = :comentario")})
public class InvFamilias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFamilia")
    private Integer idFamilia;
    @Size(max = 255)
    @Column(name = "nombreFamilia")
    private String nombreFamilia;
    @Size(max = 255)
    @Column(name = "comentario")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFamilia")
    private List<InvSubfamilias> invSubfamiliasList;

    public InvFamilias() {
    }

    public InvFamilias(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public List<InvSubfamilias> getInvSubfamiliasList() {
        return invSubfamiliasList;
    }

    public void setInvSubfamiliasList(List<InvSubfamilias> invSubfamiliasList) {
        this.invSubfamiliasList = invSubfamiliasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilia != null ? idFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvFamilias)) {
            return false;
        }
        InvFamilias other = (InvFamilias) object;
        if ((this.idFamilia == null && other.idFamilia != null) || (this.idFamilia != null && !this.idFamilia.equals(other.idFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.InvFamilias[ idFamilia=" + idFamilia + " ]";
    }
    
}
