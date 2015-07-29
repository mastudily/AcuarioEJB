/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Insumoempresa;
import java.util.ArrayList;
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
public class InsumoempresaFacade extends AbstractFacade<Insumoempresa> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsumoempresaFacade() {
        super(Insumoempresa.class);
    }

    public Insumoempresa findByInsumoempresacodigo(String codigo, Integer empresaid) {
        Query q = em.createQuery("SELECT e FROM Insumoempresa e, Insumo i "
                + "WHERE e.insumoempresaPK.insumoid = i.insumoid "
                + "AND e.insumoempresaPK.empresaid = :empresaid "
                + "AND i.insumocodigo = :insumocodigo ");
        q.setParameter("insumocodigo", codigo);
        q.setParameter("empresaid", empresaid);
        Insumoempresa result = (Insumoempresa) q.getSingleResult();
        return result;
    }

    public List<Insumoempresa> findInsumoempresaByCodigo(String codigo, Integer empresaid) {
        Query q = em.createQuery("SELECT e FROM Insumoempresa e, Insumo i "
                + "WHERE e.insumoempresaPK.insumoid = i.insumoid "
                + "AND e.insumoempresaPK.empresaid = :empresaid "
                + "AND i.insumocodigo >= :insumocodigo "
                + "ORDER BY i.insumocodigo");
        q.setParameter("insumocodigo", codigo);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Insumoempresa> result = new ArrayList();
        for (Iterator<Insumoempresa> iterator = q.getResultList().iterator(); iterator.hasNext();) {
            Insumoempresa next = iterator.next();
            em.refresh(next);
            result.add(next);
        }
        return result;
    }

    public List<Insumoempresa> findInsumoempresaByNombre(String nombre, Integer empresaid) {
        Query q = em.createQuery("SELECT e FROM Insumoempresa e, Insumo i "
                + "WHERE e.insumoempresaPK.insumoid = i.insumoid "
                + "AND e.insumoempresaPK.empresaid = :empresaid "
                + "AND i.insumonombre >= :insumonombre "
                + "ORDER BY i.insumonombre");
        q.setParameter("insumonombre", nombre);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Insumoempresa> result = new ArrayList();
        for (Iterator<Insumoempresa> iterator = q.getResultList().iterator(); iterator.hasNext();) {
            Insumoempresa next = iterator.next();
            em.refresh(next);
            result.add(next);
        }
        return result;
    }
}
