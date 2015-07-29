/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Empresa;
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
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Empresa> findEmpresaByNombre(String nombre) {
        Query q = em.createQuery("SELECT e FROM Empresa e "
                + "WHERE e.empresanombre >= :empresanombre "
                + "ORDER BY e.empresanombre");
        q.setParameter("empresanombre", nombre);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Empresa> result = q.getResultList();
        return result;
    }

    public List<Empresa> findEmpresaByIdentidad(String rut) {
        Query q = em.createQuery("SELECT e FROM Empresa e "
                + "WHERE e.empresarut >= :empresarut "
                + "ORDER BY e.empresarut");
        q.setParameter("empresarut", rut);
        q.setMaxResults(100);
        q.setFirstResult(0);
        List<Empresa> result = q.getResultList();
        return result;
    }
}
