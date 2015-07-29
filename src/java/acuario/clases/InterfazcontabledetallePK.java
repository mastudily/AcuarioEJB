/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcelo Astudillo
 */
@Embeddable
public class InterfazcontabledetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int interfazcontableid;
    @Basic(optional = false)
    @NotNull
    private int cuentacontableid;

    public InterfazcontabledetallePK() {
    }

    public InterfazcontabledetallePK(int interfazcontableid, int cuentacontableid) {
        this.interfazcontableid = interfazcontableid;
        this.cuentacontableid = cuentacontableid;
    }

    public int getInterfazcontableid() {
        return interfazcontableid;
    }

    public void setInterfazcontableid(int interfazcontableid) {
        this.interfazcontableid = interfazcontableid;
    }

    public int getCuentacontableid() {
        return cuentacontableid;
    }

    public void setCuentacontableid(int cuentacontableid) {
        this.cuentacontableid = cuentacontableid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) interfazcontableid;
        hash += (int) cuentacontableid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterfazcontabledetallePK)) {
            return false;
        }
        InterfazcontabledetallePK other = (InterfazcontabledetallePK) object;
        if (this.interfazcontableid != other.interfazcontableid) {
            return false;
        }
        if (this.cuentacontableid != other.cuentacontableid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.InterfazcontabledetallePK[ interfazcontableid=" + interfazcontableid + ", cuentacontableid=" + cuentacontableid + " ]";
    }
    
}
