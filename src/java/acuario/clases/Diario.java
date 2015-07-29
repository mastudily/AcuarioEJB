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
    @NamedQuery(name = "Diario.findAll", query = "SELECT d FROM Diario d"),
    @NamedQuery(name = "Diario.findByDiarioid", query = "SELECT d FROM Diario d WHERE d.diarioid = :diarioid"),
    @NamedQuery(name = "Diario.findByDiarioreferencia", query = "SELECT d FROM Diario d WHERE d.diarioreferencia = :diarioreferencia"),
    @NamedQuery(name = "Diario.findByDiariofecha", query = "SELECT d FROM Diario d WHERE d.diariofecha = :diariofecha"),
    @NamedQuery(name = "Diario.findByDiarioestado", query = "SELECT d FROM Diario d WHERE d.diarioestado = :diarioestado")})
public class Diario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer diarioid;
    @Lob
    @Size(max = 65535)
    private String diariodescripcion;
    @Size(max = 100)
    private String diarioreferencia;
    @Temporal(TemporalType.DATE)
    private Date diariofecha;
    @Size(max = 10)
    private String diarioestado;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID")
    @ManyToOne(optional = false)
    private Empresa empresaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diario")
    private List<Diariodetalle> diariodetalleList;

    public Diario() {
    }

    public Diario(Integer diarioid) {
        this.diarioid = diarioid;
    }

    public Integer getDiarioid() {
        return diarioid;
    }

    public void setDiarioid(Integer diarioid) {
        this.diarioid = diarioid;
    }

    public String getDiariodescripcion() {
        return diariodescripcion;
    }

    public void setDiariodescripcion(String diariodescripcion) {
        this.diariodescripcion = diariodescripcion;
    }

    public String getDiarioreferencia() {
        return diarioreferencia;
    }

    public void setDiarioreferencia(String diarioreferencia) {
        this.diarioreferencia = diarioreferencia;
    }

    public Date getDiariofecha() {
        return diariofecha;
    }

    public void setDiariofecha(Date diariofecha) {
        this.diariofecha = diariofecha;
    }

    public String getDiarioestado() {
        return diarioestado;
    }

    public void setDiarioestado(String diarioestado) {
        this.diarioestado = diarioestado;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    @XmlTransient
    public List<Diariodetalle> getDiariodetalleList() {
        return diariodetalleList;
    }

    public void setDiariodetalleList(List<Diariodetalle> diariodetalleList) {
        this.diariodetalleList = diariodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diarioid != null ? diarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diario)) {
            return false;
        }
        Diario other = (Diario) object;
        if ((this.diarioid == null && other.diarioid != null) || (this.diarioid != null && !this.diarioid.equals(other.diarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Diario[ diarioid=" + diarioid + " ]";
    }
    
}
