/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Constante.findAll", query = "SELECT c FROM Constante c"),
    @NamedQuery(name = "Constante.findByConstanteid", query = "SELECT c FROM Constante c WHERE c.constanteid = :constanteid"),
    @NamedQuery(name = "Constante.findByConstantecodigo", query = "SELECT c FROM Constante c WHERE c.constantecodigo = :constantecodigo"),
    @NamedQuery(name = "Constante.findByConstantetipo", query = "SELECT c FROM Constante c WHERE c.constantetipo = :constantetipo"),
    @NamedQuery(name = "Constante.findByConstantedescripcion", query = "SELECT c FROM Constante c WHERE c.constantedescripcion = :constantedescripcion"),
    @NamedQuery(name = "Constante.findByConstanteabreviatura", query = "SELECT c FROM Constante c WHERE c.constanteabreviatura = :constanteabreviatura"),
    @NamedQuery(name = "Constante.findByConstantevalor", query = "SELECT c FROM Constante c WHERE c.constantevalor = :constantevalor"),
    @NamedQuery(name = "Constante.findByConstanteestado", query = "SELECT c FROM Constante c WHERE c.constanteestado = :constanteestado")})
public class Constante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer constanteid;
    @Size(max = 10)
    private String constantecodigo;
    @Size(max = 10)
    private String constantetipo;
    @Size(max = 100)
    private String constantedescripcion;
    @Size(max = 30)
    private String constanteabreviatura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal constantevalor;
    @Size(max = 10)
    private String constanteestado;

    public Constante() {
    }

    public Constante(Integer constanteid) {
        this.constanteid = constanteid;
    }

    public Integer getConstanteid() {
        return constanteid;
    }

    public void setConstanteid(Integer constanteid) {
        this.constanteid = constanteid;
    }

    public String getConstantecodigo() {
        return constantecodigo;
    }

    public void setConstantecodigo(String constantecodigo) {
        this.constantecodigo = constantecodigo;
    }

    public String getConstantetipo() {
        return constantetipo;
    }

    public void setConstantetipo(String constantetipo) {
        this.constantetipo = constantetipo;
    }

    public String getConstantedescripcion() {
        return constantedescripcion;
    }

    public void setConstantedescripcion(String constantedescripcion) {
        this.constantedescripcion = constantedescripcion;
    }

    public String getConstanteabreviatura() {
        return constanteabreviatura;
    }

    public void setConstanteabreviatura(String constanteabreviatura) {
        this.constanteabreviatura = constanteabreviatura;
    }

    public BigDecimal getConstantevalor() {
        return constantevalor;
    }

    public void setConstantevalor(BigDecimal constantevalor) {
        this.constantevalor = constantevalor;
    }

    public String getConstanteestado() {
        return constanteestado;
    }

    public void setConstanteestado(String constanteestado) {
        this.constanteestado = constanteestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constanteid != null ? constanteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constante)) {
            return false;
        }
        Constante other = (Constante) object;
        if ((this.constanteid == null && other.constanteid != null) || (this.constanteid != null && !this.constanteid.equals(other.constanteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Constante[ constanteid=" + constanteid + " ]";
    }
    
}
