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
public class KitinsumodetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int insumoid;
    @Basic(optional = false)
    @NotNull
    private int kitinsumoid;

    public KitinsumodetallePK() {
    }

    public KitinsumodetallePK(int insumoid, int kitinsumoid) {
        this.insumoid = insumoid;
        this.kitinsumoid = kitinsumoid;
    }

    public int getInsumoid() {
        return insumoid;
    }

    public void setInsumoid(int insumoid) {
        this.insumoid = insumoid;
    }

    public int getKitinsumoid() {
        return kitinsumoid;
    }

    public void setKitinsumoid(int kitinsumoid) {
        this.kitinsumoid = kitinsumoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) insumoid;
        hash += (int) kitinsumoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KitinsumodetallePK)) {
            return false;
        }
        KitinsumodetallePK other = (KitinsumodetallePK) object;
        if (this.insumoid != other.insumoid) {
            return false;
        }
        if (this.kitinsumoid != other.kitinsumoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.KitinsumodetallePK[ insumoid=" + insumoid + ", kitinsumoid=" + kitinsumoid + " ]";
    }
    
}
