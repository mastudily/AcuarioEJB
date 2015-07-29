/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Perfil;
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
public class PerfilFacade extends AbstractFacade<Perfil> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }

    public List<Perfil> findPerfilById(Integer id) {
        Query q = em.createQuery("SELECT p FROM Perfil p "
                + "WHERE p.perfilid >= :perfilid "
                + "ORDER BY p.perfilid");
        q.setParameter("perfilid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Perfil> result = q.getResultList();
        return result;
    }

    public List<Perfil> findPerfilByNombre(String nombre) {
        Query q = em.createQuery("SELECT p FROM Perfil p "
                + "WHERE p.perfilnombre >= :perfilBuscar "
                + "ORDER BY p.perfilnombre");
        q.setParameter("perfilBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Perfil> result = q.getResultList();
        return result;
    }
}
