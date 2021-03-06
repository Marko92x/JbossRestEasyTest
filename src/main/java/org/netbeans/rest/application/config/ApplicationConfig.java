/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rs.htec.rest.entities.services.CmsRoleRESTEndpoint.class);
        resources.add(rs.htec.rest.entities.services.CmsTablesRESTEndpoint.class);
        resources.add(rs.htec.rest.entities.services.CmsUserRESTEndpoint.class);
        resources.add(rs.htec.rest.entities.services.FileUpload.class);
        resources.add(rs.htec.rest.entities.services.FileUploadBase64.class);
        resources.add(rs.htec.rest.entities.services.NewsRESTEndpoint.class);
        resources.add(rs.htec.rest.entities.services.UserRESTEndpoint.class);
    }
    
}
