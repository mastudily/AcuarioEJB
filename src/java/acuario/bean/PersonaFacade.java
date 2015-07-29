/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    public List<Persona> findPersonaByNombre(String nombre) {
        Query q = em.createQuery("SELECT p FROM Persona p "
                + "WHERE concat(p.personaapellidos,' ',p.personanombres) >= :personaBuscar "
                + "ORDER BY concat(p.personaapellidos,' ',p.personanombres)");
        q.setParameter("personaBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Persona> result = q.getResultList();
        return result;
    }

    public List<Persona> findPersonaByIdentidad(String rut) {
        Query q = em.createQuery("SELECT p FROM Persona p "
                + "WHERE p.personarut >= :personarut "
                + "ORDER BY p.personarut");
        q.setParameter("personarut", rut);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Persona> result = q.getResultList();
        return result;
    }
}
