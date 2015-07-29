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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Formapago.findAll", query = "SELECT f FROM Formapago f"),
    @NamedQuery(name = "Formapago.findByFormapagoid", query = "SELECT f FROM Formapago f WHERE f.formapagoid = :formapagoid"),
    @NamedQuery(name = "Formapago.findByFormapagonombre", query = "SELECT f FROM Formapago f WHERE f.formapagonombre = :formapagonombre"),
    @NamedQuery(name = "Formapago.findByFormapagodescripcion", query = "SELECT f FROM Formapago f WHERE f.formapagodescripcion = :formapagodescripcion"),
    @NamedQuery(name = "Formapago.findByFormapagoestado", query = "SELECT f FROM Formapago f WHERE f.formapagoestado = :formapagoestado")})
public class Formapago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer formapagoid;
    @Size(max = 30)
    private String formapagonombre;
    @Size(max = 100)
    private String formapagodescripcion;
    @Size(max = 10)
    private String formapagoestado;
    @JoinColumn(name = "FORMAPAGOCTACBLE", referencedColumnName = "CUENTACONTABLEID")
    @ManyToOne
    private Cuentacontable formapagoctacble;
    @JoinColumn(name = "FORMAPAGOCONCTACBLE", referencedColumnName = "CUENTACONTABLEID")
    @ManyToOne
    private Cuentacontable formapagoconctacble;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formapago")
    private List<Ingresoforpag> ingresoforpagList;

    public Formapago() {
    }

    public Formapago(Integer formapagoid) {
        this.formapagoid = formapagoid;
    }

    public Integer getFormapagoid() {
        return formapagoid;
    }

    public void setFormapagoid(Integer formapagoid) {
        this.formapagoid = formapagoid;
    }

    public String getFormapagonombre() {
        return formapagonombre;
    }

    public void setFormapagonombre(String formapagonombre) {
        this.formapagonombre = formapagonombre;
    }

    public String getFormapagodescripcion() {
        return formapagodescripcion;
    }

    public void setFormapagodescripcion(String formapagodescripcion) {
        this.formapagodescripcion = formapagodescripcion;
    }

    public String getFormapagoestado() {
        return formapagoestado;
    }

    public void setFormapagoestado(String formapagoestado) {
        this.formapagoestado = formapagoestado;
    }

    public Cuentacontable getFormapagoctacble() {
        return formapagoctacble;
    }

    public void setFormapagoctacble(Cuentacontable formapagoctacble) {
        this.formapagoctacble = formapagoctacble;
    }

    public Cuentacontable getFormapagoconctacble() {
        return formapagoconctacble;
    }

    public void setFormapagoconctacble(Cuentacontable formapagoconctacble) {
        this.formapagoconctacble = formapagoconctacble;
    }

    @XmlTransient
    public List<Ingresoforpag> getIngresoforpagList() {
        return ingresoforpagList;
    }

    public void setIngresoforpagList(List<Ingresoforpag> ingresoforpagList) {
        this.ingresoforpagList = ingresoforpagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formapagoid != null ? formapagoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapago)) {
            return false;
        }
        Formapago other = (Formapago) object;
        if ((this.formapagoid == null && other.formapagoid != null) || (this.formapagoid != null && !this.formapagoid.equals(other.formapagoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Formapago[ formapagoid=" + formapagoid + " ]";
    }
    
}
