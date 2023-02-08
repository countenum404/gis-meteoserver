package com.gis.meteoserver.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public void process(byte[] bytes){
        System.out.println(new String("Server output: " + new String(bytes)));
    }
}
