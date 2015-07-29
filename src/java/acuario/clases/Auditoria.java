/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByAuditoriaid", query = "SELECT a FROM Auditoria a WHERE a.auditoriaid = :auditoriaid"),
    @NamedQuery(name = "Auditoria.findByAuditoriatabla", query = "SELECT a FROM Auditoria a WHERE a.auditoriatabla = :auditoriatabla"),
    @NamedQuery(name = "Auditoria.findByAuditoriaregistroid", query = "SELECT a FROM Auditoria a WHERE a.auditoriaregistroid = :auditoriaregistroid"),
    @NamedQuery(name = "Auditoria.findByAuditoriatransaccion", query = "SELECT a FROM Auditoria a WHERE a.auditoriatransaccion = :auditoriatransaccion"),
    @NamedQuery(name = "Auditoria.findByAuditoriafecha", query = "SELECT a FROM Auditoria a WHERE a.auditoriafecha = :auditoriafecha"),
    @NamedQuery(name = "Auditoria.findByAuditoriausuario", query = "SELECT a FROM Auditoria a WHERE a.auditoriausuario = :auditoriausuario"),
    @NamedQuery(name = "Auditoria.findByAuditoriaprograma", query = "SELECT a FROM Auditoria a WHERE a.auditoriaprograma = :auditoriaprograma"),
    @NamedQuery(name = "Auditoria.findByAuditoriaestacion", query = "SELECT a FROM Auditoria a WHERE a.auditoriaestacion = :auditoriaestacion"),
    @NamedQuery(name = "Auditoria.findByAuditoriaestado", query = "SELECT a FROM Auditoria a WHERE a.auditoriaestado = :auditoriaestado")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer auditoriaid;
    @Size(max = 20)
    private String auditoriatabla;
    @Basic(optional = false)
    @NotNull
    private int auditoriaregistroid;
    @Size(max = 10)
    private String auditoriatransaccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditoriafecha;
    @Size(max = 20)
    private String auditoriausuario;
    @Size(max = 20)
    private String auditoriaprograma;
    @Size(max = 20)
    private String auditoriaestacion;
    @Size(max = 10)
    private String auditoriaestado;

    public Auditoria() {
    }

    public Auditoria(Integer auditoriaid) {
        this.auditoriaid = auditoriaid;
    }

    public Auditoria(Integer auditoriaid, int auditoriaregistroid) {
        this.auditoriaid = auditoriaid;
        this.auditoriaregistroid = auditoriaregistroid;
    }

    public Integer getAuditoriaid() {
        return auditoriaid;
    }

    public void setAuditoriaid(Integer auditoriaid) {
        this.auditoriaid = auditoriaid;
    }

    public String getAuditoriatabla() {
        return auditoriatabla;
    }

    public void setAuditoriatabla(String auditoriatabla) {
        this.auditoriatabla = auditoriatabla;
    }

    public int getAuditoriaregistroid() {
        return auditoriaregistroid;
    }

    public void setAuditoriaregistroid(int auditoriaregistroid) {
        this.auditoriaregistroid = auditoriaregistroid;
    }

    public String getAuditoriatransaccion() {
        return auditoriatransaccion;
    }

    public void setAuditoriatransaccion(String auditoriatransaccion) {
        this.auditoriatransaccion = auditoriatransaccion;
    }

    public Date getAuditoriafecha() {
        return auditoriafecha;
    }

    public void setAuditoriafecha(Date auditoriafecha) {
        this.auditoriafecha = auditoriafecha;
    }

    public String getAuditoriausuario() {
        return auditoriausuario;
    }

    public void setAuditoriausuario(String auditoriausuario) {
        this.auditoriausuario = auditoriausuario;
    }

    public String getAuditoriaprograma() {
        return auditoriaprograma;
    }

    public void setAuditoriaprograma(String auditoriaprograma) {
        this.auditoriaprograma = auditoriaprograma;
    }

    public String getAuditoriaestacion() {
        return auditoriaestacion;
    }

    public void setAuditoriaestacion(String auditoriaestacion) {
        this.auditoriaestacion = auditoriaestacion;
    }

    public String getAuditoriaestado() {
        return auditoriaestado;
    }

    public void setAuditoriaestado(String auditoriaestado) {
        this.auditoriaestado = auditoriaestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditoriaid != null ? auditoriaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.auditoriaid == null && other.auditoriaid != null) || (this.auditoriaid != null && !this.auditoriaid.equals(other.auditoriaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Auditoria[ auditoriaid=" + auditoriaid + " ]";
    }
    
}
