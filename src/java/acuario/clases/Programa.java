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
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByProgramaid", query = "SELECT p FROM Programa p WHERE p.programaid = :programaid"),
    @NamedQuery(name = "Programa.findByProgramanombre", query = "SELECT p FROM Programa p WHERE p.programanombre = :programanombre"),
    @NamedQuery(name = "Programa.findByProgramadescripcion", query = "SELECT p FROM Programa p WHERE p.programadescripcion = :programadescripcion"),
    @NamedQuery(name = "Programa.findByProgramaabreviatura", query = "SELECT p FROM Programa p WHERE p.programaabreviatura = :programaabreviatura"),
    @NamedQuery(name = "Programa.findByProgramatipo", query = "SELECT p FROM Programa p WHERE p.programatipo = :programatipo"),
    @NamedQuery(name = "Programa.findByProgramanivel", query = "SELECT p FROM Programa p WHERE p.programanivel = :programanivel"),
    @NamedQuery(name = "Programa.findByProgramapadreid", query = "SELECT p FROM Programa p WHERE p.programapadreid = :programapadreid"),
    @NamedQuery(name = "Programa.findByProgramaorden", query = "SELECT p FROM Programa p WHERE p.programaorden = :programaorden"),
    @NamedQuery(name = "Programa.findByProgramaestado", query = "SELECT p FROM Programa p WHERE p.programaestado = :programaestado")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer programaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String programanombre;
    @Size(max = 100)
    private String programadescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String programaabreviatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String programatipo;
    @Basic(optional = false)
    @NotNull
    private short programanivel;
    @Basic(optional = false)
    @NotNull
    private int programapadreid;
    @Basic(optional = false)
    @NotNull
    private short programaorden;
    @Size(max = 10)
    private String programaestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private List<Programaperfil> programaperfilList;

    public Programa() {
    }

    public Programa(Integer programaid) {
        this.programaid = programaid;
    }

    public Programa(Integer programaid, String programanombre, String programaabreviatura, String programatipo, short programanivel, int programapadreid, short programaorden) {
        this.programaid = programaid;
        this.programanombre = programanombre;
        this.programaabreviatura = programaabreviatura;
        this.programatipo = programatipo;
        this.programanivel = programanivel;
        this.programapadreid = programapadreid;
        this.programaorden = programaorden;
    }

    public Integer getProgramaid() {
        return programaid;
    }

    public void setProgramaid(Integer programaid) {
        this.programaid = programaid;
    }

    public String getProgramanombre() {
        return programanombre;
    }

    public void setProgramanombre(String programanombre) {
        this.programanombre = programanombre;
    }

    public String getProgramadescripcion() {
        return programadescripcion;
    }

    public void setProgramadescripcion(String programadescripcion) {
        this.programadescripcion = programadescripcion;
    }

    public String getProgramaabreviatura() {
        return programaabreviatura;
    }

    public void setProgramaabreviatura(String programaabreviatura) {
        this.programaabreviatura = programaabreviatura;
    }

    public String getProgramatipo() {
        return programatipo;
    }

    public void setProgramatipo(String programatipo) {
        this.programatipo = programatipo;
    }

    public short getProgramanivel() {
        return programanivel;
    }

    public void setProgramanivel(short programanivel) {
        this.programanivel = programanivel;
    }

    public int getProgramapadreid() {
        return programapadreid;
    }

    public void setProgramapadreid(int programapadreid) {
        this.programapadreid = programapadreid;
    }

    public short getProgramaorden() {
        return programaorden;
    }

    public void setProgramaorden(short programaorden) {
        this.programaorden = programaorden;
    }

    public String getProgramaestado() {
        return programaestado;
    }

    public void setProgramaestado(String programaestado) {
        this.programaestado = programaestado;
    }

    @XmlTransient
    public List<Programaperfil> getProgramaperfilList() {
        return programaperfilList;
    }

    public void setProgramaperfilList(List<Programaperfil> programaperfilList) {
        this.programaperfilList = programaperfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaid != null ? programaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.programaid == null && other.programaid != null) || (this.programaid != null && !this.programaid.equals(other.programaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Programa[ programaid=" + programaid + " ]";
    }
    
}
