/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByInsumoid", query = "SELECT i FROM Insumo i WHERE i.insumoid = :insumoid"),
    @NamedQuery(name = "Insumo.findByInsumonombre", query = "SELECT i FROM Insumo i WHERE i.insumonombre = :insumonombre"),
    @NamedQuery(name = "Insumo.findByInsumodescripcion", query = "SELECT i FROM Insumo i WHERE i.insumodescripcion = :insumodescripcion"),
    @NamedQuery(name = "Insumo.findByInsumocodigo", query = "SELECT i FROM Insumo i WHERE i.insumocodigo = :insumocodigo"),
    @NamedQuery(name = "Insumo.findByInsumovalor", query = "SELECT i FROM Insumo i WHERE i.insumovalor = :insumovalor"),
    @NamedQuery(name = "Insumo.findByInsumoventa", query = "SELECT i FROM Insumo i WHERE i.insumoventa = :insumoventa"),
    @NamedQuery(name = "Insumo.findByInsumounmed", query = "SELECT i FROM Insumo i WHERE i.insumounmed = :insumounmed"),
    @NamedQuery(name = "Insumo.findByInsumopresentacion", query = "SELECT i FROM Insumo i WHERE i.insumopresentacion = :insumopresentacion"),
    @NamedQuery(name = "Insumo.findByInsumotipo", query = "SELECT i FROM Insumo i WHERE i.insumotipo = :insumotipo"),
    @NamedQuery(name = "Insumo.findByInsumoestado", query = "SELECT i FROM Insumo i WHERE i.insumoestado = :insumoestado")})
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer insumoid;
    @Size(max = 30)
    private String insumonombre;
    @Size(max = 100)
    private String insumodescripcion;
    @Size(max = 20)
    private String insumocodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal insumovalor;
    private BigDecimal insumoventa;
    @Size(max = 10)
    private String insumounmed;
    @Size(max = 10)
    private String insumopresentacion;
    @Size(max = 10)
    private String insumotipo;
    @Lob
    private byte[] insumofoto;
    @Size(max = 10)
    private String insumoestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo")
    private List<Kitinsumodetalle> kitinsumodetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo")
    private List<Insumoempresa> insumoempresaList;

    public Insumo() {
    }

    public Insumo(Integer insumoid) {
        this.insumoid = insumoid;
    }

    public Integer getInsumoid() {
        return insumoid;
    }

    public void setInsumoid(Integer insumoid) {
        this.insumoid = insumoid;
    }

    public String getInsumonombre() {
        return insumonombre;
    }

    public void setInsumonombre(String insumonombre) {
        this.insumonombre = insumonombre;
    }

    public String getInsumodescripcion() {
        return insumodescripcion;
    }

    public void setInsumodescripcion(String insumodescripcion) {
        this.insumodescripcion = insumodescripcion;
    }

    public String getInsumocodigo() {
        return insumocodigo;
    }

    public void setInsumocodigo(String insumocodigo) {
        this.insumocodigo = insumocodigo;
    }

    public BigDecimal getInsumovalor() {
        return insumovalor;
    }

    public void setInsumovalor(BigDecimal insumovalor) {
        this.insumovalor = insumovalor;
    }

    public BigDecimal getInsumoventa() {
        return insumoventa;
    }

    public void setInsumoventa(BigDecimal insumoventa) {
        this.insumoventa = insumoventa;
    }

    public String getInsumounmed() {
        return insumounmed;
    }

    public void setInsumounmed(String insumounmed) {
        this.insumounmed = insumounmed;
    }

    public String getInsumopresentacion() {
        return insumopresentacion;
    }

    public void setInsumopresentacion(String insumopresentacion) {
        this.insumopresentacion = insumopresentacion;
    }

    public String getInsumotipo() {
        return insumotipo;
    }

    public void setInsumotipo(String insumotipo) {
        this.insumotipo = insumotipo;
    }

    public byte[] getInsumofoto() {
        return insumofoto;
    }

    public void setInsumofoto(byte[] insumofoto) {
        this.insumofoto = insumofoto;
    }

    public String getInsumoestado() {
        return insumoestado;
    }

    public void setInsumoestado(String insumoestado) {
        this.insumoestado = insumoestado;
    }

    @XmlTransient
    public List<Kitinsumodetalle> getKitinsumodetalleList() {
        return kitinsumodetalleList;
    }

    public void setKitinsumodetalleList(List<Kitinsumodetalle> kitinsumodetalleList) {
        this.kitinsumodetalleList = kitinsumodetalleList;
    }

    @XmlTransient
    public List<Insumoempresa> getInsumoempresaList() {
        return insumoempresaList;
    }

    public void setInsumoempresaList(List<Insumoempresa> insumoempresaList) {
        this.insumoempresaList = insumoempresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insumoid != null ? insumoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.insumoid == null && other.insumoid != null) || (this.insumoid != null && !this.insumoid.equals(other.insumoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Insumo[ insumoid=" + insumoid + " ]";
    }
    
}
