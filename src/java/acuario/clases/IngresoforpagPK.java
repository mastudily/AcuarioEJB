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
public class IngresoforpagPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int ingresoid;
    @Basic(optional = false)
    @NotNull
    private int formapagoid;

    public IngresoforpagPK() {
    }

    public IngresoforpagPK(int ingresoid, int formapagoid) {
        this.ingresoid = ingresoid;
        this.formapagoid = formapagoid;
    }

    public int getIngresoid() {
        return ingresoid;
    }

    public void setIngresoid(int ingresoid) {
        this.ingresoid = ingresoid;
    }

    public int getFormapagoid() {
        return formapagoid;
    }

    public void setFormapagoid(int formapagoid) {
        this.formapagoid = formapagoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ingresoid;
        hash += (int) formapagoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoforpagPK)) {
            return false;
        }
        IngresoforpagPK other = (IngresoforpagPK) object;
        if (this.ingresoid != other.ingresoid) {
            return false;
        }
        if (this.formapagoid != other.formapagoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.IngresoforpagPK[ ingresoid=" + ingresoid + ", formapagoid=" + formapagoid + " ]";
    }
    
}
