/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Ingresoforpag;
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
public class IngresoforpagFacade extends AbstractFacade<Ingresoforpag> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoforpagFacade() {
        super(Ingresoforpag.class);
    }

    public List<Ingresoforpag> findByIngresoforpagIngresoid(Integer id) {
        Query q = em.createNamedQuery("Ingresoforpag.findByIngresoid");
        q.setParameter("ingresoid", id);
        List<Ingresoforpag> result = q.getResultList();
        return result;
    }
}
