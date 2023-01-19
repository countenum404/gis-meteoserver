package com.gis.meteoserver.config;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel="toTcp")
public interface Gateway {
    String viaTcp(String in);
}
