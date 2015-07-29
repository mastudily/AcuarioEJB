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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByEmpresaid", query = "SELECT e FROM Empresa e WHERE e.empresaid = :empresaid"),
    @NamedQuery(name = "Empresa.findByEmpresarut", query = "SELECT e FROM Empresa e WHERE e.empresarut = :empresarut"),
    @NamedQuery(name = "Empresa.findByEmpresanombre", query = "SELECT e FROM Empresa e WHERE e.empresanombre = :empresanombre"),
    @NamedQuery(name = "Empresa.findByEmpresadescripcion", query = "SELECT e FROM Empresa e WHERE e.empresadescripcion = :empresadescripcion"),
    @NamedQuery(name = "Empresa.findByEmpresatelefono", query = "SELECT e FROM Empresa e WHERE e.empresatelefono = :empresatelefono"),
    @NamedQuery(name = "Empresa.findByEmpresacoordlat", query = "SELECT e FROM Empresa e WHERE e.empresacoordlat = :empresacoordlat"),
    @NamedQuery(name = "Empresa.findByEmpresacoordlon", query = "SELECT e FROM Empresa e WHERE e.empresacoordlon = :empresacoordlon"),
    @NamedQuery(name = "Empresa.findByEmpresadiario", query = "SELECT e FROM Empresa e WHERE e.empresadiario = :empresadiario"),
    @NamedQuery(name = "Empresa.findByEmpresaempleado", query = "SELECT e FROM Empresa e WHERE e.empresaempleado = :empresaempleado"),
    @NamedQuery(name = "Empresa.findByEmpresatransaccion", query = "SELECT e FROM Empresa e WHERE e.empresatransaccion = :empresatransaccion"),
    @NamedQuery(name = "Empresa.findByEmpresaestado", query = "SELECT e FROM Empresa e WHERE e.empresaestado = :empresaestado")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer empresaid;
    @Size(max = 20)
    private String empresarut;
    @Size(max = 30)
    private String empresanombre;
    @Size(max = 100)
    private String empresadescripcion;
    @Lob
    @Size(max = 2147483647)
    private String empresadireccion;
    @Size(max = 20)
    private String empresatelefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal empresacoordlat;
    private BigDecimal empresacoordlon;
    private Integer empresadiario;
    private Integer empresaempleado;
    private Integer empresatransaccion;
    @Size(max = 10)
    private String empresaestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<Diario> diarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<Cuentacontable> cuentacontableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<Ingreso> ingresoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<Solicitudinsumo> solicitudinsumoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Insumoempresa> insumoempresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Persona personaid;

    public Empresa() {
    }

    public Empresa(Integer empresaid) {
        this.empresaid = empresaid;
    }

    public Integer getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Integer empresaid) {
        this.empresaid = empresaid;
    }

    public String getEmpresarut() {
        return empresarut;
    }

    public void setEmpresarut(String empresarut) {
        this.empresarut = empresarut;
    }

    public String getEmpresanombre() {
        return empresanombre;
    }

    public void setEmpresanombre(String empresanombre) {
        this.empresanombre = empresanombre;
    }

    public String getEmpresadescripcion() {
        return empresadescripcion;
    }

    public void setEmpresadescripcion(String empresadescripcion) {
        this.empresadescripcion = empresadescripcion;
    }

    public String getEmpresadireccion() {
        return empresadireccion;
    }

    public void setEmpresadireccion(String empresadireccion) {
        this.empresadireccion = empresadireccion;
    }

    public String getEmpresatelefono() {
        return empresatelefono;
    }

    public void setEmpresatelefono(String empresatelefono) {
        this.empresatelefono = empresatelefono;
    }

    public BigDecimal getEmpresacoordlat() {
        return empresacoordlat;
    }

    public void setEmpresacoordlat(BigDecimal empresacoordlat) {
        this.empresacoordlat = empresacoordlat;
    }

    public BigDecimal getEmpresacoordlon() {
        return empresacoordlon;
    }

    public void setEmpresacoordlon(BigDecimal empresacoordlon) {
        this.empresacoordlon = empresacoordlon;
    }

    public Integer getEmpresadiario() {
        return empresadiario;
    }

    public void setEmpresadiario(Integer empresadiario) {
        this.empresadiario = empresadiario;
    }

    public Integer getEmpresaempleado() {
        return empresaempleado;
    }

    public void setEmpresaempleado(Integer empresaempleado) {
        this.empresaempleado = empresaempleado;
    }

    public Integer getEmpresatransaccion() {
        return empresatransaccion;
    }

    public void setEmpresatransaccion(Integer empresatransaccion) {
        this.empresatransaccion = empresatransaccion;
    }

    public String getEmpresaestado() {
        return empresaestado;
    }

    public void setEmpresaestado(String empresaestado) {
        this.empresaestado = empresaestado;
    }

    @XmlTransient
    public List<Diario> getDiarioList() {
        return diarioList;
    }

    public void setDiarioList(List<Diario> diarioList) {
        this.diarioList = diarioList;
    }

    @XmlTransient
    public List<Cuentacontable> getCuentacontableList() {
        return cuentacontableList;
    }

    public void setCuentacontableList(List<Cuentacontable> cuentacontableList) {
        this.cuentacontableList = cuentacontableList;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    public List<Solicitudinsumo> getSolicitudinsumoList() {
        return solicitudinsumoList;
    }

    public void setSolicitudinsumoList(List<Solicitudinsumo> solicitudinsumoList) {
        this.solicitudinsumoList = solicitudinsumoList;
    }

    @XmlTransient
    public List<Insumoempresa> getInsumoempresaList() {
        return insumoempresaList;
    }

    public void setInsumoempresaList(List<Insumoempresa> insumoempresaList) {
        this.insumoempresaList = insumoempresaList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Persona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Persona personaid) {
        this.personaid = personaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaid != null ? empresaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaid == null && other.empresaid != null) || (this.empresaid != null && !this.empresaid.equals(other.empresaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Empresa[ empresaid=" + empresaid + " ]";
    }
    
}
