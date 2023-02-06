package com.gis.meteoserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.ip.tcp.connection.AbstractClientConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpConnection;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    /**
     *
     * Class for testing connections. f.e. get http://localhost:{server.port}/api/{message} will send a message into tcp endpoint
     *
     **/

    @Autowired
    private AbstractClientConnectionFactory cf;

    @GetMapping("/api/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) throws InterruptedException {
        cf.start();
        TcpConnection connection = cf.getConnection();
        connection.send(new GenericMessage<>(message.getBytes()));
        cf.stop();
        return new ResponseEntity<String>(new String("Message sent!"), HttpStatus.ACCEPTED);
    }


}
