package com.gis.meteoserver.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequestMapping("/api/file")
public class FileController {
    /**
     *
     * Endpoints to sending files
     *
     * **/

    @Value("${meteofile}")
    private String pathToMeteoFile;

    @GetMapping("meteofile")
    public ResponseEntity<StringBuilder> sendFile() {
        System.out.println("Sending");
        try (Socket socket = new Socket("127.0.0.1", 8001)){
            byte[] array = Files.readAllBytes(Paths.get(pathToMeteoFile));
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            out.write(array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<StringBuilder>(new StringBuilder("File is sent"), HttpStatus.OK);
    }
}
