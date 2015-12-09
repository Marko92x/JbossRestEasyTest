/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.htec.rest.beans.CmsTablesBean;
import rs.htec.rest.entities.CmsTables;

/**
 *
 * @author stefan
 */
@Path("/tables")
public class CmsTablesRESTEndpoint {
    
    @EJB
    CmsTablesBean tablesBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTables() {
        return Response.ok().entity(tablesBean.findAll()).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTable(@PathParam("id") long id) {
        return Response.ok().entity(tablesBean.findById(id)).build();
    }
}
