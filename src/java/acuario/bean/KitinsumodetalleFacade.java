/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Kitinsumodetalle;
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
public class KitinsumodetalleFacade extends AbstractFacade<Kitinsumodetalle> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KitinsumodetalleFacade() {
        super(Kitinsumodetalle.class);
    }

    public List<Kitinsumodetalle> findByKitinsumoid(Integer id) {
        Query q = em.createNamedQuery("Kitinsumodetalle.findByKitinsumoid");
        q.setParameter("kitinsumoid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Kitinsumodetalle> result = q.getResultList();
        return result;
    }
}
