/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.awt.Image;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.keycloak.OAuth2Constants;
import org.keycloak.constants.ServiceUrlConstants;
import org.keycloak.common.util.KeycloakUriBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Multipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author stefan
 */
@Path("/rest-ws")
public class FileUpload {

    // prima tokene
    @POST
    @Path("/upload-on-server")
    @Consumes("multipart/form-data")
    public Response uploadFileOnServer(MultipartFormDataInput slika) throws IOException { // @MultipartForm FileUploadForm form2

        HttpClient client = new DefaultHttpClient();

        try {
            HttpPost post = new HttpPost(KeycloakUriBuilder.fromUri("http://10.10.0.40:8080/auth")
                    .path(ServiceUrlConstants.TOKEN_PATH).build("demo"));
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("username", "marko@htec.rs"));
            formparams.add(new BasicNameValuePair("password", "mikimaus8"));
            formparams.add(new BasicNameValuePair(OAuth2Constants.GRANT_TYPE, "password"));
            formparams.add(new BasicNameValuePair(OAuth2Constants.CLIENT_ID, "RESTEasyTestPublic"));
            UrlEncodedFormEntity form = new UrlEncodedFormEntity(formparams, "UTF-8");
            post.setEntity(form);

            HttpResponse response = client.execute(post);
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (status != 200) {
                String json = getContent(entity);
                throw new IOException("Bad status: " + status + " response: " + json);
            }
            if (entity == null) {
                throw new IOException("No Entity");
            }
            String json = getContent(entity);
            JSONParser parser = new JSONParser();
            JSONObject job = (JSONObject) parser.parse(json);

            System.out.println("JSON *************** " + json);

//            HttpPost post2 = new HttpPost("http://10.10.0.40:8080/RESTEasyTest/rest/multipart/upload");
//            saljiSliku.setHeader("Authorization", "bearer " + (String) job.get("access_token"));
            return Response.ok().entity("").build();
        } catch (ParseException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
            return Response.ok().entity(ex.getMessage()).build();
        } finally {
            client.getConnectionManager().shutdown();
        }
    }

    public static String getContent(HttpEntity entity) throws IOException {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int c;
            while ((c = is.read()) != -1) {
                os.write(c);
            }
            byte[] bytes = os.toByteArray();
            String data = new String(bytes);
            return data;
        } finally {
            try {
                is.close();
            } catch (IOException ignored) {

            }
        }

    }


//    @POST
//    @Path("/upload-file")
//    @Consumes("multipart/form-data")
//    public Response uploadFile(@MultipartForm FileUploadForm form) {
//  
//        String fileName = form.getFileName() == null ? "Unknown" : form.getFileName() ;
//         
//        String completeFilePath = "path/to/upload/" + fileName;
//        try
//        {
//            //Save the file
//            File file = new File(completeFilePath);
//              
//            if (!file.exists()) 
//            {
//                file.createNewFile();
//            }
//      
//            FileOutputStream fos = new FileOutputStream(file);
//      
//            fos.write(form.getFileData());
//            fos.flush();
//            fos.close();
//        } 
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        //Build a response to return
//        return Response.status(200)
//            .entity("uploadFile is called, Uploaded file name : " + fileName).build();
//    }
}
