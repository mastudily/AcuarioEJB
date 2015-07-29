/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersonaid", query = "SELECT p FROM Persona p WHERE p.personaid = :personaid"),
    @NamedQuery(name = "Persona.findByPersonanombres", query = "SELECT p FROM Persona p WHERE p.personanombres = :personanombres"),
    @NamedQuery(name = "Persona.findByPersonaapellidos", query = "SELECT p FROM Persona p WHERE p.personaapellidos = :personaapellidos"),
    @NamedQuery(name = "Persona.findByPersonarut", query = "SELECT p FROM Persona p WHERE p.personarut = :personarut"),
    @NamedQuery(name = "Persona.findByPersonaciudad", query = "SELECT p FROM Persona p WHERE p.personaciudad = :personaciudad"),
    @NamedQuery(name = "Persona.findByPersonacomuna", query = "SELECT p FROM Persona p WHERE p.personacomuna = :personacomuna"),
    @NamedQuery(name = "Persona.findByPersonacorreo", query = "SELECT p FROM Persona p WHERE p.personacorreo = :personacorreo"),
    @NamedQuery(name = "Persona.findByPersonacoordlat", query = "SELECT p FROM Persona p WHERE p.personacoordlat = :personacoordlat"),
    @NamedQuery(name = "Persona.findByPersonacoordlon", query = "SELECT p FROM Persona p WHERE p.personacoordlon = :personacoordlon"),
    @NamedQuery(name = "Persona.findByPersonamovil", query = "SELECT p FROM Persona p WHERE p.personamovil = :personamovil"),
    @NamedQuery(name = "Persona.findByPersonatelefono", query = "SELECT p FROM Persona p WHERE p.personatelefono = :personatelefono"),
    @NamedQuery(name = "Persona.findByPersonaestado", query = "SELECT p FROM Persona p WHERE p.personaestado = :personaestado")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer personaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String personanombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String personaapellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String personarut;
    @Size(max = 10)
    private String personaciudad;
    @Size(max = 10)
    private String personacomuna;
    @Lob
    @Size(max = 65535)
    private String personadireccion;
    @Size(max = 50)
    private String personacorreo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal personacoordlat;
    private BigDecimal personacoordlon;
    @Lob
    private byte[] personafoto;
    @Size(max = 20)
    private String personamovil;
    @Size(max = 20)
    private String personatelefono;
    @Size(max = 10)
    private String personaestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaid")
    private List<Empresa> empresaList;

    public Persona() {
    }

    public Persona(Integer personaid) {
        this.personaid = personaid;
    }

    public Persona(Integer personaid, String personanombres, String personaapellidos, String personarut) {
        this.personaid = personaid;
        this.personanombres = personanombres;
        this.personaapellidos = personaapellidos;
        this.personarut = personarut;
    }

    public Integer getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }

    public String getPersonanombres() {
        return personanombres;
    }

    public void setPersonanombres(String personanombres) {
        this.personanombres = personanombres;
    }

    public String getPersonaapellidos() {
        return personaapellidos;
    }

    public void setPersonaapellidos(String personaapellidos) {
        this.personaapellidos = personaapellidos;
    }

    public String getPersonarut() {
        return personarut;
    }

    public void setPersonarut(String personarut) {
        this.personarut = personarut;
    }

    public String getPersonaciudad() {
        return personaciudad;
    }

    public void setPersonaciudad(String personaciudad) {
        this.personaciudad = personaciudad;
    }

    public String getPersonacomuna() {
        return personacomuna;
    }

    public void setPersonacomuna(String personacomuna) {
        this.personacomuna = personacomuna;
    }

    public String getPersonadireccion() {
        return personadireccion;
    }

    public void setPersonadireccion(String personadireccion) {
        this.personadireccion = personadireccion;
    }

    public String getPersonacorreo() {
        return personacorreo;
    }

    public void setPersonacorreo(String personacorreo) {
        this.personacorreo = personacorreo;
    }

    public BigDecimal getPersonacoordlat() {
        return personacoordlat;
    }

    public void setPersonacoordlat(BigDecimal personacoordlat) {
        this.personacoordlat = personacoordlat;
    }

    public BigDecimal getPersonacoordlon() {
        return personacoordlon;
    }

    public void setPersonacoordlon(BigDecimal personacoordlon) {
        this.personacoordlon = personacoordlon;
    }

    public byte[] getPersonafoto() {
        return personafoto;
    }

    public void setPersonafoto(byte[] personafoto) {
        this.personafoto = personafoto;
    }

    public String getPersonamovil() {
        return personamovil;
    }

    public void setPersonamovil(String personamovil) {
        this.personamovil = personamovil;
    }

    public String getPersonatelefono() {
        return personatelefono;
    }

    public void setPersonatelefono(String personatelefono) {
        this.personatelefono = personatelefono;
    }

    public String getPersonaestado() {
        return personaestado;
    }

    public void setPersonaestado(String personaestado) {
        this.personaestado = personaestado;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaid != null ? personaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaid == null && other.personaid != null) || (this.personaid != null && !this.personaid.equals(other.personaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Persona[ personaid=" + personaid + " ]";
    }
    
}
