/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Ingresoforpag.findAll", query = "SELECT i FROM Ingresoforpag i"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoid", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagPK.ingresoid = :ingresoid"),
    @NamedQuery(name = "Ingresoforpag.findByFormapagoid", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagPK.formapagoid = :formapagoid"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagvalor", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagvalor = :ingresoforpagvalor"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagbanemi", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagbanemi = :ingresoforpagbanemi"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagreferencia1", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagreferencia1 = :ingresoforpagreferencia1"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagreferencia2", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagreferencia2 = :ingresoforpagreferencia2"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagreferencia3", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagreferencia3 = :ingresoforpagreferencia3"),
    @NamedQuery(name = "Ingresoforpag.findByIngresoforpagestado", query = "SELECT i FROM Ingresoforpag i WHERE i.ingresoforpagestado = :ingresoforpagestado")})
public class Ingresoforpag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresoforpagPK ingresoforpagPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal ingresoforpagvalor;
    @Size(max = 10)
    private String ingresoforpagbanemi;
    @Size(max = 30)
    private String ingresoforpagreferencia1;
    @Size(max = 30)
    private String ingresoforpagreferencia2;
    @Size(max = 30)
    private String ingresoforpagreferencia3;
    @Size(max = 10)
    private String ingresoforpagestado;
    @JoinColumn(name = "FORMAPAGOID", referencedColumnName = "FORMAPAGOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Formapago formapago;
    @JoinColumn(name = "INGRESOID", referencedColumnName = "INGRESOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingreso ingreso;

    public Ingresoforpag() {
    }

    public Ingresoforpag(IngresoforpagPK ingresoforpagPK) {
        this.ingresoforpagPK = ingresoforpagPK;
    }

    public Ingresoforpag(int ingresoid, int formapagoid) {
        this.ingresoforpagPK = new IngresoforpagPK(ingresoid, formapagoid);
    }

    public IngresoforpagPK getIngresoforpagPK() {
        return ingresoforpagPK;
    }

    public void setIngresoforpagPK(IngresoforpagPK ingresoforpagPK) {
        this.ingresoforpagPK = ingresoforpagPK;
    }

    public BigDecimal getIngresoforpagvalor() {
        return ingresoforpagvalor;
    }

    public void setIngresoforpagvalor(BigDecimal ingresoforpagvalor) {
        this.ingresoforpagvalor = ingresoforpagvalor;
    }

    public String getIngresoforpagbanemi() {
        return ingresoforpagbanemi;
    }

    public void setIngresoforpagbanemi(String ingresoforpagbanemi) {
        this.ingresoforpagbanemi = ingresoforpagbanemi;
    }

    public String getIngresoforpagreferencia1() {
        return ingresoforpagreferencia1;
    }

    public void setIngresoforpagreferencia1(String ingresoforpagreferencia1) {
        this.ingresoforpagreferencia1 = ingresoforpagreferencia1;
    }

    public String getIngresoforpagreferencia2() {
        return ingresoforpagreferencia2;
    }

    public void setIngresoforpagreferencia2(String ingresoforpagreferencia2) {
        this.ingresoforpagreferencia2 = ingresoforpagreferencia2;
    }

    public String getIngresoforpagreferencia3() {
        return ingresoforpagreferencia3;
    }

    public void setIngresoforpagreferencia3(String ingresoforpagreferencia3) {
        this.ingresoforpagreferencia3 = ingresoforpagreferencia3;
    }

    public String getIngresoforpagestado() {
        return ingresoforpagestado;
    }

    public void setIngresoforpagestado(String ingresoforpagestado) {
        this.ingresoforpagestado = ingresoforpagestado;
    }

    public Formapago getFormapago() {
        return formapago;
    }

    public void setFormapago(Formapago formapago) {
        this.formapago = formapago;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingresoforpagPK != null ? ingresoforpagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresoforpag)) {
            return false;
        }
        Ingresoforpag other = (Ingresoforpag) object;
        if ((this.ingresoforpagPK == null && other.ingresoforpagPK != null) || (this.ingresoforpagPK != null && !this.ingresoforpagPK.equals(other.ingresoforpagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Ingresoforpag[ ingresoforpagPK=" + ingresoforpagPK + " ]";
    }
    
}
