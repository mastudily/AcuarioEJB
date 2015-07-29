/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Formapago;
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
public class FormapagoFacade extends AbstractFacade<Formapago> {
    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormapagoFacade() {
        super(Formapago.class);
    }
    
    public List<Formapago> findFormapagoById(Integer id) {
        Query q = em.createQuery("SELECT f FROM Formapago f "
                + "WHERE f.formapagoid >= :formapagoid "
                + "ORDER BY f.formapagoid");
        q.setParameter("formapagoid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Formapago> result = q.getResultList();
        return result;
    }

    public List<Formapago> findFormapagoByNombre(String nombre) {
        Query q = em.createQuery("SELECT f FROM Formapago f "
                + "WHERE f.formapagonombre >= :formapagoBuscar "
                + "ORDER BY f.formapagonombre");
        q.setParameter("formapagoBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Formapago> result = q.getResultList();
        return result;
    }
    
}
