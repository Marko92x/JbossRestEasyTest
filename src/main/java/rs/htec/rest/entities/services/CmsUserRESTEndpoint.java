/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import rs.htec.rest.beans.CmsUserBean;

/**
 *
 * @author marko
 */
@Path("/cmsUsers")
public class CmsUserRESTEndpoint implements RestInterface {
    
    @EJB
    private CmsUserBean userBean;
    
    
    @Override
    public Response getUsers(){
        return Response.ok().entity(userBean.findAll()).build();
    }
}
