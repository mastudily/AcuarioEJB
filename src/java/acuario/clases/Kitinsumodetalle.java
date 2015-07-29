/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo Astudillo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitinsumodetalle.findAll", query = "SELECT k FROM Kitinsumodetalle k"),
    @NamedQuery(name = "Kitinsumodetalle.findByInsumoid", query = "SELECT k FROM Kitinsumodetalle k WHERE k.kitinsumodetallePK.insumoid = :insumoid"),
    @NamedQuery(name = "Kitinsumodetalle.findByKitinsumoid", query = "SELECT k FROM Kitinsumodetalle k WHERE k.kitinsumodetallePK.kitinsumoid = :kitinsumoid"),
    @NamedQuery(name = "Kitinsumodetalle.findByKitinsumodetallecantidad", query = "SELECT k FROM Kitinsumodetalle k WHERE k.kitinsumodetallecantidad = :kitinsumodetallecantidad"),
    @NamedQuery(name = "Kitinsumodetalle.findByKitinsumodetalleprecio", query = "SELECT k FROM Kitinsumodetalle k WHERE k.kitinsumodetalleprecio = :kitinsumodetalleprecio"),
    @NamedQuery(name = "Kitinsumodetalle.findByKitinsumodetalleestado", query = "SELECT k FROM Kitinsumodetalle k WHERE k.kitinsumodetalleestado = :kitinsumodetalleestado")})
public class Kitinsumodetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KitinsumodetallePK kitinsumodetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal kitinsumodetallecantidad;
    private BigDecimal kitinsumodetalleprecio;
    @Size(max = 10)
    private String kitinsumodetalleestado;
    @JoinColumn(name = "INSUMOID", referencedColumnName = "INSUMOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Insumo insumo;
    @JoinColumn(name = "KITINSUMOID", referencedColumnName = "KITINSUMOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kitinsumo kitinsumo;

    public Kitinsumodetalle() {
    }

    public Kitinsumodetalle(KitinsumodetallePK kitinsumodetallePK) {
        this.kitinsumodetallePK = kitinsumodetallePK;
    }

    public Kitinsumodetalle(int insumoid, int kitinsumoid) {
        this.kitinsumodetallePK = new KitinsumodetallePK(insumoid, kitinsumoid);
    }

    public KitinsumodetallePK getKitinsumodetallePK() {
        return kitinsumodetallePK;
    }

    public void setKitinsumodetallePK(KitinsumodetallePK kitinsumodetallePK) {
        this.kitinsumodetallePK = kitinsumodetallePK;
    }

    public BigDecimal getKitinsumodetallecantidad() {
        return kitinsumodetallecantidad;
    }

    public void setKitinsumodetallecantidad(BigDecimal kitinsumodetallecantidad) {
        this.kitinsumodetallecantidad = kitinsumodetallecantidad;
    }

    public BigDecimal getKitinsumodetalleprecio() {
        return kitinsumodetalleprecio;
    }

    public void setKitinsumodetalleprecio(BigDecimal kitinsumodetalleprecio) {
        this.kitinsumodetalleprecio = kitinsumodetalleprecio;
    }

    public String getKitinsumodetalleestado() {
        return kitinsumodetalleestado;
    }

    public void setKitinsumodetalleestado(String kitinsumodetalleestado) {
        this.kitinsumodetalleestado = kitinsumodetalleestado;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Kitinsumo getKitinsumo() {
        return kitinsumo;
    }

    public void setKitinsumo(Kitinsumo kitinsumo) {
        this.kitinsumo = kitinsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitinsumodetallePK != null ? kitinsumodetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitinsumodetalle)) {
            return false;
        }
        Kitinsumodetalle other = (Kitinsumodetalle) object;
        if ((this.kitinsumodetallePK == null && other.kitinsumodetallePK != null) || (this.kitinsumodetallePK != null && !this.kitinsumodetallePK.equals(other.kitinsumodetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Kitinsumodetalle[ kitinsumodetallePK=" + kitinsumodetallePK + " ]";
    }
    
}
