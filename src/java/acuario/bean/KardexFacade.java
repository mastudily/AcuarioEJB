/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Kardex;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
public class KardexFacade extends AbstractFacade<Kardex> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KardexFacade() {
        super(Kardex.class);
    }

    public List<Kardex> findBySolicitudinsumoid(Integer id) {
        Query q = em.createNamedQuery("Kardex.findBySolicitudinsumoid");
        q.setParameter("solicitudinsumoid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kardex> result = new ArrayList();
        for (Iterator<Kardex> iterator = q.getResultList().iterator(); iterator.hasNext();) {
            Kardex next = iterator.next();
            em.refresh(next);
            result.add(next);
        }
        return result;
    }

    public List<Kardex> findByInsumoidPeriodo(Integer id, Date fecini, Date fecfin, String estado) {
        Query q = em.createQuery("SELECT k FROM Kardex k "
                + "WHERE k.kardexPK.insumoid = :insumoid "
                + "AND k.kardexfecha >= :fechainicial "
                + "AND k.kardexfecha <= :fechafinal "
                + "AND k.kardexestado = :kardexestado "
                + "ORDER BY k.kardexfecha ASC");
        q.setParameter("insumoid", id);
        q.setParameter("fechainicial", fecini);
        q.setParameter("fechafinal", fecfin);
        q.setParameter("kardexestado", estado);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kardex> result = new ArrayList();
        for (Iterator<Kardex> iterator = q.getResultList().iterator(); iterator.hasNext();) {
            Kardex next = iterator.next();
            em.refresh(next);
            result.add(next);
        }
        return result;
    }

}
