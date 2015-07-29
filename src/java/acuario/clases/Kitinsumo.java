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
    @NamedQuery(name = "Kitinsumo.findAll", query = "SELECT k FROM Kitinsumo k"),
    @NamedQuery(name = "Kitinsumo.findByKitinsumoid", query = "SELECT k FROM Kitinsumo k WHERE k.kitinsumoid = :kitinsumoid"),
    @NamedQuery(name = "Kitinsumo.findByKitinsumodescripcion", query = "SELECT k FROM Kitinsumo k WHERE k.kitinsumodescripcion = :kitinsumodescripcion"),
    @NamedQuery(name = "Kitinsumo.findByKitinsumoabreviatura", query = "SELECT k FROM Kitinsumo k WHERE k.kitinsumoabreviatura = :kitinsumoabreviatura"),
    @NamedQuery(name = "Kitinsumo.findByKitinsumoestado", query = "SELECT k FROM Kitinsumo k WHERE k.kitinsumoestado = :kitinsumoestado")})
public class Kitinsumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer kitinsumoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String kitinsumodescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String kitinsumoabreviatura;
    @Size(max = 10)
    private String kitinsumoestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kitinsumo")
    private List<Kitinsumodetalle> kitinsumodetalleList;

    public Kitinsumo() {
    }

    public Kitinsumo(Integer kitinsumoid) {
        this.kitinsumoid = kitinsumoid;
    }

    public Kitinsumo(Integer kitinsumoid, String kitinsumodescripcion, String kitinsumoabreviatura) {
        this.kitinsumoid = kitinsumoid;
        this.kitinsumodescripcion = kitinsumodescripcion;
        this.kitinsumoabreviatura = kitinsumoabreviatura;
    }

    public Integer getKitinsumoid() {
        return kitinsumoid;
    }

    public void setKitinsumoid(Integer kitinsumoid) {
        this.kitinsumoid = kitinsumoid;
    }

    public String getKitinsumodescripcion() {
        return kitinsumodescripcion;
    }

    public void setKitinsumodescripcion(String kitinsumodescripcion) {
        this.kitinsumodescripcion = kitinsumodescripcion;
    }

    public String getKitinsumoabreviatura() {
        return kitinsumoabreviatura;
    }

    public void setKitinsumoabreviatura(String kitinsumoabreviatura) {
        this.kitinsumoabreviatura = kitinsumoabreviatura;
    }

    public String getKitinsumoestado() {
        return kitinsumoestado;
    }

    public void setKitinsumoestado(String kitinsumoestado) {
        this.kitinsumoestado = kitinsumoestado;
    }

    @XmlTransient
    public List<Kitinsumodetalle> getKitinsumodetalleList() {
        return kitinsumodetalleList;
    }

    public void setKitinsumodetalleList(List<Kitinsumodetalle> kitinsumodetalleList) {
        this.kitinsumodetalleList = kitinsumodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitinsumoid != null ? kitinsumoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitinsumo)) {
            return false;
        }
        Kitinsumo other = (Kitinsumo) object;
        if ((this.kitinsumoid == null && other.kitinsumoid != null) || (this.kitinsumoid != null && !this.kitinsumoid.equals(other.kitinsumoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Kitinsumo[ kitinsumoid=" + kitinsumoid + " ]";
    }
    
}
