/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.htec.rest.entities.services;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//html5
@WebServlet("/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 40, // 40 MB
        maxRequestSize = 1024 * 1024 * 40)
// 10 MB
public class FileUpoadEndpoint extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("blob");
        String fileName = null;
        if (part != null) {
            //writing blob
            fileName = request.getParameter("blobName");
            part.write("path/to/upload" + File.separator + fileName);

        } else {
            //Writing image or file
            part = request.getPart("file");
            fileName = getFileName(part);
            part.write("path/to/upload" + File.separator + fileName);
        }

        // Extra logic to support multiple domain - you may want to remove this
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.getWriter().print(fileName + " uploaded successfully");
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2,
                        token.length() - 1);
            }
        }
        return "";
    }
}
