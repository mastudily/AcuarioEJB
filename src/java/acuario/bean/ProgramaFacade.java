/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Programa;
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
public class ProgramaFacade extends AbstractFacade<Programa> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }

    public List<Programa> ProgramaPorTipo(String programatipo) {
        Query q = em.createQuery("SELECT p FROM Programa p "
                + "WHERE p.programatipo = :programatipo "
                + "ORDER BY p.programaorden");
        q.setParameter("programatipo", programatipo);
        List<Programa> result = q.getResultList();
        return result;
    }

    public List<Programa> ProgramaPorPadreid(String programapadreid) {
        Query q = em.createQuery("SELECT p FROM Programa p "
                + "WHERE p.programapadreid = :programapadreid "
                + "ORDER BY p.programaorden");
        q.setParameter("programapadreid", programapadreid);
        List<Programa> result = q.getResultList();
        return result;
    }

    public List<Programa> listaProgramasTipo(Integer perfilid, String programatipo, Integer programapadreid) {
        String selectPadre = "";
        if (programapadreid != 0) {
            selectPadre = "AND p.programapadreid = :programapadreid ";
        }
        Query q = em.createQuery("SELECT p FROM Programa p, Programaperfil r "
                + "WHERE r.programaperfilPK.perfilid = :perfilid "
                + "AND r.programaperfilPK.programaid = p.programaid "
                + selectPadre
                + "AND p.programatipo = :programatipo "
                + "ORDER BY p.programaorden");
        q.setParameter("perfilid", perfilid);
        q.setParameter("programatipo", programatipo);
        if (programapadreid != 0) {
            q.setParameter("programapadreid", programapadreid);
        }
        List<Programa> result = q.getResultList();
        return result;
    }

    public List<Programa> findProgramaById(Integer id) {
        Query q = em.createQuery("SELECT p FROM Programa p "
                + "WHERE p.programaid >= :programaid "
                + "ORDER BY p.programaid");
        q.setParameter("programaid", id);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Programa> result = q.getResultList();
        return result;
    }

    public List<Programa> findProgramaByNombre(String nombre) {
        Query q = em.createQuery("SELECT p FROM Programa p "
                + "WHERE p.programanombre >= :programaBuscar "
                + "ORDER BY p.programanombre");
        q.setParameter("programaBuscar", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Programa> result = q.getResultList();
        return result;
    }

    public List<Programa> findProgramaByTipo(String tipo) {
        Query q = em.createQuery("SELECT p FROM Programa p "
                + "WHERE p.programatipo = :programatipo "
                + "ORDER BY p.programanombre");
        q.setParameter("programatipo", tipo);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Programa> result = q.getResultList();
        return result;
    }
}
