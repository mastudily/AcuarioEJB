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
    @NamedQuery(name = "Programaperfil.findAll", query = "SELECT p FROM Programaperfil p"),
    @NamedQuery(name = "Programaperfil.findByPerfilid", query = "SELECT p FROM Programaperfil p WHERE p.programaperfilPK.perfilid = :perfilid"),
    @NamedQuery(name = "Programaperfil.findByProgramaid", query = "SELECT p FROM Programaperfil p WHERE p.programaperfilPK.programaid = :programaid"),
    @NamedQuery(name = "Programaperfil.findByProgramaperfilestado", query = "SELECT p FROM Programaperfil p WHERE p.programaperfilestado = :programaperfilestado")})
public class Programaperfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaperfilPK programaperfilPK;
    @Size(max = 10)
    private String programaperfilestado;
    @JoinColumn(name = "PERFILID", referencedColumnName = "PERFILID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;
    @JoinColumn(name = "PROGRAMAID", referencedColumnName = "PROGRAMAID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programa programa;

    public Programaperfil() {
    }

    public Programaperfil(ProgramaperfilPK programaperfilPK) {
        this.programaperfilPK = programaperfilPK;
    }

    public Programaperfil(int perfilid, int programaid) {
        this.programaperfilPK = new ProgramaperfilPK(perfilid, programaid);
    }

    public ProgramaperfilPK getProgramaperfilPK() {
        return programaperfilPK;
    }

    public void setProgramaperfilPK(ProgramaperfilPK programaperfilPK) {
        this.programaperfilPK = programaperfilPK;
    }

    public String getProgramaperfilestado() {
        return programaperfilestado;
    }

    public void setProgramaperfilestado(String programaperfilestado) {
        this.programaperfilestado = programaperfilestado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaperfilPK != null ? programaperfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programaperfil)) {
            return false;
        }
        Programaperfil other = (Programaperfil) object;
        if ((this.programaperfilPK == null && other.programaperfilPK != null) || (this.programaperfilPK != null && !this.programaperfilPK.equals(other.programaperfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Programaperfil[ programaperfilPK=" + programaperfilPK + " ]";
    }
    
}
