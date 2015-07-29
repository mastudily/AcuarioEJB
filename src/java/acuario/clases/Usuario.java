/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo Astudillo
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioid", query = "SELECT u FROM Usuario u WHERE u.usuarioid = :usuarioid"),
    @NamedQuery(name = "Usuario.findByUsuarioidentidad", query = "SELECT u FROM Usuario u WHERE u.usuarioidentidad = :usuarioidentidad"),
    @NamedQuery(name = "Usuario.findByUsuarioclave", query = "SELECT u FROM Usuario u WHERE u.usuarioclave = :usuarioclave"),
    @NamedQuery(name = "Usuario.findByUsuarioestado", query = "SELECT u FROM Usuario u WHERE u.usuarioestado = :usuarioestado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer usuarioid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String usuarioidentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String usuarioclave;
    @Size(max = 10)
    private String usuarioestado;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID")
    @ManyToOne(optional = false)
    private Empresa empresaid;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Persona personaid;
    @JoinColumn(name = "PERFILID", referencedColumnName = "PERFILID")
    @ManyToOne(optional = false)
    private Perfil perfilid;

    public Usuario() {
    }

    public Usuario(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Usuario(Integer usuarioid, String usuarioidentidad, String usuarioclave) {
        this.usuarioid = usuarioid;
        this.usuarioidentidad = usuarioidentidad;
        this.usuarioclave = usuarioclave;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsuarioidentidad() {
        return usuarioidentidad;
    }

    public void setUsuarioidentidad(String usuarioidentidad) {
        this.usuarioidentidad = usuarioidentidad;
    }

    public String getUsuarioclave() {
        return usuarioclave;
    }

    public void setUsuarioclave(String usuarioclave) {
        this.usuarioclave = usuarioclave;
    }

    public String getUsuarioestado() {
        return usuarioestado;
    }

    public void setUsuarioestado(String usuarioestado) {
        this.usuarioestado = usuarioestado;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    public Persona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Persona personaid) {
        this.personaid = personaid;
    }

    public Perfil getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(Perfil perfilid) {
        this.perfilid = perfilid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioid != null ? usuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioid == null && other.usuarioid != null) || (this.usuarioid != null && !this.usuarioid.equals(other.usuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Usuario[ usuarioid=" + usuarioid + " ]";
    }
    
}
