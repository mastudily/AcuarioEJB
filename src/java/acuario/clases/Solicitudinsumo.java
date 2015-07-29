/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
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
    @NamedQuery(name = "Solicitudinsumo.findAll", query = "SELECT s FROM Solicitudinsumo s"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumoid", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumoid = :solicitudinsumoid"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumodescripcion", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumodescripcion = :solicitudinsumodescripcion"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumoreferencia", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumoreferencia = :solicitudinsumoreferencia"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumofecha", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumofecha = :solicitudinsumofecha"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumotipo", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumotipo = :solicitudinsumotipo"),
    @NamedQuery(name = "Solicitudinsumo.findBySolicitudinsumoestado", query = "SELECT s FROM Solicitudinsumo s WHERE s.solicitudinsumoestado = :solicitudinsumoestado")})
public class Solicitudinsumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer solicitudinsumoid;
    @Size(max = 100)
    private String solicitudinsumodescripcion;
    @Lob
    @Size(max = 65535)
    private String solicitudinsumoobservaciones;
    @Size(max = 30)
    private String solicitudinsumoreferencia;
    @Temporal(TemporalType.DATE)
    private Date solicitudinsumofecha;
    @Size(max = 10)
    private String solicitudinsumotipo;
    @Size(max = 10)
    private String solicitudinsumoestado;
    @OneToMany(mappedBy = "solicitudinsumoid")
    private List<Ingreso> ingresoList;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID")
    @ManyToOne(optional = false)
    private Empresa empresaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudinsumo")
    private List<Kardex> kardexList;

    public Solicitudinsumo() {
    }

    public Solicitudinsumo(Integer solicitudinsumoid) {
        this.solicitudinsumoid = solicitudinsumoid;
    }

    public Integer getSolicitudinsumoid() {
        return solicitudinsumoid;
    }

    public void setSolicitudinsumoid(Integer solicitudinsumoid) {
        this.solicitudinsumoid = solicitudinsumoid;
    }

    public String getSolicitudinsumodescripcion() {
        return solicitudinsumodescripcion;
    }

    public void setSolicitudinsumodescripcion(String solicitudinsumodescripcion) {
        this.solicitudinsumodescripcion = solicitudinsumodescripcion;
    }

    public String getSolicitudinsumoobservaciones() {
        return solicitudinsumoobservaciones;
    }

    public void setSolicitudinsumoobservaciones(String solicitudinsumoobservaciones) {
        this.solicitudinsumoobservaciones = solicitudinsumoobservaciones;
    }

    public String getSolicitudinsumoreferencia() {
        return solicitudinsumoreferencia;
    }

    public void setSolicitudinsumoreferencia(String solicitudinsumoreferencia) {
        this.solicitudinsumoreferencia = solicitudinsumoreferencia;
    }

    public Date getSolicitudinsumofecha() {
        return solicitudinsumofecha;
    }

    public void setSolicitudinsumofecha(Date solicitudinsumofecha) {
        this.solicitudinsumofecha = solicitudinsumofecha;
    }

    public String getSolicitudinsumotipo() {
        return solicitudinsumotipo;
    }

    public void setSolicitudinsumotipo(String solicitudinsumotipo) {
        this.solicitudinsumotipo = solicitudinsumotipo;
    }

    public String getSolicitudinsumoestado() {
        return solicitudinsumoestado;
    }

    public void setSolicitudinsumoestado(String solicitudinsumoestado) {
        this.solicitudinsumoestado = solicitudinsumoestado;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    @XmlTransient
    public List<Kardex> getKardexList() {
        return kardexList;
    }

    public void setKardexList(List<Kardex> kardexList) {
        this.kardexList = kardexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudinsumoid != null ? solicitudinsumoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudinsumo)) {
            return false;
        }
        Solicitudinsumo other = (Solicitudinsumo) object;
        if ((this.solicitudinsumoid == null && other.solicitudinsumoid != null) || (this.solicitudinsumoid != null && !this.solicitudinsumoid.equals(other.solicitudinsumoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Solicitudinsumo[ solicitudinsumoid=" + solicitudinsumoid + " ]";
    }
    
}
