/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo Astudillo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kardex.findAll", query = "SELECT k FROM Kardex k"),
    @NamedQuery(name = "Kardex.findByEmpresaid", query = "SELECT k FROM Kardex k WHERE k.kardexPK.empresaid = :empresaid"),
    @NamedQuery(name = "Kardex.findByInsumoid", query = "SELECT k FROM Kardex k WHERE k.kardexPK.insumoid = :insumoid"),
    @NamedQuery(name = "Kardex.findBySolicitudinsumoid", query = "SELECT k FROM Kardex k WHERE k.kardexPK.solicitudinsumoid = :solicitudinsumoid"),
    @NamedQuery(name = "Kardex.findByKardexfecha", query = "SELECT k FROM Kardex k WHERE k.kardexfecha = :kardexfecha"),
    @NamedQuery(name = "Kardex.findByKardexcantidad", query = "SELECT k FROM Kardex k WHERE k.kardexcantidad = :kardexcantidad"),
    @NamedQuery(name = "Kardex.findByKardexusado", query = "SELECT k FROM Kardex k WHERE k.kardexusado = :kardexusado"),
    @NamedQuery(name = "Kardex.findByKardexprecio", query = "SELECT k FROM Kardex k WHERE k.kardexprecio = :kardexprecio"),
    @NamedQuery(name = "Kardex.findByKardextipo", query = "SELECT k FROM Kardex k WHERE k.kardextipo = :kardextipo"),
    @NamedQuery(name = "Kardex.findByKardexsigno", query = "SELECT k FROM Kardex k WHERE k.kardexsigno = :kardexsigno"),
    @NamedQuery(name = "Kardex.findByKardexultimacantidad", query = "SELECT k FROM Kardex k WHERE k.kardexultimacantidad = :kardexultimacantidad"),
    @NamedQuery(name = "Kardex.findByKardexestado", query = "SELECT k FROM Kardex k WHERE k.kardexestado = :kardexestado")})
public class Kardex implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KardexPK kardexPK;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date kardexfecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal kardexcantidad;
    private BigDecimal kardexusado;
    private BigDecimal kardexprecio;
    @Size(max = 10)
    private String kardextipo;
    @Size(max = 1)
    private String kardexsigno;
    private BigDecimal kardexultimacantidad;
    @Size(max = 10)
    private String kardexestado;
    @JoinColumns({
        @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID", insertable = false, updatable = false),
        @JoinColumn(name = "INSUMOID", referencedColumnName = "INSUMOID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Insumoempresa insumoempresa;
    @JoinColumn(name = "SOLICITUDINSUMOID", referencedColumnName = "SOLICITUDINSUMOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Solicitudinsumo solicitudinsumo;

    public Kardex() {
    }

    public Kardex(KardexPK kardexPK) {
        this.kardexPK = kardexPK;
    }

    public Kardex(KardexPK kardexPK, Date kardexfecha) {
        this.kardexPK = kardexPK;
        this.kardexfecha = kardexfecha;
    }

    public Kardex(int empresaid, int insumoid, int solicitudinsumoid) {
        this.kardexPK = new KardexPK(empresaid, insumoid, solicitudinsumoid);
    }

    public KardexPK getKardexPK() {
        return kardexPK;
    }

    public void setKardexPK(KardexPK kardexPK) {
        this.kardexPK = kardexPK;
    }

    public Date getKardexfecha() {
        return kardexfecha;
    }

    public void setKardexfecha(Date kardexfecha) {
        this.kardexfecha = kardexfecha;
    }

    public BigDecimal getKardexcantidad() {
        return kardexcantidad;
    }

    public void setKardexcantidad(BigDecimal kardexcantidad) {
        this.kardexcantidad = kardexcantidad;
    }

    public BigDecimal getKardexusado() {
        return kardexusado;
    }

    public void setKardexusado(BigDecimal kardexusado) {
        this.kardexusado = kardexusado;
    }

    public BigDecimal getKardexprecio() {
        return kardexprecio;
    }

    public void setKardexprecio(BigDecimal kardexprecio) {
        this.kardexprecio = kardexprecio;
    }

    public String getKardextipo() {
        return kardextipo;
    }

    public void setKardextipo(String kardextipo) {
        this.kardextipo = kardextipo;
    }

    public String getKardexsigno() {
        return kardexsigno;
    }

    public void setKardexsigno(String kardexsigno) {
        this.kardexsigno = kardexsigno;
    }

    public BigDecimal getKardexultimacantidad() {
        return kardexultimacantidad;
    }

    public void setKardexultimacantidad(BigDecimal kardexultimacantidad) {
        this.kardexultimacantidad = kardexultimacantidad;
    }

    public String getKardexestado() {
        return kardexestado;
    }

    public void setKardexestado(String kardexestado) {
        this.kardexestado = kardexestado;
    }

    public Insumoempresa getInsumoempresa() {
        return insumoempresa;
    }

    public void setInsumoempresa(Insumoempresa insumoempresa) {
        this.insumoempresa = insumoempresa;
    }

    public Solicitudinsumo getSolicitudinsumo() {
        return solicitudinsumo;
    }

    public void setSolicitudinsumo(Solicitudinsumo solicitudinsumo) {
        this.solicitudinsumo = solicitudinsumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kardexPK != null ? kardexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.kardexPK == null && other.kardexPK != null) || (this.kardexPK != null && !this.kardexPK.equals(other.kardexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Kardex[ kardexPK=" + kardexPK + " ]";
    }
    
}
