/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Ingreso;
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
public class IngresoFacade extends AbstractFacade<Ingreso> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoFacade() {
        super(Ingreso.class);
    }

    public Ingreso findByIngresoid(Integer id) {
        Query q = em.createNamedQuery("Ingreso.findByIngresoid");
        q.setParameter("ingresoid", id);
        Ingreso result = (Ingreso) q.getSingleResult();
        return result;
    }

    public List<Ingreso> findIngresoByFecha(Date fecha) {
        Query q = em.createQuery("SELECT i FROM Ingreso i "
                + "WHERE i.ingresofecha >= :ingresofecha "
                + "ORDER BY i.ingresofecha");
        q.setParameter("ingresofecha", fecha);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Ingreso> result = q.getResultList();
        return result;
    }

    public List<Ingreso> findIngresoByNombre(String nombre) {
        Query q = em.createQuery("SELECT i FROM Ingreso i, Cliente c, Persona p "
                + "WHERE i.clienteid.clienteid = c.clienteid "
                + "AND c.personaid.personaid = p.personaid "
                + "AND concat(p.personaapellidos,' ',p.personanombres) >= :personaBuscar "
                + "ORDER BY concat(p.personaapellidos,' ',p.personanombres)");
        q.setParameter("personaBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Ingreso> result = q.getResultList();
        return result;
    }

    public List<Ingreso> findIngresoByIdentidad(String rut) {
        Query q = em.createQuery("SELECT i FROM Ingreso i, Cliente c, Persona p "
                + "WHERE i.clienteid.clienteid = c.clienteid "
                + "AND c.personaid.personaid = p.personaid "
                + "AND p.personarut >= :personarut "
               + "ORDER BY p.personarut");
        q.setParameter("personarut", rut);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Ingreso> result = q.getResultList();
        return result;
    }
}
