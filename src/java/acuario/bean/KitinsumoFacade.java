/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Kitinsumo;
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
public class KitinsumoFacade extends AbstractFacade<Kitinsumo> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KitinsumoFacade() {
        super(Kitinsumo.class);
    }

    public List<Kitinsumo> findKitinsumoById(Integer id) {
        Query q = em.createQuery("SELECT k FROM Kitinsumo k "
                + "WHERE k.kitinsumoid >= :kitinsumoid "
                + "ORDER BY k.kitinsumoid");
        q.setParameter("kitinsumoid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kitinsumo> result = q.getResultList();
        return result;
    }

    public List<Kitinsumo> findKitinsumoByDescripcion(String buscar) {
        Query q = em.createQuery("SELECT k FROM Kitinsumo k "
                + "WHERE k.kitinsumodescripcion >= :kitinsumoBuscar "
                + "ORDER BY k.kitinsumodescripcion");
        q.setParameter("kitinsumoBuscar", buscar);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kitinsumo> result = q.getResultList();
        return result;
    }

    public List<Kitinsumo> findKitinsumoByAbreviatura(String buscar) {
        Query q = em.createQuery("SELECT k FROM Kitinsumo k "
                + "WHERE k.kitinsumoabreviatura >= :kitinsumoBuscar "
                + "ORDER BY k.kitinsumoabreviatura");
        q.setParameter("kitinsumoBuscar", buscar);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kitinsumo> result = q.getResultList();
        return result;
    }

}
