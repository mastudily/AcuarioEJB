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
    @NamedQuery(name = "Diariodetalle.findAll", query = "SELECT d FROM Diariodetalle d"),
    @NamedQuery(name = "Diariodetalle.findByDiarioid", query = "SELECT d FROM Diariodetalle d WHERE d.diariodetallePK.diarioid = :diarioid"),
    @NamedQuery(name = "Diariodetalle.findByCuentacontableid", query = "SELECT d FROM Diariodetalle d WHERE d.diariodetallePK.cuentacontableid = :cuentacontableid"),
    @NamedQuery(name = "Diariodetalle.findByDiariodetalledebe", query = "SELECT d FROM Diariodetalle d WHERE d.diariodetalledebe = :diariodetalledebe"),
    @NamedQuery(name = "Diariodetalle.findByDiariodetallehaber", query = "SELECT d FROM Diariodetalle d WHERE d.diariodetallehaber = :diariodetallehaber"),
    @NamedQuery(name = "Diariodetalle.findByDiariodetalleestado", query = "SELECT d FROM Diariodetalle d WHERE d.diariodetalleestado = :diariodetalleestado")})
public class Diariodetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiariodetallePK diariodetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal diariodetalledebe;
    private BigDecimal diariodetallehaber;
    @Size(max = 10)
    private String diariodetalleestado;
    @JoinColumn(name = "CUENTACONTABLEID", referencedColumnName = "CUENTACONTABLEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuentacontable cuentacontable;
    @JoinColumn(name = "DIARIOID", referencedColumnName = "DIARIOID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diario diario;

    public Diariodetalle() {
    }

    public Diariodetalle(DiariodetallePK diariodetallePK) {
        this.diariodetallePK = diariodetallePK;
    }

    public Diariodetalle(int diarioid, int cuentacontableid) {
        this.diariodetallePK = new DiariodetallePK(diarioid, cuentacontableid);
    }

    public DiariodetallePK getDiariodetallePK() {
        return diariodetallePK;
    }

    public void setDiariodetallePK(DiariodetallePK diariodetallePK) {
        this.diariodetallePK = diariodetallePK;
    }

    public BigDecimal getDiariodetalledebe() {
        return diariodetalledebe;
    }

    public void setDiariodetalledebe(BigDecimal diariodetalledebe) {
        this.diariodetalledebe = diariodetalledebe;
    }

    public BigDecimal getDiariodetallehaber() {
        return diariodetallehaber;
    }

    public void setDiariodetallehaber(BigDecimal diariodetallehaber) {
        this.diariodetallehaber = diariodetallehaber;
    }

    public String getDiariodetalleestado() {
        return diariodetalleestado;
    }

    public void setDiariodetalleestado(String diariodetalleestado) {
        this.diariodetalleestado = diariodetalleestado;
    }

    public Cuentacontable getCuentacontable() {
        return cuentacontable;
    }

    public void setCuentacontable(Cuentacontable cuentacontable) {
        this.cuentacontable = cuentacontable;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diariodetallePK != null ? diariodetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diariodetalle)) {
            return false;
        }
        Diariodetalle other = (Diariodetalle) object;
        if ((this.diariodetallePK == null && other.diariodetallePK != null) || (this.diariodetallePK != null && !this.diariodetallePK.equals(other.diariodetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acuario.clases.Diariodetalle[ diariodetallePK=" + diariodetallePK + " ]";
    }
    
}
