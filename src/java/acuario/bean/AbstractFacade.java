/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acuario.bean;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Marcelo Astudillo
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public boolean create(T entity) {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().refresh(entity);            
        } catch (PersistenceException e) {
            System.err.println("Error (create):" + e);
            return false;
        }
        return true;
    }

    public Integer createId(T entity) {
        try {
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().refresh(entity);            
        } catch (Exception e) {
            System.err.println("Error (createid):" + e);
            return -1;
        }
        return entity.hashCode();
    }

    public boolean edit(T entity) {
        try {
            getEntityManager().merge(entity);
        } catch (Exception e) {
            System.err.println("Error (edit):" + e);
            return false;
        }
        return true;
    }

    public boolean remove(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception e) {
            System.err.println("Error (remove):" + e);
            return false;
        }
        return true;
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
