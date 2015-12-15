/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import javax.ejb.EJB;
import rs.htec.rest.beans.CmsPrivilegesBean;

/**
 *
 * @author marko
 */
public class CmsUserPrivilegesRESTEndpoint {
    
    @EJB
    private CmsPrivilegesBean privilegesBean;
    
    
}
