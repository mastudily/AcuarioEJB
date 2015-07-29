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
public class ProgramaperfilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    private int perfilid;
    @Basic(optional = false)
    @NotNull
    private int programaid;

    public ProgramaperfilPK() {
    }

    public ProgramaperfilPK(int perfilid, int programaid) {
        this.perfilid = perfilid;
        this.programaid = programaid;
    }

    public int getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(int perfilid) {
        this.perfilid = perfilid;
    }

    public int getProgramaid() {
        return programaid;
    }

    public void setProgramaid(int programaid) {
        this.programaid = programaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perfilid;
        hash += (int) programaid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaperfilPK)) {
            return false;
        }
        ProgramaperfilPK other = (ProgramaperfilPK) object;
        if (this.perfilid != other.perfilid) {
            return false;
        }
        if (this.programaid != other.programaid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.ProgramaperfilPK[ perfilid=" + perfilid + ", programaid=" + programaid + " ]";
    }
    
}
