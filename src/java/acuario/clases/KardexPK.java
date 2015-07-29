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
public class KardexPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int empresaid;
    @Basic(optional = false)
    @NotNull
    private int insumoid;
    @Basic(optional = false)
    @NotNull
    private int solicitudinsumoid;

    public KardexPK() {
    }

    public KardexPK(int empresaid, int insumoid, int solicitudinsumoid) {
        this.empresaid = empresaid;
        this.insumoid = insumoid;
        this.solicitudinsumoid = solicitudinsumoid;
    }

    public int getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(int empresaid) {
        this.empresaid = empresaid;
    }

    public int getInsumoid() {
        return insumoid;
    }

    public void setInsumoid(int insumoid) {
        this.insumoid = insumoid;
    }

    public int getSolicitudinsumoid() {
        return solicitudinsumoid;
    }

    public void setSolicitudinsumoid(int solicitudinsumoid) {
        this.solicitudinsumoid = solicitudinsumoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresaid;
        hash += (int) insumoid;
        hash += (int) solicitudinsumoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KardexPK)) {
            return false;
        }
        KardexPK other = (KardexPK) object;
        if (this.empresaid != other.empresaid) {
            return false;
        }
        if (this.insumoid != other.insumoid) {
            return false;
        }
        if (this.solicitudinsumoid != other.solicitudinsumoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.KardexPK[ empresaid=" + empresaid + ", insumoid=" + insumoid + ", solicitudinsumoid=" + solicitudinsumoid + " ]";
    }
    
}
