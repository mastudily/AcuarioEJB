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
    @NamedQuery(name = "Cuentacontable.findAll", query = "SELECT c FROM Cuentacontable c"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontableid", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontableid = :cuentacontableid"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablecodigo", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablecodigo = :cuentacontablecodigo"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablenombre", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablenombre = :cuentacontablenombre"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontabledescripcion", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontabledescripcion = :cuentacontabledescripcion"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablepadre", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablepadre = :cuentacontablepadre"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablemayor", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablemayor = :cuentacontablemayor"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablepadreid", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablepadreid = :cuentacontablepadreid"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontablesigno", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontablesigno = :cuentacontablesigno"),
    @NamedQuery(name = "Cuentacontable.findByCuentacontableestado", query = "SELECT c FROM Cuentacontable c WHERE c.cuentacontableestado = :cuentacontableestado")})
public class Cuentacontable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer cuentacontableid;
    @Size(max = 20)
    private String cuentacontablecodigo;
    @Size(max = 30)
    private String cuentacontablenombre;
    @Size(max = 100)
    private String cuentacontabledescripcion;
    private Boolean cuentacontablepadre;
    private Boolean cuentacontablemayor;
    private Integer cuentacontablepadreid;
    @Size(max = 1)
    private String cuentacontablesigno;
    @Size(max = 10)
    private String cuentacontableestado;
    @OneToMany(mappedBy = "formapagoctacble")
    private List<Formapago> formapagoList;
    @OneToMany(mappedBy = "formapagoconctacble")
    private List<Formapago> formapagoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentacontable")
    private List<Diariodetalle> diariodetalleList;
    @JoinColumn(name = "EMPRESAID", referencedColumnName = "EMPRESAID")
    @ManyToOne(optional = false)
    private Empresa empresaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentacontable")
    private List<Interfazcontabledetalle> interfazcontabledetalleList;

    public Cuentacontable() {
    }

    public Cuentacontable(Integer cuentacontableid) {
        this.cuentacontableid = cuentacontableid;
    }

    public Integer getCuentacontableid() {
        return cuentacontableid;
    }

    public void setCuentacontableid(Integer cuentacontableid) {
        this.cuentacontableid = cuentacontableid;
    }

    public String getCuentacontablecodigo() {
        return cuentacontablecodigo;
    }

    public void setCuentacontablecodigo(String cuentacontablecodigo) {
        this.cuentacontablecodigo = cuentacontablecodigo;
    }

    public String getCuentacontablenombre() {
        return cuentacontablenombre;
    }

    public void setCuentacontablenombre(String cuentacontablenombre) {
        this.cuentacontablenombre = cuentacontablenombre;
    }

    public String getCuentacontabledescripcion() {
        return cuentacontabledescripcion;
    }

    public void setCuentacontabledescripcion(String cuentacontabledescripcion) {
        this.cuentacontabledescripcion = cuentacontabledescripcion;
    }

    public Boolean getCuentacontablepadre() {
        return cuentacontablepadre;
    }

    public void setCuentacontablepadre(Boolean cuentacontablepadre) {
        this.cuentacontablepadre = cuentacontablepadre;
    }

    public Boolean getCuentacontablemayor() {
        return cuentacontablemayor;
    }

    public void setCuentacontablemayor(Boolean cuentacontablemayor) {
        this.cuentacontablemayor = cuentacontablemayor;
    }

    public Integer getCuentacontablepadreid() {
        return cuentacontablepadreid;
    }

    public void setCuentacontablepadreid(Integer cuentacontablepadreid) {
        this.cuentacontablepadreid = cuentacontablepadreid;
    }

    public String getCuentacontablesigno() {
        return cuentacontablesigno;
    }

    public void setCuentacontablesigno(String cuentacontablesigno) {
        this.cuentacontablesigno = cuentacontablesigno;
    }

    public String getCuentacontableestado() {
        return cuentacontableestado;
    }

    public void setCuentacontableestado(String cuentacontableestado) {
        this.cuentacontableestado = cuentacontableestado;
    }

    @XmlTransient
    public List<Formapago> getFormapagoList() {
        return formapagoList;
    }

    public void setFormapagoList(List<Formapago> formapagoList) {
        this.formapagoList = formapagoList;
    }

    @XmlTransient
    public List<Formapago> getFormapagoList1() {
        return formapagoList1;
    }

    public void setFormapagoList1(List<Formapago> formapagoList1) {
        this.formapagoList1 = formapagoList1;
    }

    @XmlTransient
    public List<Diariodetalle> getDiariodetalleList() {
        return diariodetalleList;
    }

    public void setDiariodetalleList(List<Diariodetalle> diariodetalleList) {
        this.diariodetalleList = diariodetalleList;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    @XmlTransient
    public List<Interfazcontabledetalle> getInterfazcontabledetalleList() {
        return interfazcontabledetalleList;
    }

    public void setInterfazcontabledetalleList(List<Interfazcontabledetalle> interfazcontabledetalleList) {
        this.interfazcontabledetalleList = interfazcontabledetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuentacontableid != null ? cuentacontableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacontable)) {
            return false;
        }
        Cuentacontable other = (Cuentacontable) object;
        if ((this.cuentacontableid == null && other.cuentacontableid != null) || (this.cuentacontableid != null && !this.cuentacontableid.equals(other.cuentacontableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Cuentacontable[ cuentacontableid=" + cuentacontableid + " ]";
    }
    
}
