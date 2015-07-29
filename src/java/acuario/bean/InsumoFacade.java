/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Insumo;
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
public class InsumoFacade extends AbstractFacade<Insumo> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsumoFacade() {
        super(Insumo.class);
    }

    public Insumo findByInsumoid(Integer id) {
        Query q = em.createNamedQuery("Insumo.findByInsumoid");
        q.setParameter("insumoid", id);
        Insumo result = (Insumo) q.getSingleResult();
        return result;
    }

    public Insumo findByInsumocodigo(String codigo) {
        Query q = em.createNamedQuery("Insumo.findByInsumocodigo");
        q.setParameter("insumocodigo", codigo);
        Insumo result = (Insumo) q.getSingleResult();
        return result;
    }

    public List<Insumo> findInsumoByCodigo(String codigo) {
        Query q = em.createQuery("SELECT i FROM Insumo i "
                + "WHERE i.insumocodigo >= :insumocodigo "
                + "ORDER BY i.insumocodigo");
        q.setParameter("insumocodigo", codigo);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Insumo> result = q.getResultList();
        return result;
    }

    public List<Insumo> findInsumoByNombre(String nombre) {
        Query q = em.createQuery("SELECT i FROM Insumo i "
                + "WHERE i.insumonombre >= :insumonombre "
                + "ORDER BY i.insumonombre");
        q.setParameter("insumonombre", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Insumo> result = q.getResultList();
        return result;
    }

}
