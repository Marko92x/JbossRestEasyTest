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
import rs.htec.rest.entities.NewsDb;

/**
 *
 * @author stefan
 */
@Stateless
public class NewsBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<NewsDb> findAll(){
        return em.createNamedQuery("NewsDb.findAll").getResultList();
    }
    
}
