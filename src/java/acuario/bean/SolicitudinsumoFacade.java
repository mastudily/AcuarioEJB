/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Solicitudinsumo;
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
public class SolicitudinsumoFacade extends AbstractFacade<Solicitudinsumo> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudinsumoFacade() {
        super(Solicitudinsumo.class);
    }

    public Solicitudinsumo findSolicitudinsumoid(Integer id) {
        Query q = em.createNamedQuery("Solicitudinsumo.findBySolicitudinsumoid");
        q.setParameter("solicitudinsumoid", id);
        Solicitudinsumo result = null;
        try {
            result = (Solicitudinsumo) q.getSingleResult();
        } catch (Exception e) {
        }
        return result;
    }

    public List<Solicitudinsumo> findSolicitudinsumoByFecha(Date fecha, Integer empresaid) {
        Query q = em.createQuery("SELECT s FROM Solicitudinsumo s "
                + "WHERE s.solicitudinsumofecha >= :solicitudinsumofecha "
                + "AND s.empresaid.empresaid = :empresaid "
                + "ORDER BY s.solicitudinsumofecha");
        q.setParameter("solicitudinsumofecha", fecha);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Solicitudinsumo> result = q.getResultList();
        return result;
    }
}
