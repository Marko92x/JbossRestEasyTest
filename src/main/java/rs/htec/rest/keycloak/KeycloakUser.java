/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.keycloak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.constants.ServiceUrlConstants;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

/**
 *
 * @author marko
 */
public class KeycloakUser {
//
//
//    public void createUser() {
//        Keycloak kc= Keycloak.getInstance("http://localhost:8080/auth", "demo", "admin", "mikimaus8", "RESTEasyTest");
//        CredentialRepresentation credential = new CredentialRepresentation();
//        credential.setType(CredentialRepresentation.PASSWORD);
//        credential.setValue("test123");
//        UserRepresentation user = new UserRepresentation();
//        user.setUsername("testuser");
//        user.setFirstName("Test");
//        user.setLastName("User");
//        user.setCredentials(Arrays.asList(credential));
////        RoleResource role = kc.realm("demo").roles().get("user");
////        List<Object> l = new ArrayList<Object>();
////        l.add(role);
//        List<String> roles = new ArrayList<String>();
//        roles.add("user");
//        user.setRealmRoles(roles);
//        user.setEnabled(true);
////        kc.realm("demo").roles().get("user");
//        kc.realm("demo").users().create(user);
//    }
    
}
