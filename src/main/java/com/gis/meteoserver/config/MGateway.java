package com.gis.meteoserver.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MGateway {
    @Gateway(requestChannel = "fromTcp")
    void viaTcp(String in);
}
