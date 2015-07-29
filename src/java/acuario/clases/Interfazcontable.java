/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Interfazcontable.findAll", query = "SELECT i FROM Interfazcontable i"),
    @NamedQuery(name = "Interfazcontable.findByInterfazcontableid", query = "SELECT i FROM Interfazcontable i WHERE i.interfazcontableid = :interfazcontableid"),
    @NamedQuery(name = "Interfazcontable.findByInterfazcontabledescipcion", query = "SELECT i FROM Interfazcontable i WHERE i.interfazcontabledescipcion = :interfazcontabledescipcion"),
    @NamedQuery(name = "Interfazcontable.findByInterfazcontabletransaccion", query = "SELECT i FROM Interfazcontable i WHERE i.interfazcontabletransaccion = :interfazcontabletransaccion"),
    @NamedQuery(name = "Interfazcontable.findByInterfazcontableestado", query = "SELECT i FROM Interfazcontable i WHERE i.interfazcontableestado = :interfazcontableestado")})
public class Interfazcontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer interfazcontableid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String interfazcontabledescipcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String interfazcontabletransaccion;
    @Size(max = 10)
    private String interfazcontableestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interfazcontable")
    private List<Interfazcontabledetalle> interfazcontabledetalleList;

    public Interfazcontable() {
    }

    public Interfazcontable(Integer interfazcontableid) {
        this.interfazcontableid = interfazcontableid;
    }

    public Interfazcontable(Integer interfazcontableid, String interfazcontabledescipcion, String interfazcontabletransaccion) {
        this.interfazcontableid = interfazcontableid;
        this.interfazcontabledescipcion = interfazcontabledescipcion;
        this.interfazcontabletransaccion = interfazcontabletransaccion;
    }

    public Integer getInterfazcontableid() {
        return interfazcontableid;
    }

    public void setInterfazcontableid(Integer interfazcontableid) {
        this.interfazcontableid = interfazcontableid;
    }

    public String getInterfazcontabledescipcion() {
        return interfazcontabledescipcion;
    }

    public void setInterfazcontabledescipcion(String interfazcontabledescipcion) {
        this.interfazcontabledescipcion = interfazcontabledescipcion;
    }

    public String getInterfazcontabletransaccion() {
        return interfazcontabletransaccion;
    }

    public void setInterfazcontabletransaccion(String interfazcontabletransaccion) {
        this.interfazcontabletransaccion = interfazcontabletransaccion;
    }

    public String getInterfazcontableestado() {
        return interfazcontableestado;
    }

    public void setInterfazcontableestado(String interfazcontableestado) {
        this.interfazcontableestado = interfazcontableestado;
    }

    @XmlTransient
    public List<Interfazcontabledetalle> getInterfazcontabledetalleList() {
        return interfazcontabledetalleList;
    }

    public void setInterfazcontabledetalleList(List<Interfazcontabledetalle> interfazcontabledetalleList) {
        this.interfazcontabledetalleList = interfazcontabledetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interfazcontableid != null ? interfazcontableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interfazcontable)) {
            return false;
        }
        Interfazcontable other = (Interfazcontable) object;
        if ((this.interfazcontableid == null && other.interfazcontableid != null) || (this.interfazcontableid != null && !this.interfazcontableid.equals(other.interfazcontableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Interfazcontable[ interfazcontableid=" + interfazcontableid + " ]";
    }
    
}
