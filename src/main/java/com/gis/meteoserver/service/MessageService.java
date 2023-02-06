package com.gis.meteoserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public void process(byte[] bytes){
        System.out.println(new String(bytes));
    }
}
