package com.gis.meteoserver.services.messaging;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class MessageService {
    public void process(byte[] bytes) {
        System.out.println(new StringBuilder("Server output: ").append(bytes.length).append(" bytes received"));
        String generatedFilename = new String("meteodata_" + new Date().getTime());
        try (FileOutputStream outputStream = new FileOutputStream(generatedFilename)){
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("File not specified");
        } catch (IOException e) {
            System.out.println("IOException thrown");
        }
    }
}
