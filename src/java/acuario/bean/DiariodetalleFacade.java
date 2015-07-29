/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Diariodetalle;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcelo Astudillo
 */
@Stateless
public class DiariodetalleFacade extends AbstractFacade<Diariodetalle> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiariodetalleFacade() {
        super(Diariodetalle.class);
    }

    public List<Diariodetalle> findByDiarioid(Integer id) {
        Query q = em.createNamedQuery("Diariodetalle.findByDiarioid");
        q.setParameter("diarioid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Diariodetalle> result = q.getResultList();
        return result;
    }

    public List<Diariodetalle> findByCuentacontableid(Integer id) {
        Query q = em.createNamedQuery("Diariodetalle.findByCuentacontableid");
        q.setParameter("cuentacontableid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Diariodetalle> result = q.getResultList();
        return result;
    }

    public List<Diariodetalle> findDiariodetalleByFecha(Date fechaInicial, Date fechaFinal, Integer empresaid) {
        Query q = em.createQuery("SELECT d FROM Diariodetalle d, Diario i "
                + "WHERE d.diariodetallePK.diarioid = i.diarioid "
                + "AND i.diariofecha >= :fechainicial "
                + "AND i.diariofecha <= :fechafinal "
                + "AND i.empresaid.empresaid = :empresaid "
                + "ORDER BY i.diariofecha");
        q.setParameter("fechainicial", fechaInicial);
        q.setParameter("fechafinal", fechaFinal);
        q.setParameter("empresaid", empresaid);
        List<Diariodetalle> result = q.getResultList();
        return result;
    }
}
