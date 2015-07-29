/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Constante;
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
public class ConstanteFacade extends AbstractFacade<Constante> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConstanteFacade() {
        super(Constante.class);
    }

    public List<Constante> findConstanteByCodigo(String constantecodigo) {
        Query q = em.createQuery("SELECT c FROM Constante c "
                + "WHERE c.constantecodigo = :constantecodigo "
                + "AND c.constanteestado = 'ACTIVO' "
                + "ORDER BY c.constantedescripcion");
        q.setParameter("constantecodigo", constantecodigo);
        List<Constante> result = q.getResultList();
        return result;
    }

    public List<Constante> findConstanteByCodigoMnt(String constantecodigo) {
        Query q = em.createQuery("SELECT c FROM Constante c "
                + "WHERE c.constantecodigo >= :constantecodigo "
                + " AND c.constantecodigo != 'CONCEPTO' "
                + "ORDER BY c.constantecodigo");
        q.setParameter("constantecodigo", constantecodigo);
        List<Constante> result = q.getResultList();
        return result;
    }

    public Constante findConstanteByCodigoTipo(String codigo, String tipo) {
        Query q = em.createQuery("SELECT c FROM Constante c "
                + "WHERE c.constantecodigo = :constantecodigo "
                + "AND c.constantetipo = :constantetipo ");
        q.setParameter("constantecodigo", codigo);
        q.setParameter("constantetipo", tipo);
        Constante result =  null;
        try {
            result = (Constante) q.getSingleResult();
        } catch (Exception e) {
        }        
        return result;
    }

}
