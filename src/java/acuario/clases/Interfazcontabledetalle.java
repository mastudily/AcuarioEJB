/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
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
    @NamedQuery(name = "Interfazcontabledetalle.findAll", query = "SELECT i FROM Interfazcontabledetalle i"),
    @NamedQuery(name = "Interfazcontabledetalle.findByInterfazcontableid", query = "SELECT i FROM Interfazcontabledetalle i WHERE i.interfazcontabledetallePK.interfazcontableid = :interfazcontableid"),
    @NamedQuery(name = "Interfazcontabledetalle.findByCuentacontableid", query = "SELECT i FROM Interfazcontabledetalle i WHERE i.interfazcontabledetallePK.cuentacontableid = :cuentacontableid"),
    @NamedQuery(name = "Interfazcontabledetalle.findByInterfazcontabledetalledh", query = "SELECT i FROM Interfazcontabledetalle i WHERE i.interfazcontabledetalledh = :interfazcontabledetalledh"),
    @NamedQuery(name = "Interfazcontabledetalle.findByInterfazcontabledetalleformula", query = "SELECT i FROM Interfazcontabledetalle i WHERE i.interfazcontabledetalleformula = :interfazcontabledetalleformula"),
    @NamedQuery(name = "Interfazcontabledetalle.findByInterfazcontabledetalleestado", query = "SELECT i FROM Interfazcontabledetalle i WHERE i.interfazcontabledetalleestado = :interfazcontabledetalleestado")})
public class Interfazcontabledetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InterfazcontabledetallePK interfazcontabledetallePK;
    private Character interfazcontabledetalledh;
    @Size(max = 30)
    private String interfazcontabledetalleformula;
    @Size(max = 10)
    private String interfazcontabledetalleestado;
    @JoinColumn(name = "CUENTACONTABLEID", referencedColumnName = "CUENTACONTABLEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuentacontable cuentacontable;
    @JoinColumn(name = "INTERFAZCONTABLEID", referencedColumnName = "INTERFAZCONTABLEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Interfazcontable interfazcontable;

    public Interfazcontabledetalle() {
    }

    public Interfazcontabledetalle(InterfazcontabledetallePK interfazcontabledetallePK) {
        this.interfazcontabledetallePK = interfazcontabledetallePK;
    }

    public Interfazcontabledetalle(int interfazcontableid, int cuentacontableid) {
        this.interfazcontabledetallePK = new InterfazcontabledetallePK(interfazcontableid, cuentacontableid);
    }

    public InterfazcontabledetallePK getInterfazcontabledetallePK() {
        return interfazcontabledetallePK;
    }

    public void setInterfazcontabledetallePK(InterfazcontabledetallePK interfazcontabledetallePK) {
        this.interfazcontabledetallePK = interfazcontabledetallePK;
    }

    public Character getInterfazcontabledetalledh() {
        return interfazcontabledetalledh;
    }

    public void setInterfazcontabledetalledh(Character interfazcontabledetalledh) {
        this.interfazcontabledetalledh = interfazcontabledetalledh;
    }

    public String getInterfazcontabledetalleformula() {
        return interfazcontabledetalleformula;
    }

    public void setInterfazcontabledetalleformula(String interfazcontabledetalleformula) {
        this.interfazcontabledetalleformula = interfazcontabledetalleformula;
    }

    public String getInterfazcontabledetalleestado() {
        return interfazcontabledetalleestado;
    }

    public void setInterfazcontabledetalleestado(String interfazcontabledetalleestado) {
        this.interfazcontabledetalleestado = interfazcontabledetalleestado;
    }

    public Cuentacontable getCuentacontable() {
        return cuentacontable;
    }

    public void setCuentacontable(Cuentacontable cuentacontable) {
        this.cuentacontable = cuentacontable;
    }

    public Interfazcontable getInterfazcontable() {
        return interfazcontable;
    }

    public void setInterfazcontable(Interfazcontable interfazcontable) {
        this.interfazcontable = interfazcontable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interfazcontabledetallePK != null ? interfazcontabledetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interfazcontabledetalle)) {
            return false;
        }
        Interfazcontabledetalle other = (Interfazcontabledetalle) object;
        if ((this.interfazcontabledetallePK == null && other.interfazcontabledetallePK != null) || (this.interfazcontabledetallePK != null && !this.interfazcontabledetallePK.equals(other.interfazcontabledetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Interfazcontabledetalle[ interfazcontabledetallePK=" + interfazcontabledetallePK + " ]";
    }
    
}
