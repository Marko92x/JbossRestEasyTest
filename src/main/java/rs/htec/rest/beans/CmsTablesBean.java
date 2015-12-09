/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.htec.rest.entities.CmsRole;
import rs.htec.rest.entities.CmsTables;

/**
 *
 * @author stefan
 */
@Stateless
public class CmsTablesBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<CmsTables> findAll(){
        return em.createNamedQuery("CmsTables.findAll").getResultList();
    }
    
    public CmsTables findById(long id) {
        return (CmsTables) em.createNamedQuery("CmsTables.findById").setParameter("id", id).getSingleResult();
    }
}
