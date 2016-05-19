<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body>
        <p>asdasdasdasdasdasdasdasdasdasdas</p>
        <h1>JAX-RS File Upload Example</h1>
        <!--        <form action="http://localhost:8080/RESTEasyTest/rest/rest-ws/ajde" method="post" enctype="multipart/form-data">
                    <p>
                        File name : <input type="text" name="fileName" />
                    </p>
                    <p>
                        Choose the file : <input type="file" name="selectedFile" />
                    </p>
                    <input type="submit" value="Upload" />
                </form>-->
        <form action="rest/rest-ws/up" method="post" enctype="multipart/form-data">
            <p>
                Select a file : <input type="file" name="file" size="50" />
            </p>
            <input type="submit" value="Upload It" />
        </form>
    </body>
</html>