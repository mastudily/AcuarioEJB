/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public List<Cliente> findClienteByNombre(String nombre) {
        Query q = em.createQuery("SELECT c FROM Cliente c, Persona p "
                + "WHERE c.personaid.personaid = p.personaid "
                + "AND concat(p.personaapellidos,' ',p.personanombres) >= :personaBuscar "
                + "ORDER BY concat(p.personaapellidos,' ',p.personanombres)");
        q.setParameter("personaBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Cliente> result = q.getResultList();
        return result;
    }

    public List<Cliente> findClienteByIdentidad(String rut) {
        Query q = em.createQuery("SELECT c FROM Cliente c, Persona p "
                + "WHERE c.personaid.personaid = p.personaid "
                + "AND p.personarut >= :personarut "
                + "ORDER BY p.personarut");
        q.setParameter("personarut", rut);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Cliente> result = q.getResultList();
        return result;
    }
}
