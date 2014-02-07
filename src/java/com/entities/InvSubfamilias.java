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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "inv_subfamilias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvSubfamilias.findAll", query = "SELECT i FROM InvSubfamilias i"),
    @NamedQuery(name = "InvSubfamilias.findByIdSubFamilia", query = "SELECT i FROM InvSubfamilias i WHERE i.idSubFamilia = :idSubFamilia"),
    @NamedQuery(name = "InvSubfamilias.findByNombreSubFamilia", query = "SELECT i FROM InvSubfamilias i WHERE i.nombreSubFamilia = :nombreSubFamilia"),
    @NamedQuery(name = "InvSubfamilias.findByComentario", query = "SELECT i FROM InvSubfamilias i WHERE i.comentario = :comentario")})
public class InvSubfamilias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubFamilia")
    private Integer idSubFamilia;
    @Size(max = 255)
    @Column(name = "nombreSubFamilia")
    private String nombreSubFamilia;
    @Size(max = 255)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "idFamilia", referencedColumnName = "idFamilia")
    @ManyToOne(optional = false)
    private InvFamilias idFamilia;
    @OneToMany(mappedBy = "idSubFamilia")
    private List<InvProductos> invProductosList;
 

    public InvSubfamilias() {
    }

    public InvSubfamilias(Integer idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public Integer getIdSubFamilia() {
        return idSubFamilia;
    }

    public void setIdSubFamilia(Integer idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public String getNombreSubFamilia() {
        return nombreSubFamilia;
    }

    public void setNombreSubFamilia(String nombreSubFamilia) {
        this.nombreSubFamilia = nombreSubFamilia;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public InvFamilias getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(InvFamilias idFamilia) {
        this.idFamilia = idFamilia;
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
        hash += (idSubFamilia != null ? idSubFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvSubfamilias)) {
            return false;
        }
        InvSubfamilias other = (InvSubfamilias) object;
        if ((this.idSubFamilia == null && other.idSubFamilia != null) || (this.idSubFamilia != null && !this.idSubFamilia.equals(other.idSubFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.InvSubfamilias[ idSubFamilia=" + idSubFamilia + " ]";
    }
    
}
