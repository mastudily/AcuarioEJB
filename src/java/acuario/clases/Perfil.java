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
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPerfilid", query = "SELECT p FROM Perfil p WHERE p.perfilid = :perfilid"),
    @NamedQuery(name = "Perfil.findByPerfilnombre", query = "SELECT p FROM Perfil p WHERE p.perfilnombre = :perfilnombre"),
    @NamedQuery(name = "Perfil.findByPerfildescripcion", query = "SELECT p FROM Perfil p WHERE p.perfildescripcion = :perfildescripcion"),
    @NamedQuery(name = "Perfil.findByPerfilestado", query = "SELECT p FROM Perfil p WHERE p.perfilestado = :perfilestado")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer perfilid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String perfilnombre;
    @Size(max = 100)
    private String perfildescripcion;
    @Size(max = 10)
    private String perfilestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Programaperfil> programaperfilList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilid")
    private List<Usuario> usuarioList;

    public Perfil() {
    }

    public Perfil(Integer perfilid) {
        this.perfilid = perfilid;
    }

    public Perfil(Integer perfilid, String perfilnombre) {
        this.perfilid = perfilid;
        this.perfilnombre = perfilnombre;
    }

    public Integer getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(Integer perfilid) {
        this.perfilid = perfilid;
    }

    public String getPerfilnombre() {
        return perfilnombre;
    }

    public void setPerfilnombre(String perfilnombre) {
        this.perfilnombre = perfilnombre;
    }

    public String getPerfildescripcion() {
        return perfildescripcion;
    }

    public void setPerfildescripcion(String perfildescripcion) {
        this.perfildescripcion = perfildescripcion;
    }

    public String getPerfilestado() {
        return perfilestado;
    }

    public void setPerfilestado(String perfilestado) {
        this.perfilestado = perfilestado;
    }

    @XmlTransient
    public List<Programaperfil> getProgramaperfilList() {
        return programaperfilList;
    }

    public void setProgramaperfilList(List<Programaperfil> programaperfilList) {
        this.programaperfilList = programaperfilList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilid != null ? perfilid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilid == null && other.perfilid != null) || (this.perfilid != null && !this.perfilid.equals(other.perfilid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Perfil[ perfilid=" + perfilid + " ]";
    }
    
}
