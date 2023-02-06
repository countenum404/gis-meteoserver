package com.gis.meteoserver;


import com.gis.meteoserver.config.TcpConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MeteoserverApplication {
	public static void main(String[] args) {
		SpringApplication.run(MeteoserverApplication.class);
	}

}
