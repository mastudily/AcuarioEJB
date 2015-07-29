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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByIngresoid", query = "SELECT i FROM Ingreso i WHERE i.ingresoid = :ingresoid"),
    @NamedQuery(name = "Ingreso.findByIngresofecha", query = "SELECT i FROM Ingreso i WHERE i.ingresofecha = :ingresofecha"),
    @NamedQuery(name = "Ingreso.findByIngresohora", query = "SELECT i FROM Ingreso i WHERE i.ingresohora = :ingresohora"),
    @NamedQuery(name = "Ingreso.findByIngresosecuencia", query = "SELECT i FROM Ingreso i WHERE i.ingresosecuencia = :ingresosecuencia"),
    @NamedQuery(name = "Ingreso.findByIngresovalor", query = "SELECT i FROM Ingreso i WHERE i.ingresovalor = :ingresovalor"),
    @NamedQuery(name = "Ingreso.findByIngresoadicional", query = "SELECT i FROM Ingreso i WHERE i.ingresoadicional = :ingresoadicional"),
    @NamedQuery(name = "Ingreso.findByIngresoimpuestos", query = "SELECT i FROM Ingreso i WHERE i.ingresoimpuestos = :ingresoimpuestos"),
    @NamedQuery(name = "Ingreso.findByIngresodescuentos", query = "SELECT i FROM Ingreso i WHERE i.ingresodescuentos = :ingresodescuentos"),
    @NamedQuery(name = "Ingreso.findByIngresofactura", query = "SELECT i FROM Ingreso i WHERE i.ingresofactura = :ingresofactura"),
    @NamedQuery(name = "Ingreso.findByIngresotipofactura", query = "SELECT i FROM Ingreso i WHERE i.ingresotipofactura = :ingresotipofactura"),
    @NamedQuery(name = "Ingreso.findByIngresoestado", query = "SELECT i FROM Ingreso i WHERE i.ingresoestado = :ingresoestado")})
public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer ingresoid;
    @Temporal(TemporalType.DATE)
    private Date ingresofecha;
    @Temporal(TemporalType.TIME)
    private Date ingresohora;
    @Lob
    @Size(max = 65535)
    private String ingresoobservaciones;
    private Short ingresosecuencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal ingresovalor;
    private BigDecimal ingresoadicional;
    private BigDecimal ingresoimpuestos;
    private BigDecimal ingresodescuentos;
    @Size(max = 30)
    private String ingresofactura;
    @Size(max = 10)
    private String ingresotipofactura;
    @Size(max = 10)
    private String ingresoestado;
    @JoinColumn(name = "CLIENTEID", referencedColumnName = "CLIENTEID")
    @ManyToOne(optional = false)
    private Cliente clienteid;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID")
    @ManyToOne(optional = false)
    private Empresa empresaid;
    @JoinColumn(name = "SOLICITUDINSUMOID", referencedColumnName = "SOLICITUDINSUMOID")
    @ManyToOne
    private Solicitudinsumo solicitudinsumoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingreso")
    private List<Ingresoforpag> ingresoforpagList;

    public Ingreso() {
    }

    public Ingreso(Integer ingresoid) {
        this.ingresoid = ingresoid;
    }

    public Integer getIngresoid() {
        return ingresoid;
    }

    public void setIngresoid(Integer ingresoid) {
        this.ingresoid = ingresoid;
    }

    public Date getIngresofecha() {
        return ingresofecha;
    }

    public void setIngresofecha(Date ingresofecha) {
        this.ingresofecha = ingresofecha;
    }

    public Date getIngresohora() {
        return ingresohora;
    }

    public void setIngresohora(Date ingresohora) {
        this.ingresohora = ingresohora;
    }

    public String getIngresoobservaciones() {
        return ingresoobservaciones;
    }

    public void setIngresoobservaciones(String ingresoobservaciones) {
        this.ingresoobservaciones = ingresoobservaciones;
    }

    public Short getIngresosecuencia() {
        return ingresosecuencia;
    }

    public void setIngresosecuencia(Short ingresosecuencia) {
        this.ingresosecuencia = ingresosecuencia;
    }

    public BigDecimal getIngresovalor() {
        return ingresovalor;
    }

    public void setIngresovalor(BigDecimal ingresovalor) {
        this.ingresovalor = ingresovalor;
    }

    public BigDecimal getIngresoadicional() {
        return ingresoadicional;
    }

    public void setIngresoadicional(BigDecimal ingresoadicional) {
        this.ingresoadicional = ingresoadicional;
    }

    public BigDecimal getIngresoimpuestos() {
        return ingresoimpuestos;
    }

    public void setIngresoimpuestos(BigDecimal ingresoimpuestos) {
        this.ingresoimpuestos = ingresoimpuestos;
    }

    public BigDecimal getIngresodescuentos() {
        return ingresodescuentos;
    }

    public void setIngresodescuentos(BigDecimal ingresodescuentos) {
        this.ingresodescuentos = ingresodescuentos;
    }

    public String getIngresofactura() {
        return ingresofactura;
    }

    public void setIngresofactura(String ingresofactura) {
        this.ingresofactura = ingresofactura;
    }

    public String getIngresotipofactura() {
        return ingresotipofactura;
    }

    public void setIngresotipofactura(String ingresotipofactura) {
        this.ingresotipofactura = ingresotipofactura;
    }

    public String getIngresoestado() {
        return ingresoestado;
    }

    public void setIngresoestado(String ingresoestado) {
        this.ingresoestado = ingresoestado;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    public Solicitudinsumo getSolicitudinsumoid() {
        return solicitudinsumoid;
    }

    public void setSolicitudinsumoid(Solicitudinsumo solicitudinsumoid) {
        this.solicitudinsumoid = solicitudinsumoid;
    }

    @XmlTransient
    public List<Ingresoforpag> getIngresoforpagList() {
        return ingresoforpagList;
    }

    public void setIngresoforpagList(List<Ingresoforpag> ingresoforpagList) {
        this.ingresoforpagList = ingresoforpagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingresoid != null ? ingresoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.ingresoid == null && other.ingresoid != null) || (this.ingresoid != null && !this.ingresoid.equals(other.ingresoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Ingreso[ ingresoid=" + ingresoid + " ]";
    }
    
}
