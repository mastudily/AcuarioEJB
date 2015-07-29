/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import acuario.clases.Interfazcontabledetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo Astudillo
 */
@Stateless
public class InterfazcontabledetalleFacade extends AbstractFacade<Interfazcontabledetalle> {
    @PersistenceContext(unitName = "AcuarioEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterfazcontabledetalleFacade() {
        super(Interfazcontabledetalle.class);
    }
    
}
