package com.gis.meteoserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.ip.tcp.TcpInboundGateway;
import org.springframework.integration.ip.tcp.TcpOutboundGateway;
import org.springframework.integration.ip.tcp.connection.AbstractClientConnectionFactory;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetClientConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.messaging.MessageChannel;


@Configuration
@EnableIntegration
@IntegrationComponentScan
@PropertySources({@PropertySource("application.properties")})
public class TcpConfig {

    @Value("${tcp.server.port}")
    private int port;

    @Bean
    public AbstractServerConnectionFactory serverConnectionFactory(){
        TcpNetServerConnectionFactory cf = new TcpNetServerConnectionFactory(port);
        cf.setSoKeepAlive(true);
        return cf;
    }

    @Bean
    public MessageChannel mChannel(){
        return new DirectChannel();
    }

    @Bean
    public TcpInboundGateway inboundGateway(@Autowired AbstractServerConnectionFactory serverConnectionFactory,
                                            @Autowired MessageChannel mChannel){
        TcpInboundGateway inboundGateway = new TcpInboundGateway();
        inboundGateway.setConnectionFactory(serverConnectionFactory);
        inboundGateway.setRequestChannel(mChannel);
        return inboundGateway;
    }

    @Bean
    public AbstractClientConnectionFactory clientConnectionFactory(){
        return new TcpNetClientConnectionFactory("localhost", port);
    }
}
