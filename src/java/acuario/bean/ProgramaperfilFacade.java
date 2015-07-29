/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Programaperfil;
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
public class ProgramaperfilFacade extends AbstractFacade<Programaperfil> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaperfilFacade() {
        super(Programaperfil.class);
    }

    public List<Programaperfil> listaProgramas(Integer perfilid) {
        Query q = em.createNamedQuery("Programaperfil.findByPerfilid");
        q.setParameter("perfilid", perfilid);
        List<Programaperfil> result = q.getResultList();
        return result;
    }
}
