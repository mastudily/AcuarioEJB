/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcelo Astudillo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario validarUsuario(String identidad, String clave) {
        Usuario result = null;
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u "
                    + "WHERE u.usuarioidentidad = :usuarioidentidad "
                    + "AND u.usuarioclave = :usuarioclave");
            q.setParameter("usuarioidentidad", identidad);
            q.setParameter("usuarioclave", clave);
            result = (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }

    public List<Usuario> findUsuarioByNombre(String nombre) {
        Query q = em.createQuery("SELECT u FROM Usuario u, Persona p "
                + "WHERE u.personaid.personaid = p.personaid "
                + "AND concat(p.personaapellidos,' ',p.personanombres) >= :personaBuscar "
                + "ORDER BY concat(p.personaapellidos,' ',p.personanombres)");
        q.setParameter("personaBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Usuario> result = q.getResultList();
        return result;
    }

    public List<Usuario> findUsuarioByIdentidad(String rut) {
        Query q = em.createQuery("SELECT u FROM Usuario u, Persona p "
                + "WHERE u.personaid.personaid = p.personaid "
                + "AND p.personarut >= :personarut "
                + "ORDER BY p.personarut");
        q.setParameter("personarut", rut);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Usuario> result = q.getResultList();
        return result;
    }
}
