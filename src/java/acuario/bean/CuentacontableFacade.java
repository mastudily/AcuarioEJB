/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Cuentacontable;
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
public class CuentacontableFacade extends AbstractFacade<Cuentacontable> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentacontableFacade() {
        super(Cuentacontable.class);
    }

    public Cuentacontable findByCuentacontablecodigo(String codigo, Integer empresaid) {
        Query q = em.createQuery("SELECT c FROM Cuentacontable c WHERE c.cuentacontablecodigo = :cuentacontablecodigo AND c.empresaid.empresaid = :empresaid");
        q.setParameter("cuentacontablecodigo", codigo);
        q.setParameter("empresaid", empresaid);
        Cuentacontable result = (Cuentacontable) q.getSingleResult();
        return result;
    }

    public List<Cuentacontable> findCuentacontableByCodigo(String codigo, Integer empresaid) {
        Query q = em.createQuery("SELECT c FROM Cuentacontable c "
                + "WHERE c.cuentacontablecodigo >= :cuentacontablecodigo "
                + "AND c.empresaid.empresaid = :empresaid "
                + "ORDER BY c.cuentacontablecodigo");
        q.setParameter("cuentacontablecodigo", codigo);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Cuentacontable> result = q.getResultList();
        return result;
    }

    public List<Cuentacontable> findCuentacontableByNombre(String nombre, Integer empresaid) {
        Query q = em.createQuery("SELECT c FROM Cuentacontable c "
                + "WHERE c.cuentacontablenombre >= :cuentacontablenombre "
                + "AND c.empresaid.empresaid = :empresaid "
                + "ORDER BY c.cuentacontablenombre");
        q.setParameter("cuentacontablenombre", nombre);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Cuentacontable> result = q.getResultList();
        return result;
    }

    public List<Cuentacontable> findByCuentacontablemayor(boolean mayor, Integer empresaid) {
        Query q = em.createQuery("SELECT c FROM Cuentacontable c "
                + "WHERE c.cuentacontablemayor = :cuentacontablemayor "
                + "AND c.empresaid.empresaid = :empresaid "
                + "ORDER BY c.cuentacontablecodigo");
        q.setParameter("cuentacontablemayor", mayor);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Cuentacontable> result = q.getResultList();
        return result;
    }
}
