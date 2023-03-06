package com.gis.meteoserver.endpoint;

import com.gis.meteoserver.services.messaging.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class TcpEndpoint {

    @Autowired
    private MessageService service;

    @ServiceActivator(inputChannel="mChannel")
    public void echo(byte[] bytes) {
        System.out.println("Message is received");
        service.process(bytes);
    }
}
