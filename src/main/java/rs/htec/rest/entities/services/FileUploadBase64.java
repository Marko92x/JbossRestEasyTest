/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;

/**
 *
 * @author stefan
 */
@Path("upload64")
public class FileUploadBase64 {
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiveJSON(JSONObject json){
        try {
            saveImage((String)json.get("file"), (String)json.get("file_name"));
            //Prints my json object
            return Response.ok().entity(json).build();
        } catch (Exception e) {
            return Response.status(401).entity(e.getMessage()).build();
        }
    }

    //Convert a Base64 string and create a file
    private void saveImage(String file_string, String file_name) throws IOException{
        byte[] bytes = Base64.decodeBase64(file_string);
        File file = new File("path/to/upload/"+file_name);
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(bytes);
        fop.flush();
        fop.close();
    }

}
