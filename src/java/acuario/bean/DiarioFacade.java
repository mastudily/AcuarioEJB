/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Diario;
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
public class DiarioFacade extends AbstractFacade<Diario> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiarioFacade() {
        super(Diario.class);
    }

    public List<Diario> findDiarioByFecha(Date fecha, Integer empresaid) {
        Query q = em.createQuery("SELECT d FROM Diario d "
                + "WHERE d.diariofecha >= :diariofecha "
                + "AND d.empresaid.empresaid = :empresaid "
                + "ORDER BY d.diariofecha");
        q.setParameter("diariofecha", fecha);
        q.setParameter("empresaid", empresaid);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Diario> result = q.getResultList();
        return result;
    }
}
