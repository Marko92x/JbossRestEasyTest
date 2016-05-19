<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta charset="utf-8">
        <title>Upload Image as IMG or Canvas and send to server as file or Blob</title>
        <style type="text/css">
            .table {
                display: table;
                border-collapse: separate;
                border-spacing: 10px 50px;
            }
            .tableRow {
                display: table-row;
            }
            .tableCell {
                display: table-cell;
            }
            .box {
                border: 10px solid rgba(238, 238, 238, 0.5);
            }
        </style>

    <body>
        <div class="table">
            <div class="tableRow">
                <div class="tableCell">
                    <input type="file" id="file">
                </div>
                <div class="tableCell" id="fileInfo">


                </div>
            </div>
            <div class="tableRow">
                <div class="tableCell box">
                    <h2>Canvas</h2>
                    <canvas id="panel"></canvas>
                    <br>
                    <button id="uploadCanvas">Upload Canvas</button>
                </div>
                <div class="tableCell box">
                    <h2>Image</h2>
                    <img src="" id="uploadedImage">
                    <br>
                    <button id="uploadImage">Upload Image</button>
                </div>
            </div>
        </div>
        <br>
        <br>
        <script type="text/javascript">
            var imageUploader = {
                imageFile: null,
                canvasCtx: document.getElementById("panel").getContext("2d"),
                /**
                 * Trigger this object by setting up basic events.
                 */
                init: function () {

                    document.getElementById("uploadImage").onclick = this.uploadImage.bind(this);
                    document.getElementById("uploadCanvas").onclick = this.uploadCanvasAsImage.bind(this);

                    document.getElementById("file").onchange = function (event) {
                        this.imageFile = event.target.files[0];
                        document.getElementById("fileInfo").innerHTML = "File Name: " + this.imageFile.name + "<br> Image type: " + this.imageFile.type;

                        var reader = new FileReader();
                        reader.onload = function (event) {
                            var img = new Image();
                            img.onload = function () {
                                this.drawImageOnCanvas(img);
                                this.displayImage(img);
                            }.bind(this)
                            img.src = event.target.result;
                        }.bind(this);
                        reader.readAsDataURL(this.imageFile);
                    }.bind(this);
                },
                /**
                 * Draw uploaded image on Canvas
                 */
                drawImageOnCanvas: function (img) {
                    this.canvasCtx.canvas.width = img.width;
                    this.canvasCtx.canvas.height = img.height;
                    this.canvasCtx.drawImage(img, 0, 0);

                    //Some update on canvas
                    this.canvasCtx.font = "30px serif"
                    this.canvasCtx.fillStyle = "rgba(0, 0, 0, 0.4)";
                    this.canvasCtx.fillText(this.imageFile.name, 5, img.height - 8);
                },
                /**
                 * Basic image display as per the uploaded image.
                 */
                displayImage: function (img) {
                    document.getElementById("uploadedImage").src = img.src;
                },
                /**
                 * canvas data uri return the Base64 encoded image, we need to conver into a binary file
                 * before sending it to server.
                 *
                 */
                canvasToBlob: function (canvas, type) {

                    var byteString = atob(canvas.toDataURL().split(",")[1]),
                            ab = new ArrayBuffer(byteString.length),
                            ia = new Uint8Array(ab),
                            i;

                    for (i = 0; i < byteString.length; i++) {
                        ia[i] = byteString.charCodeAt(i);
                    }

                    return new Blob([ab], {
                        type: type
                    });
                },
                /**
                 * Upload basic image or file to server.
                 */
                uploadImage: function () {

                    var data = new FormData();
                    data.append("file", this.imageFile);
                    this.uploadToServer(data);

                },
                /**
                 * Add extra parmeter, in case of Canvas upload.
                 */
                uploadCanvasAsImage: function () {

                    var data = new FormData();

                    var blob = this.canvasToBlob(this.canvasCtx.canvas, this.imageFile.type);
                    data.append("blob", blob);
                    data.append("blobName", this.imageFile.name);
                    data.append("blobType", this.imageFile.type);
                    this.uploadToServer(data);

                },
                uploadToServer: function (formData) {

                    //Uncomment when you server ready

                    xhr = new XMLHttpRequest();
//                xhr.open("post", "http://localhost:9999/icodingclub_web/fileUpload", true);
                    xhr.open("post", "http://localhost:8080/RESTEasyTest/fileUpload", true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4) {
                            alert(xhr.responseText);
                        }
                    };
                    xhr.send(formData);

                }
            }

            /**
             * Trigger the app.
             */
            imageUploader.init();
        </script>
    </body>

</html>


<!--<html>
    <head>
        <title>JBoss Web/7.5.7.Final-redhat-1 - JBWEB000064: Error report</title><style>H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}</style> </head><body><h1>JBWEB000065: HTTP Status 500 - java.io.FileNotFoundException: path/to/upload/slika.jpg (No such file or directory)</h1><HR size="1" noshade="noshade"><p><b>JBWEB000309: type</b> JBWEB000066: Exception report</p><p><b>JBWEB000068: message</b> <u>java.io.FileNotFoundException: path/to/upload/slika.jpg (No such file or directory)</u></p><p><b>JBWEB000069: description</b> <u>JBWEB000145: The server encountered an internal error that prevented it from fulfilling this request.</u></p><p><b>JBWEB000070: exception</b> <pre>java.io.IOException: java.io.FileNotFoundException: path/to/upload/slika.jpg (No such file or directory)
	rs.htec.rest.entities.services.FileUpoadEndpoint.doPost(FileUpoadEndpoint.java:43)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:754)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
        </pre></p><p><b>JBWEB000071: root cause</b> <pre>java.io.FileNotFoundException: path/to/upload/slika.jpg (No such file or directory)
	java.io.FileOutputStream.open0(Native Method)
	java.io.FileOutputStream.open(FileOutputStream.java:270)
	java.io.FileOutputStream.&lt;init&gt;(FileOutputStream.java:213)
	java.io.FileOutputStream.&lt;init&gt;(FileOutputStream.java:162)
	org.apache.tomcat.util.http.fileupload.disk.DiskFileItem.write(DiskFileItem.java:416)
	rs.htec.rest.entities.services.FileUpoadEndpoint.doPost(FileUpoadEndpoint.java:43)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:754)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:847)
    </pre></p><p><b>JBWEB000072: note</b> <u>JBWEB000073: The full stack trace of the root cause is available in the JBoss Web/7.5.7.Final-redhat-1 logs.</u></p><HR size="1" noshade="noshade"><h3>JBoss Web/7.5.7.Final-redhat-1</h3></body></html>-->