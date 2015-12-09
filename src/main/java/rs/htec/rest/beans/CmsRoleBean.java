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

/**
 *
 * @author marko
 */
@Stateless
public class CmsRoleBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<CmsRole> findAll(){
        return em.createNamedQuery("CmsRole.findAll").getResultList();
    }
}
