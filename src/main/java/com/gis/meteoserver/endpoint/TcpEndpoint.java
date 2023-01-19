package com.gis.meteoserver.endpoint;

import com.gis.meteoserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class TcpEndpoint {

    @Autowired
    MessageService service;

    @ServiceActivator(inputChannel="fromTcp")
    public byte[] echo(byte[] bytes){
        return bytes;
    }
}
