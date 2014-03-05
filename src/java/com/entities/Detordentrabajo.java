/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "detordentrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detordentrabajo.findAll", query = "SELECT d FROM Detordentrabajo d"),
    @NamedQuery(name = "Detordentrabajo.findByIdDetOrden", query = "SELECT d FROM Detordentrabajo d WHERE d.idDetOrden = :idDetOrden"),
    @NamedQuery(name = "Detordentrabajo.findByIdOrden", query = "SELECT d FROM Detordentrabajo d WHERE d.idOrden.idOrden = :idOrden"),
    @NamedQuery(name = "Detordentrabajo.findByDescripcion", query = "SELECT d FROM Detordentrabajo d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Detordentrabajo.findByCantidad", query = "SELECT d FROM Detordentrabajo d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detordentrabajo.findByPrecio", query = "SELECT d FROM Detordentrabajo d WHERE d.precio = :precio"),
    @NamedQuery(name = "Detordentrabajo.findByIva", query = "SELECT d FROM Detordentrabajo d WHERE d.iva = :iva"),
    @NamedQuery(name = "Detordentrabajo.findByDescuento", query = "SELECT d FROM Detordentrabajo d WHERE d.descuento = :descuento")})
public class Detordentrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetOrden")
    private Integer idDetOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private Double iva;
    @Column(name = "descuento")
    private Double descuento;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private InvProductos idProducto;
    @JoinColumn(name = "idOrden", referencedColumnName = "idOrden")
    @ManyToOne(optional = false)
    private Ordentrabajo idOrden;

    public Detordentrabajo() {
    }

    public Detordentrabajo(Integer idDetOrden) {
        this.idDetOrden = idDetOrden;
    }

    public Detordentrabajo(Integer idDetOrden, String descripcion, double cantidad, double precio) {
        this.idDetOrden = idDetOrden;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdDetOrden() {
        return idDetOrden;
    }

    public void setIdDetOrden(Integer idDetOrden) {
        this.idDetOrden = idDetOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public InvProductos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(InvProductos idProducto) {
        this.idProducto = idProducto;
    }

    public Ordentrabajo getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Ordentrabajo idOrden) {
        this.idOrden = idOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetOrden != null ? idDetOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detordentrabajo)) {
            return false;
        }
        Detordentrabajo other = (Detordentrabajo) object;
        if ((this.idDetOrden == null && other.idDetOrden != null) || (this.idDetOrden != null && !this.idDetOrden.equals(other.idDetOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Detordentrabajo[ idDetOrden=" + idDetOrden + " ]";
    }
    
}
