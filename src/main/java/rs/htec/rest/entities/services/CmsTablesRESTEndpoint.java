/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.htec.rest.entities.CmsTables;

/**
 *
 * @author stefan
 */
@Stateless
@Path("/tables")
public class CmsTablesRESTEndpoint {
    
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<CmsTables> get() {
        List<CmsTables> list =  em.createNamedQuery("CmsTables.findAll", CmsTables.class).getResultList();
        return list;
    }
}
