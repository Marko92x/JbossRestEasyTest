/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.htec.rest.beans.CmsRoleBean;
import rs.htec.rest.beans.NewsBean;

/**
 *
 * @author stefan
 */
@Path("/news")
public class NewsRESTEndpoint {
    
    @EJB
    private NewsBean newsBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response gerNews(){
        return Response.ok().entity(newsBean.findAll()).build();
    }
    
}
