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
public class DiariodetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int diarioid;
    @Basic(optional = false)
    @NotNull
    private int cuentacontableid;

    public DiariodetallePK() {
    }

    public DiariodetallePK(int diarioid, int cuentacontableid) {
        this.diarioid = diarioid;
        this.cuentacontableid = cuentacontableid;
    }

    public int getDiarioid() {
        return diarioid;
    }

    public void setDiarioid(int diarioid) {
        this.diarioid = diarioid;
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
        hash += (int) diarioid;
        hash += (int) cuentacontableid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiariodetallePK)) {
            return false;
        }
        DiariodetallePK other = (DiariodetallePK) object;
        if (this.diarioid != other.diarioid) {
            return false;
        }
        if (this.cuentacontableid != other.cuentacontableid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.DiariodetallePK[ diarioid=" + diarioid + ", cuentacontableid=" + cuentacontableid + " ]";
    }
    
}
