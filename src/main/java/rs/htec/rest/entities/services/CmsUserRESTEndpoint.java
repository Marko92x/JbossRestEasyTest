/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.htec.rest.entities.CmsUser;

/**
 *
 * @author marko
 */
@Stateless
@Path("/cmsUsers")
public class CmsUserRESTEndpoint {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        List<CmsUser> users = em.createNamedQuery("CmsUser.findAll").getResultList();
        return Response.ok().entity(users).build();
    }
}
