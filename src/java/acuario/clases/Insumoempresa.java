/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo Astudillo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumoempresa.findAll", query = "SELECT i FROM Insumoempresa i"),
    @NamedQuery(name = "Insumoempresa.findByEmpresaid", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresaPK.empresaid = :empresaid"),
    @NamedQuery(name = "Insumoempresa.findByInsumoid", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresaPK.insumoid = :insumoid"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresastockinicial", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresastockinicial = :insumoempresastockinicial"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresastockactual", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresastockactual = :insumoempresastockactual"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresastockminimo", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresastockminimo = :insumoempresastockminimo"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresastockmaximo", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresastockmaximo = :insumoempresastockmaximo"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresaingresos", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresaingresos = :insumoempresaingresos"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresaegresos", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresaegresos = :insumoempresaegresos"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresareservado", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresareservado = :insumoempresareservado"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresasecuencia", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresasecuencia = :insumoempresasecuencia"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresacompra", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresacompra = :insumoempresacompra"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresavigencia", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresavigencia = :insumoempresavigencia"),
    @NamedQuery(name = "Insumoempresa.findByInsumoempresaestado", query = "SELECT i FROM Insumoempresa i WHERE i.insumoempresaestado = :insumoempresaestado")})
public class Insumoempresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InsumoempresaPK insumoempresaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal insumoempresastockinicial;
    private BigDecimal insumoempresastockactual;
    private BigDecimal insumoempresastockminimo;
    private BigDecimal insumoempresastockmaximo;
    private BigDecimal insumoempresaingresos;
    private BigDecimal insumoempresaegresos;
    private BigDecimal insumoempresareservado;
    private Short insumoempresasecuencia;
    @Temporal(TemporalType.DATE)
    private Date insumoempresacompra;
    @Temporal(TemporalType.DATE)
    private Date insumoempresavigencia;
    @Size(max = 10)
    private String insumoempresaestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumoempresa")
    private List<Kardex> kardexList;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;
    @JoinColumn(name = "INSUMOID", referencedColumnName = "INSUMOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Insumo insumo;

    public Insumoempresa() {
    }

    public Insumoempresa(InsumoempresaPK insumoempresaPK) {
        this.insumoempresaPK = insumoempresaPK;
    }

    public Insumoempresa(int empresaid, int insumoid) {
        this.insumoempresaPK = new InsumoempresaPK(empresaid, insumoid);
    }

    public InsumoempresaPK getInsumoempresaPK() {
        return insumoempresaPK;
    }

    public void setInsumoempresaPK(InsumoempresaPK insumoempresaPK) {
        this.insumoempresaPK = insumoempresaPK;
    }

    public BigDecimal getInsumoempresastockinicial() {
        return insumoempresastockinicial;
    }

    public void setInsumoempresastockinicial(BigDecimal insumoempresastockinicial) {
        this.insumoempresastockinicial = insumoempresastockinicial;
    }

    public BigDecimal getInsumoempresastockactual() {
        return insumoempresastockactual;
    }

    public void setInsumoempresastockactual(BigDecimal insumoempresastockactual) {
        this.insumoempresastockactual = insumoempresastockactual;
    }

    public BigDecimal getInsumoempresastockminimo() {
        return insumoempresastockminimo;
    }

    public void setInsumoempresastockminimo(BigDecimal insumoempresastockminimo) {
        this.insumoempresastockminimo = insumoempresastockminimo;
    }

    public BigDecimal getInsumoempresastockmaximo() {
        return insumoempresastockmaximo;
    }

    public void setInsumoempresastockmaximo(BigDecimal insumoempresastockmaximo) {
        this.insumoempresastockmaximo = insumoempresastockmaximo;
    }

    public BigDecimal getInsumoempresaingresos() {
        return insumoempresaingresos;
    }

    public void setInsumoempresaingresos(BigDecimal insumoempresaingresos) {
        this.insumoempresaingresos = insumoempresaingresos;
    }

    public BigDecimal getInsumoempresaegresos() {
        return insumoempresaegresos;
    }

    public void setInsumoempresaegresos(BigDecimal insumoempresaegresos) {
        this.insumoempresaegresos = insumoempresaegresos;
    }

    public BigDecimal getInsumoempresareservado() {
        return insumoempresareservado;
    }

    public void setInsumoempresareservado(BigDecimal insumoempresareservado) {
        this.insumoempresareservado = insumoempresareservado;
    }

    public Short getInsumoempresasecuencia() {
        return insumoempresasecuencia;
    }

    public void setInsumoempresasecuencia(Short insumoempresasecuencia) {
        this.insumoempresasecuencia = insumoempresasecuencia;
    }

    public Date getInsumoempresacompra() {
        return insumoempresacompra;
    }

    public void setInsumoempresacompra(Date insumoempresacompra) {
        this.insumoempresacompra = insumoempresacompra;
    }

    public Date getInsumoempresavigencia() {
        return insumoempresavigencia;
    }

    public void setInsumoempresavigencia(Date insumoempresavigencia) {
        this.insumoempresavigencia = insumoempresavigencia;
    }

    public String getInsumoempresaestado() {
        return insumoempresaestado;
    }

    public void setInsumoempresaestado(String insumoempresaestado) {
        this.insumoempresaestado = insumoempresaestado;
    }

    @XmlTransient
    public List<Kardex> getKardexList() {
        return kardexList;
    }

    public void setKardexList(List<Kardex> kardexList) {
        this.kardexList = kardexList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insumoempresaPK != null ? insumoempresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumoempresa)) {
            return false;
        }
        Insumoempresa other = (Insumoempresa) object;
        if ((this.insumoempresaPK == null && other.insumoempresaPK != null) || (this.insumoempresaPK != null && !this.insumoempresaPK.equals(other.insumoempresaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Insumoempresa[ insumoempresaPK=" + insumoempresaPK + " ]";
    }
    
}
