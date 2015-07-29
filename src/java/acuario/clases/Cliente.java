/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteid", query = "SELECT c FROM Cliente c WHERE c.clienteid = :clienteid"),
    @NamedQuery(name = "Cliente.findByClientefechanacimiento", query = "SELECT c FROM Cliente c WHERE c.clientefechanacimiento = :clientefechanacimiento"),
    @NamedQuery(name = "Cliente.findByClientedeuda", query = "SELECT c FROM Cliente c WHERE c.clientedeuda = :clientedeuda"),
    @NamedQuery(name = "Cliente.findByClientepago", query = "SELECT c FROM Cliente c WHERE c.clientepago = :clientepago"),
    @NamedQuery(name = "Cliente.findByClienteestado", query = "SELECT c FROM Cliente c WHERE c.clienteestado = :clienteestado")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer clienteid;
    @Temporal(TemporalType.DATE)
    private Date clientefechanacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal clientedeuda;
    private BigDecimal clientepago;
    @Size(max = 10)
    private String clienteestado;
    @JoinColumn(name = "PERSONAID", referencedColumnName = "PERSONAID")
    @ManyToOne(optional = false)
    private Persona personaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteid")
    private List<Ingreso> ingresoList;

    public Cliente() {
    }

    public Cliente(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Date getClientefechanacimiento() {
        return clientefechanacimiento;
    }

    public void setClientefechanacimiento(Date clientefechanacimiento) {
        this.clientefechanacimiento = clientefechanacimiento;
    }

    public BigDecimal getClientedeuda() {
        return clientedeuda;
    }

    public void setClientedeuda(BigDecimal clientedeuda) {
        this.clientedeuda = clientedeuda;
    }

    public BigDecimal getClientepago() {
        return clientepago;
    }

    public void setClientepago(BigDecimal clientepago) {
        this.clientepago = clientepago;
    }

    public String getClienteestado() {
        return clienteestado;
    }

    public void setClienteestado(String clienteestado) {
        this.clienteestado = clienteestado;
    }

    public Persona getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Persona personaid) {
        this.personaid = personaid;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteid != null ? clienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteid == null && other.clienteid != null) || (this.clienteid != null && !this.clienteid.equals(other.clienteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Cliente[ clienteid=" + clienteid + " ]";
    }
    
}
